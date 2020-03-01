package weekend1_IO;

import lombok.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * ...comment class...
 *
 * @author dagmarakitkowska@gmail.com
 * @since 16.02.2020
 */
@AllArgsConstructor
@Data
@Builder
@ToString
class Person implements Serializable {
    private String name;
    private String secondName;
    private int age;
    private String pesel;
    private transient Address address;
}

final class Zad14_PersonSerializacja implements Serializable {
    public static void main(String[] args) {

        Person person = Person.builder()
                .name("Adam")
                .secondName("Jan")
                .age(28)
                .pesel("24829820")
                .address(Address.builder().street("Bakalarska").zipCode("ZN27234").build())
                .build();

        try (OutputStream outputStream = Files.newOutputStream(Paths.get("Person2.ser"));
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        ) {
            objectOutputStream.writeObject(person);
            objectOutputStream.writeObject(person.getAddress().getStreet());
            objectOutputStream.writeObject(person.getAddress().getZipCode());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class read {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        read();
    }

    public static Person read() throws IOException, ClassNotFoundException {
        try (InputStream inputStream = Files.newInputStream(Paths.get("Person2.ser"));
             ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        ) {
            Person o = (Person) objectInputStream.readObject();
            String street = (String)objectInputStream.readObject();
            String zpiCode = (String)objectInputStream.readObject();
            return o;
        } catch (IOException | ClassNotFoundException e) {
            throw e;
        }
    }
}

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
class Address {
    private String street;
    private String zipCode;
}



