import java.util.Calendar;
import java.util.GregorianCalendar;


//Employee abstract superclass
public abstract class Employee {

    private final String firstName;
    private final String lastName;
    private final String socialSecurityNumber;
    private final Calendar birthDay;
    private final int JAN = 1;
    private final int DEC = 12;
    private final int FIRST_DAY = 1;

    //Constructor
    public Employee(String firstName, String lastName, int day,int month,int year ,String socialSecurityNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
        // Validate the date before setting it
        try {
            this.birthDay = new GregorianCalendar(year, month - 1, day); // Calendar months are zero-based
            if (!isValidDate(day, month, year)) {
                throw new IllegalArgumentException("Invalid Date of Birth");
            }
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }




    //Returns first name
    public String getFirstName() {
        return firstName;
    }

    //Returns last name
    public String getLastName() {
        return lastName;
    }

    //Returns social security number
    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    //Returns the birthday
    public Calendar getBirthDay() {
        return birthDay;
    }


    // Checks if the date is valid
    private boolean isValidDate(int day, int month, int year) {
        if (month < JAN || month > DEC || day < FIRST_DAY || day > daysInMonth(month, year)) {
            return false;
        }
        return true;
    }

    // Returns how many days there are in some month.
    private int daysInMonth(int month, int year) {
        Calendar partialDate = new GregorianCalendar(year, month - 1, FIRST_DAY); // Calendar months are zero-based
        return partialDate.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    //Returns string representation of employee object
    @Override
    public String toString() {
        return String.format("%nName: %s %s%nDate Of Birth: %d-%02d-%02d%nSocial Security Number: %s",
                getFirstName(), getLastName(),
                birthDay.get(Calendar.DAY_OF_MONTH), birthDay.get(Calendar.MONTH) + 1,birthDay.get(Calendar.YEAR) ,
                getSocialSecurityNumber());
    }

    //Abstract method must be overridden by concrete subclasses
    public abstract double earnings();//No implement currently

}
