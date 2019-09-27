package cha01_pk01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestIoc {

    public static void main (String[] args) {
        ApplicationContext appCon = new FileSystemXmlApplicationContext("config/cha01_pk01_config.xml");
        UserDao userDao = (UserDao) appCon.getBean("userDao");
        userDao.say();
    }
}
