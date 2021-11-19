import factory.PersonTestFactory;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonTest {

    @Test
    public void shouldBuildDefaultPerson() {
        final var person = PersonTestFactory.defaultBuilder()
                .build();

        assertThat(person).satisfies(it -> {
            assertThat(it.getFirstName()).isEqualTo("William");
            assertThat(it.getLastName()).isEqualTo("Pan");
            assertThat(it.getAge()).isEqualTo(25);
            assertThat(it.getSiblings()).isEmpty();
        });
    }

    @Test
    public void shouldBuildOverridingFirstNamePerson() {
        final var person = PersonTestFactory.defaultBuilder()
                .firstName("David")
                .build();

        assertThat(person).satisfies(it -> {
            assertThat(it.getFirstName()).isEqualTo("David");
            assertThat(it.getLastName()).isEqualTo("Pan");
            assertThat(it.getAge()).isEqualTo(25);
            assertThat(it.getSiblings()).isEmpty();
        });
    }

    @Test
    public void shouldBuildSiblingsPerson() {
        final var person = PersonTestFactory.defaultBuilder()
                .addSiblings(
                        PersonTestFactory.defaultBuilder()
                                .firstName("Carl")
                                .age(20)
                                .build(),
                        PersonTestFactory.defaultBuilder()
                                .firstName("Josh")
                                .age(22)
                                .build()
                )
                .build();

        assertThat(person).satisfies(it -> {
            assertThat(it.getFirstName()).isEqualTo("David");
            assertThat(it.getLastName()).isEqualTo("Pan");
            assertThat(it.getAge()).isEqualTo(25);
            assertThat(it.getSiblings()).hasSize(2);
        });
    }
}
