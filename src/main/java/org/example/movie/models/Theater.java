package org.example.movie.models;

import java.util.List;

public class Theater {
    List<Screen> screens;

    public void addScreen(Screen screen) {
        this.screens.add(screen);
    }
}
