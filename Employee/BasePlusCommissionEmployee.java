
public class BasePlusCommissionEmployee extends CommissionEmployee {
    private double baseSalary;//Base salary per week
    private final double MIN_BASE = 0.0;

    //Constructor
    public BasePlusCommissionEmployee(String firstName, String lastName, int day,int month,int year, String socialSecurityNumber, double grossSales, double commissionRate, double baseSalary)  {
        super(firstName,lastName,day,month,year,socialSecurityNumber,grossSales,commissionRate);

        if(baseSalary < MIN_BASE) {//validate
            throw new IllegalArgumentException("Base Salary must be >= 0.0");
        }
        this.baseSalary = baseSalary;
    }

    //Sets base salary
    public void setBaseSalary(double baseSalary){
        if(baseSalary < MIN_BASE) {//validate
            throw new IllegalArgumentException("Base Salary must be >= 0.0");
        }
        this.baseSalary = baseSalary;
    }

    //Returns base salary
    public double getBaseSalary(){
        return baseSalary;
    }

    //Calculate earnings ; override method earnings in CommissionEmployee
    @Override
    public double earnings(){
        return getBaseSalary() + super.earnings();
    }

    //Return String representation of BasePlusCommissionEmployee object
    @Override
    public String toString(){
        return String.format("%s %s; %s: $%,.2f",
                            "Base-salaried",super.toString(),
                            "Base salary",getBaseSalary());

    }
}
