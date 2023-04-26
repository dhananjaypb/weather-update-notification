package org.weather.update.notification.controller;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.weather.update.notification.exception.BusinessException;
import org.weather.update.notification.exception.InvalidBodyException;
import org.weather.update.notification.model.NotificationDetails;
import org.weather.update.notification.service.WeatherUpdateService;

@RunWith(MockitoJUnitRunner.class)
public class WeatherUpdateNotificationControllerTest {

	@Mock
	private WeatherUpdateService weatherUpdateService;

	@InjectMocks
	private WeatherUpdateNotificationController controller = new WeatherUpdateNotificationController();

	@Test(expected = InvalidBodyException.class)
	public void shouldNotCreateNotificationDetails() throws BusinessException, InvalidBodyException {
		NotificationDetails notificationDetails = new NotificationDetails();
		controller.createNotificationDetail(notificationDetails);
	}

	@Test(expected = InvalidBodyException.class)
	public void shouldNotCreateNotificationDetailsForInvalidTemp() throws BusinessException, InvalidBodyException {
		NotificationDetails notificationDetails = new NotificationDetails("TestName", "test", "ABC", "test");
		controller.createNotificationDetail(notificationDetails);
	}

	@Test
	public void shouldCreateNotificationDetails() throws BusinessException, InvalidBodyException {
		NotificationDetails notificationDetails = new NotificationDetails("TestName", "test", "20", "test");

		Assert.assertEquals(new ResponseEntity(HttpStatus.OK).getStatusCode(),
				controller.createNotificationDetail(notificationDetails).getStatusCode());
	}

	@Test(expected = BusinessException.class)
	public void shouldNotCreateNotificationDetailsThrowException() throws Exception {
		NotificationDetails notificationDetails = new NotificationDetails("TestName", "test", "20", "test");

		Mockito.doThrow(Exception.class).when(weatherUpdateService).createNotificationDetail(notificationDetails);
		controller.createNotificationDetail(notificationDetails);
	}

	@Test
	public void shouldGetAllNotificationDetails() throws Exception {
		NotificationDetails notificationDetails = new NotificationDetails("TestName", "test", "20", "test");

		Mockito.when(weatherUpdateService.getAllNotificationDetails()).thenReturn(Arrays.asList(notificationDetails));
		Assert.assertEquals(new ResponseEntity(HttpStatus.OK).getStatusCode(),
				controller.getAllNotificationDetails().getStatusCode());
	}

	@Test
	public void shouldGetemptyNotificationDetails() throws Exception {
		NotificationDetails notificationDetails = new NotificationDetails("TestName", "test", "20", "test");

		Mockito.when(weatherUpdateService.getAllNotificationDetails()).thenReturn(Arrays.asList());
		Assert.assertEquals(new ResponseEntity(HttpStatus.NO_CONTENT).getStatusCode(),
				controller.getAllNotificationDetails().getStatusCode());
	}
}
