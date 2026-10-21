/**
 * Name: Chin Fung Lam Marco
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/20/2026
 * File Name: PublisherBase.java
 * Description: This interface is used for all publishers in the delivery system.
 */

package edu.bu.met.cs665.observer;

/**
 * Interface that defines the behavior for publishers to manage
 * subscribers and notify them when a new delivery request is available.
 */
public interface PublisherBase {

  /**
   * Adds a subscriber to receive delivery request notifications.
   *
   * @param subscriber The subscriber to be added.
   */
  void subscribe(SubscriberBase subscriber);

  /**
   * Removes a subscriber from receiving delivery request notifications.
   *
   * @param subscriber The subscriber to be removed.
   */
  void unsubscribe(SubscriberBase subscriber);

  /**
   * Notifies all registered subscribers about a delivery request.
   */
  void notifySubscribers();
}
