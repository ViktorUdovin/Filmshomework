package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Films;
import ru.netology.repository.FilmRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class FilmRepositoryTest {
    @Mock
    public FilmRepository repository;
    @InjectMocks
    private FilmManager manager;
    Films first = new Films(1, 12, "Зеленая Миля", "Драма", "http://что-то там");
    Films second = new Films(4, 34, "Зеленая Книга", "Драма", "http://что-то там");
    Films third = new Films(3, 233, "Омерзительная восьмерка", "Вестерн", "http://что-то там");


    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
    }

    @Test
    public void shouldRemoveIfExists() {
        int idToRemove = 1;

        Films[] returned = new Films[]{second, third};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);

        manager.removeById(idToRemove);
        Films[] expected = new Films[]{third,second};
        Films[] actual = manager.getAll();
        assertArrayEquals(expected,actual);

        verify(repository,times(1)).removeById(idToRemove);
        verify(repository,times(1)).findAll();
    }

    @Test
    public void OverLimit() {
       int idToRemove = 1;
        Films[] returned = new Films[]{third};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);

        manager.removeById(idToRemove);
        Films[] expected = new Films[]{third};
        Films[] actual = manager.getAll();
        assertArrayEquals(expected,actual);

        verify(repository,times(1)).removeById(idToRemove);
        verify(repository,times(1)).findAll();


    }
}