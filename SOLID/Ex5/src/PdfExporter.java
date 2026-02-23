import java.nio.charset.StandardCharsets;

public class PdfExporter extends Exporter {
    private static final int MAX_BODY_LENGTH = 20;

    @Override
    public ExportResult export(ExportRequest req) {
        if (req == null) {
            throw new IllegalArgumentException("req is required");
        }
        if (req.body != null && req.body.length() > MAX_BODY_LENGTH) {
            return new ExportResult("application/pdf", new byte[0], "PDF cannot handle content > 20 chars");
        }
        String fakePdf = "PDF(" + req.title + "):" + (req.body != null ? req.body : "");
        return new ExportResult("application/pdf", fakePdf.getBytes(StandardCharsets.UTF_8));
    }
}
