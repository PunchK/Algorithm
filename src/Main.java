import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException
    {
        SortFunction sortFunction = new SortFunction();
        /*1.归并排序测试-MergeSort；2.堆排序-HeapSort；3.冒泡排序-BubbleSort；4.插入排序-InsertSort；5.快速排序-QuickSort；6.选择排序-SelectSort；
        7.希尔排序-SellSort；8.基数排序-BasicSort*/
        sortFunction.chooseFunc("BasicSort");
    }
}
