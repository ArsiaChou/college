package beans;

import org.springframework.stereotype.Repository;

public class AutoLoad {
    private AutoBean autoBean;

    public AutoBean getAutoBean() {
        return autoBean;
    }

    public void setAutoBean(AutoBean autoBean) {
        this.autoBean = autoBean;
    }
}
