
public class SortFunction {
    int[] a = {8,4,5,7,1,3,6,2};
    public void chooseFunc(String sortFlag){
        if(sortFlag.equals("MergeSort")){
            mergeSortTest();
        }else if(sortFlag.equals("HeapSort")){
            heapSortTest();
        }
    }
    //1.归并排序test
    public void mergeSortTest(){
        MergeSort mergeSort = new MergeSort();
        a = mergeSort.sort(a,0,a.length-1);
        for(int i=0; i<a.length; i++){
            System.out.println(a[i]);
        }
    }

    //2.堆排序
    public void heapSortTest(){
        HeapSort heapSort = new HeapSort();
        int[] b = a;
        heapSort.myHeapSort(b);
        for(int i=(a.length-1); i>=0; i--){
            System.out.println(b[i]);
        }
    }
}
