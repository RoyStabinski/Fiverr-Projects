
import java.util.Calendar;

public class Main {
    public static void main(String[] args){
        //Create Employee array
        Employee[] employees = new Employee[5];

        //Create objects
        SalariedEmployee salariedEmployee = new SalariedEmployee("Roy", "Stabinski", 16,4,1997, "0001", 80000.0);
        HourlyEmployee hourlyEmployee = new HourlyEmployee("John", "Smith", 11,2,1989, "0439", 16.75, 40);
        CommissionEmployee commissionEmployee = new CommissionEmployee("Sue", "Jones", 20,11,1972, "7341", 10000, .06);
        BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("Bob", "Lewis", 1,11,1964, "9117", 5000, .04, 300);
        PieceWorker pieceWorker = new PieceWorker("Jack","Johnson",14,5,1948,"0001",76,859.3);

        //Initialize array with employees
        employees[0] = salariedEmployee;
        employees[1] = hourlyEmployee;
        employees[2] = commissionEmployee;
        employees[3] = basePlusCommissionEmployee;
        employees[4] = pieceWorker;

        System.out.printf("Employees processed polymorphic:%n%n");

        //Processing each element in array employees
        for (Employee currentEmployee : employees) {
            // Get the current month
            Calendar currentDate = Calendar.getInstance();
            int currentMonth = currentDate.get(Calendar.MONTH) + 1;

            System.out.println(currentEmployee);

            if(currentEmployee.getBirthDay().get(Calendar.MONTH) + 1 == currentMonth)
            System.out.printf("Earned $%,.2f%nEmployee Got A BirthDay Bonus Of 200$%n%n", currentEmployee.earnings()+200);
            else
                System.out.printf("Earned $%,.2f%n%n", currentEmployee.earnings());
        }
    }
}


