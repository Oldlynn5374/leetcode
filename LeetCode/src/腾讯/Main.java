package 腾讯;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        List<String[]> strList = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            String str1 = in.next();
            String str2 = in.next();
            String[] strs = {str1, str2};
            strList.add(strs);
        }

        for (String[] strings : strList) {
            String str1 = strings[0];
            String str2 = strings[1];
            if (Main.isEqual(str1, str2)) {
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }

    }

    public static boolean isEqual(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        if (str1.length() % 2 != 0) {
            // 长度为奇数
            for (int i = 0; i < str1.length(); i++) {
                char c1 = str1.charAt(i);
                char c2 = str2.charAt(i);
                if (c1 != c2) {
                    return false;
                }
            }
            return true;
        }

        // 长度为偶数
        int mid = str1.length() >> 1;
        String str1Split1 = str1.substring(0, mid);
        String str1Split2 = str1.substring(mid );
        String str2Split1 = str2.substring(0, mid);
        String str2Split2 = str2.substring(mid);
        return isEqual(str1Split1, str2Split1) && isEqual(str1Split2, str2Split2) || isEqual(str1Split1, str2Split2) && isEqual(str1Split2, str2Split1);
    }
}
