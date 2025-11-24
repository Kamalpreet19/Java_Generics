//Problem 5. AI-Driven Resume Screening System
import java.util.ArrayList;
import java.util.List;

abstract class JobRole {
    private String candidateName;

    public JobRole(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public abstract void showRoleDetails();
}

class SoftwareEngineer extends JobRole {
    private String programmingLanguage;

    public SoftwareEngineer(String candidateName, String programmingLanguage) {
        super(candidateName);
        this.programmingLanguage = programmingLanguage;
    }

    public void showRoleDetails() {
        System.out
                .println("Software Engineer Candidate: " + getCandidateName() + ", Skilled in: " + programmingLanguage);
    }
}

class DataScientist extends JobRole {
    private String expertise;

    public DataScientist(String candidateName, String expertise) {
        super(candidateName);
        this.expertise = expertise;
    }

    public void showRoleDetails() {
        System.out.println("Data Scientist Candidate: " + getCandidateName() + ", Expertise: " + expertise);
    }
}

class ProductManager extends JobRole {
    private int experienceYears;

    public ProductManager(String candidateName, int experienceYears) {
        super(candidateName);
        this.experienceYears = experienceYears;
    }

    public void showRoleDetails() {
        System.out.println(
                "Product Manager Candidate: " + getCandidateName() + ", Experience: " + experienceYears + " years");
    }
}

class Resume<T extends JobRole> {
    private T candidate;

    public Resume(T candidate) {
        this.candidate = candidate;
    }

    public void processResume() {
        System.out.println("\nProcessing resume of " + candidate.getCandidateName());
        candidate.showRoleDetails();
    }

    public T getCandidate() {
        return candidate;
    }
}

class ResumeScreeningSystem {

    public static <T extends JobRole> Resume<T> screenResume(T candidate) {
        return new Resume<>(candidate);
    }

    public static void processAllResumes(List<? extends JobRole> candidates) {
        System.out.println("\nProcessing all candidates in the system:");
        for (JobRole candidate : candidates) {
            candidate.showRoleDetails();
        }
    }
}

public class AIResumeScreening {

    public static void main(String[] args) {

        SoftwareEngineer se = new SoftwareEngineer("Aarav Mehta", "Java & Python");
        DataScientist ds = new DataScientist("Sara Khan", "Machine Learning & NLP");
        ProductManager pm = new ProductManager("Rohan Verma", 5);

        Resume<SoftwareEngineer> seResume = ResumeScreeningSystem.screenResume(se);
        Resume<DataScientist> dsResume = ResumeScreeningSystem.screenResume(ds);
        Resume<ProductManager> pmResume = ResumeScreeningSystem.screenResume(pm);

        seResume.processResume();
        dsResume.processResume();
        pmResume.processResume();

        List<JobRole> allCandidates = new ArrayList<>();
        allCandidates.add(se);
        allCandidates.add(ds);
        allCandidates.add(pm);

        ResumeScreeningSystem.processAllResumes(allCandidates);
    }
}

