package com.roma.hometestwork.service;

import com.roma.hometestwork.domain.Chair;
import com.roma.hometestwork.repository.chairRepository.ChairRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@RunWith(MockitoJUnitRunner.class)
public class ChairServiceTest {

    @Mock
    private ChairRepository repository;

    @Captor
    private ArgumentCaptor<Chair> captor;

    private ChairService victim;

    @Before
    public void setUp() throws Exception {
        victim = new ChairService(repository);
    }

    @Test
    public void shouldCreateChair() {
        Chair chair = chair();
        when(repository.create(chair)).thenReturn(chair.getId());

        Long result = victim.createChair(chair);

        verify(repository).create(captor.capture());
        Chair captorResult = captor.getValue();

        assertThat(captorResult).isEqualTo(chair);
        assertThat(chair.getId()).isEqualTo(result);
    }

    @Test
    public void shouldFindChairById() {
        when(repository.findChairById(1001L)).thenReturn(Optional.ofNullable(chair()));

        Chair result = victim.findChairById(1001L);

        assertThat(result).isEqualTo(chair());
    }

    @Test
    public void shouldThrowExceptionChairNotFound() {
        when(repository.findChairById(any())).thenReturn(Optional.empty());

        assertThatThrownBy(() -> victim.findChairById(1001L))
                .isInstanceOf(NoSuchElementException.class)
                .hasMessage("Chair not found, id: 1001");
    }


    private Chair chair() {
        Chair chair = new Chair();
        chair.setId(1001L);
        chair.setMaterial("TEST_MATERIAL");
        chair.setModelNumber(1111L);
        chair.setPrice(1.1);
        return chair;
    }
}