package exceptions;

public class EmployeeIsNotHeadException extends Exception{
    public EmployeeIsNotHeadException() {
        super("Employee Is Not A Manager ....! ");
    }
}
