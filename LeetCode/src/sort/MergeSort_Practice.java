package sort;

public class MergeSort_Practice {
    public void merge(int[] arr, int begin, int mid, int end, int[] temp){
        int p1 = begin;
        int p2 = mid + 1;
        int count = 0;

        while (count < temp.length){
            if (arr[p1] <= arr[p2]){
                temp[count++] = arr[p1++];
            }else {
                temp[count++] = arr[p2++];
            }

            if (p1 == mid + 1){
                while (p2 <= end){
                    temp[count++] = arr[p2++];
                }
                break;
            }
            if (p2 == end + 1){
                while (p1 <= mid){
                    temp[count++] = arr[p1++];
                }
                break;
            }
        }

        count = 0;
        while (begin <= end){
            arr[begin++] = temp[count++];
        }
    }

    public void sort(int[] arr, int begin, int end, int[] temp){

        if (begin >= end){
            return;
        }

        int mid = (begin + end) / 2;

        sort(arr, begin, mid, temp);
        sort(arr,mid + 1, end, temp);

        merge(arr,begin,mid,end,temp);
    }

    public static void main(String[] args) {
        int a[] = {3,1,2};
        MergeSort_Practice mergeSort = new MergeSort_Practice();
        mergeSort.sort(a,0,a.length-1,new int[a.length]);
        for (int i : a){
            System.out.print(i + " ");
        }
    }
}
