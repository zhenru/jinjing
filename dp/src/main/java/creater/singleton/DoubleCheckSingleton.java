package creater.singleton;

/**
 * @author muzhe-wang on  18-9-7 下午6:06.
 */
public class DoubleCheckSingleton {

    private DoubleCheckSingleton singleton = null;

    /**
     * double check的单例存在的问题是　创建对象这一步骤。
     * 因为　　`singleton = new DoubleCheckSingleton();`不是原子的。　分配空间和赋值是两个步骤。
     * 极端情况是　会返回一个　　分配了空间　但是没有给赋值的对象。
     * @return
     *
     */
    public DoubleCheckSingleton getBean() {

        if (singleton == null) {
            synchronized (this) {
                if (singleton == null) {
                    singleton = new DoubleCheckSingleton();
                }
            }
        }
        return singleton;
    }
}
