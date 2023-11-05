import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Person {
    String name;
    int age;
    String gender;
    double salary;
    String status;
    LocalDate birthday;
    String groupPeopleByCountry;

    public static List<Person> getPersonList(List<Person> people) {
        return people.stream()
                .filter(person -> person.getName().startsWith("A") && person.getAge() > 30)
                .collect(Collectors.toList());
    }

    public static List<Person> getGender(List<Person> people) {
        return people.stream()
                .filter(person -> person.getGender().equals("Male") && person.getAge() >= 25 && person.getAge() <= 50)
                .collect(Collectors.toList());
    }

    public static List<Person> getSalary(List<Person> people) {
        return people.stream()
                .filter(person -> person.getStatus().equals("Work") && person.getSalary() > 5000)
                .collect(Collectors.toList());
    }

    public static List<Person> getBirthday(List<Person> people) {
        LocalDate currentDate = LocalDate.now();
        int currentMonth = currentDate.getMonthValue();
        return people.stream()
                .filter(person -> {
                    LocalDate birthDate = person.getBirthday();
                    return birthDate.getMonthValue() == currentMonth;
                })
                .collect(Collectors.toList());
    }

    public static Map<String, List<Person>> groupPeopleByCountry(List<Person> people) {
        return people.stream()
                .collect(Collectors.groupingBy(Person::getCountry));
    }

    public Person(String name, int age, String gender, double salary, String status,
                  LocalDate birthday, String groupPeopleByCountry) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
        this.status = status;
        this.birthday = birthday;
        this.groupPeopleByCountry = groupPeopleByCountry;
    }

    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }

    public String getCountry() {
        return groupPeopleByCountry;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getStatus() {
        return status;
    }

    public double getSalary() {
        return salary;
    }

    public String getGender() {
        return gender;
    }

}
