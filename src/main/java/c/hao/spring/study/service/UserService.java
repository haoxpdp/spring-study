package c.hao.spring.study.service;

import c.hao.spring.study.bean.User;

/**
 * @author by haoxpdp
 * @date 19-4-3 下午5:38
 */
public interface UserService {
    User createUser(String firstName, String lastName, String age);

    User queryUser();
}
