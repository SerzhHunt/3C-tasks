package com.epam.engx.cleancode.naming.collection;

import com.epam.engx.cleancode.naming.OrderService;
import com.epam.engx.cleancode.naming.thirdpartyjar.CollectionService;
import com.epam.engx.cleancode.naming.thirdpartyjar.Message;
import com.epam.engx.cleancode.naming.thirdpartyjar.NotificationManager;
import com.epam.engx.cleancode.naming.thirdpartyjar.Order;

public class CollectOrderService implements OrderService {
    private static final int INF0_LEVEL = 4;
    private static final int CRITICAL_LEVEL = 1;

    private CollectionService collectionService;
    private NotificationManager notificationManager;

    @Override
    public void submitOrder(Order order) {
        if (collectionService.isEligibleForCollection(order)) {
            notificationManager.notifyCustomer(Message.READY_FOR_COLLECT, INF0_LEVEL);
        } else
            notificationManager.notifyCustomer(Message.IMPOSSIBLE_TO_COLLECT, CRITICAL_LEVEL);
    }

    public void setCollectionService(CollectionService collectionService) {
        this.collectionService = collectionService;
    }

    public void setNotificationManager(NotificationManager notificationManager) {
        this.notificationManager = notificationManager;
    }
}
