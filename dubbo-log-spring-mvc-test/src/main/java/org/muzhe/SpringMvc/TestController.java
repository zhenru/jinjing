package org.muzhe.SpringMvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author muzhe-wang on  18-7-7 下午7:55.
 */

@Controller
public class TestController {







    @ResponseBody
    @RequestMapping("/hello")
    public String sayHello(String name){

        return "nihao" + name;
    }
}
