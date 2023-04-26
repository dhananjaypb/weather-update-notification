/**
 * 
 */
package org.weather.update.notification.service;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.weather.update.notification.dao.WeatherUpdateNotificationDao;
import org.weather.update.notification.model.NotificationDetails;
import org.weather.update.notification.service.impl.WeatherUpdateServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class WeatherUpdateServiceImplTest {

	@Mock
	private WeatherUpdateNotificationDao weatherUpdateNotificationDao;

	@InjectMocks
	private WeatherUpdateServiceImpl service = new WeatherUpdateServiceImpl();

	@Test
	public void shouldCreateNewNotificationDetails() throws Exception {
		NotificationDetails notificationDetails = new NotificationDetails("TestName", "test", "20", "test");

		service.createNotificationDetail(notificationDetails);
		Mockito.verify(weatherUpdateNotificationDao).createNotificationDetail(notificationDetails);
	}

	@Test(expected = Exception.class)
	public void shouldNotCreateNewNotificationDetailsThrowException() throws Exception {
		NotificationDetails notificationDetails = new NotificationDetails("TestName", "test", "20", "test");

		Mockito.doThrow(Exception.class).when(weatherUpdateNotificationDao)
				.createNotificationDetail(notificationDetails);
		service.createNotificationDetail(notificationDetails);
	}

	@Test
	public void shouldReturnNotificationDetails() throws Exception {
		NotificationDetails notificationDetails = new NotificationDetails("TestName", "test", "20", "test");

		Mockito.doReturn(Arrays.asList(notificationDetails)).when(weatherUpdateNotificationDao)
				.getAllNotificationDetails();
		Assert.assertEquals(Arrays.asList(notificationDetails).get(0).getName(),
				service.getAllNotificationDetails().get(0).getName());
	}

	@Test
	public void shouldNotReturnNotificationDetails() throws Exception {
		Mockito.doReturn(null).when(weatherUpdateNotificationDao).getAllNotificationDetails();
		Assert.assertNull(service.getAllNotificationDetails());
	}

	@Test(expected = Exception.class)
	public void shouldNotReturnNotificationDetailsThrowException() throws Exception {
		Mockito.doThrow(Exception.class).when(weatherUpdateNotificationDao).getAllNotificationDetails();
		service.getAllNotificationDetails();
	}

}
