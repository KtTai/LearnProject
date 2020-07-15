package kttai.learnMain;

public class UserClassOut {
    public void wink(){
        System.out.println("userClassOut IN  被加载。。。。。。。。"+"该类的加载器为" + this.getClass().getClassLoader().toString());
    }

}
