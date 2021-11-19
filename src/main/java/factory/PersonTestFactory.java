package factory;

import model.ImmutablePerson;

import static factory.PersonTestConstants.DEFAULT_AGE;
import static factory.PersonTestConstants.DEFAULT_FIRST_NAME;
import static factory.PersonTestConstants.DEFAULT_LAST_NAME;

public class PersonTestFactory {

    public static ImmutablePerson.Builder defaultBuilder() {
        return ImmutablePerson.builder()
                .firstName(DEFAULT_FIRST_NAME)
                .lastName(DEFAULT_LAST_NAME)
                .age(DEFAULT_AGE);
    }
}
