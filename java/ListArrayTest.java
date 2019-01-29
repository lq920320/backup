/**
 * @author liuqian
 * @date 2018/7/2 17:42
 */
public class StringTest {
  @Test
  public void heh() {
    List<Employee> employees = new ArrayList<Employee>() {{
      add(new Employee() {{
        setUserId("A01");
      }});
      add(new Employee() {{
        setUserId("A02");
      }});
      add(new Employee() {{
        setUserId("A03");
      }});
      add(new Employee() {{
        setUserId("A04");
      }});
      add(new Employee() {{
        setUserId("A05");
      }});
      add(new Employee() {{
        setUserId("A06");
      }});
    }};
    String[] userArray = employees.stream().map(Employee::getUserId).toArray(String[]::new);

    System.out.println(Arrays.toString(userArray));
  }
}
