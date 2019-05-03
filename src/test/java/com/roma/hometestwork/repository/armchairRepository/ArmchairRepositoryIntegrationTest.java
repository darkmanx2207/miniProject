package com.roma.hometestwork.repository.armchairRepository;

import com.roma.hometestwork.config.AppConfig;
import com.roma.hometestwork.domain.Armchair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(value = {HibernateArmchairRepository.class, AppConfig.class})
public class ArmchairRepositoryIntegrationTest {

    @Autowired
    private ArmchairRepository victim;

    @Test
    public void shouldCreateArmchair() {
        Armchair armchair = new Armchair();
        armchair.setType("TEST_TYPE");

        Long result = victim.create(armchair);

        assertThat(result).isNotNull();
    }
}