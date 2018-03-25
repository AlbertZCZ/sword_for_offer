package sword.offer;

/**
 * @Author:Zhangchaozhen
 * @Date: Create in 2018/3/25 10:28
 * @Description: 请实现一个函数，把字符串中的每个空格替换成"%20"，例如“We are happy.“，
 * 则输出”We%20are%20happy.“。
 */
public class Interview04 {
    /**
     *
     * @param string 要转换的字符数组
     * @param usedLength 字符数组中已经使用的长度
     * @return 转换后字符数组使用的长度 -1表示失败
     */
    public static int replaceBlank(char[] string,int usedLength) {
        //判断字符是否合法
        if (string == null || usedLength > string.length)
            return -1;
        //统计字符数组中空白字符数
        int whiteCount = 0;
        for (int i = 0;i < string.length;i++) {
            if (string[i] == ' ')
                whiteCount++;
        }

        //计算转换后数组的长度
        //由于是把1个字符替换称3个字符，我们必须把空格后面的所有的字符都后移两个字节
        int targetLength = whiteCount * 2 + usedLength;//新数组的长度
        int temp = usedLength;//保存长度用于结果返回
        if (targetLength > string.length)//如果转换后的长度大于数组的最大长度，则失败
            return -1;

        //如果空白字符不存在则不处理
        if (whiteCount == 0)
            return -1;

        targetLength--;//处理后字符放置的位置，指向新数组最后一个
        usedLength--;//从后向前第一个处理的字符，指向原数组最后一个

        //数组中有空白字符，一直到空白字符处理完
        while (usedLength >= 0 && targetLength > usedLength) {
            if (string[usedLength] == ' ') {
                string[targetLength--] = '0';
                string[targetLength--] = '2';
                string[targetLength--] = '%';
            }else {
                string[targetLength--] = string[usedLength];
            }
            usedLength--;
        }
        return temp;
    }
}
