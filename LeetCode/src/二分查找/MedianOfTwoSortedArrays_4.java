package 二分查找;

public class MedianOfTwoSortedArrays_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int k = len >> 1; // 目标第 k 小的数
        if (len % 2 != 0){
            k = (len + 1) >> 1;
        }

        if (m == 0){
            if (len % 2 != 0){
                return nums2[n - k];
            }else {
                double d1 = nums2[n - k - 1];
                double d2 = nums2[n - k];
                return (d1 + d2) / 2;
            }

        }
        if (n == 0){
            if (len %2 != 0){
                return nums1[m - k];
            }else {
                double d1 = nums1[m - k - 1];
                double d2 = nums1[m - k];
                return (d1 + d2) / 2;
            }

        }

        int p1 = 0; // 排除后 nums1 的首元素位置
        int p2 = 0; // 排除后 nums2 的首元素位置

        while (true){
            int halfK = k >> 1;
            int num1 = p1 + halfK - 1; // 比较位置
            int num2 = p2 + halfK - 1; // 比较位置

            if (halfK == 0){
                if (len % 2 == 0){
                    double d1 = nums1[p1];
                    double d2 = nums2[p2];

                    if (d1 < d2){
                        if (p1 < m - 1){
                            d2 = Math.min(d2, nums1[p1 + 1]);
                        }
                    }else {
                        if (p2 < n - 1){
                            d1 = Math.min(d1, nums2[p2 + 1]);
                        }
                    }

                    return (d1 + d2) / 2;
                }
                return nums1[p1] < nums2[p2] ? nums1[p1] : nums2[p2];
            }

            if (num1 >= m){
                num1 = m - 1;
            }
            if (num2 >= n){
                num2 = n - 1;
            }

            int len1 = m - p1; // 排除后 nums1 的长度
            int len2 = n - p2; // 排除后 nums2 的长度

            if (nums1[num1] <= nums2[num2]){
                k = k - ( num1 + 1 - p1);
                p1 = num1 + 1;
                //k = k - ( p1 - num1);
            }else {
                k -= num2 + 1 - p2;
                p2 = num2 + 1;
                //k = k - (p2 - num2);
            }

            if (p1 >= m){ // nums1 已全部被排除
                if (len % 2 == 0){
                    double d1 = nums2[p2 + k - 1];
                    double d2 = nums2[p2 + k];
                    return (d1 + d2) / 2;
                }
                return nums2[p2 + k - 1];
            }
            if (p2 >= n){
                if (len % 2 == 0){
                    double d1 = nums1[p1 + k - 1];
                    double d2 = nums1[p1 + k];
                    return (d1 + d2) / 2;
                }
                return nums1[p1 + k - 1];
            }
        }


    }

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {-1,3};
        System.out.println(new MedianOfTwoSortedArrays_4().findMedianSortedArrays(nums1,nums2));
    }


}
