package template;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MergeSort {

    public static void main(String[] args) {
        int[] dest = new int[]{8, 9, 2, 4, 5, 1, 6};
        int[] support = new int[dest.length];

        // 归并排序
        new MergeSort().mergeSort(dest, 0, dest.length, support);

        System.out.println(Arrays.stream(dest).mapToObj(e -> e + "").collect(Collectors.joining()));
    }

    /**
     * 归并排序
     *
     * @param dest    目标数组
     * @param x       数组起点    第一个元素索引
     * @param y       数组终点    最后一个元素索引 + 1
     * @param support 辅助数组
     */
    public void mergeSort(int[] dest, int x, int y, int[] support) {
        // 如果数组元素多于一个才需要排序
        if (y - x > 1) {
            // 获取中点
            int m = (x + y) / 2;
            // 定义两个索引 p q，用于索引左右两个子数组，索引 i 用于索引辅助数组
            int p = x, q = m, i = x;

            // 排序   左子数组
            mergeSort(dest, x, m, support);
            // 排序   右子数组
            mergeSort(dest, m, y, support);

            // 只要两个子数组的索引未越界
            while (p < x || q < y) {
                // 如果右子数组已经越界左子数组未越界，或者两者都未越界但左子数组首元素小于右子数组，把左子数组首元素放入辅助数组中
                if (q >= y || (p < x && dest[p] < dest[q])) support[i++] = dest[p++];
                else support[i++] = dest[q++];
            }

            // 将辅助数组中的元素放回到目标数组中
            for (i = x; i < y; i++) dest[i] = support[i];
        }
    }
}
