import java.util.Arrays;
import java.util.List;

public class GenericMethodsExample {

    public static void main(String[] args) {
      
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int oddCount = countOddIntegers(integerList);
        System.out.println("Number of odd integers: " + oddCount);
        String[] stringArray = {"apple", "banana", "cherry", "date"};
        System.out.println("Original Array: " + Arrays.toString(stringArray));

        exchangeElements(stringArray, 1, 3);
        System.out.println("Array after exchanging elements: " + Arrays.toString(stringArray));
        List<Integer> integerList2 = Arrays.asList(5, 3, 8, 2, 7, 1, 10, 6);
        int begin = 2;
        int end = 6;

        Integer maxInRange = findMaxInRange(integerList2, begin, end);
        System.out.println("Maximal element in the range [" + begin + ", " + end + "]: " + maxInRange);
    }

    public static <T extends Number> int countOddIntegers(List<T> list) {
        int count = 0;
        for (T element : list) {
            if (element.intValue() % 2 != 0) {
                count++;
            }
        }
        return count;
    }

    public static <T> void exchangeElements(T[] array, int index1, int index2) {
        if (index1 >= 0 && index1 < array.length && index2 >= 0 && index2 < array.length) {
            T temp = array[index1];
            array[index1] = array[index2];
            array[index2] = temp;
        } else {
            System.out.println("Invalid indices");
        }
    }

    public static <T extends Comparable<T>> T findMaxInRange(List<T> list, int begin, int end) {
        if (begin < 0 || end >= list.size() || begin > end) {
            throw new IllegalArgumentException("Invalid range");
        }

        T max = list.get(begin);
        for (int i = begin + 1; i <= end; i++) {
            if (list.get(i).compareTo(max) > 0) {
                max = list.get(i);
            }
        }
        return max;
    }
}
