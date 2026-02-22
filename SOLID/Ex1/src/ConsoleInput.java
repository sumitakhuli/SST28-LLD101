import java.util.*;

class ParsedInput {
    final String name, email, phone, program;
    ParsedInput(String name, String email, String phone, String program) {
        this.name = name; this.email = email;
        this.phone = phone; this.program = program;
    }
}

class RawInputParser {
    ParsedInput parse(String raw) {
        Map<String, String> kv = new LinkedHashMap<>();
        for (String part : raw.split(";")) {
            String[] t = part.split("=", 2);
            if (t.length == 2) kv.put(t[0].trim(), t[1].trim());
        }
        return new ParsedInput(
            kv.getOrDefault("name",    ""),
            kv.getOrDefault("email",   ""),
            kv.getOrDefault("phone",   ""),
            kv.getOrDefault("program", "")
        );
    }
}

public class ConsoleInput {
    public String readLine() { return ""; }
}
