package utils;

/**
 * @author 曹先森
 * @version V1.0
 * @description
 * @date 2021年10月31日 23:11
 */
public class Help {
    public static void change(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
