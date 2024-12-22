package mapCollection;

import java.util.Map;

public class Department {
    private Long id;
    private String name;
    private Map<Long, String> employeeNames;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Long, String> getEmployeeNames() {
        return employeeNames;
    }

    public void setEmployeeNames(Map<Long, String> employeeNames) {
        this.employeeNames = employeeNames;
    }
}
