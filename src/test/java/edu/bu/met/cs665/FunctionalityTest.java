package edu.bu.met.cs665;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This is the JUnit test that is a part of the requirement under Implementation Details
 */
public class FunctionalityTest {

  @Test
  public void testDeliveryToFiveDrivers() {
    // Given: A shop and five different drivers
    Shop shop = new Shop("Five Below");

    Driver driver1 = new Driver("John", "Van");
    Driver driver2 = new Driver("Johnny", "Taxi");
    Driver driver3 = new Driver("Jim", "Scooter");
    Driver driver4 = new Driver("Jimmy", "Van");
    Driver driver5 = new Driver("Timmy", "Taxi");

    // Given: all 5 of the drivers are subscribed to the same shop
    shop.subscribe(driver1);
    shop.subscribe(driver2);
    shop.subscribe(driver3);
    shop.subscribe(driver4);
    shop.subscribe(driver5);

    // When: the shop creates a delivery request and sends it to subscribers
    shop.createDeliveryRequest("Pool Noodles", "Deliver to Roxbury");

    // Then: All five drivers should have received the same delivery request
    DeliveryRequest request = shop.getLatestDeliveryRequest();

    assertSame(request, driver1.getLatestDeliveryRequest());
    assertSame(request, driver2.getLatestDeliveryRequest());
    assertSame(request, driver3.getLatestDeliveryRequest());
    assertSame(request, driver4.getLatestDeliveryRequest());
    assertSame(request, driver5.getLatestDeliveryRequest());
  }
}
