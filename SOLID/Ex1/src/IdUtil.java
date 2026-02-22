import java.util.*;

class ValidationResult {
    private final List<String> errors;
    ValidationResult(List<String> errors) {
        this.errors = Collections.unmodifiableList(errors);
    }
    boolean isValid() { return errors.isEmpty(); }
    List<String> errors() { return errors; }
}

class StudentValidator {
    private static final Set<String> ALLOWED =
        new HashSet<>(Arrays.asList("CSE", "AI", "SWE"));

    ValidationResult validate(ParsedInput input) {
        List<String> errors = new ArrayList<>();
        if (input.name.isBlank())
            errors.add("name is required");
        if (input.email.isBlank() || !input.email.contains("@"))
            errors.add("email is invalid");
        if (input.phone.isBlank() || !input.phone.chars().allMatch(Character::isDigit))
            errors.add("phone is invalid");
        if (!ALLOWED.contains(input.program))
            errors.add("program is invalid");
        return new ValidationResult(errors);
    }
}

public class IdUtil {
    public static String nextStudentId(int currentCount) {
        int next = currentCount + 1;
        String num = String.format("%04d", next);
        return "SST-2026-" + num;
    }
}
