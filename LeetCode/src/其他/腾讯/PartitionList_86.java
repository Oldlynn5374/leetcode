package 其他.腾讯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PartitionList_86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null){
            return null;
        }
        ListNode pos = head;
        Queue<ListNode> targetList = new LinkedList<>();
        Queue<ListNode> greaterList = new LinkedList<>();

        while (pos != null){
            if (pos.val < x){
                targetList.offer(pos);
            }else if (pos.val >= x){
                greaterList.offer(pos);
            }
            pos = pos.next;
        }

        head = targetList.poll();
        pos = head;
        while (!targetList.isEmpty()){
            ListNode temp = targetList.poll();
            pos.next = temp;
            pos = temp;
        }
        if (head == null){
            head = greaterList.poll();
            pos = head;
        }
        while (!greaterList.isEmpty()){
            ListNode temp = greaterList.poll();
            pos.next = temp;
            pos = temp;
        }
        pos.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        new PartitionList_86().partition(n6, 0);
        System.out.println();
    }
}
