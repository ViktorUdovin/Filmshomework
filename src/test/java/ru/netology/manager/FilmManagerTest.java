package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Film;

import static org.junit.jupiter.api.Assertions.*;

class FilmManagerTest {

    FilmManager manager = new FilmManager(10);
   private Film first = new Film(1,  "Зеленая Миля", "Драма", "http://что-то там");
   private Film second = new Film(2,  "Зеленая Книга", "Драма", "http://что-то там");
   private Film thrid = new Film(3,  "Омерзительная восьмерка", "Вестерн", "http://что-то там");
   private Film fourth = new Film(4,  "Платформа", "Хоррор", "http://что-то там");
   private Film fifth = new Film(5,  "Криминальное чтиво", "Драма", "http://что-то там");
   private Film sixth = new Film(6,  "Телохранитель", "Боевик", "http://что-то там");
   private Film seventh = new Film(7,  "Афера по-американски", "Криминальный фильм", "http://что-то там");
   private Film eighth = new Film(8,  "Социальная сеть", "История", "http://что-то там");
   private Film ninth = new Film(9,  "Остров проклятых", "Триллер", "http://что-то там");
   private Film tenth = new Film(10,  "1+1", "Драма", "http://что-то там");
   private Film eleventh = new Film(11,  "остров", "Драма", "http://что-то там");
   private Film twelfth = new Film(12,  "дурак", "Драма", "http://что-то там");
   private Film thirteenth = new Film(13,  "Папа", "Короткометражка", "http://что-то там");

    @Test
    public void getAll(){
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

        Film[] actual = manager.getAll();
        Film[] expected = new Film[] {tenth,ninth,eighth,seventh,sixth,fifth,fourth,thrid,second,first};

        assertArrayEquals(actual,expected);
    }

    @Test
    public void addfilm(){
        FilmManager manager = new FilmManager(10);

        manager.add(first);


        Film[] actual = manager.getAll();
        Film[] expected = new Film[] {first};

        assertArrayEquals(actual,expected);
    }

    @Test
    public void emptyFilms() {
        FilmManager manager = new FilmManager(10);


        Film[] actual = manager.getAll();
        Film[] expected = new Film[]{};

        assertArrayEquals(actual, expected);
    }

    @Test
    public void getMoreFilms(){
        FilmManager manager = new FilmManager(10);

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

        Film[] actual = manager.getAll();
        Film[] expected = new Film[] {tenth,ninth,eighth,seventh,sixth,fifth,fourth,thrid,second,first};

        assertArrayEquals(actual,expected);
    }

    @Test
    public void getMoreFilmsthanTrhee(){
        FilmManager manager = new FilmManager(3);

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

        Film[] actual = manager.getAll();
        Film[] expected = new Film[] {tenth,ninth,eighth};

        assertArrayEquals(actual,expected);
    }

    @Test
    public void getAllthreefilms(){
        manager.add(first);
        manager.add(second);
        manager.add(thrid);


        Film[] actual = manager.getAll();
        Film[] expected = new Film[] {thrid,second,first};

        assertArrayEquals(actual,expected);
    }

    @Test
    public void getAllthirteenth(){
        FilmManager manager = new FilmManager(10);
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
        manager.add(eleventh);
        manager.add(twelfth);
        manager.add(thirteenth);


        Film[] actual = manager.getAll();
        Film[] expected = new Film[] {thirteenth,twelfth,eleventh,tenth,ninth,eighth,seventh,sixth,fifth,fourth};

        assertArrayEquals(actual,expected);
    }

    @Test
    public void getAllthanthirteenth(){
        FilmManager manager = new FilmManager(13);
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
        manager.add(eleventh);
        manager.add(twelfth);
        manager.add(thirteenth);


        Film[] actual = manager.getAll();
        Film[] expected = new Film[] {thirteenth,twelfth,eleventh,tenth,ninth,eighth,seventh,sixth,fifth,fourth,thrid,second,first};

        assertArrayEquals(actual,expected);
    }
}