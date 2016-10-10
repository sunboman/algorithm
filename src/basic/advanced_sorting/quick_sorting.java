package basic.advanced_sorting;

/**
 * Created by sunbo_000 on 2/11/2016.
 */
public class quick_sorting {

    public static void quickSort(int[] array, int left, int right) {
        if (left >= right) return;
        int s = left;
        int e = right;
        int mid = (left + right) / 2;
        int pivot = array[mid];
        while (left < right) {
            if (array[left] <= pivot) left++;
            if (array[right] >= pivot) right--;
            if (array[left] > pivot && array[right] < pivot) {
                int tmp = array[right];
                array[right] = array[left];
                array[left] = tmp;
                left++;
                right--;
            }
        }
        int tmp = array[mid];
        array[mid] = array[left];
        array[left] = tmp;
        if (s < left)
            quickSort(array, s, left - 1);
        if (right < e)
            quickSort(array, right, e);
    }

    public static void Sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static void main(String[] args) {
        int[] array = {2, 5, 4, 1, 0, 85, 15};
        Sort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
