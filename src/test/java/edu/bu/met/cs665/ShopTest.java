package edu.bu.met.cs665;

import org.junit.Test;
import static org.junit.Assert.*;

public class ShopTest {

  @Test
  public void testCreateDeliveryRequest() {
    // Given: a shop
    Shop shop = new Shop("Walmart");

    // When: the shop creates a new delivery request
    shop.createDeliveryRequest("Laptop", "Deliver to Allston");

    // Then: verify that the delivery request was created correctly
    DeliveryRequest request = shop.getLatestDeliveryRequest();

    assertEquals("Laptop", request.getProduct());
    assertEquals("Deliver to Allston", request.getDescription());
    assertSame(shop, request.getShop());
  }

  @Test
  public void testUpdateDeliveryRequest() {
    // Given: a shop with an existing delivery request
    Shop shop = new Shop("Apple Store");
    shop.createDeliveryRequest("iPhone", "Deliver to Dorchester");

    // When: the shop updates the delivery request
    shop.updateDeliveryRequest("iPad", "Deliver to Quincy.");

    // Then: Verify that the delivery request was updated
    DeliveryRequest request = shop.getLatestDeliveryRequest();

    assertEquals("iPad", request.getProduct());
    assertEquals("Deliver to Quincy.", request.getDescription());
  }

  @Test
  public void testSubscribe() {
    // Given: a shop and a driver
    Shop shop = new Shop("Whole Foods");
    Driver driver = new Driver("Tim", "Scooter");

    // When: driver subscribes to the shop and the shop creates a request
    shop.subscribe(driver);
    shop.createDeliveryRequest("Apples", "Deliver to Boston");

    // Then: Verify that the driver received the delivery request
    assertSame(shop.getLatestDeliveryRequest(), driver.getLatestDeliveryRequest());
  }

  @Test
  public void testUnsubscribe() {
    // Given: a shop with a subscribed driver
    Shop shop = new Shop("Best Buy");
    Driver driver = new Driver("John", "Van");
    shop.subscribe(driver);

    shop.createDeliveryRequest("Laptop", "Deliver to Boston");
    DeliveryRequest firstRequest = driver.getLatestDeliveryRequest();

    // When: the driver unsubscribes, and a new request is created
    shop.unsubscribe(driver);
    shop.createDeliveryRequest("Monitor", "Deliver to Cambridge");

    // Then: verify that the driver has the previous request
    assertSame(firstRequest, driver.getLatestDeliveryRequest());
    assertNotSame(shop.getLatestDeliveryRequest(), driver.getLatestDeliveryRequest());
  }
}
