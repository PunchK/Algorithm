import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException
    {
        SortFunction sortFunction = new SortFunction();
        //1.归并排序测试-MergeSort；2.堆排序-MergeSort；
        sortFunction.chooseFunc("MergeSort");
    }
}
