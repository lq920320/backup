```java
// get today and clear time of day
Calendar cal = Calendar.getInstance();
cal.set(Calendar.HOUR_OF_DAY, 0); // ! clear would not reset the hour of day !
cal.clear(Calendar.MINUTE);
cal.clear(Calendar.SECOND);
cal.clear(Calendar.MILLISECOND);

// get start of this week in milliseconds
cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
System.out.println("Start of this week:       " + cal.getTime());
System.out.println("... in milliseconds:      " + cal.getTimeInMillis());

// start of the next week
cal.add(Calendar.WEEK_OF_YEAR, 1);
System.out.println("Start of the next week:   " + cal.getTime());
System.out.println("... in milliseconds:      " + cal.getTimeInMillis());
This month in milliseconds:

// get today and clear time of day
Calendar cal = Calendar.getInstance();
cal.set(Calendar.HOUR_OF_DAY, 0); // ! clear would not reset the hour of day !
cal.clear(Calendar.MINUTE);
cal.clear(Calendar.SECOND);
cal.clear(Calendar.MILLISECOND);

// get start of the month
cal.set(Calendar.DAY_OF_MONTH, 1);
System.out.println("Start of the month:       " + cal.getTime());
System.out.println("... in milliseconds:      " + cal.getTimeInMillis());

// get start of the next month
cal.add(Calendar.MONTH, 1);
System.out.println("Start of the next month:  " + cal.getTime());
System.out.println("... in milliseconds:      " + cal.getTimeInMillis());
```
