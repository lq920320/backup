package myzd;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuqian
 * @date 2018/7/6 16:21
 * Find different in two list.
 */
public class CollectionsTest {


  @Test
  public void collectionTest() {
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();
    for (int i = 0; i < 400000; i++) {
      list1.add(i);
    }
    for (int i = 0; i < 400000; i++) {
      list2.add(i * 2);
    }

//    System.out.println(getDifferent1(list1, list2).size());
//    System.out.println(getDifferent2(list1, list2).size());
//    System.out.println(getDifferent3(list1, list2).size());
//    System.out.println(getDifferent4(list1, list2).size());
    System.out.println(getDifferent5(list1, list2).size());
  }

  // 方法1，两层遍历查找，遍历次数为list1.size()*list2.size()，有点蠢
  private static List<Integer> getDifferent1(List<Integer> list1, List<Integer> list2) {
    // diff 存放不同的元素
    List<Integer> diff = new ArrayList<>();
    // 开始查找的时间，用于计时
    long start = System.currentTimeMillis();
    for (Integer str : list1) {
      if (!list2.contains(str)) {
        diff.add(str);
      }
    }
    // 计时
    System.out.println("方法1 耗时：" + (System.currentTimeMillis() - start) + " 毫秒");
    return diff;
  }

  // 方法2，两层遍历查找，用retainAll()方法查找，也很蠢，方法底层依旧是两层遍历
  private static List<Integer> getDifferent2(List<Integer> list1, List<Integer> list2) {
    long start = System.currentTimeMillis();
    list1.retainAll(list2);// 返回值是boolean
    System.out.println("方法2 耗时：" + (System.currentTimeMillis() - start) + " 毫秒");
    return list1;
  }

  // 方法3，用Map存放List1和List2的元素作为key，value为其在List1和List2中出现的次数
  // 出现次数为1的即为不同元素，查找次数为list1.size() + list2.size()，较方法1和2，是极大简化
  private static List<Integer> getDifferent3(List<Integer> list1, List<Integer> list2) {
    List<Integer> diff = new ArrayList<>();
    long start = System.currentTimeMillis();
    Map<Integer, Integer> map = new HashMap<>(list1.size() + list2.size());
    // 将List1元素放入Map，计数1
    for (Integer string : list1) {
      map.put(string, 1);
    }
    // 遍历List2，在Map中查找List2的元素，找到则计数+1；未找到则放入map，计数1
    for (Integer string : list2) {
      Integer count = map.get(string);
      if (count != null) {
        map.put(string, ++count);// 此处可优化，减少put次数，即为方法4
        continue;
      }
      map.put(string, 1);
    }
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() == 1) {
        diff.add(entry.getKey());
      }
    }
    System.out.println("方法3 耗时：" + (System.currentTimeMillis() - start) + " 毫秒");
    return diff;
  }

  // 优化方法3，减少put次数
  private static List<Integer> getDifferent4(List<Integer> list1, List<Integer> list2) {
    List<Integer> diff = new ArrayList<>();
    long start = System.currentTimeMillis();
    Map<Integer, Integer> map = new HashMap<>(list1.size() + list2.size());
    List<Integer> maxList = list1;
    List<Integer> minList = list2;
    if (list2.size() > list1.size()) {
      maxList = list2;
      minList = list1;
    }
    for (Integer string : maxList) {
      map.put(string, 1);
    }
    for (Integer string : minList) {
      Integer count = map.get(string);
      if (count != null) {
        map.put(string, ++count);
        continue;
      }
      map.put(string, 1);
    }
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() == 1) {
        diff.add(entry.getKey());
      }
    }
    System.out.println("方法4 耗时：" + (System.currentTimeMillis() - start) + " 毫秒");
    return diff;

  }

  //方法5
  private static List<Integer> getDifferent5(List<Integer> list1, List<Integer> list2) {
    List<Integer> diff = new ArrayList<>();
    long start = System.currentTimeMillis();
//    list1 = list1.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
//    list2 = list2.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
    for (int i = 0; i < list1.size(); i++) {
      if (!list1.get(i).equals(list2.get(i))) {
        diff.add(list1.get(i));
      }
    }
    System.out.println("方法5 耗时：" + (System.currentTimeMillis() - start) + " 毫秒");
    return diff;
  }

}
