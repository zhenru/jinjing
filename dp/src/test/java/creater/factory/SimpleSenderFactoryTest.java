package creater.factory;

import creater.factory.base.Sender;
import creater.factory.base.SimpleSenderFactory;
import org.junit.Test;

/**
 * @author muzhe-wang on  18-9-7 下午4:59.
 */
public class SimpleSenderFactoryTest {


    @Test
    public void generateSender() {

        Sender mailSender = SimpleSenderFactory.generateSender("mail");
        mailSender.send();

        Sender smsSender = SimpleSenderFactory.generateSender("sms");
        smsSender.send();

        SimpleSenderFactory.generateSender("null");
    }
}