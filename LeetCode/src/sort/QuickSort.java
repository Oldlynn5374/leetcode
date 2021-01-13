package sort;

public class QuickSort {
    public  void sort(int[] a,int l,int r){
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

    public static void main(String[] args) {
        int[] a = {42,30,69,98,86,15,57};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(a, 0, a.length - 1);
        for (int i : a){
            System.out.println(i);
        }

    }
}
