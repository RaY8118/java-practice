import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Array {
    public static void main(String[] args) {
        String[] arr = new String[4];
        Collection<String> list = new ArrayList<>();
        arr[0] = "one";
        arr[1] = "two";
        arr[2] = "three";
        arr[3] = "four";

        System.out.println(Arrays.toString(arr));
        int[] numbers = { 100, 200, 300 };
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        for (int num : numbers) {
            System.out.println(num);
        }

        Arrays.stream(arr).forEach(System.out::println);
    }
}
