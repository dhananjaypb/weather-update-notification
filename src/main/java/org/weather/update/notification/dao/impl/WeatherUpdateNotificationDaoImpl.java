package org.weather.update.notification.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.weather.update.notification.dao.WeatherUpdateNotificationDao;
import org.weather.update.notification.model.NotificationDetails;

/*
 * This is dao class for API.
 */
@Repository
public class WeatherUpdateNotificationDaoImpl implements WeatherUpdateNotificationDao {

	private static Logger logger = LogManager.getLogger(WeatherUpdateNotificationDaoImpl.class);

	private static List<NotificationDetails> notificationDetail = new ArrayList<>();

	/*
	 * This method is to create notification details.
	 * It accepts NotificationDetails object.
	 */
	@Override
	public void createNotificationDetail(NotificationDetails notificationDetails) {
		logger.info("WeatherUpdateNotificationDaoImpl : createNotificationDetail");

		notificationDetail.add(notificationDetails);

		logger.info("WeatherUpdateNotificationDaoImpl : Notification Detail created");
	}

	/*
	 * This method is used for get all notification details.
	 */
	@Override
	public List<NotificationDetails> getAllNotificationDetails() {
		logger.info("WeatherUpdateNotificationDaoImpl : getAllNotificationDetails");
		return notificationDetail;
	}
}
