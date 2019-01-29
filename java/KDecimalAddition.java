package myzd;

import org.junit.Test;

/**
 * @author liuqian
 * @date 2018/5/21 18:18
 */
public class KDecimalAddition {

  /**
   * 给出一个k，a，b，代表a和b都是一个k进制的数，输出a + b的k进制数。
   *
   * @param k 进制
   * @param a 数字
   * @param b 数字
   */
  private String solution(int k, String a, String b) {
    int i, j, temp = 0;
    StringBuilder ans = new StringBuilder();
    for (i = 0; i < a.length(); i++) {
      if (a.charAt(i) != '0') {
        break;
      }
    }
    a = a.substring(i);
    for (j = 0; j < b.length(); j++) {
      if (b.charAt(j) != '0') {
        break;
      }
    }
    b = b.substring(j);
    if (a.length() < b.length()) {
      String t = a;
      a = b;
      b = t;
    }
    StringBuilder c = new StringBuilder(a);
    j = b.length() - 1;
    for (i = a.length() - 1; i >= 0; i--) {
      int sum = a.charAt(i) - '0';
      if (j >= 0) {
        sum += b.charAt(j) - '0';
        j--;
      }
      if (temp != 0) {
        sum += temp;
      }
      c.setCharAt(i, (char) (sum % k + '0'));
      temp = sum / k;
    }
    if (temp != 0) {
      ans.insert(0, (char) ('0' + temp));
    }
    ans.append(c);
    return ans.toString();
  }

  @Test
  public void decimalAdditionTest() {
    System.out.println(this.solution(3, "12", "1"));
    System.out.println(this.solution(2, "101", "1"));
    System.out.println(this.solution(10, "20", "6"));
  }
}
