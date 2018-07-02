package org.muzhe.parser.parsers;

import com.google.common.base.Strings;
import org.muzhe.parser.bean.Registry;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.w3c.dom.Element;

/**
 * @author muzhe-wang on  18-6-24 上午11:25.
 */
public class RegistryBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    /**
     * 返回当前的xsd对应的　Class对象。
     * @param element
     * @return
     */
    @Override
    protected Class getBeanClass(Element element){
        return Registry.class;
    }

    /**
     * 将一个对象
     * @param element
     * @param beanDefinitionBuilder
     */
    @Override
    protected  void doParse(Element element , BeanDefinitionBuilder beanDefinitionBuilder){

        String id = element.getAttribute("id");
        String address = element.getAttribute("address");
        String port = element.getAttribute("port");

        if (!Strings.isNullOrEmpty(id)){
            beanDefinitionBuilder.addPropertyValue("id" , id);
        }
        if (!Strings.isNullOrEmpty(address)){
            beanDefinitionBuilder.addPropertyValue("address" , address);
        }

        if (!Strings.isNullOrEmpty(port)){
            beanDefinitionBuilder.addPropertyValue("port" , port);
        }
    }
}
