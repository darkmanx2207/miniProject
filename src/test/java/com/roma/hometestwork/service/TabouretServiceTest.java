package com.roma.hometestwork.service;

import com.roma.hometestwork.domain.Tabouret;
import com.roma.hometestwork.repository.tabouretRepository.TabouretRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TabouretServiceTest {

    @Mock
    private TabouretRepository repository;

    @Captor
    private ArgumentCaptor<Tabouret> captor;

    private TabouretService victim;

    @Before
    public void setUp() throws Exception {
        victim = new TabouretService(repository);
    }

    @Test
    public void shouldCreateTabouret() {
        Tabouret tabouret = tabouret();
        when(repository.create(tabouret)).thenReturn(tabouret.getId());

        Long result = victim.createTabouret(tabouret);

        verify(repository).create(captor.capture());
        Tabouret captorResult = captor.getValue();

        assertThat(captorResult).isEqualTo(tabouret);
        assertThat(tabouret.getId()).isEqualTo(result);
    }

    @Test
    public void shouldFindTabouretById() {
        when(repository.findTabouretById(1001L)).thenReturn(Optional.ofNullable(tabouret()));

        Tabouret result = victim.findTabouretById(1001L);

        assertThat(result).isEqualTo(tabouret());
    }

    @Test
    public void shouldThrowExceptionTabouretNotFound() {
        when(repository.findTabouretById(any())).thenReturn(Optional.empty());

        assertThatThrownBy(() -> victim.findTabouretById(1001L))
                .isInstanceOf(NoSuchElementException.class)
                .hasMessage("Tabouret not found, id: 1001");
    }


    private Tabouret tabouret() {
        Tabouret tabouret = new Tabouret();
        tabouret.setHight(10);
        return tabouret;
    }
}