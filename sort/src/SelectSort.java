public class SelectSort {
    public void selectSort(int[] arr){
        int t=0;
        for(int i=0; i<arr.length-1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[index] > arr[j])
                    index = j;
            if(index != i) {
                t = arr[i];
                arr[i] = arr[index];
                arr[index] = t;
            }
        }
    }
}
