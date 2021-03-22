package 其他.腾讯;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKLists_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        int pos = 0;
        while (pos < lists.length && lists[pos] == null){
            pos++;
        }
        if (pos >= lists.length){
            return result;
        }
        ListNode min = lists[pos];

        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            if (node == null){
                continue;
            }
            if (node.val < min.val){
                min = node;
                pos = i;
            }
        }

        result = min;
        lists[pos] = lists[pos].next;

        ListNode rear = result;
        while (true){
            boolean isOver = true;
            pos = 0;
            while (pos < lists.length && lists[pos] == null){
                pos++;
            }
            if (pos >= lists.length){
                break;
            }
            min = lists[pos];

            for (int i = 0; i < lists.length; i++) {
                ListNode node = lists[i];
                if (node != null){
                    isOver = false;
                }else {
                    continue;
                }

                if (node.val < min.val){
                    min = node;
                    pos = i;
                }
            }
            if (isOver){
                break;
            }
            rear.next = min;
            rear = rear.next;
            lists[pos] = lists[pos].next;


        }

        return result;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val){
                    return -1;
                }else if (o1.val > o2.val){
                    return 1;
                }else {
                    return 0;
                }
            }
        });

        ListNode result = new ListNode(0);
        ListNode p = result;

        for (ListNode node : lists){
            queue.offer(node);
        }

        while (!queue.isEmpty()){
            p.next = queue.poll();
            p = p.next;
            if (p.next != null){
                queue.offer(p.next);
            }
        }

        return result.next;
    }

    public ListNode mergeKLists3(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode result = lists[0];
        for (int i = 1; i < lists.length; i++){
            result = mergeTwoLists(result, lists[i]);
        }
        return result;
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        int mid = left + (right - left) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;

        ListNode m1 = new ListNode(1);
        ListNode m2 = new ListNode(3);
        ListNode m3 = new ListNode(4);
        m1.next = m2;
        m2.next = m3;

        ListNode o1 = new ListNode(2);
        ListNode o2 = new ListNode(6);
        o1.next = o2;

        ListNode[] lists = new ListNode[3];
        lists[0] = m1;
        lists[1] = n1;
        lists[2] = o1;

        ListNode result = new MergeKLists_23().mergeKLists3(lists);
        while (result != null){
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
