import javax.sql.DataSource;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Date date = new Date();
        Long time=date.getTime();
        System.out.println(time);
        date.setTime(1000);
        System.out.println(date);

    }
}
