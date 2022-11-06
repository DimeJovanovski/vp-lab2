package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Order placeOrder(String balloonColor, String clientName, String address);

    List<Order> findAll();

    Optional<Order> findById(Long id);

    Optional<Order> save(String balloonColor, String balloonSize, String clientName, String clientAddress);

    // String balloonColor, String balloonSize, String clientName, String clientAddress
    Order addPendingOrder(String balloonColor, String balloonSize, String clientName, String clientAddress);

    Order getPendingOrder();

    void removePendingOrder();

}