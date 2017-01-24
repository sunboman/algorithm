package xwan.bloomberg;

/**
 * Created by xwan on 1/15/17.
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *   Implement an iterator to flatten a 2d vector.

     For example,
     Given 2d vector =

     [
     [1,2],
     [3],
     [4,5,6]
     ]


     By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].

     Hint:

     How many variables do you need to keep track?
     Two variables is all you need. Try with x and y.
     Beware of empty rows. It could be the first few rows.
     To write correct code, think about the invariant to maintain. What is it?
     The invariant is x and y must always point to a valid point in the 2d vector. Should you maintain your invariant ahead of time or right when you need it?
     Not sure? Think about how you would implement hasNext(). Which is more complex?
     Common logic in two different places should be refactored into a common method.
     Follow up:
     As an added challenge, try to code it using only iterators in C++ or iterators in Java.
 */
public class Flatten2DVector251$ {
    List<Iterator<Integer>> ite;
    int currPos = 0;
    public Flatten2DVector251$(List<List<Integer>> vec2d) {
        ite = new ArrayList<>();
        for (List<Integer> list : vec2d) {
            if (list.size() > 0) {
                ite.add(list.iterator());
            }
        }
    }

    public int next() {
        int currVal = ite.get(currPos).next();
        if (!ite.get(currPos).hasNext()) {
            currPos++;
        }
        return currVal;
    }

    public boolean hasNext() {
        return currPos < ite.size() && ite.get(currPos).hasNext();
    }

    class Flatten2DVec {
        Iterator<List<Integer>> listIterator;
        Iterator<Integer> ite;
        public Flatten2DVec(List<List<Integer>> vec2d) {
            listIterator = vec2d.iterator();
        }

        public int next() {
            hasNext();
            return ite.next();
        }

        public boolean hasNext() {
            while ((ite == null || !ite.hasNext()) && listIterator.hasNext()) {
                ite = listIterator.next().iterator();
            }
            return ite != null && ite.hasNext();
        }
    }
}
