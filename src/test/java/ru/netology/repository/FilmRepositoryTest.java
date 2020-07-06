package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Films;

import static org.junit.jupiter.api.Assertions.*;

class FilmRepositoryTest {
FilmRepository repository = new FilmRepository();

    @Test
    public void addfilm(){
        Films first = new Films(1, 12, "Зеленая Миля", "Драма", "http://что-то там");
        Films second = new Films(2, 34, "Зеленая Книга", "Драма", "http://что-то там");
        Films third = new Films(3, 233, "Омерзительная восьмерка", "Вестерн", "http://что-то там");

        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(third);

        Films[] expected = new Films[]{first,second,third,third};
        Films[] actual = repository.findAll();

        assertArrayEquals(expected,actual);

    }

    @Test
    public void findfilm(){
        Films first = new Films(1, 12, "Зеленая Миля", "Драма", "http://что-то там");
        Films second = new Films(2, 34, "Зеленая Книга", "Драма", "http://что-то там");
        Films third = new Films(3, 233, "Омерзительная восьмерка", "Вестерн", "http://что-то там");

        repository.save(first);
        repository.save(second);
        repository.save(third);
        System.out.println(repository.findAll());
       repository.findById(1);


       Films[] expected = repository.findById(1);
       Films[] actual = repository.findById(1);

        assertArrayEquals(expected,actual);

    }

    @Test
    public void findbyIdfilm(){
        Films first = new Films(1, 12, "Зеленая Миля", "Драма", "http://что-то там");
        Films second = new Films(2, 34, "Зеленая Книга", "Драма", "http://что-то там");
        Films third = new Films(3, 233, "Омерзительная восьмерка", "Вестерн", "http://что-то там");

        repository.save(first);
        repository.save(second);
        repository.save(third);
        System.out.println(repository.findAll());
        repository.findById(4);


        Films[] expected = null;
        Films[] actual = repository.findById(4);

        assertArrayEquals(expected,actual);

    }

    @Test
    public void deletefilm(){
        Films first = new Films(1, 12, "Зеленая Миля", "Драма", "http://что-то там");
        Films second = new Films(2, 34, "Зеленая Книга", "Драма", "http://что-то там");
        Films third = new Films(3, 233, "Омерзительная восьмерка", "Вестерн", "http://что-то там");

        repository.save(first);
        repository.save(second);
        repository.save(third);
        System.out.println(repository.findAll());
        repository.removeById(1);


        Films[] expected = new Films[]{second,third};
        Films[] actual = repository.findAll();

        assertArrayEquals(expected,actual);

    }

    @Test
    public void deleteAllFilm(){
        Films first = new Films(1, 12, "Зеленая Миля", "Драма", "http://что-то там");
        Films second = new Films(2, 34, "Зеленая Книга", "Драма", "http://что-то там");
        Films third = new Films(3, 233, "Омерзительная восьмерка", "Вестерн", "http://что-то там");

        repository.save(first);
        repository.save(second);
        repository.save(third);
        System.out.println(repository.findAll());
        repository.removeAll();


        Films[] expected = new Films[]{};
        Films[] actual = repository.findAll();

        assertArrayEquals(expected,actual);

    }

}