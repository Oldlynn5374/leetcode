package sort;

public class QuickSort_Practice5 {
    public int partition(int[]arr ,int low, int high){
        int p = arr[low];
        while (low < high){
            while (low < high && arr[high] >= p){
                high--;
            }
            arr[low] = arr[high];

            while (low < high && arr[low] <= p){
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = p;

        return low;
    }

    public void sort(int[] arr, int begin, int end){
        if (begin >= end){
            return;
        }
        int pos = partition(arr,begin,end);
        sort(arr, begin, pos - 1);
        sort(arr, pos + 1, end);
    }

    public static void main(String[] args) {
        int[] a = {5, 4, 3, 1, 2, 4};
        new QuickSort_Practice5().sort(a,0,a.length-1);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
