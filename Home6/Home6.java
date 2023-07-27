import java.util.UUID;

public class Homework {

    // Interface for report generators
    public interface ReportGenerator {
        Report generateReport(Document document);
    }

    // PDF Report Generator
    public class PdfReportGenerator implements ReportGenerator {
        @Override
        public Report generateReport(Document document) {
            // Implementation to generate PDF report from the document
            // ...
            return new Report(pdfData);
        }
    }

    // JSON Report Generator
    public class JsonReportGenerator implements ReportGenerator {
        @Override
        public Report generateReport(Document document) {
            // Implementation to generate JSON report from the document
            // ...
            return new Report(jsonData);
        }
    }

    // XML Report Generator
    public class XmlReportGenerator implements ReportGenerator {
        @Override
        public Report generateReport(Document document) {
            // Implementation to generate XML report from the document
            // ...
            return new Report(xmlData);
        }
    }

    public class ReportEntrypoint {

        // Factory method to create a report based on the report type
        public Report create(Document document, String reportType) {
            ReportGenerator reportGenerator = null;
            switch (reportType) {
                case "pdf":
                    reportGenerator = new PdfReportGenerator();
                    break;
                case "json":
                    reportGenerator = new JsonReportGenerator();
                    break;
                case "xml":
                    reportGenerator = new XmlReportGenerator();
                    break;
                // Add more cases for other report types as needed
                default:
                    throw new IllegalArgumentException("Unsupported report type: " + reportType);
            }

            return reportGenerator.generateReport(document);
        }
    }

    public class Document {

        private UUID id;
        private String number;
        // ...

        // Getters and setters for document fields
    }

    public class Report {
        private byte[] data;

        public Report(byte[] data) {
            this.data = data;
        }

        // Getters and setters for report data
    }
}
