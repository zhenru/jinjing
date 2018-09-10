package creater.factory.base;

/**
 * @author muzhe-wang on  18-9-7 下午5:03.
 */
public class SimpleSenderFactory2 {

    /**
     * 邮件发送器
     * @return
     */
    public static Sender produceMailSender() {
        return new MailSender();
    }

    public static Sender produceSmsSender() {
        return new SmsSender();
    }
}
