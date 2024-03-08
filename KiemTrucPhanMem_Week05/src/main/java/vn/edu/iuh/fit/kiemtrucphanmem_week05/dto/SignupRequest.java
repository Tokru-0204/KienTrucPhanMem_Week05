package vn.edu.iuh.fit.kiemtrucphanmem_week05.dto;

public class SignupRequest {
    private String username;
    private String password;
    private String fullName;
    private int age;
    private String address;
    private long salary;

    public SignupRequest() {
    }

    public SignupRequest(String username, String password, String fullName, int age, String address, long salary) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.age = age;
        this.address = address;
        this.salary = salary;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
}
