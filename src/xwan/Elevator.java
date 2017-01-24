package xwan;

import java.util.*;

/**
 * Created by xwan on 1/3/17.
 */
public class Elevator {
    static class Task {
        int weight;
        int floor;

        public Task(int weight, int floor) {
            this.weight = weight;
            this.floor = floor;
        }
    }

    public static int solution(int[] A, int[] B, int M, int X, int Y) {
        if (A == null || B == null || A.length == 0 || B.length == 0 || X < 1 || Y < 1) {
            return 0;
        }
        int res = 0;
        Queue<Task> taskQueue = new LinkedList<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] > Y) {
                throw new RuntimeException("This should not happen!");
            }
            taskQueue.add(new Task(A[i], B[i]));
        }
        while (!taskQueue.isEmpty()) {
            res += helper(taskQueue, M, X, Y);
        }
        return res;
    }
    public static int helper(Queue<Task> taskQueue, int M, int X, int Y) {
        HashSet<Integer> floors = new HashSet<>();
        while (!taskQueue.isEmpty() && X > 0 && (Y - taskQueue.peek().weight) >= 0) {
            Task task = taskQueue.poll();
            X -= 1;
            Y -= task.weight;
            floors.add(task.floor);
        }
        return floors.size() + 1;
    }

    public static void main(String[] args) {
//        int[] A = new int[] {60, 80, 40};
//        int[] B = new int[] {2, 3, 5};
//        int M = 5;
//        int X = 2;
//        int Y = 200;

        int[] A = new int[] {40,40,100,80,20};
        int[] B = new int[] {3,3,2,2,3};
        int M = 3;
        int X = 5;
        int Y = 200;
        System.out.println(solution(A, B, M, X, Y));
    }
}
