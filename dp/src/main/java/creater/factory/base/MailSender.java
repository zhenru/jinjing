package creater.factory.base;

/**
 * @author muzhe-wang on  18-9-7 下午4:55.
 */
public class MailSender implements Sender {

    public void send() {
        System.out.println("mail sender");
    }

}
