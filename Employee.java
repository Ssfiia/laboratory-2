import java.util.List;
public class Employee {
    private final String name;
    private final Department department;

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
        if (department != null) {
            department.addEmployee(this);
        }
    }

    public String getName() { return name; }
    public Department getDepartment() { return department; }

    public List<Employee> getColleagues() {
        return department == null ? List.of() : department.getEmployees();
    }

    public boolean isHeadOfDepartment() {
        return department != null && department.getHead() == this;
    }

    @Override
    public String toString() {
        if (department == null) return name + " (без отдела)";
        if (isHeadOfDepartment()) {
            return name + " начальник отдела " + department.getName();
        }
        String headName = department.getHead() != null ? department.getHead().getName() : "(не назначен)";
        return name + " работает в отделе " + department.getName() + ", начальник которого " + headName;
    }
}