package kttai.learnMain;

public class UserClass {
    public void wink(){
        System.out.println("userClass  被加载。。。。。。。。"+"该类的加载器为" + this.getClass().getClassLoader().toString());
    }

    public static void main(String[] args) {
//        UserClassOut uc = new UserClassOut();
//        uc.wink();
//        System.out.println(uc.getClass().getClassLoader().toString());
    }
}
