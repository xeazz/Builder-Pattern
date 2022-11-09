

public class Main {
    public static void main(String[] args) {
        Person mother = new PersonBuilder()
                .setName("Ольга")
                .setSurname("Штрейс")
                .setAge(32)
                .setAddress("Санкт-Петербург")
                .build();
        System.out.println(mother.hasAge());
        mother.happyBirthday();
        Person child = mother.newChildBuilder()
                .setName("Павел")
                .build();
        System.out.println(mother);
        System.out.println("У " + mother.getName() + " есть сын, " + child.getName());
        try {
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}