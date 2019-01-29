package myzd;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * @author liuqian
 * @date 2018/3/21 11:16
 * Clean repeated data by stream.
 */
public class CleanRepeatedDataTest {

  @Test
  public void cleanRepeatedTest() {
    ObjectMapper objectMapper = new ObjectMapper();
    List<Student> studentList = getStudentList();
    Map<String, Integer> groupList = studentList.stream().collect(
      groupingBy(Student::getName, summingInt(Student::getMathScore))
    );
    try {
      System.out.println(objectMapper.writeValueAsString(groupList));
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
//    List<Student> unique = studentList.stream().collect(
//      collectingAndThen(
//        toCollection(() -> new TreeSet<>(Comparator.comparing(Student::getName))), ArrayList::new)
//    );
//    List<String> names =
//      studentList.stream()
//        .filter(student -> student.getName() != null)
//        .map(Student::getName)
//        .collect(Collectors.toList());
//    System.out.println(names);
    System.out.println("------------------after-------------------");
//    for (Student student : unique) {
//      System.out.println(student.toString());
//    }

  }

  @Test
  public void cleanRepeatTest() {
    List<Student> studentList = getStudentList();
    List<Student> unique = studentList.stream().collect(
      collectingAndThen(
        toCollection(() -> new TreeSet<>(Comparator.comparing(Student::getName))), ArrayList::new)
    );
    List<String> names =
      studentList.stream()
        .filter(student -> student.getName() != null)
        .map(Student::getName)
        .collect(Collectors.toList());
    System.out.println(names);
    System.out.println("------------------after-------------------");
    for (Student student : unique) {
      System.out.println(student.toString());
    }

  }


  @Data
  private class Student {
    private String name;
    private Integer mathScore;
    private Integer chineseScore;
    private Integer englishScore;

    @Override
    public String toString() {
      return "Student: name is " + name + ", mathScore is " + mathScore +
        ", chineseScore is " + chineseScore +
        ", englishScore is " + englishScore;
    }
  }

  private List<Student> getStudentList() {
    return new ArrayList<Student>() {{
      add(new Student() {{
        setName("Mike");
        setMathScore(10);
        setChineseScore(10);
        setEnglishScore(10);
      }});
      add(new Student() {{
        setName("Mike");
        setMathScore(20);
        setChineseScore(20);
        setEnglishScore(20);
      }});
      add(new Student() {{
        setName("Mike");
        setMathScore(5);
        setChineseScore(5);
        setEnglishScore(5);
      }});
      add(new Student() {{
        setName("Jack");
        setMathScore(10);
        setChineseScore(10);
        setEnglishScore(10);
      }});
      add(new Student() {{
        setName("Tom");
        setMathScore(5);
        setChineseScore(5);
        setEnglishScore(5);
      }});
    }};
  }

  private static final List<String> stringList = new ArrayList<String>() {{
    add("a");
    add("b");
  }};

  @Test
  public void stringTest() {
    final Student student = new Student();
    student.setName("123");
    stringList.add("c");
    System.out.println(stringList);
  }

  @Test
  public void decodeTest() {
    Base64.Decoder decoder = Base64.getDecoder();
    System.out.println(Arrays.toString(decoder.decode("y39HucT/PazBwj2O8ghDQQ==")));
  }


  @Test
  public void dis3() {
    List<Student> students = getStudentList();
    students.parallelStream().filter(distinctByKey(Student::getName))
      .forEach(System.out::println);
  }


  private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
    Set<Object> seen = ConcurrentHashMap.newKeySet();
    return t -> seen.add(keyExtractor.apply(t));
  }
}

