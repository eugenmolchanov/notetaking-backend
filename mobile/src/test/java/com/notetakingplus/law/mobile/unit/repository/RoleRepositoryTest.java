package com.notetakingplus.law.mobile.unit.repository;

import com.notetakingplus.law.common.entity.Role;
import com.notetakingplus.law.common.repository.RoleRepository;
import com.notetakingplus.law.mobile.config.TestJpaPersistenceConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

@RunWith(SpringRunner.class)
@DataJpaTest(properties = {"spring.main.allow-bean-definition-overriding=true"})
@Import({TestJpaPersistenceConfig.class})
public class RoleRepositoryTest {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void findByNameTest() {
        Optional<Role> roleOptional = roleRepository.findByName("User");

        assertSoftly(softly -> {
            softly.assertThat(roleOptional).isPresent();

            Role role = roleOptional.get();
            softly.assertThat(role.getName()).isEqualTo("User");
        });
    }
}
