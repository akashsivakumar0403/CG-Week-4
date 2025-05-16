import java.util.*;

abstract class JobRole {
    abstract String getRoleName();
    abstract List<String> getReqSkills();
}

class SoftwareEng extends JobRole {
    public String getRoleName() {
        return "Software Engineer";
    }

    public List<String> getReqSkills() {
        return Arrays.asList("Java", "DSA", "Algorithms", "System Design");
    }
}

class DataScientist extends JobRole {
    public String getRoleName() {
        return "Data Scientist";
    }

    public List<String> getReqSkills() {
        return Arrays.asList("Pythin", "machine Learning", "Statistics", "Data Visualization");
    }
}

class ProductManager extends JobRole {
    public String getRoleName() {
        return "Product Manager";
    }

    public List<String> getReqSkills() {
        return Arrays.asList("Product Strategy", "User Research", "Communications", "Road Mapping");
    }
}

class Resume<T extends JobRole> {
    private String name;
    private T role;
    private List<String> skills;

    public Resume(String name, T role, List<String> skills) {
        this.name = name;
        this.role = role;
        this.skills = skills;
    }

    public String getName() { return name; }
    public T getRole() { return role; }
    public List<String> getSkills() { return skills; }

    public void display() {
        System.out.println("Candidate = " + name);
        System.out.println("Applying for = " + role.getRoleName());
        System.out.println("Skills = " + String.join(", ", skills));
    }

    public boolean isQualified() {
        return skills.containsAll(role.getReqSkills());
    }
}

class ResumeScreener {
    public static void processResumes(List<? extends Resume<? extends JobRole>> resumes) {
        for (Resume<? extends JobRole> resume : resumes) {
            resume.display();
            if (resume.isQualified()) {
                System.out.println("Status = Qualified");
            } else {
                System.out.println("Status = Not qualified");
            }
            System.out.println();
        }
    }
}

public class ResumeScreeningSystem {
    public static void main(String[] args) {
        Resume<SoftwareEng> r1 = new Resume<>(
                "Ruchi",
                new SoftwareEng(),
                Arrays.asList("Java", "DSA", "Algorithms", "System Design", "Git")
        );

        Resume<DataScientist> r2 = new Resume<>(
                "Vandit",
                new DataScientist(),
                Arrays.asList("Python", "Machine Learning", "Data Visualization", "Deep Learning")
        );

        Resume<ProductManager> r3 = new Resume<>(
                "Bhadrik",
                new ProductManager(),
                Arrays.asList("Product Strategy", "Communication", "User Research")
        );

        Resume<DataScientist> r4 = new Resume<>(
                "Ami",
                new DataScientist(),
                Arrays.asList("Excel", "SQL")
        );

        List<Resume<? extends JobRole>> resumeList = Arrays.asList(r1, r2, r3, r4);

        System.out.println("AI-Driven Resume Screening System");
        ResumeScreener.processResumes(resumeList);
    }
}
