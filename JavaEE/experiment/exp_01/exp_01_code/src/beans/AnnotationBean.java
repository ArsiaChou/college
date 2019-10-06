package beans;

import org.springframework.stereotype.Repository;

@Repository("annotationBean")
public class AnnotationBean extends ExBean{

    public AnnotationBean(int number, String name, String value) {
        super(number, name, value);
    }

    public AnnotationBean() {
        super(2, "anno_name", "anno_value");
    }
}
