package basic.advanced_sorting;

/**
 * Created by sunbo_000 on 2/11/2016.
 */
public class quick_sorting {

    private static void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int index = partition(nums, start, end);
            quickSort(nums, start, index - 1);
            quickSort(nums, index + 1, end);
        }
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            if (left < right) {
                nums[left++] = nums[right];
            }
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            if (left < right) {
                nums[right--] = nums[left];
            }
        }

        nums[left] = pivot;
        return left;
    }

    public static void Sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static void main(String[] args) {
        int[] array = {3,1,2,-1,5,4,3};
        Sort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
