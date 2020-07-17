package ru.netology.manager;

import ru.netology.domain.Film;

public class FilmManager {
    private Film[] films = new Film[0];

    public FilmManager(int afishaLength) {
        this.afishaLength = afishaLength;
    }

    int afishaLength;

    public FilmManager() {
    }

    public void add(Film item) {
        // создаем новый массив размером на еденицу больше
        int length = films.length + 1;
        Film[] tmp = new Film[length];
// itar + tab
// коипруем поэлементно
        System.arraycopy(films, 0, tmp, 0, films.length);

        // кладем последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        films = tmp;
    }


    public Film[] getAll() {
        int resultLenght = 0;
        if (afishaLength < films.length) {
            resultLenght = afishaLength;
        }
        if (afishaLength >= films.length){
            resultLenght = films.length;
        }

        Film[] result = new Film[resultLenght];
        // перебираем массив в прямом порядке
        // но кладем результат в обратном
        for (int i = 0; i < result.length; i++) {
            int index = films.length - i - 1;


            result[i] = films[index];
            System.out.println(films[index]);
        }
        return result;
    }
}