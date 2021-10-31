import utils.Help;

/**
 * @author 曹文艳   (caowy@cloud-young.com)
 * @version V1.0
 * @description
 * @date 2021年10月30日 23:56
 */
//选择排序
public class SelectSort {
    public void selectSort(int[] array){
        for (int i = array.length - 1; i >= 0 ; i--) {
            int maxIndex = getMaxIndex(array, 0, i + 1);
            Help.change(array,i,maxIndex);
        }
    }

    private int getMaxIndex(int[] array, int i, int i1) {
        int max = Integer.MIN_VALUE;

        int maxIndex = i1;
        for (int j = i1 - 1; j >= 0 ; j--) {
            if (array[j] > max){
                max = array[j];
                maxIndex = j;
            }

        }
        return maxIndex;
    }


    public static void main(String[] args) {
        SelectSort selectSort = new SelectSort();
        int[] array = {20,15,18,10,5,3,1};
        selectSort.selectSort(array);
        for (int i : array) {
            System.out.print(i + "、 ");
        }
    }
}
