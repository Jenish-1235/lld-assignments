/**
 * Handles all console output for invoices. Keeps formatting out of
 * CafeteriaSystem.
 */
public class InvoicePrinter {

    public void printInvoice(String formattedInvoice) {
        System.out.print(formattedInvoice);
    }

    public void printSaved(String invId, int lineCount) {
        System.out.println("Saved invoice: " + invId + " (lines=" + lineCount + ")");
    }
}
