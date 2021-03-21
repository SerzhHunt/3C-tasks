package com.epam.engx.cleancode.naming.delivery;

import com.epam.engx.cleancode.naming.thirdpartyjar.DeliveryService;
import com.epam.engx.cleancode.naming.thirdpartyjar.Order;

public class TrueDeliveryServiceStub implements DeliveryService {

    @Override
    public boolean isDelivery(Order o) {
        return true;
    }
}
