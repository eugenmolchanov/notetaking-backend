package com.notetakingplus.law.mobile.repository;

import com.notetakingplus.law.common.entity.User;
import com.notetakingplus.law.common.repository.UserRepository;
import com.notetakingplus.law.mobile.config.TestJpaPersistenceConfig;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest(properties = {"spring.main.allow-bean-definition-overriding=true"})
@Import({TestJpaPersistenceConfig.class})
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void getByEmailAddressAndPasswordTest() {
        Optional<User> optionalUser = userRepository.findByEmailAddress("yauhenmalchanau@gmail.com");

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(optionalUser).isPresent();
            User user = optionalUser.get();
            softly.assertThat(user).isNotNull();
            softly.assertThat(user.getEmailAddress()).isEqualTo("yauhenmalchanau@gmail.com");
            softly.assertThat(user.getFirstName()).isEqualTo("Yauhen");
            softly.assertThat(user.getLastName()).isEqualTo("Malchanau");
            softly.assertThat(user.getRole().getName()).isEqualTo("User");
        });
    }

    @Test
    public void getEmptyOptionalByEmailAddressAndPasswordTest() {
        Optional<User> optionalUser = userRepository.findByEmailAddress("someemail@gmail.com");

        assertThat(optionalUser).isNotPresent();
    }
}
