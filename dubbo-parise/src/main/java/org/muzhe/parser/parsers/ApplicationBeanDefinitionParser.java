package org.muzhe.parser.parsers;

import com.google.common.base.Strings;
import com.sun.org.glassfish.gmbal.ManagedObject;
import lombok.Getter;
import org.muzhe.parser.bean.Application;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.w3c.dom.Element;

/**
 * 这个是对应的标签解析类。　就是之前的xsd对应的对象。
 * 这个对象是一个单例对象
 * @author muzhe-wang on  18-6-22 下午6:28.
 */

public class ApplicationBeanDefinitionParser  extends AbstractSingleBeanDefinitionParser {

    private final Class<?> beanClass;

    private final  boolean required;

    public ApplicationBeanDefinitionParser(Class<?> beanClass, boolean required) {
        this.beanClass = beanClass;
        this.required = required;
    }

    @Override
    protected  Class getBeanClass(Element element){
        return Application.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder beanDefinitionBuilder){
        String id = element.getAttribute("id");
        String name = element.getAttribute("name");
        String version = element.getAttribute("version");

        if (!Strings.isNullOrEmpty(id)){
            beanDefinitionBuilder.addPropertyValue("id" , id);
        }
        if (!Strings.isNullOrEmpty(name)){
            beanDefinitionBuilder.addPropertyValue("name" , name);
        }
        if (!Strings.isNullOrEmpty(version)){
            beanDefinitionBuilder.addPropertyValue("version" , version);
        }
    }


}
