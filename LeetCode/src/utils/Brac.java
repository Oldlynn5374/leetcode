package utils;

public class Brac {
    public static String changeBrac(String str){
        str = str.replaceAll("\\[", "{");
        str = str.replaceAll("\\]","}");
        // str = str.replaceAll("\"","\'");
        return str;
    }

    public static void main(String[] args) {
        String str = "[[4,9,10],[4,9,15],[4,9,12],[10,12,10],[10,12,8]]]";
        str = Brac.changeBrac(str);
        System.out.println(str);
    }
}
