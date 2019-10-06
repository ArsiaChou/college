package beans;

import org.springframework.stereotype.Repository;
import javax.annotation.Resource;

@Repository("annotationLoad")
public class AnnotationLoad {
    @Resource(name="annotationBean")
    private AnnotationBean annotationBean;

    public AnnotationBean getAnnotationBean() {
        return annotationBean;
    }
}
