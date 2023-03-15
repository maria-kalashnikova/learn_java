package lesson5;

public class Employee {
    private String fullName;
    private String jobTitle;
    private String eMail;
    private String phoneNumber;
    private int salary;
    private int age;

    private void setFullName(String fullName) {
        this.fullName = fullName;
    }

    protected void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    protected void seteMail(String eMail) {
        this.eMail = eMail;
    }

    protected void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    protected void setSalary(int salary) {
        this.salary = salary;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public Employee(String fullName, String jobTitle, String eMail, String phoneNumber, int salary, int age){
        setFullName(fullName);
        setJobTitle(jobTitle);
        seteMail(eMail);
        setPhoneNumber(phoneNumber);
        setSalary(salary);
        setAge(age);
    }

    public void getInfo(){
        System.out.println(String.format("Сотрудлник: %s", fullName));
        System.out.println(String.format("Должность: %s", jobTitle));
        System.out.println(String.format("E-mail: %s", eMail));
        System.out.println(String.format("Тел: %s", phoneNumber));
        System.out.println(String.format("Зарплата: %s", salary));
        System.out.println(String.format("Возраст: %s", age));
    }

}
