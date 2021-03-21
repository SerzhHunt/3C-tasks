package com.epam.engx.cleancode.naming.delivery;

import com.epam.engx.cleancode.naming.thirdpartyjar.DeliveryService;
import com.epam.engx.cleancode.naming.thirdpartyjar.Order;

public class FalseDeliveryServiceStub implements DeliveryService {
    @Override
    public boolean isDelivery(Order order) {
        return false;
    }
}
