package org.weather.update.notification.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.weather.update.notification.dao.WeatherUpdateNotificationDao;
import org.weather.update.notification.model.NotificationDetails;
import org.weather.update.notification.service.WeatherUpdateService;

/*
 * This is service class for API.
 */
@Service
public class WeatherUpdateServiceImpl implements WeatherUpdateService {

	private static Logger logger = LogManager.getLogger(WeatherUpdateServiceImpl.class);

	@Autowired
	private WeatherUpdateNotificationDao weatherUpdateNotificationDao;

	/*
	 * This method is to create notification details.
	 * It accepts NotificationDetails object.
	 * If any error occur while creating resource it will @throw BusinessException
	 */
	@Override
	public void createNotificationDetail(NotificationDetails notificationDetails) throws Exception {

		logger.info("WeatherUpdateServiceImpl : createNotificationDetail");

		try {
			weatherUpdateNotificationDao.createNotificationDetail(notificationDetails);
			logger.info("WeatherUpdateServiceImpl : ");
		} catch (Exception exception) {
			logger.error("Error while creating notification details");
			throw new Exception("Error while creating notification details");
		}
	}

	/*
	 * This method is used for get all notification details.
	 * If any error occur while creating resource it will @throw BusinessException
	 */
	@Override
	public List<NotificationDetails> getAllNotificationDetails() throws Exception {
		List<NotificationDetails> notificationDetails;
		try {
			notificationDetails = weatherUpdateNotificationDao.getAllNotificationDetails();
		} catch (Exception exception) {
			logger.error("Error while retrieving notification details");
			throw new Exception("Error while retrieving notification details");
		}
		return notificationDetails;
	}
}
