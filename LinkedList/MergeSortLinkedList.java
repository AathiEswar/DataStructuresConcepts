package Concepts.LinkedList;

import NeetCode.ListNode;

public class MergeSortLinkedList {
    public ListNode sortList(ListNode head) {
        // if no elements or only one element return head itself
        if(head == null || head.next == null) return head;


        // find the middle element (one element to the left)
        ListNode mid = middleOfList(head);

        // to break the list into two get the one element before the middle
        ListNode newHead = mid.next;
        // break the left and right ( the middle node )
        mid.next = null;

        // get left half and right half
        ListNode left = sortList(head);
        ListNode right = sortList(newHead);


        // return the merge of left half and right half
        return mergeTwoList(left , right);

    }

    public ListNode middleOfList(ListNode head){
        // hare and tortoise algorithm
        ListNode fast = head;
        ListNode slow = head;

        // if odd elements then middle is returned , if even then the left middle is returned
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;

        }
        // slow is the middle node
        return slow;
    }

    public ListNode mergeTwoList(ListNode left , ListNode right){
        // dummy to keep track of the  start
        ListNode dummy = new ListNode(0);

        // to iterate
        ListNode cur  = dummy;

        // iterate till both nodes have values
        while(left != null && right != null){
            if(left.val <= right.val){
                cur.next = left;
                left  = left.next;
            }
            else{
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        // add the remaining nodes
        if(left != null) cur.next = left;
        if(right != null) cur.next = right;

        // return the start
        return dummy.next;
    }
}
