package leetcode;

import java.util.BitSet;

/**
 * Created by sunbo on 2/8/2017.
 */

/*
Design a Phone Directory which supports the following operations:



get: Provide a number which is not assigned to anyone.
check: Check if a number is available or not.
release: Recycle or release a number.
Example:

// Init a phone directory containing a total of 3 numbers: 0, 1, and 2.
PhoneDirectory directory = new PhoneDirectory(3);

// It can return any available phone number. Here we assume it returns 0.
directory.get();

// Assume it returns 1.
directory.get();

// The number 2 is available, so return true.
directory.check(2);

// It returns 2, the only number that is left.
directory.get();

// The number 2 is no longer available, so return false.
directory.check(2);

// Release number 2 back to the pool.
directory.release(2);

// Number 2 is available again, return true.
directory.check(2);
 */

public class Design_Phone_Directory_379 {
    int max;
    int smallestIndex;
    BitSet bs;

    public Design_Phone_Directory_379(int num) {
        this.max = max;
        bs = new BitSet(max);
    }

    public boolean check(int num) {
        return !bs.get(num);
    }

    public int get() {
        if (smallestIndex == max) {
            return -1;
        }
        int res = smallestIndex;
        bs.set(smallestIndex);
        smallestIndex = bs.nextClearBit(smallestIndex);
        return res;
    }

    public void release(int num) {
        if (!bs.get(num)) {
            return;
        }
        bs.clear(num);
        if (smallestIndex > num) {
            smallestIndex = num;
        }
    }
}
