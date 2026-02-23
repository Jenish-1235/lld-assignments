import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Student Onboarding ===");
        StudentStore store = new FakeDb();
        RawInputParser parser = new RawInputParser();
        StudentValidator validator = new StudentValidator();
        OnboardingPrinter printer = new OnboardingPrinter();
        OnboardingService svc = new OnboardingService(store, parser, validator, printer);

        String raw = "name=Riya;email=riya@sst.edu;phone=9876543210;program=CSE";
        svc.registerFromRawInput(raw);

        System.out.println();
        System.out.println("-- DB DUMP --");
        List<StudentRecord> all = store.all();
        System.out.print(TextTable.render3(all));
    }
}
