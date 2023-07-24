public class StudentController {
    private List<Student> students = new ArrayList<>();
    private List<StudentGroup> studentGroups = new ArrayList<>();
    private List<Lesson> lessons = new ArrayList<>();

    @PostMapping("/create_group")
    public ResponseEntity<String> createGroup(@RequestBody StudentGroup group) {
        group.setIdentifier(studentGroups.size() + 1);
        studentGroups.add(group);
        return ResponseEntity.status(HttpStatus.CREATED).body("Group created successfully");
    }

    @GetMapping("/get_groups")
    public ResponseEntity<List<StudentGroup>> getGroups() {
        return ResponseEntity.ok(studentGroups);
    }

    @PostMapping("/create_student")
    public ResponseEntity<String> createStudent(@RequestBody Student student) {
        student.setIdentifier(students.size() + 1);
        students.add(student);
        return ResponseEntity.status(HttpStatus.CREATED).body("Student created successfully");
    }

    @GetMapping("/get_students/{groupId}")
    public ResponseEntity<List<Student>> getStudentsByGroup(@PathVariable long groupId) {
        StudentGroup group = studentGroups.stream()
                                          .filter(g -> g.getIdentifier() == groupId)
                                          .findFirst()
                                          .orElse(null);

        if (group != null) {
            List<Student> studentsInGroup = students.stream()
                                                    .filter(s -> s.getGroup().equals(group))
                                                    .collect(Collectors.toList());
            return ResponseEntity.ok(studentsInGroup);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create_lesson")
    public ResponseEntity<String> createLesson(@RequestBody Lesson lesson) {
        lesson.setIdentifier(lessons.size() + 1);
        lessons.add(lesson);
        return ResponseEntity.status(HttpStatus.CREATED).body("Lesson created successfully");
    }

    @GetMapping("/get_lessons/{studentId}")
    public ResponseEntity<List<Lesson>> getLessonsByStudent(@PathVariable long studentId) {
        Student student = students.stream()
                                  .filter(s -> s.getIdentifier() == studentId)
                                  .findFirst()
                                  .orElse(null);

        if (student != null) {
            List<Lesson> lessonsForStudent = lessons.stream()
                                                    .filter(l -> l.getGroup().equals(student.getGroup()))
                                                    .collect(Collectors.toList());
            return ResponseEntity.ok(lessonsForStudent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
