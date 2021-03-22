package 动态规划.练习题;

public class LongestTurbulentSubarray_978 {
    public int maxTurbulenceSize(int[] arr) {
        if (arr.length <= 1){
            return arr.length;
        }
        if (arr.length == 2){
            if (arr[0] == arr[1]){
                return 1;
            }else {
                return 2;
            }
        }
        int p1 = 0;
        int p2 = 1;
        int p3 = 2;
        int count = 2;
        int max = 0;
        int min = 0;
        boolean isMin = true;
        while (p3 < arr.length){
            int num1 = arr[p1++];
            int num2 = arr[p2++];
            int num3 = arr[p3++];
            if ((num2 > num1 && num2 > num3) || (num2 < num1 && num2 < num3)){
                count++;
                if (count >= 2){
                    isMin = false;
                }
            }else {
                if (num1 == num2 && num1 == num3){
                    min = Math.max(min, 1);
                } else{
                    min = Math.max(min, 2);
                }
                max = Math.max(max, count);
                count = 2;
                continue;
            }

        }

        if (isMin){
            return min;
        }
        max = Math.max(max, count);

        return max;
    }

    public static void main(String[] args) {
        int[] arr = {4,5};
        System.out.println(new LongestTurbulentSubarray_978().maxTurbulenceSize(arr));
    }
}
