package org.example.movie.models;

import lombok.Getter;

@Getter
public class Show {
    String id;
    Movie movie;
    long startTs;
    long endTs;
    long duration;
    Screen screen;
}
