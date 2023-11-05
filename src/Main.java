import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Kateryna", 40, "Female", 30000,
                "Study", LocalDate.of(1982,11,28), "Australia"));
        people.add(new Person("Yura", 48, "Male",100000,
                "Work",LocalDate.of(1975,9,14), "USA"));
        people.add(new Person("Sofi", 11, "Female", 20000,
                "Study", LocalDate.of(2012,4,3), "Ukraine"));
        people.add(new Person("Andre", 35, "Male", 4000,
                "Work", LocalDate.of(1960,1,7), "Greece"));

        List<Person> result = Person.getPersonList(people);
        for (Person person : result) {

            System.out.println(" Person list : " + person.getName() + " " + person.getAge() + " years old");

        }

        List<Person> gender = Person.getGender(people);
        for (Person person : gender) {
            System.out.println(person.getName() + " " + person.getAge());
        }

        List<Person> salary = Person.getSalary(people);
        for (Person person : salary){
            System.out.println(person.getName() + " " + person.getSalary());
        }
        List<Person> birthday = Person.getBirthday(people);
        for (Person person : birthday){
            System.out.println(person.getName() + " " + person.getBirthday());
        }
        Map<String, List<Person>> peopleGroupByCountry = Person.groupPeopleByCountry(people);
        for (Map.Entry<String, List<Person>> entry : peopleGroupByCountry.entrySet()){
            String country = entry.getKey();
            List<Person> peopleInCountry = entry.getValue();
            System.out.println(country + " " + peopleInCountry.size());
        }
    }
}