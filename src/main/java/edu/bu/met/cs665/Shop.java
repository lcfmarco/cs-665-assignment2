/**
 * Name: Chin Fung Lam Marco
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/20/2026
 * File Name: Shop.java
 * Description: This class sets up the shop responsible for keeping track of subscribed
 *              drivers and creating delivery requests to send out.
 */

package edu.bu.met.cs665;

import edu.bu.met.cs665.observer.PublisherBase;
import edu.bu.met.cs665.observer.SubscriberBase;

import java.util.ArrayList;

/**
 * The Shop class implements the PublisherBase interface as it is the one broadcasting
 * a message to the Subscribers.
 */
public class Shop implements PublisherBase {

  private String name;
  private DeliveryRequest latestDeliveryRequest;
  private ArrayList<SubscriberBase> subscribers;

  /**
   * Shop constructor that sets the Shop name, and initializes an empty subscribers list
   * with no delivery request.
   *
   * @param name the name of the shop.
   */
  public Shop(String name) {
    this.name = name;
    this.latestDeliveryRequest = null;
    this.subscribers = new ArrayList<SubscriberBase>();
  }

  /**
   * Getter method for the shop name.
   *
   * @return name of the shop as a String.
   */
  public String getName() {
    return this.name;
  }

  /**
   * Setter method for the shop name.
   *
   * @param name Name of the shop.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Method for shops to create delivery requests and broadcast to subscribers.
   *
   * @param product The product to deliver.
   * @param description The description of the delivery.
   */
  public void createDeliveryRequest(String product, String description) {
    DeliveryRequest request = new DeliveryRequest(product, description, this);
    setLatestDeliveryRequest(request);
  }

  /**
   * Method to update existing and latest delivery request and broadcast the update
   * to subscribers.
   *
   * @param product the new product name to update
   * @param description the new description to update
   */
  public void updateDeliveryRequest(String product, String description) {

    // Can't update a delivery if it doesn't exist
    if (this.latestDeliveryRequest == null) {
      throw new IllegalStateException("No delivery request exists to update.");
    }

    latestDeliveryRequest.setProduct(product);
    latestDeliveryRequest.setDescription(description);
    this.notifySubscribers();
  }

  /**
   * Private Setter method for the latest delivery request sent from the shop.
   *
   * @param request The latest delivery request sent out by the shop.
   */
  private void setLatestDeliveryRequest(DeliveryRequest request) {
    this.latestDeliveryRequest = request;
    this.notifySubscribers();
  }

  /**
   * Getter method for the latest delivery request created by the shop.
   *
   * @return the latest delivery request of the shop.
   */
  public DeliveryRequest getLatestDeliveryRequest() {
    return this.latestDeliveryRequest;
  }

  /**
   * Method to add a subscriber to the shop.
   *
   * @param subscriber The subscriber to be added.
   */
  public void subscribe(SubscriberBase subscriber) {
    if (!subscribers.contains(subscriber)) {
      subscribers.add(subscriber);
    }
  }

  /**
   * Method to unsubscribe a subscriber from the shop.
   *
   * @param subscriber The subscriber to be removed.
   */
  public void unsubscribe(SubscriberBase subscriber) {
    subscribers.remove(subscriber);
  }

  /**
   * Method to notify subscribers with a new delivery request
   * or with a change to an existing delivery request.
   */
  public void notifySubscribers() {
    for (SubscriberBase subscriber : subscribers) {
      subscriber.update(this.latestDeliveryRequest);
    }
  }
}
