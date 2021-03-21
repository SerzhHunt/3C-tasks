package com.epam.engx.cleancode.naming.delivery;

import com.epam.engx.cleancode.naming.OrderService;
import com.epam.engx.cleancode.naming.thirdpartyjar.*;

public class DeliveryOrderService implements OrderService {

    private DeliveryService deliveryService;
    private OrderFulfilmentService orderService;

    @Override
    public void submitOrder(Order order) {
        if (deliveryService.isDelivery(order)) {
            orderService.fulfilProducts(order.getProducts());
        } else {
            throw new DeliveryOrderNotFoundException();
        }
    }

    public void setDeliveryService(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    public void setOrderService(OrderFulfilmentService orderService) {
        this.orderService = orderService;
    }
}
