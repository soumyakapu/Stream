package Stream;

import Stream.entity.Employee;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
   static List<Employee> employees=new LinkedList<>();
    static {
        employees.add(new Employee("sonu","sonu@gmail.com",List.of("employee","admin"),16000.0));
        employees.add(new Employee("radha","radha@gmail.com",List.of("employee"),15000.0));
        employees.add(new Employee("ambica","ambica@gmail.com",List.of("employee"),10000.0));
        employees.add(new Employee("swarupa","swarup@gmail.com",List.of("employee"),10000.0));
        employees.add(new Employee("Geeta","geeta@gmail.com",List.of("Hr"),10000.0));

    }


    public static void main(String[] args) {
        //using foreach
       employees.stream().forEach((employees)-> System.out.println(employees));
       //map
       List<Employee> increasedSalary= employees.stream().map(
                employee -> new Employee(
                        employee.getName(),
                        employee.getEmail(),
                        employee.getRole(),
                        employee.getSalary()*1.10
                )
        ).collect(Collectors.toList());
        System.out.println(increasedSalary);
        //filter with map
        List<Employee> filterdEmployee=employees.stream().filter(employee ->employee.getSalary()>14000.0).map(
                employee -> new Employee(
                        employee.getEmail(),
                        employee.getName(),
                        employee.getRole(),
                        employee.getSalary()*1.10
                )
        ).collect(Collectors.toList());
        System.out.println(filterdEmployee);
        //filter Map Collect size
      int setEmployee= employees.stream().map(
                employee -> new Employee(
                        employee.getEmail(),
                        employee.getName(),
                        employee.getRole(),
                        employee.getSalary()*1.10
                )
        ).filter(employee -> employee.getSalary()>14000.0)
                .collect(Collectors.toSet())
              .size() ;
        System.out.println(setEmployee);
        //for findFirst
        Employee findEmployee=employees.stream().filter(employee ->employee.getSalary()>15000.0).map(
                employee -> new Employee(
                        employee.getEmail(),
                        employee.getName(),
                        employee.getRole(),
                        employee.getSalary()*1.10
                )
        ).findFirst()
                .orElse(null);
        System.out.println(findEmployee);
        //flatMap
       String roles= employees.stream().map(employee -> employee.getRole())
                .flatMap(String->String.stream())
                .collect(Collectors.joining(","));
        System.out.println(roles);
        //limit
       List<Employee> skipedEmployee= employees.stream().skip(1).limit(2).collect(Collectors.toList());
        System.out.println(skipedEmployee);
        //sorted
      Set<Employee> sortedEmployee=  employees.stream().sorted((o1,o2)->o1.getEmail().compareToIgnoreCase(o2.getEmail())).collect(Collectors.toSet());
        System.out.println(sortedEmployee);
    }
}