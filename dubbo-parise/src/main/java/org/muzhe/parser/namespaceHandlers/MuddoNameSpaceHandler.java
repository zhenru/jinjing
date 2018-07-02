package org.muzhe.parser.namespaceHandlers;

import org.muzhe.parser.bean.Application;
import org.muzhe.parser.parsers.ApplicationBeanDefinitionParser;
import org.muzhe.parser.parsers.RegistryBeanDefinitionParser;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author muzhe-wang on  18-6-24 上午11:59.
 */
public class MuddoNameSpaceHandler extends NamespaceHandlerSupport {

    public void init() {
        registerBeanDefinitionParser("application" , new ApplicationBeanDefinitionParser(Application.class, true));
        registerBeanDefinitionParser("registry" , new RegistryBeanDefinitionParser());
    }
}
