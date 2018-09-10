package creater.factory.factory;

import creater.factory.base.Provider;
import creater.factory.base.Sender;
import creater.factory.base.SmsSender;

/**
 * @author muzhe-wang on  18-9-7 下午5:21.
 */
public class SmsProvider  implements Provider {
    public Sender produce() {
        //很多时候可以没有Ｓender，但是一定会有　Provider.
        return new SmsSender();
    }
}
