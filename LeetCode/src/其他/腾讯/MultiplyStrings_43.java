package 其他.腾讯;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class MultiplyStrings_43 {
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        for (int i = 0; i < num1.length(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(num1.charAt(i));
            for (int j = i; j < len1 - 1; j++) {
                sb.append('0');
            }
            list1.add(sb.toString());
        }

        for (int i = 0; i < num2.length(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(num2.charAt(i));
            for (int j = i; j < len2 - 1; j++) {
                sb.append('0');
            }
            list2.add(sb.toString());
        }

        String result = "0";

        for (String n1 : list1){
            for (String n2 : list2){
                int len = n1.length() + n2.length() - 2;
                StringBuilder sum = new StringBuilder();
                int n = (n1.charAt(0) - '0') * (n2.charAt(0) - '0');
                sum.append(n);
                for (int i = 0; i < len; i++) {
                    sum.append('0');
                }
                result = addNum(result, sum.toString());
            }
        }

        if (result.charAt(0) == '0'){
            return "0";
        }

        return result;
    }

    public String addNum(String num1, String num2){
        int len1 = num1.length();
        int len2 = num2.length();

        StringBuilder sb = new StringBuilder();
        int c = 0; // 进位
        int p1 = len1 - 1;
        int p2 = len2 - 1;
        while (p1 >=0 && p2 >= 0){
            char c1 = num1.charAt(p1);
            char c2 = num2.charAt(p2);
            int sum = (c1 - '0') + (c2 - '0') + c;
            sb.insert(0, sum % 10);
            c = sum / 10;
            p1--;
            p2--;
        }


        while (p1 >= 0){
            char c1 = num1.charAt(p1);
            int sum = c1 - '0' + c;
            c = sum / 10;
            sb.insert(0, sum % 10);
            p1--;
        }



        while (p2 >= 0){
            char c2 = num2.charAt(p2);
            int sum = c2 - '0' + c;
            c = sum / 10;
            sb.insert(0, sum);
            p2--;
        }

        if (c == 1){
            sb.insert(0 , 1);
        }


        return sb.toString();
    }

    public static void main(String[] args) {
        String num1 = "123456789";
        String num2 = "987654321";
        String result = new MultiplyStrings_43().multiply(num1, num2);
        System.out.println(result);
    }
}
