package utils;

public class Brac {
    public static String changeBrac(String str){
        str = str.replaceAll("\\[", "{");
        str = str.replaceAll("\\]","}");
        str = str.replaceAll("\"","\'");
        return str;
    }

    public static void main(String[] args) {
        String str = "[[\"1\",\"0\",\"1\",\"0\",\"0\"],[\"1\",\"0\",\"1\",\"1\",\"1\"],[\"1\",\"1\",\"1\",\"1\",\"1\"],[\"1\",\"0\",\"0\",\"1\",\"0\"]]";
        str = Brac.changeBrac(str);
        System.out.println(str);
    }
}
