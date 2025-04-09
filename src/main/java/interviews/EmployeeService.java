package interviews;

public class EmployeeService {

    private static EmployeeService employeeService;

    private EmployeeService(){}

    public EmployeeService getSingleTon() {
        EmployeeService empService = employeeService;
        if(empService == null){
            synchronized (this) {
                empService = employeeService;
                if(empService == null){
                    employeeService = new EmployeeService();
                    empService = employeeService;
                }
            }
        }
        return empService;
    }

    public static void main(String[] args) {

        EmployeeService e = new EmployeeService();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                ///
            }
        });

    }

}
