package c.hao.spring.study.service.impl;

import c.hao.spring.study.bean.User;
import c.hao.spring.study.service.UserService;

/**
 * @author by haoxpdp
 * @date 19-4-3 下午5:39
 */
public class UserServiceImpl implements UserService {

    public User createUser(String firstName, String lastName, String age) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAge(age);
        return user;
    }

    public User queryUser() {
        User user = new User();
        user.setFirstName("test");
        user.setLastName("test");
        user.setAge("20");
        return user;
    }
}
