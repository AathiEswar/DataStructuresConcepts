package Concepts.LinkedList;

import NeetCode.ListNode;

public class Problems {
    public static void main(String[] args) {

    }

    public static ListNode cycleMeetPoint(ListNode head){
        ListNode fast = head;
        ListNode slow= head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast != slow){
                break;
            }
        }

        if(fast != null || fast.next !=null){
            return null;
        }

        while(head != slow){
            head = head.next;
            slow = slow.next;
        }

        return head;
    }

    public static int lengthOfLinedList(ListNode head){
        ListNode temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }

        return count;
    }

    public static boolean cycleLinkedList(ListNode head){
        // hare and tortoise algorithm to find cycles
        ListNode fast = head;
        ListNode slow = head;

        // iterate till fast or next of fast reaches the end ( if so no cycle)
        while(fast != null && fast.next != null){
            fast = fast.next .next;
            slow = slow.next;

            if(fast == slow){
                return true;
            }
        }

        return false;
    }
    public static ListNode mergeTwoSortedList(ListNode list1 , ListNode list2){
        // dummy to go to head later
        ListNode dummy = new ListNode(0);

        // to iterate
        ListNode cur = dummy;

        // iterate both only till one of them ends ( one might be larger than other)
        while(list1 != null && list2 != null){

            //compare and link cur to that list
            if(list1.val <= list2.val){
                cur.next = list1;
                list1 = list1.next;
            }
            else{
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        // one of them might not end so link cur to that list

        if(list1 != null){
            cur.next = list1;
        }

        if(list2 != null){
            cur.next = list2;
        }

        return dummy.next;
    }
    public static ListNode insertUsingRecursion(ListNode curNode , int val , int index){
        if(index == 0){
            // create the node here and link its next to the cur node and pass back the new node to previous recursion call
            ListNode temp = new ListNode();
            temp.val = val;
            temp.next = curNode;
            return temp;
        }
        // get the new Node from next recursion call and add it to the next of curNode
        ListNode nextNode = insertUsingRecursion(curNode.next , val , index--);
        curNode.next = nextNode;
        //return the curNode to previous stack
        return curNode;
    }

    public static ListNode removeDuplicates(ListNode head){
        // dummy node to iterate
        ListNode cur = head;


        // check if curNode or next Node is null
        while(cur!= null && cur.next != null){

            // if value same then connect to the next node
            if(cur.val == cur.next.val ){
                cur.next = cur.next.next;
            }
            // if not same then move to next node
            else{
                cur = cur.next;
            }
        }

        return head;
    }
}
