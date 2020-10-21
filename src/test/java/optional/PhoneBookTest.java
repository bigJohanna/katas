package optional;

import org.junit.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneBookTest {

    private final PhoneBook phoneBook = new PhoneBook();

    @Test
    public void findPhoneNumberByName() {
        Optional<String> phoneNumber = phoneBook.findPhoneNumberByName("Jos de Vos");
        assertThat(phoneNumber.isPresent()).isTrue();
        assertThat(phoneNumber.get()).isEqualTo("016/161616");
    }

    @Test
    public void findPhoneNumberByName_NotFound() {
        Optional<String> phoneNumber = phoneBook.findPhoneNumberByName("Jos de Voss");
        assertThat(phoneNumber.isEmpty()).isTrue();
    }

    @Test
    public void findNameByPhoneNumber() {
        Optional<String> name = phoneBook.findNameByPhoneNumber("016/161616");
        assertThat(name.isPresent()).isTrue();
        assertThat(name.get()).isEqualTo("Jos de Vos");
    }

    @Test
    public void findNameByPhoneNumber_NotFound() {
        Optional<String> phoneNumber = phoneBook.findPhoneNumberByName("016/161619");
        assertThat(phoneNumber.isEmpty()).isTrue();
    }

}