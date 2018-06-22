package org.muzhe.parser.parsers;

import com.google.common.base.Strings;
import com.sun.org.glassfish.gmbal.ManagedObject;
import lombok.Getter;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.xml.AbstractBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

/**
 * @author muzhe-wang on  18-6-22 下午6:28.
 */
@Getter
public class ApplicationBeanDefinitionParser  extends AbstractBeanDefinitionParser {

    private final Class<?> beanClass;

    private final  boolean required;

    public ApplicationBeanDefinitionParser(Class<?> beanClass, boolean required) {
        this.beanClass = beanClass;
        this.required = required;
    }

    @Override
    protected AbstractBeanDefinition parseInternal(Element element, ParserContext parserContext) {
        String id = element.getAttribute("id");
        String name = element.getAttribute("name");
        String version = element.getAttribute("version");

        if (Strings.isNullOrEmpty(id)){

        }


        return null;
    }
}
