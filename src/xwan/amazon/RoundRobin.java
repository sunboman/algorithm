package xwan.amazon;

/**
 * Created by xwan on 1/27/17.
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Round Robin Average Wait Time的题，
 * 对[size=11.000000pt]int[] arrival = {0, 1, 3, 9};
 * int[] run = {2, 1, 7, 5};
 * [size=11.000000pt]int q = 2;
 * [size=11.000000pt]的情况，我手算的Average Wait Time是4/4 = 1s，地里的面经的程序算的是1.25s，不知是我算错了还是程序有小bug?
 *
 * 一个处理器要处理一堆request，一次只能处理一条，每次执行一个任务最多执行时间q，接着执行等待着的下一个任务。若前一个任务没执行完则放到队尾，等待下一次执行

    假设只要有任务开始以后cpu是不会空闲的，也就是说cpu开始后如果空闲了就说明没有任务了，另外Robin Round最后返回值是float
 *
 *
 *  e.g.
     arrival_time = [0, 1, 4], execution_time = [5, 2, 3], q = 3
     average wait time = (7 - 5) + (5 - 3) + (10 - 7) / 3 = 2.3333333  q is quantum
 */

public class RoundRobin {
    static class Process {
        int arrTime;
        int exeTime;

        public Process(int arrTime, int exeTime) {
            this.arrTime = arrTime;
            this.exeTime = exeTime;
        }
    }

    public static float avgWaitingTime(int[] arrs, int[] exes, int q) {
        if (arrs == null || exes == null || arrs.length != exes.length) {
            return 0;
        }
        int len = arrs.length;
        int currTime = 0;
        int waitTime = 0;
        Queue<Process> queue = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            queue.offer(new Process(arrs[i], exes[i]));
        }
        while (!queue.isEmpty()) {
            Process curr = queue.poll();
            if (currTime - curr.arrTime < 0) {
                waitTime += 0;
                currTime += curr.arrTime - currTime;
            } else {
                waitTime += currTime - curr.arrTime;
            }
            currTime += Math.min(curr.exeTime, q);
            if (curr.exeTime > q) {
                queue.offer(new Process(currTime, curr.exeTime - q));
            }
        }

        return (float) waitTime / len;
    }


    public static float Solution(int[] Atime, int[] Etime, int q) {
        if (Atime == null || Etime == null || Atime.length != Etime.length)
            return 0;
        int length = Atime.length;
        Queue<Process> queue = new LinkedList<Process>();
        int curTime = 0, waitTime = 0;
        int index = 0;
        while (!queue.isEmpty() || index < length) {
            if (!queue.isEmpty()) {
                Process cur = queue.poll();
                waitTime += curTime - cur.arrTime;
                curTime += Math.min(cur.exeTime, q);
                for (; index < length && Atime[index] <= curTime; index++)
                    queue.offer(new Process(Atime[index], Etime[index]));
                if (cur.exeTime > q)
                    queue.offer(new Process(curTime, cur.exeTime - q));
            }
            else {
                queue.offer(new Process(Atime[index], Etime[index]));
                curTime = Atime[index++];
            }
        }
        return (float) waitTime / length;
    }
    public static void main(String[] args) {
        int[] arrs = {0, 1, 3, 9};
        int[] exes = {2, 1, 7, 5};
        System.out.println(avgWaitingTime(arrs, exes, 2));
        System.out.println(Solution(arrs, exes, 2));
    }
}
