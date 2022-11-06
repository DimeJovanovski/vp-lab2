package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Order;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository {
    public List<Order> findAll() {
        return DataHolder.orders;
    }

    public Optional<Order> findById(Long id) {
        return DataHolder.orders.stream().filter(r -> r.getOrderId().equals(id)).findFirst();
    }

    public Optional<Order> save(String color, String size, String clientName, String clientAddress) {
        Order order = new Order(color, size, clientName, clientAddress);
        DataHolder.orders.removeIf(r -> r.getBalloonColor().equals(color));
        DataHolder.orders.add(order);
        return Optional.of(order);
    }

    public Order addPendingOrder(String balloonColor, String balloonSize, String clientName, String clientAddress) {
        Order order = new Order(balloonColor, balloonSize, clientName, clientAddress);
        DataHolder.pedingOrder = order;
        return order;
    }

    public void removePendingOrder() {
        DataHolder.pedingOrder=null;
    }

    public Order getPendingOrder() {
        return DataHolder.pedingOrder;
    }
}
