import org.junit.Test;

/**
 * @author liuqian
 * @date 2019/6/27  9:47
 * 翻转字符串
 */
public class ReverseStringTest {

    /**
     * 方法一：利用 StringBuffer 或 StringBuilder 的 reverse 成员方法
     */
    @Test
    public void reverseString1() {
        String str = "Hello";
        String reverseStr = new StringBuilder(str).reverse().toString();
        System.out.println(reverseStr);
    }

    /**
     * 利用 String 的 toCharArray 方法先将字符串转化为 char 类型数组，然后将各个字符进行重新拼接
     */
    @Test
    public void reverseString2() {
        String str = "Hello";
        char[] chars = str.toCharArray();
        StringBuilder reverseStr = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            reverseStr.append(chars[i]);
        }
        System.out.println(reverseStr.toString());
    }

    /**
     * 利用 String 的 CharAt 方法取出字符串中的各个字符
     */
    @Test
    public void reverseString3() {
        String str = "Hello";
        StringBuilder reverseStr = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            reverseStr.insert(0, str.charAt(i));
        }
        System.out.println(reverseStr.toString());
    }
}
