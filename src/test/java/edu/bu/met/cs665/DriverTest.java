package edu.bu.met.cs665;

import org.junit.Test;
import static org.junit.Assert.*;

public class DriverTest {

  @Test
  public void testMakeDriver() {
    // Given: a driver named "Kemba" that drives a "Van"
    String name = "Kemba";
    String type = "Van";

    // When: a Driver is created
    Driver driver = new Driver(name, type);

    // Then: the driver should be called "Kemba" and drives a "Van", with
    // no a null delivery request.
    assertEquals("Kemba", driver.getDriverName());
    assertEquals("Van", driver.getVehicleType());
    assertNull(driver.getLatestDeliveryRequest());
  }

  @Test
  public void testDriverUpdate() {
    // Given: a shop and a driver
    Shop shop = new Shop("Best Buy");
    Driver driver = new Driver("John", "Taxi");

    // When: a new delivery request is created and updated to the driver
    DeliveryRequest request = new DeliveryRequest(
      "Laptop", "Deliver to Boston", shop);
    driver.update(request);

    // Then: The request should equal to the latest request received by the driver
    assertSame(request, driver.getLatestDeliveryRequest());
  }

  @Test
  public void testInvalidVehicleType() {
    // Given: an invalid vehicle type
    String vehicleType = "airplane";

    // When: a Driver object is created with this type
    IllegalArgumentException exception =
      assertThrows(IllegalArgumentException.class, () -> {
        new Driver("Bob", vehicleType);
      });

    // Then: the correct error message should be returned
    assertEquals(
      "Invalid vehicle type: please choose either Van, Taxi, or Scooter.",
      exception.getMessage()
    );
  }
}
