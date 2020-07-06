package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Films;

import static org.junit.jupiter.api.Assertions.*;

class FilmManagerTest {

    @Test
    public void getAll(){
        FilmManager manager = new FilmManager();
        manager.afishaLength = 10;
        Films first = new Films(1, 12, "Зеленая Миля", "Драма", "http://что-то там");
        Films second = new Films(2, 34, "Зеленая Книга", "Драма", "http://что-то там");
        Films thrid = new Films(3, 233, "Омерзительная восьмерка", "Вестерн", "http://что-то там");
        Films fourth = new Films(4, 454, "Платформа", "Хоррор", "http://что-то там");
        Films fifth = new Films(5, 154, "Криминальное чтиво", "Драма", "http://что-то там");
        Films sixth = new Films(6, 133, "Телохранитель", "Боевик", "http://что-то там");
        Films seventh = new Films(7, 152, "Афера по-американски", "Криминальный фильм", "http://что-то там");
        Films eighth = new Films(8, 111, "Социальная сеть", "История", "http://что-то там");
        Films ninth = new Films(9, 19, "Остров проклятых", "Триллер", "http://что-то там");
        Films tenth = new Films(10, 47, "1+1", "Драма", "http://что-то там");


        manager.add(first);
        manager.add(second);
        manager.add(thrid);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);

        Films[] actual = manager.getAll();
        Films[] expected = new Films[] {tenth,ninth,eighth,seventh,sixth,fifth,fourth,thrid,second,first};

        assertArrayEquals(actual,expected);
    }

    @Test
    public void addfilm(){
        FilmManager manager = new FilmManager();
        manager.afishaLength = 10;
        Films first = new Films(1, 12, "Зеленая Миля", "Драма", "http://что-то там");

        manager.add(first);


        Films[] actual = manager.getAll();
        Films[] expected = new Films[] {first};

        assertArrayEquals(actual,expected);
    }

    @Test
    public void emptyFilms() {
        FilmManager manager = new FilmManager();
        manager.afishaLength = 10;

        Films[] actual = manager.getAll();
        Films[] expected = new Films[]{};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void getMoreFilms(){
        FilmManager manager = new FilmManager();
        manager.afishaLength = 10;
        Films first = new Films(1, 12, "Зеленая Миля", "Драма", "http://что-то там");
        Films second = new Films(2, 34, "Зеленая Книга", "Драма", "http://что-то там");
        Films thrid = new Films(3, 233, "Омерзительная восьмерка", "Вестерн", "http://что-то там");
        Films fourth = new Films(4, 454, "Платформа", "Хоррор", "http://что-то там");
        Films fifth = new Films(5, 154, "Криминальное чтиво", "Драма", "http://что-то там");
        Films sixth = new Films(6, 133, "Телохранитель", "Боевик", "http://что-то там");
        Films seventh = new Films(7, 152, "Афера по-американски", "Криминальный фильм", "http://что-то там");
        Films eighth = new Films(8, 111, "Социальная сеть", "История", "http://что-то там");
        Films ninth = new Films(9, 19, "Остров проклятых", "Триллер", "http://что-то там");
        Films tenth = new Films(10, 47, "1+1", "Драма", "http://что-то там");

        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(first);
        manager.add(second);
        manager.add(thrid);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);

        Films[] actual = manager.getAll();
        Films[] expected = new Films[] {tenth,ninth,eighth,seventh,sixth,fifth,fourth,thrid,second,first};

        assertArrayEquals(actual,expected);
    }
}