package cha01_pk01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIoc {

    public static void main (String[] args) {
        ApplicationContext appCon = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) appCon.getBean("userDao");
        userDao.say();
    }
}
