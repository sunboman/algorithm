/**
 *
 * 50. Pow(x, n)
 *
 * Implement pow(x, n).
 *
 * https://leetcode.com/problems/powx-n/
 */


/**
 * @param {number} x
 * @param {number} n
 * @return {number}
 */
var myPow = function(x, n) {
    return n < 0 ? 1 / power(x, -n) : power(x, n);
};

var power = function(x, n) {
    if(n === 0) return 1;

    var half = power(x, (n / 2)|0);
    return half * half * (n % 2 === 0 ? 1 : x);
};

