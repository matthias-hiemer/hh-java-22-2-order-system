package repo;

import model.Order;
import model.Product;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderRepoTest {

    @Test
    void addOrder_whenGivenOrder_addsOrder(){
        // GIVEN
        List<Product> products = List.of(
                new Product("P1", "Nudeln"),
                new Product("P2", "Klopapier")
        );
        Order order1 = new Order("O-1", products);

        OrderRepo orderRepo = new OrderRepo();

        // WHEN
        orderRepo.addOrder(order1);
        Order actual = orderRepo.getOrder("O-1");

        // THEN
        Order expected = new Order("O-1", products);
        assertEquals(expected, actual);
    }

    @Test
    void listOrders_whenCalled_returnsAllOrders(){
        // GIVEN
        List<Product> products1 = List.of(
                new Product("P1", "Nudeln"),
                new Product("P2", "Klopapier")
        );
        Order order1 = new Order("O-1", products1);

        List<Product> products2 = List.of(
                new Product("P3", "Counterstrike 1.6")
        );
        Order order2 = new Order("O-2", products2);

        OrderRepo orderRepo = new OrderRepo();

        orderRepo.addOrder(order1);
        orderRepo.addOrder(order2);

        // WHEN
        List<Order> actual = orderRepo.listOrders();

        // THEN
        Order expectedOrder1 = new Order("O-1", products1);
        Order expectedOrder2 = new Order("O-2", products2);
        List<Order> expected = List.of(expectedOrder1, expectedOrder2);

        assertEquals(expected, actual);

    }

}