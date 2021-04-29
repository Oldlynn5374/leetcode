package test.hashcodetest;

public class MutableClass {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        MutableClass cls = new MutableClass();
        System.out.println(cls.hashCode());
        cls.setAge(23);
        cls.setName("hhh");
        System.out.println(cls.hashCode());
        cls.setAge(44);
        System.out.println(cls.hashCode());

    }
}
