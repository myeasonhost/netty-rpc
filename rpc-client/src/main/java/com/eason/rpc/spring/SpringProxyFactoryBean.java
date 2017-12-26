package com.eason.rpc.spring;

import com.eason.rpc.common.annotation.ClientService;
import com.eason.rpc.proxy.RpcProxyFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;


public class SpringProxyFactoryBean<T> implements InitializingBean, FactoryBean<T> {

    @Autowired
    private RpcProxyFactory rpcProxyFactory;

    private String innerClassName;


    public T getObject() throws Exception {
        Class innerClass = Class.forName(innerClassName);
        if (innerClass.isInterface()) {
            return null;
        }
        Field[] fields = innerClass.getDeclaredFields();
        T target=(T)innerClass.newInstance();
        for (Field field : fields) {
            ClientService clientService = field.getAnnotation(ClientService.class);
            if (clientService!=null){
                long timeoutInMillis = clientService.timeout();
                String host=clientService.address().split(":")[0];
                Integer port=Integer.parseInt(clientService.address().split(":")[1]);
                field.setAccessible(true);
                field.set(target,rpcProxyFactory.proxyBean(host,port,field.getType(),timeoutInMillis));
            }
        }
        return  target;
    }

    public Class<?> getObjectType() {
        try {
            if (innerClassName!=null){
                return Class.forName(innerClassName);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean isSingleton() {
        return true;
    }

    public void afterPropertiesSet() throws Exception {

    }

    public String getInnerClassName() {
        return innerClassName;
    }

    public void setInnerClassName(String innerClassName) {
        this.innerClassName = innerClassName;
    }

}
