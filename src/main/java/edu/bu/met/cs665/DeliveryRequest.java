/**
 * Name: Chin Fung Lam Marco
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/20/2026
 * File Name: DeliveryRequest.java
 * Description: This class is responsible for making Delivery Requests.
 */

package edu.bu.met.cs665;

/**
 * This is the DeliveryRequest class.
 * This class is responsible for representing the delivery requests
 * that can be created by shops.
 */
public class DeliveryRequest {

  private String product;
  private String description;
  private final Shop shop;

  /**
   * Create a DeliveryRequest object using the product name, the description of
   * the request, and the shop that created the request.
   *
   * @param product The name of the product to deliver.
   * @param description The description of the delivery request.
   * @param shop The shop that requested this delivery.
   */
  public DeliveryRequest(String product, String description, Shop shop) {
    setProduct(product);
    setDescription(description);
    this.shop = shop;
  }

  /**
   * Getter method for the product name of the request.
   *
   * @return Product as a String.
   */
  public String getProduct() {
    return this.product;
  }

  /**
   * Setter method for the product of the delivery request.
   *
   * @param product Product to deliver.
   */
  public void setProduct(String product) {
    this.product = product;
  }

  /**
   * Getter method for the description of the delivery.
   *
   * @return Description of delivery request as a String.
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * Setter method for the description of the delivery.
   *
   * @param description Description of the delivery request.
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Getter method of the shop that made the request.
   *
   * @return Shop that created the delivery request.
   */
  public Shop getShop() {
    return this.shop;
  }
}

