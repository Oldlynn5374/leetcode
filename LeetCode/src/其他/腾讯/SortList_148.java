package 其他.腾讯;

public class SortList_148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (true) {
            if (fast == null || fast.next == null){
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        // mid
        ListNode tmp = slow.next;
        slow.next = null;

        // sort
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);

        // merge
        ListNode result = new ListNode();
        ListNode temp = result;
        while (left != null && right != null) {
            if (left.val < right.val) {
                temp.next = left;
                temp = temp.next;
                left = left.next;
            }else {
                temp.next = right;
                temp = temp.next;
                right = right.next;
            }
        }
        temp.next = left == null ? right : left;

        return result.next;
    }


}
