package xwan.ood.design;

import java.util.*;

/**
 * Created by xwan on 1/31/17.
 */
public class Test {
    public static boolean checkSingleSwap(int[] A)
    {
        int count = 0;
        int[]B = Arrays.copyOf(A, A.length);
        Arrays.sort(B);
        for(int i=0; i<A.length; i++)
        {
            if(A[i] != B[i]) count++;
        }

        if(count > 2) return false;
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,3,4};
        int[] a = {1,8,2,8,2,10};
        int[] b = {1,3,5};

        System.out.println(checkSingleSwap(arr));
        System.out.println(checkSingleSwap(a));
        System.out.println(checkSingleSwap(b));
        Set<Integer> hash = new HashSet<>();


    }

    public int leastBricks(List<List<Integer>> wall) {
        int n = wall.size();
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < wall.get(i).size() - 1; j++) {
                sum += wall.get(i).get(j);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
                max = Math.max(max, map.get(sum));
            }
        }
        return n - max;
    }

    public int nextGreaterElement(int n) {
        LinkedList<Integer> list = new LinkedList<>();
        while (n != 0) {
            list.push(n % 10);
            n /= 10;
        }
        if (list.size() < 2) return -1;
        int j = list.size() - 2;
        while (j >= 0 && list.get(j) >= list.get(j + 1)) {
            j--;
        }
        if (j < 0) return -1;
        int temp = list.get(j);
        for (int i = list.size() - 1; i > j; i--) {
            if (temp < list.get(i)) {
                list.set(j, list.get(i));
                list.set(i, temp);
                break;
            }
        }
        Collections.sort(list.subList(j + 1, list.size()));
        long res = 0;
        for (int i : list) {
            res = res * 10 + i;
        }
        if (res > Integer.MAX_VALUE) return -1;
        else return (int)res;
    }

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] s_arr = s.split(" ");
        for (String e : s_arr) {
            sb.append(reverse(e)).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    private String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}
