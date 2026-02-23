public class OnboardingService {
    private final StudentStore store;
    private final RawInputParser parser;
    private final StudentValidator validator;
    private final OnboardingPrinter printer;

    public OnboardingService(StudentStore store, RawInputParser parser, StudentValidator validator,
            OnboardingPrinter printer) {
        this.store = store;
        this.parser = parser;
        this.validator = validator;
        this.printer = printer;
    }

    public void registerFromRawInput(String raw) {
        printer.printInput(raw);

        RawStudentData data = parser.parse(raw);
        ValidationResult result = validator.validate(data);

        if (!result.isSuccess()) {
            printer.printValidationErrors(result.getErrors());
            return;
        }

        String id = IdUtil.nextStudentId(store.count());
        StudentRecord rec = new StudentRecord(id, data.name, data.email, data.phone, data.program);
        store.save(rec);

        printer.printSuccess(rec, store.count());
    }
}
