import java.util.Collections;
import java.util.List;

public class CreditsRule implements EligibilityRule {
    @Override
    public List<String> reasons(StudentProfile s) {
        if (s.earnedCredits < 20) {
            return List.of("credits below 20");
        }
        return Collections.emptyList();
    }
}
