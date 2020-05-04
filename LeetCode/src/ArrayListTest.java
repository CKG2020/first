import java.util.ArrayList;
import java.util.Collections;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(1);
        arr.add(9);
        arr.add(3);
        arr.add(8);
        System.out.println(arr.get(2));

        int size = arr.size();
        System.out.println(size);

        int maxElement = Collections.max(arr);
        System.out.println(maxElement);

        int indexOfMaxElement = arr.indexOf(Collections.max(arr));

        System.out.println(indexOfMaxElement);
    }
}
