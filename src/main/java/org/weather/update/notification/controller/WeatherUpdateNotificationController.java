package org.weather.update.notification.controller;

import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.weather.update.notification.exception.BusinessException;
import org.weather.update.notification.exception.InvalidBodyException;
import org.weather.update.notification.model.NotificationDetails;
import org.weather.update.notification.service.WeatherUpdateService;

/*
 * This is controller class for API.
 * Using CrossOrigin annotation handling CORS policy
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class WeatherUpdateNotificationController {

	private static Logger logger = LogManager.getLogger(WeatherUpdateNotificationController.class);

	@Autowired
	private WeatherUpdateService weatherUpdateService;

	/*
	 * This is Post method to create notification details. It accepts
	 * NotificationDetails object as request body. If any error occur while
	 * creating resource it will @throw BusinessException If request body is
	 * invalid then it will throw InvalidBodyException It consumes and produces
	 * json
	 */
	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity createNotificationDetail(@RequestBody NotificationDetails notificationDetails)
			throws BusinessException, InvalidBodyException {

		logger.info("WeatherUpdateNotificationController : createNotificationDetail");

		logger.info("WeatherUpdateNotificationController : Details received " + notificationDetails);

		if (ObjectUtils.allNotNull(notificationDetails.getName(), notificationDetails.getCity(),
				notificationDetails.getTemp(), notificationDetails.getChannel())
				&& NumberUtils.isCreatable(notificationDetails.getTemp())) {
			try {
				weatherUpdateService.createNotificationDetail(notificationDetails);
			} catch (Exception exception) {
				logger.error("WeatherUpdateNotificationController : Error occur while store details");
				throw new BusinessException("WeatherUpdateNotificationController : Error occur while insert details");
			}
			logger.info("WeatherUpdateNotificationController : request created " + notificationDetails);
		} else {
			logger.error("WeatherUpdateNotificationController : Request body is invalid");
			throw new InvalidBodyException("WeatherUpdateNotificationController : Request body is invalid");
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/*
	 * This method is used for get all notification details. It produces json.
	 * If any error occur while creating resource it will @throw
	 * BusinessException If no records there then it will retuen 204 status code
	 */
	@GetMapping(value = "/getAllNotificationDetails", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<NotificationDetails>> getAllNotificationDetails() throws BusinessException {

		logger.info("WeatherUpdateNotificationController : getNotificationDetails");

		List<NotificationDetails> notificationDetails;
		try {
			notificationDetails = weatherUpdateService.getAllNotificationDetails();
		} catch (Exception e) {
			logger.error("Error while retrieving notification details");
			throw new BusinessException("Error while retrieving notification details");
		}
		if (!CollectionUtils.isEmpty(notificationDetails)) {
			return new ResponseEntity<List<NotificationDetails>>(notificationDetails, HttpStatus.OK);
		}
		logger.info("WeatherUpdateNotificationController : No record found");
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
