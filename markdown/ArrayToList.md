
Array To List method:

```java
    @Test
    public void arrayToList() {
        String[] array = {"1", "2"};
        List<String> strings = Arrays.asList(array);
        try {
            strings.add("3");
        } catch (UnsupportedOperationException e) {
            log.error("不可进行add, remove 操作，构造了一个定长不可变的列表");
            System.out.println(strings);
        }

        System.out.println("-------------------------");
        List<String> strings2 = new ArrayList<>(array.length);
        Collections.addAll(strings2, array);
        System.out.println(strings2);
        strings2.add("3");
        System.out.println(strings2);

        System.out.println("-------------------------");
        List<String> string3 = new ArrayList<>(Arrays.asList(array));
        System.out.println(string3);
        string3.add("3");
        System.out.println(string3);
    }
```
