import java.util.*;

/**
 * Orchestrates checkout only: ID → calculate → format → print → save.
 * No formatting, no tax/discount logic; depends on InvoiceStore (not
 * FileStore).
 */
public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final InvoiceStore store;
    private final InvoicePrinter printer;
    private final CheckoutCalculator calculator;
    private final InvoiceFormatter formatter;
    private int invoiceSeq = 1000;

    public CafeteriaSystem(InvoiceStore store, InvoicePrinter printer,
            CheckoutCalculator calculator, InvoiceFormatter formatter) {
        this.store = store;
        this.printer = printer;
        this.calculator = calculator;
        this.formatter = formatter;
    }

    public void addToMenu(MenuItem i) {
        menu.put(i.id, i);
    }

    public void checkout(String customerType, List<OrderLine> lines) {
        String invId = "INV-" + (++invoiceSeq);
        InvoiceData data = calculator.calculate(invId, menu, lines, customerType);
        String formatted = formatter.format(data);
        printer.printInvoice(formatted);
        store.save(invId, formatted);
        printer.printSaved(invId, store.countLines(invId));
    }
}
