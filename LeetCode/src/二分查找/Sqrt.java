package 二分查找;

public class Sqrt {
    public static int sqrt(int a) {
        int l = 0;
        int r = a;
        int mid;
        int sqrt;

        if (a == 1 || a == 0){
            return a;
        }

        while (l <= r) {
            mid = (l + r) / 2;
            sqrt = a / mid;

            if (l == mid){
                return l;
            }
            if (mid == sqrt){
                return mid;
            }else if (mid > sqrt){
                r = mid;
            }else {
                l = mid;
            }
        }

        return r;
    }

    public static int mySqrt(int x) {
        int l = 0;
        int r = x;
        int mid;
        int y;
        if (x == 1 || x == 0){
            return x;
        }
        while (l <= r) {
            mid = (l + r) / 2;
            y = mid * mid - x; // 容易溢出
            if (l == mid){
                return mid;
            }
            if (y == 0){
                return mid;
            }else if (y < 0){
                l = mid;
            }else if (y > 0){
                r = mid;
            }
        }

        return r;
    }

    public static void main(String[] args) {
  /*      int counter = 0;
        while (true){
            int r1 = Sqrt.mySqrt(counter);
            int r2 = Sqrt.sqrt(counter);
            if (r1 != r2){
                System.out.println(counter + " " + r1 + " " + r2);
                break;
            }
            counter++;
        }*/

        System.out.println(Sqrt.mySqrt(92684));
    }
}
