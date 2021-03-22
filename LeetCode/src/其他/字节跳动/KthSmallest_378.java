package 其他.字节跳动;

import java.util.LinkedList;
import java.util.Queue;

/*
    给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
 */
public class KthSmallest_378 {

    public int kthSmallest(int[][] matrix, int k) {
        int left = matrix[0][0];
        int right = matrix[matrix.length-1][matrix.length-1];

        while (left < right){
            int mid = (left + right) >> 1;
            if (checkSum(matrix, mid) < k){
                left = mid + 1;
            }else {
                right = mid;
            }
        }

        return left;
    }

    public int checkSum(int[][] martix, int mid){
        int sum = 0;
        int high = martix.length;
        int len = 0;
        int x = martix.length - 1;
        int y = 0;
        while (true){
            if (x < 0 || y > martix[x].length - 1){
                break;
            }
            if (martix[x][y] <= mid){
                len++;
                y++;
            }else {
                sum += len * high;
                high--;
                len = 0;
                x--;
            }

        }
        sum += len * high;
        return sum;
    }

    public static void main(String[] args) {
        int[][] martix = new int[][]{
                {1,5,9},
                {10,11,13},
                {12,13,15}
        };

        System.out.println(new KthSmallest_378().kthSmallest(martix, 8));
    }

}

