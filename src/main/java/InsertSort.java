/**
 * @author 曹文艳   (caowy@cloud-young.com)
 * @version V1.0
 * @description
 * @date 2021年10月29日 23:14
 */

//插入排序(从小到大排序)
public class InsertSort {
    public void insetSort(int[] array){
        for (int i = 1; i <= array.length - 1 ; i++) {
            int c = array[i];
            int j = i;
            for (;j>0 && array[j - 1] > c ; j--){
                array[j] = array[j - 1];
            }
            array[j] = c;
        }
    }

    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        int[] array = {20,15,18,10,5,3,1};
        insertSort.insetSort(array);
        for (int i : array) {
            System.out.print(i + "、 ");
        }
    }
}
