/**
 * Abstraction for saving invoices. CafeteriaSystem depends on this, not
 * FileStore.
 */
public interface InvoiceStore {
    void save(String name, String content);

    int countLines(String name);
}
