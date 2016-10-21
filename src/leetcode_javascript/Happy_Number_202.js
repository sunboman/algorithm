/**
 * 202. Happy Number
 *
 *
 * Write an algorithm to determine if a number is "happy".

  A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

  Example: 19 is a happy number

  12 + 92 = 82
  82 + 22 = 68
  62 + 82 = 100
  12 + 02 + 02 = 1

 *
 *
 * https://leetcode.com/problems/happy-number/
 */

/**
 * @param {number} n
 * @return {boolean}
 */
var isHappy = function(n) {
    if(n === 1 || n === 7) return true;
    if(n < 10) return false;

     while(n >= 10) {
        var str = n.toString();
        var sum = 0;
        for(var i = 0; i < str.length; i++) {
            sum += Math.pow(str[i], 2);
        }
        n = Number(sum);
    }

    return n === 1 || n === 7;

};