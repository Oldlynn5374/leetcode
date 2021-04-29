package 练习题;

public class RemoveNthNodeFromEndofList_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0) {
            return head;
        }
        ListNode front = head;
        for (int i = 0; i < n - 1; i++) {
            front = front.next;
            if (front == null) {
                return null;
            }
        }

        ListNode node = head;
        ListNode last = null;
        while (true) {
            if (front.next == null) {
                if (last == null) {
                    head = head.next;
                }else {
                    last.next = node.next;
                    node.next = null;

                }
                break;
            }

            last = node;
            front = front.next;
            node = node.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        //n2.next = n3;

        ListNode node = new RemoveNthNodeFromEndofList_19().removeNthFromEnd(n1, 2);
        System.out.println(node);
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }