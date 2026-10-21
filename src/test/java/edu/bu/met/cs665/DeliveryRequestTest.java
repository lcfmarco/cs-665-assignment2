package edu.bu.met.cs665;

import org.junit.Test;
import static org.junit.Assert.*;

public class DeliveryRequestTest {

  @Test
  public void testMakeDeliveryRequest() {
    // Given: a product name, description, and a shop
    String product = "Milk";
    String description = "Deliver milk to Cambridge by Sunday.";
    Shop shop = new Shop("Trader Joe's");

    // When: Delivery Request is created by the shop
    DeliveryRequest request = new DeliveryRequest(product, description, shop);

    // Then: Delivery Request should match the product, description, and shop
    assertEquals("Milk", request.getProduct());
    assertEquals("Deliver milk to Cambridge by Sunday.",
                  request.getDescription());
    assertSame(shop, request.getShop());
  }
}
