package Concepts.LinkedList;

import NeetCode.ListNode;

public class Problems {
    public static void main(String[] args) {

    }

    public static void reorderLinkedList(ListNode head){

        // find the middle element using hare and tortoise algo

        ListNode fast  = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        // slow is the middle element
        // reverse the other half of the linked list
        ListNode cur = slow;
        ListNode prev = null;

        while(cur != null){
            ListNode nextNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextNode;
        }

        // prev has the start of the reversed list

        // iterate and add the nodes

        ListNode left = head;
        ListNode right = prev;

        // right will be the last element so rightmust exits but the next element doesnt need to
        while(right.next != null){
            ListNode temp = left.next;
            left.next = right;
            left = temp;

            temp = right.next;
            right.next = left;
            right = temp;
        }
    }

    public static boolean isPalindrome(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        //find mid
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        // slow is the middle element
        ListNode cur = slow;
        ListNode prev = null;


        // reverse list from the middle
        while(cur != null){
            ListNode nextNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextNode;
        }


        // iterate and check from left and right part of list
        ListNode right = prev;
        ListNode left = head;

        // iterate from right because the right might be larger if the total elements are odd
        // and the left might point to start of the reversed list 
        while(right != null){
            if(right.val != left.val){
                return false;
            }

            right = right.next;
            left = left.next;
        }

        return true;
    }
    public static ListNode reverseLinkedList2(ListNode head , int start , int end){
        // check if no elements or only one element present
        if(head == null || head.next == null) return head;

        // to keep track of the start
        ListNode dummy = new ListNode(0);

        dummy.next = head;

        //to have track of the start and prev of the reverse part
        ListNode prev = null;
        ListNode cur = dummy;

        // iterate till the start
        for(int i=0;i<start;i++){
            prev = cur;
            cur = cur.next;
        }

        // prev is the normal and cur is the start of reverse lit

        // reverse the list till end
        for(int i = 0 ; i < end - start ; i++){
            ListNode nextNode  = cur.next;
            cur.next = nextNode.next;
            nextNode.next = prev.next;
            prev.next = nextNode;
        }


        // return the start
        return dummy.next;


    }

    public static ListNode reverseLinkedListRecursion(ListNode head){
        if(head == null || head.next == null) return head;

        // has the till done reverse list
        ListNode newhead = reverseLinkedListRecursion(head.next);

        // change the pointers only through the head
        head.next.next = head;
        head.next = null;

        return newhead;
    }
    public static ListNode reverseLinkedList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode cur = head;
        ListNode prev = null;

        while (cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
    public static ListNode middleOfLinkedList(ListNode head){
        ListNode fast = head;
        ListNode slow= head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static boolean isHappyNumber(int n){
        int fast = n;
        int slow = n;

        do{
            fast = sqDigits(sqDigits(fast));
            slow = sqDigits(slow);
        }while (fast != slow);

        return fast == 1;
    }

    public static int sqDigits(int n){
        int sum =0;

        while(n!=0){
            int digit = n%10;

            sum += digit * digit;

            n/=10;
        }

        return sum;
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
