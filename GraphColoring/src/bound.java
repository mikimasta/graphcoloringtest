import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class bound {
    public static int getLowerBound(ArrayList<Integer> numbers) {

        ArrayList<Integer> arr = new ArrayList<>();

        HashSet<Integer> set = new HashSet<>(numbers);


        for (int element : set) {
            int count = 0;
            for (int k = 0; k < numbers.size(); k++) {
                if (element == numbers.get(k)) count++;
            }
            arr.add(count);
        }


        return Collections.min(arr);
    }
    public static int getUpperBound (ArrayList <Integer> numbers) {

        ArrayList<Integer> arr = new ArrayList<>();

        HashSet<Integer> set = new HashSet<>(numbers);


        for (int element : set) {
            int count = 0;
            for (int k = 0; k < numbers.size(); k++) {
                if (element == numbers.get(k)) count++;
            }
            arr.add(count);
        }


        return Collections.max(arr) + 1;
    }
}

