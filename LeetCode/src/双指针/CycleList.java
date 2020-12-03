package 双指针;

import java.util.HashMap;
import java.util.Map;

public class CycleList {

    public static ListNode detectCycle(ListNode head) { // 哈希表做法
        Map<Integer , ListNode> map = new HashMap();

        while(head != null){

            if (map.get(head.val) != null){
                return head;
            }

            map.put(head.val,head);
            head = head.next;
        }

        return null;
    }

    public static ListNode detectCycle2(ListNode head) { // 快慢指针做法

        if (head == null){
            return null;
        }

        ListNode slow = head.next;
        if (slow == null){
            return null;
        }
        ListNode fast = head.next.next;

        while (null != fast){

            if (slow == fast){ // fast 和 slow 第一次相遇
                fast = head;
                break;
            }

            slow = slow.next;
            fast = fast.next;
            if (fast == null){
                return null;
            }
            fast = fast.next;
        }

        if (null == fast){ // 没有闭环
            return null;
        }

        while (null != fast){

            if (slow == fast){ // fast 和 slow 第二次相遇

                return fast;
            }

            slow = slow.next;
            fast = fast.next;
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(-4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;

        System.out.println(CycleList.detectCycle2(n1).val);
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

