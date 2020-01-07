package myzd;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.junit.Test;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author liuqian
 * @date 2018/1/8 15:10
 * Sort a list by key.
 */
public class ComparatorTest {

  @Test
  public void compareTest() {
    List<TestData> dataList = getDataList();
    dataList = dataList.stream().sorted(Comparator.comparing(TestData::getId, Comparator.nullsLast(Comparator.naturalOrder()))).collect(Collectors.toList());
    List<Integer> idList = dataList.stream().map(TestData::getId).sorted(Comparator.nullsLast(Comparator.reverseOrder())).collect(Collectors.toList());
    Integer maxId = idList.get(0);
    System.out.println("maxId :  " + maxId);
    for (TestData data : dataList) {
      System.out.println(data.toString());
    }
  }

  @Test
  public void mapTest() throws JsonProcessingException {
    Map<Integer, Integer> map = new HashMap<>(16);
    map.put(1, 90);
    map.put(2, 80);
    map.put(3, 70);
    map.put(4, 60);
    map.put(5, 50);
    ObjectMapper objectMapper = new ObjectMapper();
    System.out.println(objectMapper.writeValueAsString(map));

    System.out.println("{\"8\":77,\"9\":85,\"10\":90}");

    String completedDegreeMap = "{\"8\":77,\"9\":85,\"10\":90}";
    String countLevel = "8,9,10";
    Map<Integer, Integer> degreeMap = new HashMap<>(16);
    try {
      degreeMap = objectMapper.readValue(completedDegreeMap, new TypeReference<Map<Integer, Integer>>() {
      });
    } catch (IOException e) {
      e.printStackTrace();
    }
    String[] levels = countLevel.split(",");
    for (String level : levels) {
      System.out.println("--------------" + level + "----------------");
      System.out.println(degreeMap.get(Integer.parseInt(level)));
    }

  }

  @Data
  private class TestData {
    private Integer id;
    private String callName;

    @Override
    public String toString() {
      return "The id is " + this.id + ", callName is " + this.callName + ".";
    }
  }

  private List<TestData> getDataList() {
    TestData data1 = new TestData() {{
      setId(1);
      setCallName("A");
    }};
    TestData data2 = new TestData() {{
      setId(2);
      setCallName("B");
    }};
    TestData data3 = new TestData() {{
      setId(3);
    }};
    TestData data4 = new TestData() {{
      setId(null);
    }};
    TestData data5 = new TestData() {{
      setId(5);
      setCallName("E");
    }};

    return new ArrayList<TestData>() {{
      add(data1);
      add(data2);
      add(data3);
      add(data4);
      add(data5);
    }};
  }
}
