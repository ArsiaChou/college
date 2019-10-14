package cha03_pk01;

import cha03_pk01.aspect.JdkProxy;
import cha03_pk01.user.UserDao;
import cha03_pk01.user.UserDaoImpl;

public class Test {
    public static void main(String[] args) {
        JdkProxy jdkProxy = new JdkProxy();
        UserDao userDao = new UserDaoImpl();
        UserDao userDao1 = (UserDao) jdkProxy.createProxy(userDao);

        userDao1.addUser();
        userDao1.deleteUser();
        userDao1.queryUser("ars");
    }
}
