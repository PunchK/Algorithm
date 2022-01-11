public class HeapSort {
    public static void myHeapSort(int[] arr){
        int i;
        int len = arr.length;
        for(i = len/2-1; i>=0; i--){
            adjustment(arr, i, len);
        }
        for(i=len-1; i>=0; i--){
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            adjustment(arr, 0, i);
        }
    }
    public static void adjustment(int[] arr,int pos, int len){
        int child = 2*pos+1;
        if(child + 1 < len && arr[child] > arr[child + 1]){
            child++;
        }
        if(child <len && arr[pos] > arr[child]){
            int tmp = arr[pos];
            arr[pos] = arr[child];
            arr[child] = tmp;
            adjustment(arr, child, len);
        }
    }
}
