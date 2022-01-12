public class QuickSort {
    public static void quickSort(int arr[],int low,int high){
        int pivot,p_pos,i,t;
        if(low<high){
            p_pos = low;
            pivot = arr[p_pos];
            for(i = low+1; i<=high; i++){
                if(arr[i]>pivot){
                    p_pos++;
                    t = arr[p_pos];
                    arr[p_pos] = arr[i];
                    arr[i] = t;
                }
            t = arr[low];
            arr[low] = arr[p_pos];
            arr[p_pos] = t;

            quickSort(arr, low, p_pos-1);
            quickSort(arr, p_pos+1, high);
            }
        }
    }
}
