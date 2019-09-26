package bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBeanT {
    public static void main(String[] args) {
        ApplicationContext appCon = new ClassPathXmlApplicationContext("applicationContext.xml");

        BeanT id_bean = (BeanT) appCon.getBean("id-bean"),
                name_bean = (BeanT) appCon.getBean("name-bean"),
                class_bean = (BeanT) appCon.getBean("bean.BeanT"),
                factory_static_bean = (BeanT) appCon.getBean("factory-static-bean"),
                factory_bean = (BeanT) appCon.getBean("factory-bean");

        System.out.println("id_bean: "+id_bean);
        System.out.println("name_bean: "+name_bean);
        System.out.println("class_bean: "+class_bean);
        System.out.println("factory_static_bean: "+factory_static_bean);
        System.out.println("factory_bean: "+factory_bean);

        BeanT beanT1 = (BeanT) appCon.getBean("scope-prototype"),
                beanT2 = (BeanT) appCon.getBean("scope-prototype"),
                beanT3 = (BeanT) appCon.getBean("scope-singleton"),
                beanT4 = (BeanT) appCon.getBean("scope-singleton");

        System.out.println();
        System.out.println("scope-prototype equals: "+beanT1.equals(beanT2));
        System.out.println("scope-singleton equals: "+beanT3.equals(beanT4));
        System.out.println("scope-prototype ==: "+(beanT1 == beanT2));
        System.out.println("scope-singleton ==: "+(beanT3 == beanT4));

        BeanT property_bean = (BeanT) appCon.getBean("property-bean");
        System.out.println("property-bean: name="+property_bean.getName()+", value="+property_bean.getValue());
    }
}
