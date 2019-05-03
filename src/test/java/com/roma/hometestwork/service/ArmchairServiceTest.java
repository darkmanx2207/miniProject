package com.roma.hometestwork.service;

import com.roma.hometestwork.domain.Armchair;
import com.roma.hometestwork.domain.Chair;
import com.roma.hometestwork.repository.armchairRepository.ArmchairRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ArmchairServiceTest {

    @Mock
    private ArmchairRepository repository;

    @Captor
    private ArgumentCaptor<Armchair> captor;

    private ArmchairService victim;

    @Before
    public void setUp() throws Exception {
        victim = new ArmchairService(repository);
    }

    @Test
    public void shouldCreateArmchair() {
        Armchair armchair = armchair();
        when(repository.create(armchair)).thenReturn(armchair.getId());

        Long result = victim.createArmchair(armchair);

        verify(repository).create(captor.capture());
        Armchair captorResult = captor.getValue();

        assertThat(captorResult).isEqualTo(armchair);
        assertThat(armchair.getId()).isEqualTo(result);
    }

    @Test
    public void shouldFindArmchairById() {
        when(repository.findArmchairById(1001L)).thenReturn(Optional.ofNullable(armchair()));

        Chair result = victim.findArmchairById(1001L);

        assertThat(result).isEqualTo(armchair());
    }

    private Armchair armchair() {
        Armchair armchair = new Armchair();
        armchair.setType("TEST_TYPE");
        return armchair;
    }
}