import java.util.*;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final TaxPolicy tax;
    private final DiscountPolicy discount;
    private final InvoiceFormatter formatter;
    private final InvoiceStore store;
    private int invoiceSeq = 1000;

    public CafeteriaSystem(TaxPolicy tax, DiscountPolicy discount,
                           InvoiceFormatter formatter, InvoiceStore store) {
        this.tax       = tax;
        this.discount  = discount;
        this.formatter = formatter;
        this.store     = store;
    }

    public void addToMenu(MenuItem item) { menu.put(item.id, item); }

    public void checkout(String customerType, List<OrderLine> lines) {
        String invId = "INV-" + (++invoiceSeq);

        double subtotal = 0.0;
        for (OrderLine l : lines) {
            subtotal += menu.get(l.itemId).price * l.qty;
        }

        double taxPct      = tax.taxPercent(customerType);
        double taxAmount   = subtotal * (taxPct / 100.0);
        double discAmount  = discount.discountAmount(customerType, subtotal, lines.size());
        double total       = subtotal + taxAmount - discAmount;

        InvoiceSummary summary = new InvoiceSummary(
            invId, lines, menu, subtotal, taxPct, taxAmount, discAmount, total
        );

        String printable = formatter.format(summary);
        System.out.print(printable);

        store.save(invId, printable);
        System.out.println("Saved invoice: " + invId + " (lines=" + store.countLines(invId) + ")");
    }
}
