package test;

public class OuterClass {

    private static Test test = new Test();
    public static Test getTest(){
        System.out.println(test);
        return test;
    }
    public static void print(){
        System.out.println("OuterClass's print");
    }


    public static void main(String[] args) {
        OuterClass.getTest();
        OuterClass.getTest();
        OuterClass.getTest();
    }
}
