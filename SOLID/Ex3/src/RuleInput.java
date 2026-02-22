interface EligibilityRule {
    String check(StudentProfile s);
}

public class RuleInput {
    public double minCgr = 8.0;
    public int minAttendance = 75;
    public int minCredits = 20;
}

class DisciplinaryRule implements EligibilityRule {
    @Override
    public String check(StudentProfile s) {
        return s.disciplinaryFlag != LegacyFlags.NONE ? "disciplinary flag present" : null;
    }
}

class CgrRule implements EligibilityRule {
    private final RuleInput config;
    CgrRule(RuleInput config) { this.config = config; }

    @Override
    public String check(StudentProfile s) {
        return s.cgr < config.minCgr ? "CGR below " + (int) config.minCgr + ".0" : null;
    }
}

class AttendanceRule implements EligibilityRule {
    private final RuleInput config;
    AttendanceRule(RuleInput config) { this.config = config; }

    @Override
    public String check(StudentProfile s) {
        return s.attendancePct < config.minAttendance
            ? "attendance below " + config.minAttendance : null;
    }
}

class CreditsRule implements EligibilityRule {
    private final RuleInput config;
    CreditsRule(RuleInput config) { this.config = config; }

    @Override
    public String check(StudentProfile s) {
        return s.earnedCredits < config.minCredits
            ? "credits below " + config.minCredits : null;
    }
}
