import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;


public class Test {


    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3));
        list.add(4, 100);
        for (int i: list) {
            System.out.println(i);
        }
    }
}