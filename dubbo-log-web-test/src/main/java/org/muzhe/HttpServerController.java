package org.muzhe;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author muzhe-wang on  18-7-7 下午4:04.
 */
@Controller
public class HttpServerController {

    @RequestMapping(value = "/echo")
    @ResponseBody
    public String echoService(){
        System.out.println("你好呀");

        return "hello";
    }
    
}
