package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Films {
    private int id;
    private int filmId;
    private String filmName;
    private String filmCategory;
    private String urlCoverFilm;
}
