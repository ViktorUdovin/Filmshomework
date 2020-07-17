package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Film;
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
    Film first = new Film(1,  "Зеленая Миля", "Драма", "http://что-то там");
    Film second = new Film(4,  "Зеленая Книга", "Драма", "http://что-то там");
    Film third = new Film(3,  "Омерзительная восьмерка", "Вестерн", "http://что-то там");
    Film fourth = new Film(4,  "Платформа", "Хоррор", "http://что-то там");
    Film fifth = new Film(5,  "Криминальное чтиво", "Драма", "http://что-то там");
    Film sixth = new Film(6,  "Телохранитель", "Боевик", "http://что-то там");
    Film seventh = new Film(7,  "Афера по-американски", "Криминальный фильм", "http://что-то там");
    Film eighth = new Film(8,  "Социальная сеть", "История", "http://что-то там");
    Film ninth = new Film(9,  "Остров проклятых", "Триллер", "http://что-то там");
    Film tenth = new Film(10,  "1+1", "Драма", "http://что-то там");
    Film eleventh = new Film(11,  "остров", "Драма", "http://что-то там");
    Film twelfth = new Film(12,  "дурак", "Драма", "http://что-то там");
    Film thirteenth = new Film(13,  "Папа", "Короткометражка", "http://что-то там");


    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
    }

    @Test
    public void getAll(){
        FilmManager manager = new FilmManager(10);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        Film[] actual = manager.getAll();
        Film[] expected = new Film[] {tenth,ninth,eighth,seventh,sixth,fifth,fourth,third,second,first};

        assertArrayEquals(actual,expected);
    }


    @Test
    public void shouldRemoveIfExists() {
        int idToRemove = 1;

        Film[] returned = new Film[]{second, third};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);

        manager.removeById(idToRemove);
        Film[] expected = new Film[]{third,second};
        Film[] actual = manager.getAll();
        assertArrayEquals(expected,actual);

        verify(repository,times(1)).removeById(idToRemove);
        verify(repository,times(1)).findAll();
    }

    @Test
    public void OverLimit() {
       int idToRemove = 1;
        Film[] returned = new Film[]{third};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);

        manager.removeById(idToRemove);
        Film[] expected = new Film[]{third};
        Film[] actual = manager.getAll();
        assertArrayEquals(expected,actual);

        verify(repository,times(1)).removeById(idToRemove);
        verify(repository,times(1)).findAll();


    }
}