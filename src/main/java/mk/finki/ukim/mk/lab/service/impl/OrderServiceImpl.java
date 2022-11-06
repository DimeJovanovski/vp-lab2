package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.repository.OrderRepository;
import mk.finki.ukim.mk.lab.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order placeOrder(String balloonColor, String clientName, String address) {
        return null;
    }

    @Override
    public List<Order> findAll() {
        return this.orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(Long id) {
        return this.orderRepository.findById(id);
    }

    @Override
    public Optional<Order> save(String balloonColor, String balloonSize, String clientName, String clientAddress) {
        return this.orderRepository.save(balloonColor, balloonSize, clientName, clientAddress);
    }

    @Override
    public Order addPendingOrder(String balloonColor, String balloonSize, String clientName, String clientAddress) {
        return this.orderRepository.addPendingOrder(balloonColor, balloonSize, clientName, clientAddress);
    }

    @Override
    public Order getPendingOrder() {
        return this.orderRepository.getPendingOrder();
    }

    @Override
    public void removePendingOrder() {
        this.orderRepository.removePendingOrder();
    }
}
