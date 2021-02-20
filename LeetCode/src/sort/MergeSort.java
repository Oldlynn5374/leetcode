package sort;

public class MergeSort {
    public void sort(int[] a){
        int[] b = new int[a.length];
        for (int size = 1; size <a.length; size *= 2){
            for (int i = 0; i < a.length; i += size){
                int j = i + size;
                int is = i + size;
                int js = j + size;
                int ti = i;
                int tj = j;
                int pos = i;

                if (tj >= a.length){
                    j = i;
                    js = is;
                    i -= size;
                    is = i + size;
                }

                if (js > a.length){
                    js = a.length;
                }

                // 相邻两组合并
                while (ti < is && tj < js){
                    if (a[ti] > a[tj]){
                        b[pos++] = a[tj++];
                    }else {
                        b[pos++] = a[ti++];
                    }


                    if (ti == is){
                        while (tj < js){
                            b[pos++] = a[tj++];
                        }
                        break;
                    }
                    if (tj == js){
                        while (ti < is){
                            b[pos++] = a[ti++];
                        }
                        break;
                    }
                }
                i += size;
            }

            for (int k = 0; k < a.length; k++){
                a[k] = b[k];
            }
        }

    }

    public void swap (int []a,int i,int j){
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }


    public void sort2(int[] arr, int begin, int end, int[] temp){

        if (begin >= end){
            return;
        }

        int mid = (begin + end) / 2;
        sort2(arr,begin,mid,temp);
        sort2(arr,mid+1,end,temp);
        merge(arr,begin,mid,end,temp);


    }

    public void merge(int[] arr, int begin, int mid, int end, int[] temp){
        int p1 = begin;
        int p2 = mid + 1;
        int count = 0;
        while (count < temp.length){
            if (arr[p1] < arr[p2]){
                temp[count++] = arr[p1];
                p1++;
            }else {
                temp[count++] = arr[p2];
                p2++;
            }

            if (p1 == mid + 1){
                while (p2 < end + 1){
                    temp[count++] = arr[p2++];
                }
                break;
            }
            if (p2 == end + 1){
                while (p1 < mid + 1){
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
        MergeSort mergeSort = new MergeSort();
  /*      mergeSort.sort(a);
        for (int i : a){
            System.out.println(i);
        }*/
        int[] temp = new int[a.length];
        mergeSort.sort2(a,0,a.length-1,temp);
        for (int i : a){
            System.out.print(i + " ");
        }
    }
}
