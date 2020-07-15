package kttai.learnMain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 自定义类加载器
 */
public class I_myClassLoader extends ClassLoader{

    private String classPath;
    public I_myClassLoader(String classPath){
        this.classPath = classPath;
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

    public static void main(String[] args) throws ClassNotFoundException {
        // TODO 需要删掉项目中的类，原因是 ： APPClassLoader（为当前类的父加载器，自定义类的加载器默认的父加载器确定） 可以找到自己能加载的类，就不会允许子加载器 加载相同的类
        I_myClassLoader myClassLoader = new I_myClassLoader("D:/data/testCode");
        Class<?> userOutClass = myClassLoader.loadClass("kttai.learnMain.UserClassOut");
//        UserClassOut o = userOutClass.newInstance();
        System.out.println("main  " + userOutClass.getClassLoader().toString());
    }


}
