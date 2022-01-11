
public class SortFunction {
    int[] a = {8,4,5,7,1,3,6,2};
    public void chooseFunc(String sortFlag){
        if(sortFlag.equals("MergeSort")){
            mergeSortTest();
        }else if(sortFlag.equals("HeapSort")){
            heapSortTest();
        }else if(sortFlag.equals("BubbleSort")){
            bubbleSortTest();
        }
    }
    //1.归并排序
    public void mergeSortTest(){
        MergeSort mergeSort = new MergeSort();
        int[] b = a;
        b = mergeSort.sort(a,0,a.length-1);
        printAbc(b);
    }

    //2.堆排序
    public void heapSortTest(){
        HeapSort heapSort = new HeapSort();
        int[] b = a;
        heapSort.myHeapSort(b);
        printCba(b);
    }

    //3.冒泡排序
    public void bubbleSortTest(){
        BubbleSort bubbleSort = new BubbleSort();
        int[] b = a;
        bubbleSort.bubbleSort(b);
        printAbc(b);
    }

    public void printAbc(int[] a){
        for(int i=0; i<a.length; i++){
            System.out.println(a[i]);
        }
    }

    public void printCba(int[] a){
        for(int i=(a.length-1); i>=0; i--){
            System.out.println(a[i]);
        }
    }
}
