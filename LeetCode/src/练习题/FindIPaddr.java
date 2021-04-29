package 练习题;

import java.util.ArrayList;
import java.util.List;

public class FindIPaddr {
    public List<String> getAddr(String num) {
        List<String> res = new ArrayList<>();
        backtracking(res, new StringBuilder(), num, 0, 0);
        return res;
    }

    public void backtracking(List<String> res, StringBuilder sb, String num, int pos, int count) {
        if (count == 4) {
            if (pos < num.length()) {
                return;
            }
            sb.delete(sb.length() - 1, sb.length());
            res.add(sb.toString());
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (pos + i > num.length()) {
                break;
            }
            String val = num.substring(pos, pos + i);
            if (val.equals("")) continue;
            Integer value = Integer.valueOf(val);
            if (value > 255) {
                continue;
            }
            int start = sb.length();
            sb.append(val + ".");
            backtracking(res, sb, num, pos + i, count + 1);
            sb.delete(start, sb.length());
        }
    }

    public static void main(String[] args) {
        String num = "22525519168";
        List<String> addr = new FindIPaddr().getAddr(num);

        for (String s : addr) {
            System.out.println(s);
        }
    }
}
