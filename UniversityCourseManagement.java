//Problem 3. Multi-Level University Course Management System

import java.util.ArrayList;
import java.util.List;

abstract class CourseType {
    private String evaluationName;

    public CourseType(String evaluationName) {
        this.evaluationName = evaluationName;
    }

    public String getEvaluationName() {
        return evaluationName;
    }

    public abstract void showEvaluationDetails();
}

class ExamCourse extends CourseType {
    private int totalMarks;

    public ExamCourse(String evaluationName, int totalMarks) {
        super(evaluationName);
        this.totalMarks = totalMarks;
    }

    public void showEvaluationDetails() {
        System.out.println("Exam-Based Course: " + getEvaluationName() + ", Total Marks: " + totalMarks);
    }
}

class AssignmentCourse extends CourseType {
    private int assignmentsCount;

    public AssignmentCourse(String evaluationName, int assignmentsCount) {
        super(evaluationName);
        this.assignmentsCount = assignmentsCount;
    }

    public void showEvaluationDetails() {
        System.out.println("Assignment-Based Course: " + getEvaluationName() + ", Assignments: " + assignmentsCount);
    }
}

class ResearchCourse extends CourseType {
    private String researchTopic;

    public ResearchCourse(String evaluationName, String researchTopic) {
        super(evaluationName);
        this.researchTopic = researchTopic;
    }

    public void showEvaluationDetails() {
        System.out.println("Research-Based Course: " + getEvaluationName() + ", Topic: " + researchTopic);
    }
}

class Course<T extends CourseType> {
    private String courseName;
    private T evaluationType;

    public Course(String courseName, T evaluationType) {
        this.courseName = courseName;
        this.evaluationType = evaluationType;
    }

    public String getCourseName() {
        return courseName;
    }

    public T getEvaluationType() {
        return evaluationType;
    }

    public void showCourseInfo() {
        System.out.println("\nCourse: " + courseName);
        evaluationType.showEvaluationDetails();
    }
}

class CourseCatalog {
    private List<Course<? extends CourseType>> courses = new ArrayList<>();

    public <T extends CourseType> void addCourse(Course<T> course) {
        courses.add(course);
        System.out.println(course.getCourseName() + " added to catalog.");
    }

    public void showAllCourses() {
        System.out.println("\nAll Courses in Catalog:");
        for (Course<? extends CourseType> course : courses) {
            course.showCourseInfo();
        }
    }
}

public class UniversityCourseManagement {
    public static void main(String[] args) {

        CourseCatalog catalog = new CourseCatalog();

        Course<ExamCourse> cs101 = new Course<>("CS101", new ExamCourse("Midterm & Final", 100));
        Course<AssignmentCourse> eng201 = new Course<>("ENG201", new AssignmentCourse("Weekly Assignments", 5));
        Course<ResearchCourse> res301 = new Course<>("RES301", new ResearchCourse("Research Project", "AI Ethics"));

        catalog.addCourse(cs101);
        catalog.addCourse(eng201);
        catalog.addCourse(res301);

        catalog.showAllCourses();
    }
}