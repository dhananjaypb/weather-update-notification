package org.weather.update.notification.dao;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.weather.update.notification.dao.impl.WeatherUpdateNotificationDaoImpl;
import org.weather.update.notification.model.NotificationDetails;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class WeatherUpdateNotificationDaoImplTest {

	private WeatherUpdateNotificationDaoImpl dao = new WeatherUpdateNotificationDaoImpl();

	@Test
	public void createWeatherNotificationDetails() {
		dao.createNotificationDetail(new NotificationDetails("TestName", "test", "20", "test"));
	}
	
	@Test
	public void returnAllNotificationDetails(){
		dao.getAllNotificationDetails();
	}

}
