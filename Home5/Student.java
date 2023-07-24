public class Student {
    private long identifier;
    private String name;
    private StudentGroup group;

    // constructors, getters, setters
}

// StudentGroup.java
public class StudentGroup {
    private long identifier;
    private int number;

    // constructors, getters, setters
}

// Lesson.java
public class Lesson {
    private long identifier;
    private StudentGroup group;
    private Date date;

    // constructors, getters, setters
}
