package com.epam.engx.cleancode.naming;

import com.epam.engx.cleancode.naming.thirdpartyjar.Order;
import com.epam.engx.cleancode.naming.thirdpartyjar.Submitable;

public interface OrderService extends Submitable {
    void submitOrder(Order order);
}
