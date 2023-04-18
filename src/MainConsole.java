import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class MainConsole {
    ArrayList<Employee> empList;
    ArrayList<Employee> masikList;

    public MainConsole() throws FileNotFoundException {
        empList = new ArrayList<>();
        masikList = new ArrayList<>();
        beolvas();
        feladat02();
        feladat03();
    }

    public void beolvas() throws FileNotFoundException {

        File file = new File("dolgozok.csv");
        Scanner sc = new Scanner(file, "utf-8");   
        String firstLine = sc.nextLine();
     

      
        
        while(sc.hasNext()) {
            String line = sc.nextLine();
            // System.out.println(line);
            String[] lineArray = line.split(",");

            Employee emp =  new Employee( 
                Integer.parseInt(lineArray[0]),
                lineArray[1],
                lineArray[2],
                Double.parseDouble(lineArray[3]),
                LocalDate.parse(lineArray[4])
            );

            empList.add(emp);
        }  
    }

    public void feladat02(){
        System.out.println("Feladat 2");

        for(Employee emp : this.empList){
             //System.out.println(emp.name);
            if(emp.birth.getYear()< 2001){
                this.masikList.add(emp);
                System.out.println(emp.name);

            }
          

        }
      
        
    }

    public void feladat03() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter("koraiak.csv");
      


        for(Employee emp : this.masikList){
            pw.append(emp.id.toString());
            pw.append(" , ");
            pw.append(emp.name);
            pw.append(" , ");
            pw.append(emp.city);
            pw.append(" , ");
            pw.append(emp.salary.toString());
            pw.append(" , ");
            pw.append(emp.birth.toString());
            pw.append("\n");
        }
        pw.close();
    }
    
}
