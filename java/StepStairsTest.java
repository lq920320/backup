package myzd;

import org.junit.Test;

/**
 * @author liuqian
 * @date 2018/3/21 13:23
 */
public class StepStairsTest {

  @Test
  public void stepStairs() {
    String string1 = "Hello";
    String string2 = string1;
    string1 = "World";
    System.out.println(string1);
    System.out.println(string2);
    System.out.println(stepWays(10));
  }

  private int stepWays(int stairs) {
    //f(n)=f(n−1)+f(n−2)，f(0)=1，f(1)=1
    if (stairs == 0 || stairs == 1) return 1;
    if (stairs == 2) return 2;
    return stepWays(stairs - 1) + stepWays(stairs - 2);
  }

}
