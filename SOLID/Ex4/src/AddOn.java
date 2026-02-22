interface PricingComponent {
    double monthlyAmount();
    double depositAmount();
}

class SingleRoomPricer implements PricingComponent {
    public double monthlyAmount() { return 14000.0; }
    public double depositAmount() { return 5000.0; }
}

class DoubleRoomPricer implements PricingComponent {
    public double monthlyAmount() { return 15000.0; }
    public double depositAmount() { return 5000.0; }
}

class TripleRoomPricer implements PricingComponent {
    public double monthlyAmount() { return 12000.0; }
    public double depositAmount() { return 5000.0; }
}

class DeluxeRoomPricer implements PricingComponent {
    public double monthlyAmount() { return 16000.0; }
    public double depositAmount() { return 5000.0; }
}

class MessPricer implements PricingComponent {
    public double monthlyAmount() { return 1000.0; }
    public double depositAmount() { return 0.0; }
}

class LaundryPricer implements PricingComponent {
    public double monthlyAmount() { return 500.0; }
    public double depositAmount() { return 0.0; }
}

class GymPricer implements PricingComponent {
    public double monthlyAmount() { return 300.0; }
    public double depositAmount() { return 0.0; }
}

public enum AddOn {
    MESS, LAUNDRY, GYM
}
