package org.muzhe.jingjing.jvm;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author muzhe-wang on  18-7-19 上午10:42.
 */
public class HotSwapURLClassLoader extends URLClassLoader {

    private static final Map<String, Long> cacheLastModifyMap = new HashMap<String, Long>();

    private static final String classPath = "/todo";

    private static final String packagePath = "todo";

    private static final HotSwapURLClassLoader hotSwapUrlClassLoader = new HotSwapURLClassLoader();

    public HotSwapURLClassLoader() {
        super(getMyUrls());
    }

    private static URL[] getMyUrls() {
        URL url = null;
        try {
            url = new File(classPath).toURI().toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return new URL[]{url};
    }

    public static HotSwapURLClassLoader getClassLoader() {
        return hotSwapUrlClassLoader;
    }

    /**
     * 不使用默认的双亲委派机制
     *
     * @param name
     * @param resolve
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        Class clazz = null;

        clazz = findLoadedClass(name);
        if (clazz != null) {
            if (resolve) {
                resolveClass(clazz);
            }

            if (isModify(name)) {
                clazz = customLoad(name, hotSwapUrlClassLoader);
            }
            return clazz;
        }
        //这个是系统中的jar包中的类
        if (name.startsWith("java.")) {
            try {
                ClassLoader system = ClassLoader.getSystemClassLoader();
                clazz = system.loadClass(name);
                if (clazz != null) {
                    if (resolve) {
                        resolveClass(clazz);
                    }
                    return clazz;
                }
            } catch (Exception ex) {

            }
        }
        return customLoad(name, this);
    }

    public Class load(String name) throws ClassNotFoundException {
        return loadClass(name);
    }


    private boolean isModify(String name) {
//        todo
        return false;
    }

    private Class customLoad(String name, ClassLoader hotSwapUrlClassLoader) throws ClassNotFoundException {
        return customLoad(name, false, hotSwapUrlClassLoader);
    }

    private Class customLoad(String name, boolean resolve, ClassLoader hotSwapUrlClassLoader) throws ClassNotFoundException {
        Class clazz = ((HotSwapURLClassLoader) hotSwapUrlClassLoader).findClass(name);
        if (resolve) {
            ((HotSwapURLClassLoader) hotSwapUrlClassLoader).resolveClass(clazz);
        }
        long modifyTime = getClassModifyTime(name);
        cacheLastModifyMap.put(name, modifyTime);
        return clazz;
    }




    /**
     * 文件上一次修改的时间
     *
     * @param name
     * @return
     */
    private long getClassModifyTime(String name) {
        return 0;
    }
}
