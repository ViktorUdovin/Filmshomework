package ru.netology.manager;

import ru.netology.domain.Films;
import ru.netology.repository.FilmRepository;

public class FilmManager {
    private FilmRepository repository;
    private Films[] films = new Films[0];
    int afishaLength;
    public FilmManager(FilmRepository repository) {
       this.repository = repository;
    }



    public void add(Films item) {
       repository.save(item);
    }


    public Films[] getAll() {

        Films[] films = repository.findAll();
        Films[] result = new Films[films.length];
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
