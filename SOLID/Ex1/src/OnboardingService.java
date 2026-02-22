public class OnboardingService {
    private final RawInputParser      parser;
    private final StudentValidator    validator;
    private final StudentRepository   repository;
    private final RegistrationPrinter printer;

    public OnboardingService(RawInputParser parser,
                             StudentValidator validator,
                             StudentRepository repository,
                             RegistrationPrinter printer) {
        this.parser     = parser;
        this.validator  = validator;
        this.repository = repository;
        this.printer    = printer;
    }

    public void registerFromRawInput(String raw) {
        printer.printInput(raw);

        ParsedInput      input  = parser.parse(raw);
        ValidationResult result = validator.validate(input);

        if (!result.isValid()) {
            printer.printErrors(result.errors());
            return;
        }

        String id         = IdUtil.nextStudentId(repository.count());
        StudentRecord rec = new StudentRecord(id, input.name, input.email, input.phone, input.program);
        repository.save(rec);
        printer.printSuccess(rec, repository.count());
    }
}
