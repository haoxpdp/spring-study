package c.hao.spring.study.service;

import c.hao.spring.study.bean.Order;

/**
 * @author by haoxpdp
 * @date 19-4-3 下午5:31
 */
public interface OrderService {

    Order createOrder(String username, String product);

    Order queryOrder(String username);
}
