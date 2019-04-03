package c.hao.spring.study.service.impl;

import c.hao.spring.study.bean.Order;
import c.hao.spring.study.service.OrderService;

/**
 * @author by haoxpdp
 * @date 19-4-3 下午5:39
 */
public class OrderServiceImpl implements OrderService {
    public Order createOrder(String username, String product) {
        Order order = new Order();
        order.setUsername(username);
        order.setProduct(product);
        return order;
    }

    public Order queryOrder(String username) {
        Order order = new Order();
        order.setUsername("test");
        order.setProduct("test");
        return order;
    }
}
