package c.hao.spring.study.bean;

import org.springframework.beans.factory.InitializingBean;

import java.sql.SQLOutput;

/**
 * @author by haoxpdp
 * @date 19-4-3 下午5:31
 */
public class Order {
    String id;
    String username;
    String amount;
    String product;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", amount='" + amount + '\'' +
                ", product='" + product + '\'' +
                '}';
    }


}
