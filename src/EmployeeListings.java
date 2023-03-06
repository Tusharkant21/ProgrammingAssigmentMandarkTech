import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Employee{
   public String firstName;
   public String lastName;

   public String role;
   public String division;

    public Employee() {
    }

    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }
}

public class EmployeeListings {
    public static void main(String[] args){
        // function to change csv file to object of employees(read csv file);
        // passing parameter is "address local address of csv file";
         List<Employee> employeeList = readCsvFile("src/csv/employee.csv");
         //Entries in manager.csv filegit-
         System.out.println("Entries in manager.csv file -");
         for(Employee employee:employeeList){

             String rol = employee.getRole();
             String div = employee.getDivision();
             String r= "Manager";
             String d = "R&D";
             
             if(rol.equals(r) && div.equals(d)) {
            	 System.out.print(employee.getFirstName()+", ");
                 if(employee.getLastName()!=null){
                     System.out.print(employee.getLastName()+", ");
                 }
                 System.out.println(employee.getRole()+", "+employee.getDivision());
             }
            
             
             

         }
         System.out.println();
         // Entries in single_name_employees.csv file-
            System.out.println("Entries in single_name_employees.csv file-");
         for(Employee employee:employeeList){
             if(employee.lastName==null){
                 System.out.println(employee.getFirstName()+", "+employee.getRole()+", "+employee.getDivision());

             }

         }
    }

  public static  List<Employee> readCsvFile(String fileLocation){
       // list of employee
      List<Employee> employeeList=new ArrayList<>();
      try{
          //get file from location
          File csvFile = new File(fileLocation);

          // read csv file
          BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFile));

          String line;
          int count =0;
          // loop to through all the object of employee
          while((line=bufferedReader.readLine()) !=null){
              if(count==0){
                  count++;
                  continue;
              }
              Employee employee = new Employee();
              String[] data = line.split(",");
              String name = data[0];
              StringTokenizer st = new StringTokenizer(name," ");
              int tokens = st.countTokens();
              if(tokens==2){
                      employee.setFirstName(st.nextToken());
                      employee.setLastName(st.nextToken());
              }
              else {
                  employee.setFirstName(st.nextToken());
              }
            employee.setRole(data[1]);
            employee.setDivision(data[2]);

            employeeList.add(employee);
            count++;

          }

      }
      catch (IOException exception){
          System.out.println("exception "+exception);

      }
      // return list of employee after getting details from csv file;
      return employeeList;
  }


}
