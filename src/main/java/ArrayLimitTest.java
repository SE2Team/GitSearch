import data.Test;

import java.util.ArrayList;

/**
 * Created by moeyui on 2016/3/17 0017.
 */
public class ArrayLimitTest {
    ArrayList<Test> a=new ArrayList<Test>();

    public static void main(String[] args) {
        int count=1;
        ArrayLimitTest test=new ArrayLimitTest();
        while (count<20000){
            test.a.add(new Test());
            count++;
            System.out.println(count);
        }
        ArrayList<Test> nn=test.a;
        System.out.println("over");
    }
}
