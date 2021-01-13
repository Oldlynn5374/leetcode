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

    public static void main(String[] args) {
        int a[] = {6,5,3,1,8,7,2,4,9,11,20,15,33,44};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(a);
        for (int i : a){
            System.out.println(i);
        }
    }
}
