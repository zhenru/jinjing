package creater.factory.base;

/**
 * @author muzhe-wang on  18-9-7 下午5:20.
 */
public interface Provider {

    /**
     * 生成一个　Sender
     * @return
     */
    Sender produce();
}
