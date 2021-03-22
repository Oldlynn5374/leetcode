package 其他.字节跳动;

/*
    输出镜像二叉树
 */
public class ByteDance2 {

    public static void printTree (Tree node){
        if (node == null){
            return;
        }
        System.out.print(node.val + " ");
        printTree(node.lChild);
        printTree(node.rChild);
    }

    public static void copyMirror(Tree node, Tree temp){
        if (node == null){
            return;
        }

        temp.val = node.val;
        if (node.lChild != null){
            temp.rChild = new Tree();
        }
        if (node.rChild != null){
            temp.lChild = new Tree();
        }
        copyMirror(node.lChild, temp.rChild);
        copyMirror(node.rChild, temp.lChild);
    }

    public static void main(String[] args) {
        Tree node1 = new Tree(1);
        Tree node2 = new Tree(2);
        Tree node3 = new Tree(3);
        Tree node4 = new Tree(4);
        Tree node5 = new Tree(5);
        Tree node6 = new Tree(6);
        Tree node7 = new Tree(7);

        node1.lChild = node2;
        node1.rChild = node3;

        node2.lChild = node4;
        node2.rChild = node5;

        node3.lChild = node6;
        node3.rChild = node7;

        ByteDance2.printTree(node1);
        System.out.println();

        Tree temp = new Tree();
        ByteDance2.copyMirror(node1, temp);
        ByteDance2.printTree(temp);

    }
}

class Tree{
    int val;
    Tree lChild;
    Tree rChild;

    public Tree() {
    }

    public Tree(int val) {
        this.val = val;
    }
}
