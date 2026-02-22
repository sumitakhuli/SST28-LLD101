import java.nio.charset.StandardCharsets;

public class PdfExporter extends Exporter {
    private static final int MAX_BODY_LENGTH = 20;

    @Override
    protected ExportResult doExport(ExportRequest req) {
        if (req.body != null && req.body.length() > MAX_BODY_LENGTH) {
            return ExportResult.error("PDF cannot handle content > 20 chars");
        }
        String fakePdf = "PDF(" + req.title + "):" + req.body;
        return ExportResult.success("application/pdf", fakePdf.getBytes(StandardCharsets.UTF_8));
    }
}
