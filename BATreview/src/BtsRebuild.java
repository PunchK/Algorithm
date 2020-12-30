import java.util.ArrayList;

public class BtsRebuild {
    public static class Node {
        public int value;
        public Node left;//左指针
        public Node right;//本类类型变量

        public Node (int v) {
            value = v;//构造函数
        }
    }//二叉树的基本描述

    public static Node posArrayToBST(int[] posArr) {
        return process1(posArr, 0, posArr.length - 1);
    }

    //目前，我们在使用posArr[L...R]这些数字，建树
    //建出来的树，各个节点之间连接完毕，最后将头节点返回（普通返回）
    public static Node process1(int[] posArr, int L,int R){ //0.操作的范围是L-R，考虑使用范围作为条件
        if (L > R) { //1.先判断有无效
            return null;
        }
        Node head = new Node (posArr[R]);
        if (L == R) { //2.判断最终的结束条件
            return head;
        }
        int M = L-1; //这里有个问题，为什么M的初始值是L-1？（感觉很好，马上可以看出不对劲的地方。需要相信，然后直面。）预防R左侧的树均大于/小于R的值（不平衡），为了兼顾三种情况
        //1.平衡情况：既有小于又有大于，M的值一定会更新，所以M的初始值根本无所谓（观察递归时，参数是否正确）
        //2.右侧无子树时，也是正确的。但是当左侧无子树时，M的初始值必须为L-1，因为for循环只做判断就跳出来，M的值不变，而在后面的递归调用中，右子树参数的起始位置为M+1（逻辑的严谨性）
        //这个初始值设定，兼顾所有情况，不需做逻辑分支进行区分
        for(int i = L;i < R; i++) { //此处是i<R,不是小于R-1，因为范围的上线是到R-1；3.考虑搜索二叉树的特性，构建左右树分解（拆解）条件
            if (posArr[i] < posArr[R]) { //这里判断的是小于posArr[R]，因为是搜索二叉树，所以比头小的在左侧，比头大的在右侧
                M = i; //将划分点找到
            }
        }
        head.left = process1(posArr, L, M); //将left与right和head相关联
        head.right = process1(posArr, M+1, R-1); //如果根节点只有左子树，那么右子树一定是空节点，所以正好就是第一个判定条件（不难，只是没有接触过，所以要多接触）
        return head;
    }

    public static Node posArrayToBST2(int[] posArr) {
        return process2(posArr, 0, posArr.length-1);
    }

    public static Node process2(int[] posArr, int L, int R){
        if (L > R){
            return null;
        }
        Node head = new Node (posArr[R]);
        if (L == R){
            return head;
        }
        int M = L-1, left = L ,right = R-1;
        while (left <= right){
            int mid = left + ((right=left) >> 1);
            if (posArr[mid] < posArr[R]){
                M = mid;
                left = mid+1;
            }else{
                right = mid -1;
            }
        }
        head.left = process2(posArr, L, M);
        head.right = process2(posArr, M+1, R-1);
        return head;
    }

    //for test：怎么证明，我写的是对的
    public static int[] getBstPosArray(Node head) {
        ArrayList<Integer> posList = new ArrayList<>();
        pos(head, posList);
        int[] ans= new int[posList.size()];
        for (int i = 0;i < ans.length; i++){
            ans[i] = posList.get(i);
        }
        return ans;
    }

    public static  void pos(Node head, ArrayList<Integer> posList) {
        if (head != null) {
            pos(head.left, posList);
            pos(head.right, posList);
            posList.add(head.value);
        }
    }

    public static Node genarateRandomBST(int min, int max, int N) {
        if (min > max){
            return null;
        }
        return createTree (min, max, 1, N);

    }

    public static Node createTree(int min, int max, int level, int N) {
        if (min > max || level >N) {
            return null;
        }
        Node head = new Node(random(min, max));
        head.left = createTree(min, head.value -1, level+1, N);
        head.right = createTree(head.value + 1, max,level + 1, N);
        return head;
    }

    public static int random(int min, int max) {
        return min + (int) (Math.random() * (max - min + 1));
    }

    public static boolean isSameValueStructure(Node head1, Node head2) {
        if ((head1 == null && head2 != null) || (head1 != null && head2 == null)) {
            return false;
        }
        if (head1 == null && head2 == null){
            return true;
        }
        return head1.value == head2.value && isSameValueStructure(head1.left, head2.left)
                && isSameValueStructure(head1.right, head2.right);
    }

    public static void printTree(Node head) {
        System.out.println("Binary Tree");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(Node head, int height,String to, int len) {
        if (head == null){
            return;
        }
        printInOrder(head.right, height+1, "v", len);
        String val = to + head.value +to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM -lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height + len) +val);
        printInOrder(head.left, height + 1, "^", len);
    }


}
