package cha02_pk01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.io.File;

public class TestBeanT {
    private static final String xmlConfigFilePath = "config/cha02_pk01_config.xml";
    //create
    public static void test01(ApplicationContext appCon) {
        BeanT id_bean = (BeanT) appCon.getBean("id-bean"),
                name_bean = (BeanT) appCon.getBean("name-bean"),
                class_bean = (BeanT) appCon.getBean("cha02_pk01.BeanT"),
                factory_static_bean = (BeanT) appCon.getBean("factory-static-bean"),
                factory_bean = (BeanT) appCon.getBean("factory-bean");

        System.out.println("id_bean: "+id_bean);
        System.out.println("name_bean: "+name_bean);
        System.out.println("class_bean: "+class_bean);
        System.out.println("factory_static_bean: "+factory_static_bean);
        System.out.println("factory_bean: "+factory_bean);
    }

    //scope
    public static void test02(ApplicationContext appCon) {
        BeanT beanT1 = (BeanT) appCon.getBean("scope-prototype"),
                beanT2 = (BeanT) appCon.getBean("scope-prototype"),
                beanT3 = (BeanT) appCon.getBean("scope-singleton"),
                beanT4 = (BeanT) appCon.getBean("scope-singleton");

        System.out.println();
        System.out.println("scope-prototype equals: "+beanT1.equals(beanT2));
        System.out.println("scope-singleton equals: "+beanT3.equals(beanT4));
        System.out.println("scope-prototype ==: "+(beanT1 == beanT2));
        System.out.println("scope-singleton ==: "+(beanT3 == beanT4));
    }

    //设值注入
    public static void test03(ApplicationContext appCon) {
        BeanT property_bean = (BeanT) appCon.getBean("property-bean"),
                constructor_bean = (BeanT) appCon.getBean("constructor-bean");

        System.out.println("property-bean: "+property_bean);
        System.out.println("constructor-bean: "+constructor_bean);
    }

    public static void main(String[] args) {
        System.out.println("xml file exist: "+new File(xmlConfigFilePath).exists());

        ApplicationContext appCon = new FileSystemXmlApplicationContext(xmlConfigFilePath);

        //test01(appCon);
        //test02(appCon);
        test03(appCon);
    }
}
