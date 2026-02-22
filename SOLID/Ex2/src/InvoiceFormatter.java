import java.util.*;

class InvoiceSummary {
    final String invoiceId;
    final List<OrderLine> lines;
    final Map<String, MenuItem> menu;
    final double subtotal;
    final double taxPct;
    final double tax;
    final double discount;
    final double total;

    InvoiceSummary(String invoiceId, List<OrderLine> lines, Map<String, MenuItem> menu,
                   double subtotal, double taxPct, double tax, double discount, double total) {
        this.invoiceId = invoiceId;
        this.lines     = lines;
        this.menu      = menu;
        this.subtotal  = subtotal;
        this.taxPct    = taxPct;
        this.tax       = tax;
        this.discount  = discount;
        this.total     = total;
    }
}

public class InvoiceFormatter {
    public String format(InvoiceSummary inv) {
        StringBuilder sb = new StringBuilder();
        sb.append("Invoice# ").append(inv.invoiceId).append("\n");
        for (OrderLine l : inv.lines) {
            MenuItem item = inv.menu.get(l.itemId);
            sb.append(String.format("- %s x%d = %.2f\n", item.name, l.qty, item.price * l.qty));
        }
        sb.append(String.format("Subtotal: %.2f\n", inv.subtotal));
        sb.append(String.format("Tax(%.0f%%): %.2f\n", inv.taxPct, inv.tax));
        sb.append(String.format("Discount: -%.2f\n", inv.discount));
        sb.append(String.format("TOTAL: %.2f\n", inv.total));
        return sb.toString();
    }
}
