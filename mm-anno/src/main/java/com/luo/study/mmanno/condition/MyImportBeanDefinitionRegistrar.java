package com.luo.study.mmanno.condition;

import com.luo.study.mmanno.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     * AnnotationMetadata：当前类的注解信息
     * BeanDefinitionRegistry:BeanDefinition注册类；
     * 		把所有需要添加到容器中的bean；调用
     * 		BeanDefinitionRegistry.registerBeanDefinition手工注册进来
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {

        boolean beanDefinition = beanDefinitionRegistry.containsBeanDefinition("com.luo.study.mmanno.bean.Blue");
        boolean beanDefinition2 = beanDefinitionRegistry.containsBeanDefinition("com.luo.study.mmanno.bean.Yellow");
        if (beanDefinition && beanDefinition2){
            //指定Bean定义信息；（Bean的类型，Bean。。。）
            RootBeanDefinition rainBow = new RootBeanDefinition(RainBow.class);
            //注册一个Bean，指定bean名
            beanDefinitionRegistry.registerBeanDefinition("rainBow", rainBow);
        }
    }
}
