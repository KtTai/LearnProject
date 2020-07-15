package kttai.learn;

import java.text.SimpleDateFormat;
import java.util.*;

public class Test200528Compare {
    public static void main(String[] args) {
        Calendar cal0 = Calendar.getInstance();
        TestDateCompare testDateCompare0 = new TestDateCompare();
        testDateCompare0.setTaskLimit(cal0.getTime());
        TestDateCompare testDateCompare1 = new TestDateCompare();
        Calendar cal1 = Calendar.getInstance();
        cal1.add(Calendar.DAY_OF_MONTH,1);
        testDateCompare1.setTaskLimit(cal1.getTime());
        TestDateCompare testDateCompare2 = new TestDateCompare();
        Calendar cal2 = Calendar.getInstance();
        cal2.add(Calendar.DAY_OF_MONTH,29);
        testDateCompare2.setTaskLimit(cal2.getTime());

        List<TestDateCompare> testDateCompares = Arrays.asList(new TestDateCompare[]{testDateCompare0, testDateCompare1, testDateCompare2});

        Collections.sort(testDateCompares, new Comparator<TestDateCompare>() {
            @Override
            public int compare(TestDateCompare o1, TestDateCompare o2) {
                return -(o1.getTaskLimit().compareTo(o2.getTaskLimit()));
            }
        });

        testDateCompares.forEach(testDateCompare -> {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println(sdf.format(testDateCompare.getTaskLimit()));
        });
    }

}
class TestDateCompare {
    private int id;
    private Date taskLimit;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTaskLimit() {
        return taskLimit;
    }

    public void setTaskLimit(Date taskLimit) {
        this.taskLimit = taskLimit;
    }
}
