import beans.AnnotationLoad;
import beans.AutoLoad;
import beans.XMLBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test {
    private static final String configFile_xmlLoad = "config/xml_load.xml";
    private static final String configFile_annotationLoad = "config/annotation_load.xml";
    private static final String configFile_autoLoad = "config/auto_load.xml";
    private static ApplicationContext applicationContext;


    public static void xmlLoad() {
        applicationContext = new FileSystemXmlApplicationContext(configFile_xmlLoad);
        XMLBean beanT = (XMLBean) applicationContext.getBean("bean-t");
        System.out.println("xml load: "+beanT);
    }

    public static void annotationLoad() {
        applicationContext = new FileSystemXmlApplicationContext(configFile_annotationLoad);
        AnnotationLoad annotationLoad = (AnnotationLoad) applicationContext.getBean("annotationLoad");
        System.out.println("annotation load: " + annotationLoad.getAnnotationBean());
    }

    public static void autoLoad() {
        applicationContext = new FileSystemXmlApplicationContext(configFile_autoLoad);
        AutoLoad autoLoad = (AutoLoad) applicationContext.getBean("autoLoad");
        System.out.println("auto load: "+autoLoad.getAutoBean());
    }

    public static void main(String[] args) {
        xmlLoad();
        annotationLoad();
        autoLoad();
    }
}
