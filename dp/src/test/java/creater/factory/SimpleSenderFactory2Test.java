package creater.factory;

import creater.factory.base.Sender;
import creater.factory.base.SimpleSenderFactory2;
import org.junit.Test;

/**
 * @author muzhe-wang on  18-9-7 下午5:05.
 */
public class SimpleSenderFactory2Test {

    @Test
    public void testSimpleSender() {

        Sender mailSender = SimpleSenderFactory2.produceMailSender();
        mailSender.send();

        Sender smsSender = SimpleSenderFactory2.produceSmsSender();
        smsSender.send();

    }

}