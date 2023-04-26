package org.weather.update.notification.dao;

import java.util.List;

import org.weather.update.notification.model.NotificationDetails;

public interface WeatherUpdateNotificationDao {

    void createNotificationDetail(NotificationDetails notificationDetails);

	List<NotificationDetails> getAllNotificationDetails();
}
