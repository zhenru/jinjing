package structure.facade;

import com.sun.corba.se.impl.protocol.giopmsgheaders.AddressingDispositionHelper;

/**
 * @author muzhe-wang on  18-9-10 下午6:26.
 */
public class Computer {

    private Disk disk;

    private Cpu cpu;

    private Memory memory;

    public Computer() {
        this.disk = new Disk();
        this.memory = new Memory();
        this.cpu = new Cpu();
    }

    public void startUp() {
        System.out.println("当前计算机开始启动");
        memory.startUp();
        disk.startUp();
        cpu.startUp();
        System.out.println("启动完毕");
    }

    public void shutdown() {
        System.out.println("计算机开始关闭");
        memory.shutdown();
        disk.shutDown();
        cpu.shutdown();
        System.out.println("计算机开始关闭");
    }
}
