package com.roma.hometestwork.repository.chairRepository;

import com.roma.hometestwork.config.AppConfig;
import com.roma.hometestwork.domain.Chair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(value = {HibernateChairRepository.class, AppConfig.class})
public class ChairRepositoryIntegrationTest {
    @Autowired
    private ChairRepository victim;

    @Test
    public void shouldCreateChair() {
        Chair chair = new Chair();
        chair.setModelNumber(10L);
        chair.setMaterial("TEST_MATERIAL");
        chair.setPrice(10);

        Long result = victim.create(chair);

        assertThat(result).isNotNull();
    }

    @Test
    public void shouldFindChairById() {
        Chair chair = new Chair();
        chair.setModelNumber(10L);
        chair.setMaterial("TEST_MATERIAL");
        chair.setPrice(10);

        Long id = victim.create(chair);

        Optional<Chair> result = victim.findChairById(id);
        assertThat(result).hasValue(expectedChair(id));
    }

    private Chair expectedChair(Long id) {
        Chair chair = new Chair();
        chair.setId(id);
        chair.setModelNumber(10L);
        chair.setMaterial("TEST_MATERIAL");
        chair.setPrice(10);
        return chair;
    }
}