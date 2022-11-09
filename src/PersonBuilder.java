public class PersonBuilder {
    private String name;
    private String surname;
    private int age = -1;
    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0 || age > 100) {
            throw new IllegalArgumentException("Некорректный возраст");
        } else {
            this.age = age;
            return this;
        }
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null || surname == null) {
            throw new IllegalStateException("Необходимо указать фамилию или имя");
        } else {
            Person person;
            if (this.age != -1) {
                person = new Person(this.name, this.surname, this.age);
                person.address = this.address;
            } else {
                person = new Person(this.name, this.surname);
                person.address = this.address;
            }
            return person;
        }
    }
}
