package org.muzhe.test.spi;

import org.muzhe.test.spi.iml.DefaultService;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author muzhe-wang on  18-6-22 下午3:13.
 */
public class ServiceFramework {

    public String serviceFramework(String name , int age){


        ServiceLoader<IService>  s = ServiceLoader.load(IService.class);

        Iterator<IService> iterator = s.iterator();

        if (iterator.hasNext()){
            IService iService = iterator.next();
            return iService.execute(name , age);
        }
        return new DefaultService().execute(name, age);

    }
}
