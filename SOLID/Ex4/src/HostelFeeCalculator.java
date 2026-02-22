import java.util.*;

public class HostelFeeCalculator {
    private final BookingRepo repo;

    public HostelFeeCalculator(BookingRepo repo) { this.repo = repo; }

    public void process(BookingRequest req, List<PricingComponent> components) {
        double monthly = 0.0;
        double deposit = 0.0;
        for (PricingComponent c : components) {
            monthly += c.monthlyAmount();
            deposit += c.depositAmount();
        }

        Money monthlyMoney = new Money(monthly);
        Money depositMoney = new Money(deposit);

        ReceiptPrinter.print(req, monthlyMoney, depositMoney);

        String bookingId = "H-" + (7000 + new Random(1).nextInt(1000));
        repo.save(bookingId, req, monthlyMoney, depositMoney);
    }
}
