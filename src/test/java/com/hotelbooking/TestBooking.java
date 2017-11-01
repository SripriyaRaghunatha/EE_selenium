package com.hotelbooking;

import org.testng.annotations.Test;
import com.hotelbooking.booking;

public class TestBooking {
	@Test
	public void testHotelReservationPage() {

		booking.getHotelReservationPage();
	}

	@Test(dependsOnMethods = { "testHotelReservationPage" })
	public void testCreateBooking() throws Exception {
		booking.createBooking("ABCD","EFG","100.00",true,"2017-10-31","2017-10-31");
		booking.createBooking("AB'D","E-G","1000.00",false,"2017-10-31","2017-10-31");

	}

	@Test(dependsOnMethods = { "testHotelReservationPage" })
	public void testDeleteBooking() throws Exception {
		Thread.sleep(500); //TODO - replace with WaitForElement
		booking.deleteBooking();
	}

}
