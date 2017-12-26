package com.eason.rpc.spring;

import com.eason.rpc.common.annotation.ClientExporter;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.Arrays;
import java.util.Set;

public class RpcScanner extends ClassPathBeanDefinitionScanner {
    public RpcScanner(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public void registerDefaultFilters() {
        this.addIncludeFilter(new AnnotationTypeFilter(ClientExporter.class));
    }

    public boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        return super.isCandidateComponent(beanDefinition) && beanDefinition.getMetadata()
                .hasAnnotation(ClientExporter.class.getName());
    }

    @Override
    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
        logger.info("Scan dir=" + Arrays.toString(basePackages));
        Set<BeanDefinitionHolder> beanDefinitions = super.doScan(basePackages);
        for (BeanDefinitionHolder holder : beanDefinitions) {
            try {
                GenericBeanDefinition definition = (GenericBeanDefinition) holder.getBeanDefinition();
                definition.getPropertyValues().add("innerClassName", definition.getBeanClassName());
                definition.setBeanClass(SpringProxyFactoryBean.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return beanDefinitions;
    }
}
