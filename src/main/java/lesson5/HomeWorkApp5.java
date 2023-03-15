package lesson5;

public class HomeWorkApp5 {
    public static void main(String[] args) {
        Employee person_1 = new Employee("Иван", "devops", "support@mail.ru",
                "89056673022", 200000, 30);
        Employee person_2 = new Employee("Дмитрий", "architect", "support@mail.ru",
                "89056673022", 250000, 43);
        Employee person_3 = new Employee("Александр", "back-end developer", "support@mail.ru",
                "89056655022", 310000, 39);
        Employee person_4 = new Employee("Виталий", "back-end developer", "support@mail.ru",
                "89056673022", 310000, 41);
        Employee person_5 = new Employee("Вадим", "front-end developer", "support@mail.ru",
                "89056673022", 200000, 23);

        Employee[] employeesArray = {person_1, person_2, person_3, person_4, person_5};

        for (Employee person : employeesArray){
            if (person.getAge() >= 40){
                person.getInfo();
            }
        }
    }
}
