package com.roma.hometestwork.repository.tabouretRepository;

import com.roma.hometestwork.config.AppConfig;
import com.roma.hometestwork.domain.Tabouret;
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
@Import(value = {HibernateTabouretRepository.class, AppConfig.class})
public class TabouretRepositoryIntegrationTest {

    @Autowired
    private TabouretRepository victim;

    @Test
    public void shouldCreateTabouret() {
        Tabouret tabouret = new Tabouret();
        tabouret.setHight(1.5);

        Long result = victim.create(tabouret);

        assertThat(result).isNotNull();
    }
}