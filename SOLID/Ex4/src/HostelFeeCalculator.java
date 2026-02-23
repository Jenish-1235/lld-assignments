import java.util.Random;

public class HostelFeeCalculator {
    private final RoomPricer roomPricer;
    private final AddOnPricer addOnPricer;
    private final BookingRepo repo;

    public HostelFeeCalculator(RoomPricer roomPricer, AddOnPricer addOnPricer, BookingRepo repo) {
        this.roomPricer = roomPricer;
        this.addOnPricer = addOnPricer;
        this.repo = repo;
    }

    public void process(BookingRequest req) {
        Money monthly = roomPricer.baseMonthly(req.roomType);
        for (AddOn a : req.addOns) {
            monthly = monthly.plus(addOnPricer.price(a));
        }
        Money deposit = new Money(5000.00);

        ReceiptPrinter.print(req, monthly, deposit);

        String bookingId = "H-" + (7000 + new Random(1).nextInt(1000));
        repo.save(bookingId, req, monthly, deposit);
    }
}
