package com.epam.engx.cleancode.naming.collection;

import com.epam.engx.cleancode.naming.OrderService;
import com.epam.engx.cleancode.naming.thirdpartyjar.CollectionService;
import com.epam.engx.cleancode.naming.thirdpartyjar.Message;
import com.epam.engx.cleancode.naming.thirdpartyjar.NotificationManager;
import com.epam.engx.cleancode.naming.thirdpartyjar.Order;

public class CollectOrderService implements OrderService {
    private static final int INF0_NOTIFICATION = 4;
    private static final int CRITICAL_NOTIFICATION = 1;

    private CollectionService collectionService;
    private NotificationManager notificationManager;

    @Override
    public void submitOrder(Order order) {
        if (collectionService.isEligibleForCollection(order)) {
            notificationManager.notifyCustomer(Message.READY_FOR_COLLECT, INF0_NOTIFICATION); // 4 - info notification level
        } else
            notificationManager.notifyCustomer(Message.IMPOSSIBLE_TO_COLLECT, CRITICAL_NOTIFICATION); // 1 - critical notification level
    }

    public void setCollectionService(CollectionService collectionService) {
        this.collectionService = collectionService;
    }

    public void setNotificationManager(NotificationManager notificationManager) {
        this.notificationManager = notificationManager;
    }
}
