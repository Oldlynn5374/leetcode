package sort;

public class MergeSort_Practice3 {
    public void sort(int[] arr, int begin, int end, int[] temp){
        if (begin >= end){
            return;
        }
        int mid = (begin + end) / 2;
        sort(arr,begin,mid,temp);
        sort(arr,mid + 1,end,temp);
        merge(arr,begin,mid,end,temp);

    }

    public void merge(int[] arr, int begin, int mid, int end, int[] temp){
        int p1 = begin;
        int p2 = mid + 1;
        int count = 0;

        while (true){
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

    public static void main(String[] args) {
        int a[] = {8,4,5,7,1,3,6,2,10};
        MergeSort_Practice3 mergeSort = new MergeSort_Practice3();
  /*      mergeSort.sort(a);
        for (int i : a){
            System.out.println(i);
        }*/
        int[] temp = new int[a.length];
        mergeSort.sort(a,0,a.length-1,temp);
        for (int i : a){
            System.out.print(i + " ");
        }
    }
}
