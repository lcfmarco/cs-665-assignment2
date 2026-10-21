/**
 * Name: Chin Fung Lam Marco
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/20/2026
 * File Name: SubscriberBase.java
 * Description: This interface is used for all subscribers in the delivery system.
 */

package edu.bu.met.cs665;

/**
 * Interface that defines the method that allow subscribers to receive notifications
 * whenever a new delivery request is sent by a publisher.
 */
public interface SubscriberBase {

  /**
   * Receives a notification from the publisher when a new delivery request is available.
   *
   * @param request The delivery request sent by the publisher.
   */
  void update(DeliveryRequest request);
}
