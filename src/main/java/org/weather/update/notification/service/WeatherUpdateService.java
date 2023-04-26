package org.weather.update.notification.service;

import java.util.List;

import org.weather.update.notification.model.NotificationDetails;

public interface WeatherUpdateService {

	void createNotificationDetail(NotificationDetails notificationDetails) throws Exception;

	List<NotificationDetails> getAllNotificationDetails() throws Exception;
}
