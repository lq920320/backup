```java
    @Test
    public void valueEqualTest() {
        String a = new String("1233");
        String b = "1233";
        System.out.println(a == b); // false
        System.out.println(a.equals(b)); // true

        Integer n1 = new Integer(5);
        Integer n2 = 5;
        int n3 = 5;
        System.out.println(n1 == n2); // false
        System.out.println(n1.equals(n2)); // true
        System.out.println(n1 == n3); // true
        System.out.println(n2 == n3); // true
    }
```
