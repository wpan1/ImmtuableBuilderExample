package model;

import org.immutables.value.Value;

import java.util.List;

@Value.Immutable
public interface Person {

    String getFirstName();

    String getLastName();

    int getAge();

    @Value.Default
    default List<Person> getSiblings() {
        return List.of();
    }
}
