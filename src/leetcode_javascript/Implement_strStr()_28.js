/**
 *
 * 28 Implement strStr()
 *
 * Implement strStr().

  Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * https://leetcode.com/problems/implement-strstr/
 *
 */

/**
 * @param {string} haystack
 * @param {string} needle
 * @return {number}
 */
var strStr = function(haystack, needle) {
    if (haystack === null || needle === null) return -1;
    var n = haystack.length,
        m = needle.length;
    if (m === 0) return 0;
    for (var i = 0; i < n - m + 1; i++) {
        if (haystack.substring(i, i + m) === needle) {
            return i;
        }
    }

    return -1;
};