import java.util.*;

abstract class CourseType {
    private String courseName;

    public CourseType(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() { return courseName; }

    public abstract String getEvaluationType();
}

class ExamCourse extends CourseType {
    public ExamCourse(String courseName) {
        super(courseName);
    }

    public String getEvaluationType() {
        return "Exam-Based";
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String courseName) {
        super(courseName);
    }

    public String getEvaluationType() {
        return "Assignment-Based";
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String courseName) {
        super(courseName);
    }

    public String getEvaluationType() {
        return "Research-Based";
    }
}

class Course<T extends CourseType> {
    private T courseDetail;
    private String dept;

    public Course(T courseDetail, String dept) {
        this.courseDetail =  courseDetail;
        this.dept = dept;
    }

    public T getCourseDetail() { return courseDetail; }

    public String getDept() { return dept; }

    public String toString() {
        return "[" + dept + "]" + " "  + courseDetail.getCourseName() + " " + "(" + courseDetail.getEvaluationType() + ")";
    }
}

class UniUtils {
    public static void displayCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            System.out.println(course.getCourseName() + " - " + course.getEvaluationType());
        }
    }
}

public class UniCourseManagement {
    public static void main(String[] args) {
        Course<ExamCourse> math101 = new Course<>(new ExamCourse("Math 101"), "Mathematics");
        Course<AssignmentCourse> cs102 = new Course<>(new AssignmentCourse("Intro to Programming"), "Computer Science");
        Course<ResearchCourse> bio501 = new Course<>(new ResearchCourse("Genetics Research"), "Biology");

        List<Course<? extends CourseType>> catalog  = new ArrayList<>();
        catalog.add(math101);
        catalog.add(cs102);
        catalog.add(bio501);

        System.out.println("Course Catalog:");
        for (Course<? extends CourseType> course : catalog) {
            System.out.println(course);
        }

        List<CourseType> allCourseTypes = Arrays.asList(
                new ExamCourse("Physics 201"),
                new AssignmentCourse("Software Engineering"),
                new ResearchCourse("AI and Ethics")
        );

        System.out.println("\nDisplaying Courses (via Wildcard):");
        UniUtils.displayCourses(allCourseTypes);
    }
}
