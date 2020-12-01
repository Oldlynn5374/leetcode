package ListNode;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultList = new ListNode();
        ListNode result = resultList;
        Boolean flag = false;
        while(true){
            // if(l1 == null){
            //     break;
            // }
            int temp = l1.val + l2.val;
            if(temp < 10){
                if(flag == false){
                    resultList.val = temp;
                }else if(flag == true){//如果进位后又=10，则flag保持不变，下一位计算继续需要+1
                    if(temp + 1 >= 10){
                        resultList.val = 0;
                    }else{
                        resultList.val = temp + 1;
                        flag = false;
                    }
                }
            }else if(temp >= 10){
                temp = temp % 10;
                if(flag == false){
                    flag = true;
                    resultList.val = temp;
                }else if(flag == true){
                    temp = temp + 1;
                    resultList.val = temp;
                }
            }

            //链表向后移
            l1 = l1.next;
            l2 = l2.next;
            if(l1 == null && l2 == null){
                break;
            }
            if(l1 == null){
                l1 = new ListNode(0);
            }
            if(l2 == null){
                l2 = new ListNode(0);
            }
            resultList.next = new ListNode();
            resultList = resultList.next;
        }

        return result;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode root = new ListNode();
        ListNode result = root;
        int carry = 0;
        while(l1!=null || l2!=null || carry!=0){

            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sum = l1Val + l2Val + carry;
            carry = sum / 10;
            sum = sum % 10;
            root.val = sum;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;

            if(l1==null && l2==null && carry==0){
                break;
            }else {
                ListNode newNode = new ListNode();
                root.next = newNode;
                root = root.next;
            }

        }

        return result;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        ListNode n1 = new ListNode(9);
        ListNode n2 = new ListNode(9);
        ListNode n3 = new ListNode(9);
        ListNode n4 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        ListNode k1 = new ListNode(9);
        ListNode k2 = new ListNode(9);
        //ListNode k3 = new ListNode(4);
       // ListNode k4 = new ListNode(1);
        k1.next = k2;
       // k2.next = k3;
        //k3.next = k4;

        ListNode node = listNode.addTwoNumbers2(n1, k1);
        while(node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
