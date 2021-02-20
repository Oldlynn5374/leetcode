package utils;

public class Brac {
    public static String changeBrac(String str){
        str = str.replaceAll("\\[", "{");
        str = str.replaceAll("\\]","}");
        // str = str.replaceAll("\"","\'");
        return str;
    }

    public static void main(String[] args) {
        String str = "[[7,9],[4,5],[7,9],[-7,-1],[0,10],[3,10],[3,6],[2,3]]";
        str = Brac.changeBrac(str);
        System.out.println(str);
    }
}
