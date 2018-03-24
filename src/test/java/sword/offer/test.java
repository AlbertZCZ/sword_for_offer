package sword.offer;

/**
 * @Author:Zhangchaozhen
 * @Date: Create in 2018/3/24 18:13
 * @Description:测试用例
 */
public class test {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        System.out.println(Interview03.find(matrix,7));
    }
}
