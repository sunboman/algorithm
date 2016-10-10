package basic.basic_sorting;

/**
 * Created by sunbo_000 on 2/11/2016.
 */
public class insertionSort {
    public static int[] Sort(int[] array) {
        int sorted = 0;
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            for (int j = sorted; j >= 0; j--) {
                if (temp < array[j]) {
                    array[j + 1] = array[j];
                } else {
                    array[j + 1] = temp;
                    break;
                }
            }
            sorted++;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 2, 4, 5, 6, 7, 5, 3};
        insertionSort.Sort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }
}
