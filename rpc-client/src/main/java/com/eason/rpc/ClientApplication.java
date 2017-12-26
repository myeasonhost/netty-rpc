package com.eason.rpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class ClientApplication {

//    @Bean
//    public RpcProxyFactory rpcProxyFactory(){
//        return new RpcProxyFactory();
//    }

    /**
     * 也可以采用配置文件的方式
     * 如果不想自己proxy,可以像dubbo那样扩展schema
     * 或者自己scan指定包,在FactoryBean里头替换
     * @param
     * @return
     */
//    @Bean
//    public HelloService buildHelloService(RpcProxyFactory rpcProxyFactory){
//        return rpcProxyFactory.proxyBean(HelloService.class,100/*timeout*/);
//    }

    public static void main(String[] args){
        SpringApplication app = new SpringApplication(ClientApplication.class);
        app.setWebEnvironment(false);
        app.run(args);
    }
}
