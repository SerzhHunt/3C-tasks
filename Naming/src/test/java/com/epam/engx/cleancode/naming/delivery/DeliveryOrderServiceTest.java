package com.epam.engx.cleancode.naming.delivery;

import com.epam.engx.cleancode.naming.thirdpartyjar.DeliveryOrderNotFoundException;
import org.junit.Test;

public class DeliveryOrderServiceTest {

    private DeliveryOrderService deliveryOrderService = new DeliveryOrderService();

    @Test
    public void shouldDeliverProducts() {
        OrderFulfilmentServiceMock fulfilmentServiceMock = new OrderFulfilmentServiceMock();
        deliveryOrderService.setOrderService(fulfilmentServiceMock);
        deliveryOrderService.setDeliveryService(new TrueDeliveryServiceStub());
        deliveryOrderService.submitOrder(new OrderStub("product-1"));
        fulfilmentServiceMock.assertFirstProductName("product-1");
    }

    @Test (expected = DeliveryOrderNotFoundException.class)
    public void shouldNotDeliverProducts() {
        deliveryOrderService.setDeliveryService(new FalseDeliveryServiceStub());
        deliveryOrderService.submitOrder(new OrderStub("product-1"));
    }

}
