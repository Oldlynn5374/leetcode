package sort;

public class QuickSort {
    public void sort(int[] a,int l,int r){
        if (l > r) return;
        int pos = partition(a, l, r);
        sort(a,l,pos - 1);
        sort(a,pos + 1,r);
    }

    public int partition(int[] a,int low,int high){
        int p = a[low];
        while (low < high){

            while (low < high && a[high] >= p ){
                high--;
            }
            a[low] = a[high];

            while (low < high && a[low] <= p){
                low++;
            }
            a[high] = a[low];

        }
        a[low] = p;
        return low;
    }

    public int partition2(int[] a, int low, int high){

        int temp = a[low];
        while (low < high){
            while (a[high] >= temp && low < high){
                high--;
            }
            a[low] = a[high];

            while (a[low] <= temp && low < high){
                low++;
            }
            a[high] = a[low];
        }
        a[low] = temp;

        return low;
    }

    public static void main(String[] args) {
        int[] a = {5,3,1,2,4};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(a, 0, a.length - 1);
        for (int i : a){
            System.out.println(i);
        }

    }
}
