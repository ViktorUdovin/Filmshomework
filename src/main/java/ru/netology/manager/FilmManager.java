package ru.netology.manager;

import ru.netology.domain.Film;
import ru.netology.repository.FilmRepository;

public class FilmManager {
    private FilmRepository repository;
    int afishaLength = 10;

    public FilmManager(FilmRepository repository) {
       this.repository = repository;
    }

    public FilmManager(int afishaLength) {
        this.afishaLength = afishaLength;
    }


    public void add(Film item) {
       repository.save(item);
    }


    public Film[] getAll() {

        Film[] films = repository.findAll();
        int resultLenght = 0;
        if (afishaLength < films.length) {
            resultLenght = afishaLength;
        }
        if (afishaLength >= films.length){
            resultLenght = films.length;
        }
        if (afishaLength == 0) {
            resultLenght = afishaLength;

        }

        Film[] result = new Film[resultLenght];
        for (int i = 0; i < result.length; i++) {
            int index = films.length - i - 1;


            result[i] = films[index];
        }
        return result;
    }


    public void removeById(int id) {
        repository.removeById(id);
    }
}
