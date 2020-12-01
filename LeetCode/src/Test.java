import java.sql.Date;
import java.sql.Timestamp;

public class Test {
    public static void main(String[] args) {

        String msg = "aaaaaa";
        Integer i = 10;
        new Test().test1(msg ,i);
        System.out.println(msg);
        System.out.println(i);
    }

    public void test1(String msg,Integer i){
        msg = new String("sssss");
        i ++;
        System.out.println(msg);
        System.out.println(i);
    }
}
