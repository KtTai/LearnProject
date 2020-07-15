package kttai.learnMain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 打破双亲委派机制
 */
public class I_myClassLoader_2 extends ClassLoader{

    private String classPath;
    public I_myClassLoader_2(String classPath){
        this.classPath = classPath;
    }


    protected Class<?> loadClass(String name, boolean resolve)
            throws ClassNotFoundException
    {
        if ("kttai.learnMain.UserClassOut".equals(name)){
// 自定义类 需要打破的   走 下面
            synchronized (getClassLoadingLock(name)) {
                // First, check if the class has already been loaded
                Class<?> c = findLoadedClass(name);
                if (c == null) {
                    long t0 = System.nanoTime();
                /* 不需要去父加载器 加载
                try {
                    ClassLoader parent = this.getParent();
                    if (parent != null) {
                        c = parent.loadClass(name, false);
                    } else {
                        c = findBootstrapClassOrNull(name);
                    }
                } catch (ClassNotFoundException e) {
                    // ClassNotFoundException thrown if class not found
                    // from the non-null parent class loader
                }*/

                    if (c == null) {
                        // If still not found, then invoke findClass in order
                        // to find the class.
                        long t1 = System.nanoTime();
                        c = findClass(name);

                        // this is the defining class loader; record the stats
                        sun.misc.PerfCounter.getParentDelegationTime().addTime(t1 - t0);
                        sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
                        sun.misc.PerfCounter.getFindClasses().increment();
                    }
                }
                if (resolve) {
                    resolveClass(c);
                }
                return c;
            }
        }else {
            // 其他类 正常类加载机制
            return super.loadClass(name,resolve);
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        try {
            String stringName = name.replaceAll("\\.", "/");
            FileInputStream fileInputStream = new FileInputStream(classPath + "/" + stringName+".class");
            byte[] b = new byte[fileInputStream.available()];
            int read = fileInputStream.read(b);
            fileInputStream.close();
            return defineClass(name,b,0,b.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        I_myClassLoader_2 myClassLoader = new I_myClassLoader_2("D:/data/testCode");
        UserClassOut userClassOutIn = new UserClassOut();
        userClassOutIn.wink();
        Class<?> userOutClass = myClassLoader.loadClass("kttai.learnMain.UserClassOut");
        Object o = userOutClass.newInstance();
        Method wink = userOutClass.getMethod("wink", null);
        wink.invoke(o, null);
//        System.out.println("main  " + userOutClass.getClassLoader().toString());
    }
}
