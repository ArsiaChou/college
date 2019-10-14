package cha03_pk01.aspect;

import cha03_pk01.user.UserDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy implements InvocationHandler {
    private UserDao userDao;

    public Object createProxy(UserDao userDao) {
        this.userDao = userDao;
        ClassLoader classLoader = JdkProxy.class.getClassLoader();
        Class[] classes = userDao.getClass().getInterfaces();
        return Proxy.newProxyInstance(classLoader, classes, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MyAspect myAspect = new MyAspect();
        Object object;
        if (!method.getName().equals("queryUser")) {
            myAspect.checkPermissions();
            object = method.invoke(userDao, args);
            myAspect.log();
        } else {
            object = null;
            userDao.queryUser((String) args[0]);
        }
        return object;
    }
}
