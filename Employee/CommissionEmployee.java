
public class CommissionEmployee extends Employee{
    private double grossSales;//gross weekly sales
    private double commissionRate;//commission percentage

    private final double MIN_RATE = 0.0;

    private final double MAX_RATE = 1.0;

    //Constructor
    public CommissionEmployee(String firstName, String lastName, int day, int month, int year, String socialSecurityNumber, double grossSales, double commissionRate) {
        super(firstName, lastName,day,month,year ,socialSecurityNumber);

        if (commissionRate <= MIN_RATE || commissionRate >= MAX_RATE) {//validate
            throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
        }
        if (grossSales < MIN_RATE) {//validate
            throw new IllegalArgumentException("Gross sales must be >= 0.0");
        }

        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
    }

    //Sets gross sales amount
    public void setGrossSales(double grossSales){
        if (grossSales < MIN_RATE) {//validate
            throw new IllegalArgumentException("Gross sales must be >= 0.0");
        }
        this.grossSales = grossSales;
    }

    //Sets Commission rate
    public void setCommissionRate(double commissionRate) {
        if (commissionRate <= MIN_RATE || commissionRate >= MAX_RATE) {//validate
            throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
        }
        this.commissionRate = commissionRate;
    }

    //Returns commission rate
    public double getCommissionRate(){
        return commissionRate;
    }

    //Returns gross sales amount
    public double getGrossSales(){
        return grossSales;
    }

    //Calculate earnings ; override abstract method earnings in Employee
    @Override
    public double earnings(){
        return getCommissionRate() * getGrossSales();
    }

    //Return string representation of CommissionEmployee object
    @Override
    public String toString() {
        return String.format("%s: %s%n%s: $%,.2f; %s: %.2f",
                            "Commission Employee", super.toString(),
                            "Gross Sales", getGrossSales(),
                            "Commission Rate", getCommissionRate());
    }
    }


