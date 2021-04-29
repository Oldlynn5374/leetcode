package 腾讯;

import java.util.*;

public class Solution1 {
    public ListNode solve(ListNode S) {
        // write code here
        Map<ListNode, ListNode> sonMap = new HashMap<>();
        Map<ListNode, ListNode> fatherMap = new HashMap<>();
        ListNode min;
        min = S;
        ListNode node = S;
        // 找出最小结点
        while (node != null) {
            ListNode next = node.next;
            if (next == null) {
                next = S;
            }

            fatherMap.put(next, node);

            if (node.val == min.val) {
                sonMap.put(node, next);
            }

            if (node.val < min.val) {
                min = node;
                sonMap.clear();
                sonMap.put(node, next);
            }
            node = node.next;
        }


        while (sonMap.size() != 1) {
            Set<Map.Entry<ListNode, ListNode>> entries = new HashSet<>(sonMap.entrySet());

            ListNode minSon = new ListNode();
            minSon.val = Integer.MAX_VALUE;
            ListNode minFather = null;
            int minVal = Integer.MAX_VALUE;
            List<ListNode> minList = new ArrayList<>();
            for (Map.Entry<ListNode, ListNode> entry : entries) {
                ListNode thisNode = entry.getKey();
                ListNode thisSon = entry.getValue();
                int value = thisSon.val;

                if (value > minVal) {
                    // entries.remove(entry);
                    sonMap.remove(entry.getKey());
                } else if (value < minVal) {
                    for (ListNode listNode : minList) {
                        sonMap.remove(listNode);
                    }
                    minList.clear();
                    minVal = thisSon.val;
                    minSon = sonMap.get(thisSon);
                    if (minSon == null) {
                        minSon = S;
                    }
                    minFather = thisNode;
                    sonMap.put(minFather, sonMap.get(minSon));
                    min = minFather;
                    minList.add(minFather);
                }else {
                    minSon = sonMap.get(thisSon);
                    if (minSon == null) {
                        minSon = S;
                    }
                    minFather = thisNode;
                    sonMap.put(minFather, sonMap.get(minSon));
                    min = minFather;
                    minList.add(minFather);
                }
            }
        }

        if (sonMap.size() == 1) {
            ListNode father = fatherMap.get(min);
            father.next = null;
            ListNode temp = min;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = S;
            return min;
        }


        return null;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);

        n3.next = n4;
        n4.next = n5;
        n5.next = n1;
        n1.next = n2;

        ListNode result = new Solution1().solve(n3);
        System.out.println(result.val);
    }
}

class ListNode {
    int val;
    ListNode next = null;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }
}