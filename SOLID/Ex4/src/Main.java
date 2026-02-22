import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Hostel Fee Calculator ===");

        BookingRequest req = new BookingRequest(LegacyRoomTypes.DOUBLE, List.of(AddOn.LAUNDRY, AddOn.MESS));

        HostelFeeCalculator calc = new HostelFeeCalculator(new FakeBookingRepo());
        calc.process(req, buildComponents(req));
    }

    private static List<PricingComponent> buildComponents(BookingRequest req) {
        List<PricingComponent> list = new ArrayList<>();
        list.add(roomPricer(req.roomType));
        for (AddOn a : req.addOns) list.add(addOnPricer(a));
        return list;
    }

    private static PricingComponent roomPricer(int roomType) {
        return switch (roomType) {
            case LegacyRoomTypes.SINGLE -> new SingleRoomPricer();
            case LegacyRoomTypes.DOUBLE -> new DoubleRoomPricer();
            case LegacyRoomTypes.TRIPLE -> new TripleRoomPricer();
            default -> new DeluxeRoomPricer();
        };
    }

    private static PricingComponent addOnPricer(AddOn a) {
        return switch (a) {
            case MESS    -> new MessPricer();
            case LAUNDRY -> new LaundryPricer();
            case GYM     -> new GymPricer();
        };
    }
}
