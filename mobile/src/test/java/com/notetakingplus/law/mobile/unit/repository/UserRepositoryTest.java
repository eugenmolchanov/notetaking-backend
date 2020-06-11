package com.notetakingplus.law.mobile.unit.repository;

import com.notetakingplus.law.common.entity.Role;
import com.notetakingplus.law.common.entity.User;
import com.notetakingplus.law.common.repository.UserRepository;
import com.notetakingplus.law.mobile.config.TestJpaPersistenceConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

@RunWith(SpringRunner.class)
@DataJpaTest(properties = {"spring.main.allow-bean-definition-overriding=true"})
@Import({TestJpaPersistenceConfig.class})
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void getByEmailAddressAndPasswordTest() {
        Optional<User> optionalUser = userRepository.findByEmailAddress("yauhenmalchanau@gmail.com");

        assertSoftly(softly -> {
            softly.assertThat(optionalUser).isPresent();
            User user = optionalUser.get();
            softly.assertThat(user).isNotNull();
            softly.assertThat(user.getEmailAddress()).isEqualTo("yauhenmalchanau@gmail.com");
            softly.assertThat(user.getFirstName()).isEqualTo("Yauhen");
            softly.assertThat(user.getLastName()).isEqualTo("Malchanau");
            softly.assertThat(user.getRole()).isEqualTo(Role.USER);
        });
    }

    @Test
    public void getEmptyOptionalByEmailAddressAndPasswordTest() {
        Optional<User> optionalUser = userRepository.findByEmailAddress("someemail@gmail.com");

        assertThat(optionalUser).isNotPresent();
    }

    @Test
    public void saveUserTest() {
        User user = new User();
        user.setFirstName("foo");
        user.setLastName("bar");
        user.setEmailAddress("foo@gmail.com");
        user.setPassword("password");
        user.setRole(Role.USER);

        User savedUser = userRepository.save(user);
        testEntityManager.flush();
        testEntityManager.clear();

        Optional<User> userOptional = userRepository.findById(savedUser.getId());

        assertSoftly(softly -> {
            softly.assertThat(userOptional).isPresent();

            User foundUser = userOptional.get();
            softly.assertThat(foundUser.getId()).isNotNull();
            softly.assertThat(foundUser.getFirstName()).isEqualTo(user.getFirstName());
            softly.assertThat(foundUser.getLastName()).isEqualTo(user.getLastName());
            softly.assertThat(foundUser.getPassword()).isEqualTo(user.getPassword());
            softly.assertThat(foundUser.getRole()).isEqualTo(Role.USER);
        });
    }
}
