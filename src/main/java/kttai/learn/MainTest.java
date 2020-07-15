package kttai.learn;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;

public class MainTest {
    static String str3 = "ab";

    public static void main(String[] args) {
//        System.out.println(5%3);
//        ArrayList<int[]> newArrList = new ArrayList<>(2);
//        Double a = 8.001;
        /*StringBuilder queryWorkTypeSqlSB = new StringBuilder();
        queryWorkTypeSqlSB.append(" SELECT ");
        queryWorkTypeSqlSB.append(" 	userWT.user_id, ");
        queryWorkTypeSqlSB.append(" 	userWT.schedule_date, ");
        queryWorkTypeSqlSB.append(" 	userWT.work_type_id, ");
        queryWorkTypeSqlSB.append(" 	bWT.work_type_name ");
        queryWorkTypeSqlSB.append(" FROM ");
        queryWorkTypeSqlSB.append(" 	mf_org_user_work_type userWT ");
        queryWorkTypeSqlSB.append(" LEFT JOIN b_work_type bWT ON bWT.id = userWT.work_type_id ");
        queryWorkTypeSqlSB.append(" WHERE ");
        queryWorkTypeSqlSB.append(" 	userWT.user_id in (");
        queryWorkTypeSqlSB.append(")  ");
        System.out.println(queryWorkTypeSqlSB.toString());*/

//        System.out.println(Math.pow(2,3));
//        System.out.println(5/10);
//        String a = "#{fasdf.afsd==null?\"\":{#fasdf.afsd}}";
//        List<String> split = split(a, "#{", "}");
//        System.out.println(split.size());
//        int a = 1;
//        a = a << 1;
//        System.out.println(a);

       /* Map<Integer,Integer> map1 = new HashMap<>(20);
        map1.put(1,100);
        map1.put(2,200);
        map1.put(3,300);
        map1.put(4,400);
        map1.put(5,500);
        map1.put(6,600);
        map1.put(7,700);
        map1.put(8,800);
        map1.put(9,900);
        map1.put(10,1000);
        map1.put(11,1100);
        map1.put(12,1200);
        map1.put(13,1300);
        Map<Integer,Integer> map2 = new Hashtable<>();
        Map<Integer,Integer> map3 = new ConcurrentHashMap<>();
        Collections.synchronizedMap(map1);
//        Lock
        int i = 9;
        synchronized (new Object()){
            i++;
        }*/


//        double a = 10.5d;
//        double v = a % 0.5;
//        System.out.println(v>0);
//        String str2 = new StringBuilder("aasssaa").append("a").toString();
////        String str1 = "aasssaaa";
//        System.out.println(str2 == str2.intern());
//        System.out.println(str2 == str2.intern());
////        System.out.println(str1 == str2.intern());
////        System.out.println(str1 == str2);
//
//        String strTeq = "asasas";
//        String strTe = new String(new char[]{'a','s','a','s','a','s'},0,6);
//        System.out.println(strTe == strTe.intern());//false
//        System.out.println(strTeq == strTe.intern());//true
//        System.out.println(strTeq == strTe);// false
//
//        String sta = "asqq";

//        String str1 = new String("a")+new String("b");
//        String str2 = str1.intern();
//        System.out.println(str1 == str2);
//        System.out.println(str1 == str3);
//        System.out.println(str2 == str3);


        int ad= 10;
        try {
            ad++;
            return;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("a");
        }
        System.out.println(ad);
    }

}
