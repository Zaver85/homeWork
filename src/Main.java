import writer.FileHandler;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        GenealogyTree genealogyTree = new GenealogyTree();

        Person person1 = new Person("Сергей", LocalDate.of(1964, 9, 4), Gender.MALE);
        Person person2 = new Person("Светлана", LocalDate.of(1964, 9, 26), Gender.FEMALE);
        Person person3 = new Person("Алексей", LocalDate.of(1985, 5, 5), Gender.MALE);
        Person person4 = new Person("Никита", LocalDate.of(1993, 2, 22), Gender.MALE);
        Person person5 = new Person("Мия", LocalDate.of(2022, 6, 12), Gender.FEMALE);

        genealogyTree.addPerson(person1);
        genealogyTree.addPerson(person2);
        genealogyTree.addPerson(person3);
        genealogyTree.addPerson(person4);
        genealogyTree.addPerson(person5);

        person3.setFather(person1);
        person3.setMother(person2);
        person4.setFather(person1);
        person4.setMother(person2);
        person5.setFather(person4);

        System.out.println("Генеалогическое древо:");
        System.out.println(genealogyTree);

        genealogyTree.sortByName();
        System.out.println("\nСписок отсортированный по имени:");
        System.out.println(genealogyTree);

        genealogyTree.sortByBirthDate();
        System.out.println("\nСписок отсортированный по дате рождения:");
        System.out.println(genealogyTree);


        FileHandler fileHandler = new FileHandler();
        GenealogyTree loadedTree = readTree();
        saveTree(genealogyTree);

    }



    private static GenealogyTree readTree() {
        FileHandler fileHandler = new FileHandler();
        return(GenealogyTree) fileHandler.read();
    }

    private static void saveTree(GenealogyTree tree) {
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(tree);

    }
}