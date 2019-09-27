package cha02_pk02;

import cha02_pk02.beans.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.io.File;

public class AnnotationAssembleTest {
    private static final String xmlConfigFile = "config/cha02_pk02_config.xml";
    public static void main(String[] args) {
        System.out.println("xml file exist: "+ new File(xmlConfigFile).exists());

        ApplicationContext appCon = new FileSystemXmlApplicationContext(xmlConfigFile);

        UserController userController = (UserController) appCon.getBean("userController");
        userController.save();
    }
}
