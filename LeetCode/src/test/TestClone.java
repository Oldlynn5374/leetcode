package test;

public class TestClone {
    public static void main(String[] args) throws CloneNotSupportedException {
        A a1 = new A(2);
        A a2 = (A) a1.clone();
        a1.val = 4;
        System.out.println(a2.val);
    }
}

class A implements Cloneable{
    int val;

    public A(int val) {
        this.val = val;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
