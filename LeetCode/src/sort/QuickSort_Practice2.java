package sort;

public class QuickSort_Practice2 {
    public void sort(int[] arr, int low, int high){
        if (low > high){
            return;
        }
        int pos = partition(arr, low, high);
        sort(arr, 0, pos - 1);
        sort(arr, pos + 1, high);
    }

    public int partition(int[] arr, int low, int high){
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

    public static void main(String[] args) {
        int[] a = {5,3,1,4,2,4};
        QuickSort_Practice2 practice = new QuickSort_Practice2();
        practice.sort(a, 0, a.length-1);
        for (int i : a){
            System.out.println(i);
        }
    }
}
