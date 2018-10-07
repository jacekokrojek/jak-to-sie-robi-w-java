package e.polimorfizm.intro;

import e.polimorfizm.Note;

public class Wind extends Instrument {
    // Redefine interface method:
    public void play(Note n) {
        System.out.println("Wind.play() " + n);
    }
}