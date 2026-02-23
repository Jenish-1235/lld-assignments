import java.util.List;

public interface EligibilityRule {
    List<String> reasons(StudentProfile s);
}
