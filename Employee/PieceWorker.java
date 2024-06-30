public class PieceWorker extends Employee {

    private int piece; // amount of produce pieces
    private double salaryPerPiece;

    private final int MIN_PIECE = 0;
    private final double MIN_SALARY = 0.0;


    public PieceWorker(String firstName,String lastName,int day,int month,int year,String socialSecurityNumber,int piece,double salaryPerPiece){
        super(firstName,lastName,day,month,year,socialSecurityNumber);
        if(piece < MIN_PIECE)
            throw new IllegalArgumentException("Pieces must be >= 0");
        this.piece = piece;

        if(salaryPerPiece < MIN_SALARY)
            throw new IllegalArgumentException("Salary per piece must be >= 0.0");
        this.salaryPerPiece = salaryPerPiece;

    }

    //Sets the salary per piece
    public void setSalaryPerPiece(double salaryPerPiece){
        if(salaryPerPiece < MIN_SALARY)
            throw new IllegalArgumentException("Salary per piece must be >= 0.0");
        this.salaryPerPiece = salaryPerPiece;
    }

    //Sets amount of pieces
    public void setPiece(int piece){
        if(piece < MIN_PIECE)
            throw new IllegalArgumentException("Pieces must be >= 0");
        this.piece = piece;
    }

    //Returns the salary per piece
    public double getSalaryPerPiece(){
        return salaryPerPiece;
    }

    //Returns the amount of pieces
    public int getPiece(){
        return piece;
    }

    //Returns the earnings
    @Override
    public double earnings() {
        return getPiece() * getSalaryPerPiece();
    }

    //Return String representation of PieceWorker object
    @Override
    public String toString(){
        return String.format("%s%n%s: %d%n%s: $%,.2f",
                super.toString(),
                "Amount of Pieces Produced", getPiece(),
                "Salary Per Piece", getSalaryPerPiece());
    }

}
