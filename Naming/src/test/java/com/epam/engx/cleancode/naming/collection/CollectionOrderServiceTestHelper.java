package com.epam.engx.cleancode.naming.collection;

import com.epam.engx.cleancode.naming.thirdpartyjar.CollectionService;
import com.epam.engx.cleancode.naming.thirdpartyjar.Submitable;

public class CollectionOrderServiceTestHelper {

    public CollectOrderService getService(){
        return new CollectOrderService();
    }

    public void submit(Submitable collectOrderService) {
        ((CollectOrderService) collectOrderService).submitOrder(new OrderDummy());
    }

    public void setNotificationManager(NotificationManagerMock notificationManagerMock, Submitable collectOrderService) {
        ((CollectOrderService) collectOrderService).setNotificationManager(notificationManagerMock);
    }

    public void setCollectionService(Submitable collectOrderService, CollectionService collectionServiceStub) {
        ((CollectOrderService) collectOrderService).setCollectionService(collectionServiceStub);
    }
}
