// The composite pattern is meant to allow treating individual objects and compositions of objects, or “composites” in the same way. 

// base component
public interface Department {
    void printDepartmentName();
}

// leaf components

public class FinancialDepartment implements Department {

    private Integer id;
    private String name;

    public void printDepartmentName() {
        System.out.println(getClass().getSimpleName());
    }

    //constructor, getters, setters..
}

public class SalesDepartment implements Department {

    private Integer id;
    private String name;

    public void printDepartmentName() {
        System.out.println(getClass().getSimpleName());
    }
}

// composite class

public class HeadDepartment implements Department {

    private Integer id;
    private String name;]
    private List<Department> childDepartments;

    public HeadDepartment(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.childDepartments = new ArrayList<>();
    }

    public void printDepartmentName() {
        childDepartments.forEach(Department::printDepartmentName);
    }

    public void addDepartment(Department department) {
        childDepartments.add(department);
    }

    public void removeDepartment(Department department) {
        childDepartments.remove(department);
    }
}

// demo

public class CompositeDemo {

    public static void main(String args[]) {
        Department salesDepartment = new SalesDepartment(1, "Sales department");
        Department financialDepartment = new FinancialDepartment(2, "Financial department");
 
        HeadDepartment headDepartment = new HeadDepartment(3, "Head department");
 
        headDepartment.addDepartment(salesDepartment);
        headDepartment.addDepartment(financialDepartment);
 
        headDepartment.printDepartmentName();
    }
}

// More information - https://www.baeldung.com/java-composite-pattern