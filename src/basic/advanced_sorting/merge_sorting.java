package basic.advanced_sorting;

/**
 * Created by sunbo_000 on 2/11/2016.
 */
public class merge_sorting {
    public static void mergeSort(int[] array, int[] store, int start, int end) {
        if (start >= end)
            return;
        int mid = (start + end) / 2;
        int start1 = start;
        int end1 = mid;
        int start2 = mid + 1;
        int end2 = end;
        mergeSort(array, store, start1, end1);
        mergeSort(array, store, start2, end2);
        int k = start;
        while (start1 <= end1 && start2 <= end2)
            store[k++] = array[start1] <= array[start2] ? array[start1++] : array[start2++];
        while (start1 <= end1)
            store[k++] = array[start1++];
        while (start2 <= end2)
            store[k++] = array[start2++];

        for (k = start; k <= end; k++) {
            array[k] = store[k];
        }
    }

    public static void Sort(int[] array) {
        int[] store = new int[array.length];
        mergeSort(array, store, 0, array.length - 1);
    }

    public static void main(String[] args) {
        int[] array = {4, 2, 3, 1};
        merge_sorting.Sort(array);
        String a = null;
    }
}
