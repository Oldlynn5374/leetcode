package 其他.腾讯;

public class RotateList_61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        ListNode pos = head;
        for (int i = 0; i < k; i++) {
            if (pos.next == null){
                pos = head;
            }else {
                pos = pos.next;
            }
        }

        ListNode seg = head;
        ListNode newHead = null;
        while (true){
            if (pos.next == null){
                newHead = seg.next == null ? head : seg.next;
                pos.next = head;
                seg.next = null;
                break;
            }
            seg = seg.next;
            pos = pos.next;
        }

        if (newHead == head){
            return newHead;
        }

        return newHead;
    }

    public ListNode rotateRight2(ListNode head, int k) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode old = head;
        int count;
        for (count = 1; old.next != null; count++){
            old = old.next;
        }
        old.next = head;

        old = head;
        for (int i = 0; i < count - k % count - 1; i++) {
            old = old.next;
        }
        ListNode result = old.next;
        old.next = null;
        return result;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        ListNode head = new RotateList_61().rotateRight2(n1, 2);
        System.out.println();
    }
}
