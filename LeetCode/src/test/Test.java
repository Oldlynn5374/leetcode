package test;

public class Test {
    public Test() {
        System.out.println("Test 对象创建");
    }

    public static void main(String[] args){
        Test test = new Test();
        // 初始化Bean1
        Bean1 bean1 = test.new Bean1();
        bean1.I++;
        // 初始化Bean2
        Bean2 bean2 = new Test.Bean2();
        bean2.J++;

    }
    class Bean1{
        public int I = 0;
    }

    static class Bean2{
        public int J = 0;
        public static void run(){

        }
    }
}
