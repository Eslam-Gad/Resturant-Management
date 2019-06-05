package resturant;

public class Emp {

    private final String ID;
    private final String name_emp;
    private final int salary;
    private final String job;
    private final String address;
    

    public Emp(String ID, String name_emp, int salary, String job , String address) {
        this.ID = ID;
        this.name_emp = name_emp;
        this.salary = salary;
        this.job = job;
        this.address = address;
    }

    public String getID() {
        return ID;
    }

    public String getName_emp() {
        return name_emp;
    }

    public int getSalary() {
        return salary;
    }

    public String getJob() {
        return job;
    }
     public String getAddress() {
        return address;
    }

}
