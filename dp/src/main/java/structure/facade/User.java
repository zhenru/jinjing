package structure.facade;

/**
 * @author muzhe-wang on  18-9-10 下午6:29.
 */
public class User {

    public static void main(String[] args) {

        Computer computer = new Computer();
        computer.startUp();

        System.out.println("----------------------------------------------------");
        computer.shutdown();
    }
}
