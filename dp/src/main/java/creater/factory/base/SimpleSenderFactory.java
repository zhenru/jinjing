package creater.factory.base;

/**
 * @author muzhe-wang on  18-9-7 下午4:56.
 */
public class SimpleSenderFactory {

    /**
     * 更具类型生成　Sender实例
     *  这种方法的实现使用不同的type来实现不同类型的实例。但是可能的情况是type是非法的，
     *  这个时候出现的问题是type写错了导致创建失败，这个时候可以使用　enum帮助控制数量的实现。
     * @param type
     * @return
     */
    public static Sender generateSender(String type) {

        if ("mail".equals(type)) {
            return new MailSender();
        } else if ("sms".equals(type)) {
            return new SmsSender();
        } else {
            System.out.println("illegal sender");
            throw new RuntimeException("Illegal Sender type");
        }
    }
}
