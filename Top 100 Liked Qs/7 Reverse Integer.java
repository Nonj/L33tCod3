// if the reversed integer overflows, return zero
// What I could do is mod 10 / 10 and that would be O(n) time complexity n
// being how long the integer is
// Have to check for negative numbers
// First solution O(n) time + O(1) space


class Solution {
    public int reverse(int x) {
        int toReturn = 0;
        int numToModify = x > 0 ? x : -x;
        while (numToModify > 0) {
            int latestDigit = numToModify % 10;
            // to check if within 32 bit range
            if ((long) toReturn * 10 > Integer.MAX_VALUE) return 0;
            toReturn *= 10;
            toReturn += latestDigit;
            numToModify /= 10;
        }
        if (x < 0) {
            return -toReturn;
        } else {
            return toReturn;
        }
    }
}