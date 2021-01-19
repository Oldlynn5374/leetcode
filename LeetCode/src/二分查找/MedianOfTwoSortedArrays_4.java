package 二分查找;

public class MedianOfTwoSortedArrays_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {




        return 0;
    }

    public int findK(int[] nums1,int[] nums2,int k){

        int halfK ;
        int point1 = 0;
        int point2 = 0;

        int num1;
        int num2;

        while (true){
            halfK = k / 2;

            if (halfK == 0){
                return nums1[point1] < nums2[point2] ? nums1[point1]:nums2[point2];
            }

        }


    }
}
