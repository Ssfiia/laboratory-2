
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Department {
    private final String name;
    private Employee head;
    private final List<Employee> employees = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public Employee getHead() { return head; }
    public void setHead(Employee head) { this.head = head; }

    public List<Employee> getEmployees() {
        return Collections.unmodifiableList(employees);
    }

    void addEmployee(Employee e) {
        if (!employees.contains(e)) employees.add(e);
    }

    @Override
    public String toString() {
        return "отдел " + name + (head != null ? ", начальник " + head.getName() : ", начальник не назначен");
    }
}
