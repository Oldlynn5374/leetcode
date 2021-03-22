package utils;

public class Brac {
    public static String changeBrac(String str){
        str = str.replaceAll("\\[", "{");
        str = str.replaceAll("\\]","}");
        // str = str.replaceAll("\"","\'");
        return str;
    }

    public static void main(String[] args) {
        String str = "[[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]]";
        str = Brac.changeBrac(str);
        System.out.println(str);
    }
}
