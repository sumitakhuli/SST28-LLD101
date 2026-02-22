import java.nio.charset.StandardCharsets;

public class CsvExporter extends Exporter {
    @Override
    protected ExportResult doExport(ExportRequest req) {
        String csv = "title,body\n" + csvField(req.title) + "," + csvField(req.body) + "\n";
        return ExportResult.success("text/csv", csv.getBytes(StandardCharsets.UTF_8));
    }

    private String csvField(String s) {
        if (s == null) return "";
        if (s.contains(",") || s.contains("\n") || s.contains("\"")) {
            return "\"" + s.replace("\"", "\"\"") + "\"";
        }
        return s;
    }
}
