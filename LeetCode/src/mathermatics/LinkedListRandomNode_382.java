package mathermatics;

import java.util.Random;

public class LinkedListRandomNode_382 {

    private ListNode head;
    private Random random;
    private int listLength = 0;

    public LinkedListRandomNode_382(ListNode head) {
        this.head = head;
        random = new Random();
    }


    public int getRandom() {
        ListNode node = head;
        int rand;
        if (listLength != 0) {
            rand = random.nextInt(listLength);
        }else {
            rand = random.nextInt(Integer.MAX_VALUE);
        }

        int length = 0;
        for (int i = 0; i < rand; i++) {
            node = node.next;
            length++;
            if (node == null) {
                listLength = length;
                node = head;
                rand = random.nextInt(length);
                for (int j = 0; j < rand; j++) {
                    node = node.next;
                }
                break;
            }
        }

        return node.val;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }