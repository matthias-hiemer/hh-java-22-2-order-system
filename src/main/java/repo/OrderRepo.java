package repo;

import model.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderRepo {

    private Map<String, Order> orders = new HashMap();

    public void addOrder(Order order) {
        orders.put(order.getId(), order);
    }

    public Order getOrder(String id) {
        Order foundOrder = orders.get(id);

        return foundOrder;
    }

    public List<Order> listOrders() {
        return new ArrayList<>(orders.values());
    }

}
