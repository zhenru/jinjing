package creater.factory.base;

import creater.factory.factory.MailProvider;
import creater.factory.factory.SmsProvider;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author muzhe-wang on  18-9-7 下午5:24.
 */
public class ProviderTest {

    @Test
    public void testProvider(){

        Provider provider = new SmsProvider();
        Sender sender = provider.produce();
        sender.send();
        System.out.println();

        Provider mailProvider = new MailProvider();
        Sender mailSender = mailProvider.produce();
        mailSender.send();
        System.out.println();
    }


}