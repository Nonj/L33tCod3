// Are the lists arbitrarily long? so Can one list be longer than another?
// What happens if given a list like (1 -> 2 -> 3) & (3) my output should be (4 -> 2 -> 3) correct?
// Discuss Solution:
// 1. I could do straight traversal of the two lists, keep track of a 10's carry over, if there is, I would
// add it on to the next linked list and I'd mod that by 10 to stay keeping track of the carry over
// Once thats done I would advance both lists and return once finished
// This solution is O(n + m) time and O(n) memory
// 2. I could do the same, but just altering one of the lists

// Steps:
// 1. Keep track of end of two lists to know when to stop
// 2. Add each value of the list up, and make it into a variable
// 3. Mod the variable to see if you have something to carry over
// 4. put that value into a new node of the linkedlist, and advance nodes
// 5. repeat and return once finished


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode toRet = new ListNode(0);
        ListNode point = toRet;
        int carryOver = 0;

        
        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 != null) { sum += l1.val; }
            if (l2 != null) { sum += l2.val; }
            point.next = new ListNode((sum += carryOver) % 10);
            point = point.next;
            if (sum > 9) { 
                carryOver = 1;
            } else {
                carryOver = 0;
            }
            if (l1 != null) { l1 = l1.next; }
            if (l2 != null) { l2 = l2.next; }
        }
        if (carryOver != 0) {
            point.next = new ListNode(carryOver);
        }
        return toRet.next;
    }
}