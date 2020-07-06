package ru.netology.manager;

import ru.netology.domain.Films;

public class FilmManager {
    private Films[] films = new Films[0];
    int afishaLength;

    public FilmManager() {
    }

    public void add(Films item) {
        // создаем новый массив размером на еденицу больше
        int length = films.length + 1;
        Films[] tmp = new Films[length];
// itar + tab
// коипруем поэлементно
        System.arraycopy(films, 0, tmp, 0, films.length);

        // кладем последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        films = tmp;
    }


    public Films[] getAll() {
        int resultLenght = 0;
        if (afishaLength < films.length) {
            resultLenght = afishaLength;
        }
        if (afishaLength >= films.length){
            resultLenght = films.length;
        }

        Films[] result = new Films[resultLenght];
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