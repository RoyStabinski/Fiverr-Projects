
public class SalariedEmployee extends Employee {
    private double weeklySalary;
    private final double MIN_SALARY = 0.0;

    //Constructor
    public SalariedEmployee(String firstName, String lastName, int day,int month,int year , String socialSecurityNumber, double weeklySalary) {
        super(firstName, lastName, day,month,year ,socialSecurityNumber);

        if (weeklySalary < MIN_SALARY) {
            throw new IllegalArgumentException("Weekly Salary Must Be >= 0.0");
        }

        this.weeklySalary = weeklySalary;
    }

    //Set Salary
    public void setWeeklySalary(double weeklySalary)  {
        if (weeklySalary < MIN_SALARY) {
            throw new IllegalArgumentException("Weekly Salary Must Be >= 0.0");
        }

        this.weeklySalary = weeklySalary;
    }

    //Return salary
    public double getWeeklySalary() {
        return weeklySalary;
    }

    //Calculate earnings ; override method earnings in Employee
    @Override
    public double earnings() {
        return getWeeklySalary();
    }

    //Return string representation of SalariedEmployee object
    @Override
    public String toString() {
        return String.format("Salaried Employee: %s%n%s: $%,.2f", super.toString(),
                            "Weekly Salary", getWeeklySalary());
    }
}

