package creater.factory.factory;

import creater.factory.base.MailSender;
import creater.factory.base.Provider;
import creater.factory.base.Sender;

/**
 * @author muzhe-wang on  18-9-7 下午5:23.
 */
public class MailProvider implements Provider {
    public Sender produce() {
        return new MailSender();
    }
}
