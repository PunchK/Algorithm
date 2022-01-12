public class SortFunction {
    int[] a = {8,4,5,7,1,3,6,2};
    public void chooseFunc(String sortFlag){
        /*1.归并排序测试-MergeSort；2.堆排序-HeapSort；3.冒泡排序-BubbleSort；4.插入排序-InsertSort；5.快速排序-QuickSort；6.选择排序-SelectSort；
        7.希尔排序-SellSort；8.基数排序-BasicSort*/
        if(sortFlag.equals("MergeSort")){
            mergeSortTest();
        }else if(sortFlag.equals("HeapSort")){
            heapSortTest();
        }else if(sortFlag.equals("BubbleSort")){
            bubbleSortTest();
        }else if(sortFlag.equals("InsertSort")){
            insertSortTest();
        }else if(sortFlag.equals("QuickSort")){
            quickSortTest();
        }else if(sortFlag.equals("SelectSort")){
            selectSortTest();
        }else if(sortFlag.equals("SellSort")){
            shellSortTest();
        }else if(sortFlag.equals("BasicSort")){
            basicSortTest();
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

    //4.插入排序
    public void insertSortTest(){
        InsertSort insertSort = new InsertSort();
        int[] b = a;
        insertSort.insertSort(b);
        printAbc(b);
    }

    //5.快速排序
    public void quickSortTest(){
        QuickSort quickSort = new QuickSort();
        int[] b = a;
        QuickSort.quickSort(b, 0, b.length-1);
        printCba(b);
    }

    //6.希尔排序
    public void shellSortTest(){
        ShellSort shellSort = new ShellSort();
        int[] b = a;
        shellSort.shellSort(b);
        printAbc(b);
    }

    //7.选择排序
    public void selectSortTest(){
        SelectSort selectSort = new SelectSort();
        int[] b = a;
        selectSort.selectSort(b);
        printAbc(b);
    }

    //8.基数排序
    public void basicSortTest(){
        BasicSort basicSort = new BasicSort();
        int[] b = a;
        basicSort.basicSort(b);
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
