package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;

import static org.junit.jupiter.api.Assertions.*;

class FilmRepositoryTest {
FilmRepository repository = new FilmRepository();

    @Test
    public void addfilm(){
        Film first = new Film(1,  "Зеленая Миля", "Драма", "http://что-то там");
        Film second = new Film(2,  "Зеленая Книга", "Драма", "http://что-то там");
        Film third = new Film(3,  "Омерзительная восьмерка", "Вестерн", "http://что-то там");

        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(third);

        Film[] expected = new Film[]{first,second,third,third};
        Film[] actual = repository.findAll();

        assertArrayEquals(expected,actual);

    }


    @Test
    public void findFilm(){
        Film first = new Film(1,  "Зеленая Миля", "Драма", "http://что-то там");
        Film second = new Film(2,  "Зеленая Книга", "Драма", "http://что-то там");
        Film third = new Film(3,  "Омерзительная восьмерка", "Вестерн", "http://что-то там");
        repository.save(first);
        repository.save(second);
        repository.save(third);
        Film film = repository.findById(1);
        assertEquals(first, film);
    }

    @Test
    public void deletefilm(){
        Film first = new Film(1,  "Зеленая Миля", "Драма", "http://что-то там");
        Film second = new Film(2,  "Зеленая Книга", "Драма", "http://что-то там");
        Film third = new Film(3,  "Омерзительная восьмерка", "Вестерн", "http://что-то там");

        repository.save(first);
        repository.save(second);
        repository.save(third);
        System.out.println(repository.findAll());
        repository.removeById(1);


        Film[] expected = new Film[]{second,third};
        Film[] actual = repository.findAll();

        assertArrayEquals(expected,actual);

    }

    @Test
    public void deleteAllFilm(){
        Film first = new Film(1,  "Зеленая Миля", "Драма", "http://что-то там");
        Film second = new Film(2,  "Зеленая Книга", "Драма", "http://что-то там");
        Film third = new Film(3,  "Омерзительная восьмерка", "Вестерн", "http://что-то там");

        repository.save(first);
        repository.save(second);
        repository.save(third);
        System.out.println(repository.findAll());
        repository.removeAll();


        Film[] expected = new Film[]{};
        Film[] actual = repository.findAll();

        assertArrayEquals(expected,actual);

    }

}