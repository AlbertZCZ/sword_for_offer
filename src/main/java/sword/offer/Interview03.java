package sword.offer;

/**
 * @Author:Zhangchaozhen
 * @Date: Create in 2018/3/24 17:31
 * @Description:在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Interview03 {
    /**
     * 规律：首先选取数组中右上角的数字。如果该数字等于要查找的数字，查找过程结束：
     * 如果该数字大于要查找的数字，剔除这个数字所在的列：如果该数字小于要查找的数字，剔除这个数字所在的行。
     * 也就是说如果要查找的数字不在数组的右上角，则每－次都在数组的查找范围中剔除）行或者一列，这样每一步都可以缩小
     * 查找的范围，直到找到要查找的数字，或者查找范围为空。
     * @param matrix 待查找的二维数组
     * @param number 要查找的数
     * @return 找到true 找不到false
     */
    public static boolean find(int[][] matrix, int number) {
        //判断条件
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        //数组行数
        int rows = matrix.length;
        //数组列数
        int cols = matrix[1].length;
        //开始的行数
        int row = 0;
        //开始的列数
        int col = cols - 1;

        //确保找的位置在数组之内
        while (row >= 0 && row < rows && col >= 0 && col <= cols) {
            if (matrix[row][col] == number) {
                return true;
            } else if (matrix[row][col] > number) {
                // 如果找到的数比要找的数大，说明要找的数在当前数的左边
                col--;
                // 如果找到的数比要找的数小，说明要找的数在当前数的下边
            } else {
                row++;
            }
        }
        return false;
    }
}
