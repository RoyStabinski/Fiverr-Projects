
public class HourlyEmployee extends Employee {
    private double wage; // wage per hour
    private double hours; // hours worked for week
    private final double MIN_WAGE = 0.0;
    private final double MIN_HOURS = 0.0;
    private final double MAX_HOURS = 168.0;
    private final int IN_TIME_HOURS = 40;

    //Constructor
    public HourlyEmployee(String firstName, String lastName, int day,int month,int year, String socialSecurityNumber, double wage, double hours) {
        super(firstName, lastName, day,month,year,socialSecurityNumber);

        if (wage < MIN_WAGE) {//validate wage
            throw new IllegalArgumentException("Hourly wage must be >= 0.0");
        }
        if (hours < MIN_HOURS || hours > MAX_HOURS) {//validate hours
            throw new IllegalArgumentException("Hours worked must be >= 0.0 and <= 168.0");
        }
        this.wage = wage;
        this.hours = hours;
    }

    //Set wage
    public void setWage(double wage) {
        if (wage < MIN_WAGE) {//validate wage
            throw new IllegalArgumentException("Hourly wage must be >= 0.0");
        }
        this.wage = wage;
    }

    //Set Hours
    public void setHours(double hours){
        if (hours < MIN_HOURS || hours > MAX_HOURS) {//validate hours
            throw new IllegalArgumentException("Hours worked must be >= 0.0 and <= 168.0");
        }
        this.hours = hours;
    }

    //Returns wage
    public double getWage(){
        return wage;
    }

    //Returns hours
    public double getHours(){
        return hours;
    }

    //Calculate earnings ; override abstract method earnings in Employee
    @Override
    public double earnings() {
        if (getHours() <= IN_TIME_HOURS) {//No overtime
            return getHours() * getWage();
        } else {
            return IN_TIME_HOURS * getWage() + (getHours() - IN_TIME_HOURS) * getWage() * 1.5;
        }
    }

    //Return string representation of HourlyEmployee object
    @Override
    public String toString(){
        return String.format("Hourly Employee: %s%n%s: $%,.2f; %s: %,.2f",super.toString(),
                            "Hourly Wage",getWage(),
                            "Hours Worked",getHours());
    }
}

