package xiexie;

import org.junit.Test;

/**
 * @author muzhe-wang on  18-9-14 上午11:08.
 */
public class TestCase {


    @Test
    public void testCase(){

        Thread.State state = Thread.currentThread().getState();
        System.out.println(state.toString());
    }
}
