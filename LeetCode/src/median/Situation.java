package median;

public class Situation {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;
        int length = (m + n) / 2;

        int p1 = 0;//nums1的指针
        int p2 = 0;//nums2的指针

        if( (m + n) % 2 != 0 ){

            double mid = 0;
            for (int i = 0; i <= length; i++){

                if( p1 == m ){//如果p1已到nums1的尽头，则直接让 mid = nums2[P2] 。否则因为 p1++ ，引起越界异常
                    mid = nums2[p2];
                    p2++;
                    continue;
                }

                if( p2 == n ){
                    mid = nums1[p1];
                    p1++;
                    continue;
                }

                if(nums1[p1] < nums2[p2]){//让小的数赋予到 mid
                    mid = nums1[p1];
                    p1++;
                }else {
                    mid = nums2[p2];
                    p2++;
                }
            }

            return mid;

        }else {

            double mid1 = 0;
            double mid2 = 0;

            for (int i = 0; i <= length; i++){

                if( p1 == m ){
                    if(i % 2 == 0){
                       mid1 = nums2[p2];
                    }else {
                       mid2 = nums2[p2];
                    }
                    p2++;
                    continue;
                }

                if( p2 == n ){
                    if(i % 2 == 0){
                        mid1 = nums1[p1];
                    }else {
                        mid2 = nums1[p1];
                    }
                    p1++;
                    continue;
                }

                if(nums1[p1] < nums2[p2]){
                    if(i % 2 == 0){
                        mid1 = nums1[p1];
                        p1++;
                    }else {
                        mid2 = nums1[p1];
                        p1++;
                    }

                }else {
                    if(i % 2 == 0){
                        mid1 = nums2[p2];
                        p2++;
                    }else {
                        mid2 = nums2[p2];
                        p2++;
                    }
                }
            }

            return (mid1 + mid2) / 2.0;

        }

    }

    public static void main(String[] args) {
        int [] nums1 = new int[]{1,2};
        int [] nums2 = new int[]{3,4,5};
        Situation situation = new Situation();

        System.out.println(situation.findMedianSortedArrays(nums1,nums2));

    }
}
