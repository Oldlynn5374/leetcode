package 数据结构.堆;

import java.util.LinkedList;
import java.util.Queue;

public class Heap {
    public int val;
    public Heap father;
    public Heap lChild;
    public Heap rChild;

    public Heap() {
    }

    public Heap(int val) {
        this.val = val;
    }

    public static Heap createHeap(int[] arr){
        Heap heap = new Heap(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            Heap last = getLastAvail(heap);
            last.val = arr[i];

            while (last != null && last.father != null && last.val > last.father.val ){
                int temp = last.val;
                last.val = last.father.val;
                last.father.val = temp;
                last = last.father;
            }
        }

        return heap;
    }

    public static Heap getLastAvail(Heap heap){
        Queue<Heap> queue = new LinkedList<>();
        queue.offer(heap);

        while (!queue.isEmpty()){
            Heap node = queue.poll();
            if (node.lChild == null ){
                node.lChild = new Heap();
                node.lChild.father = node;
                return node.lChild;
            } else if (node.rChild == null){
                node.rChild = new Heap();
                node.rChild.father = node;
                return node.rChild;
            }else {
                queue.offer(node.lChild);
                queue.offer(node.rChild);
            }
        }

        return null;
    }

    public static Heap getLast(Heap heap){
        Queue<Heap> queue = new LinkedList<>();
        queue.offer(heap);
        Heap node = null;

        while (!queue.isEmpty()){
            node = queue.poll();
            if (node.lChild != null){
                queue.offer(node.lChild);
            }
            if (node.rChild != null){
                queue.offer(node.rChild);
            }
        }

        return node;
    }

    public static int pop(Heap heap){
        int result = heap.val;
        Heap last = getLast(heap);
        heap.val = last.val;
        Heap lastFather = last.father;
        if (lastFather.rChild == null){
            lastFather.lChild = null;
        }else if (lastFather.rChild != null){
            lastFather.rChild = null;
        }

        // 下坠
        while (true){
            Heap lChild = heap.lChild;
            Heap rChild = heap.rChild;

            Heap child = null;
            if (lChild == null){
                child = rChild;
            }else if (rChild == null){
                child = lChild;
            }else if (lChild.val > rChild.val){
                child = lChild;
            }else {
                child = rChild;
            }

            if (child == null){
                break;
            }

            if (heap.val < child.val){
                int temp = heap.val;
                heap.val = child.val;
                child.val = temp;
                heap = child;
            }else {
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2,4,3,1,5,7,6,8,9};
        Heap heap = Heap.createHeap(arr);
        System.out.println(Heap.pop(heap));
        System.out.println(Heap.pop(heap));
        System.out.println();
    }
}
