package ru.netology.repository;

import ru.netology.domain.Films;


public class FilmRepository {
    private Films[] items = new Films[0];
    int afishaLength;

    public void save(Films item) {
        int length = items.length + 1;
        Films[] tmp = new Films[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }


    public Films[] findAll() {
        return items;
    }

    public Films[] findById(int id) {
        int length = items.length - 1;
       Films[] tmp = new Films[length];
        int index = 0;
        for (Films item : items) {
            if (item.getId() == id) {
                tmp[index] = item;
                return tmp ;
            }
        }
        return null;
    }

    public void removeById(int id) {
        int length = items.length - 1;
        Films[] tmp = new Films[length];
        int index = 0;
        for (Films item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

    public void removeAll(){
        int length = 0;
        Films[] tmp = new Films[length];
        items = tmp;
    }
}
