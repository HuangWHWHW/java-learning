import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class LambdaDemo {
    public static void main(String[] args) {
        // 测试通用Lambda方法
        List<Employee> employees = new ArrayList<Employee>() {{
            add(new Employee("John", 10.0));
            add(new Employee("Michael", 34.0));
            add(new Employee("Lily", 84.7));
            add(new Employee("Sam", 5.2));
            add(new Employee("Rose", 30.0));
        }};

        // use Function
        System.out.println("-----use Function-----");
        getNames(s -> s.getName(), employees).forEach(System.out::println);

        // use forEach
        System.out.println("-----use forEach-----");
        employees.forEach(e -> System.out.println(e.getName()));
    }

    private static List<String> getNames(Function<Employee, String> f, List<Employee> employees) {
        List<String> names = new ArrayList<>();
        employees.forEach(e -> names.add(f.apply(e)));
        return names;
    }
}

class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }
}
