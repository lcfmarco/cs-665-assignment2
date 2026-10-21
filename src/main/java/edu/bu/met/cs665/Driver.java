/**
 * Name: Chin Fung Lam Marco
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/20/2026
 * File Name: Driver.java
 * Description: This class is responsible for the delivery driver.
 */

package edu.bu.met.cs665;

/**
 * Driver class that uses the SubscriberBase interface as
 * the drivers are subscribing to shops (the publishers).
 */
public class Driver implements SubscriberBase {

  // String list of valid Driver types
  private static final String[] DRIVER_TYPES = {
    "Van",
    "Taxi",
    "Scooter"
  };

  private String driverName;
  private String vehicleType;
  private DeliveryRequest latestDeliveryRequest;

  /**
   * Constructor for Driver.
   *
   * @param driverName The name of the driver.
   * @param vehicleType The type of vehicle.
   */
  public Driver(String driverName, String vehicleType) {
    setDriverName(driverName);
    setVehicleType(vehicleType);
  }

  /**
   * Getter method for the Driver's name.
   *
   * @return The name of the driver as a String.
   */
  public String getDriverName() {
    return this.driverName;
  }

  /**
   * Setter method for the Driver's name.
   *
   * @param driverName The name of the driver to set.
   */
  public void setDriverName(String driverName) {
    this.driverName = driverName;
  }

  /**
   * Getter method for the type of vehicle.
   *
   * @return Vehicle type as a String.
   */
  public String getVehicleType() {
    return this.vehicleType;
  }

  /**
   * Setter method for the vehicle type, and ensures that the vehicle
   * type is valid by comparing it to DRIVER_TYPES.
   *
   * @param vehicleType The vehicle type to create.
   */
  public void setVehicleType(String vehicleType) {
    for (String type : DRIVER_TYPES) {
      if (type.equalsIgnoreCase(vehicleType)) {
        this.vehicleType = type;
        return;
      }
    }
    throw new IllegalArgumentException(
        "Invalid vehicle type: please choose either Van, Taxi, or Scooter."
    );
  }

  /**
   * Updates the most recent delivery request received by the Driver.
   *
   * @param request The delivery request sent by the publisher.
   */
  public void update(DeliveryRequest request) {
    this.latestDeliveryRequest = request;
  }

  /**
   * Getter method for the latest delivery request received by the Driver.
   *
   * @return Latest Delivery Request as a DeliveryRequest object.
   */
  public DeliveryRequest getLatestDeliveryRequest() {
    return this.latestDeliveryRequest;
  }
}
