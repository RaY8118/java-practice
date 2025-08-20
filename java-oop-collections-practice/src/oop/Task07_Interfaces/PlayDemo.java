/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author parth
 */
interface Playable {

    public void play();
}

class Guitar implements Playable {

    @Override
    public void play() {
        System.out.println("Playing Guitar");
    }
}

class Piano implements Playable {

    @Override
    public void play() {
        System.out.println("Playing Piano");
    }
}

public class PlayDemo {

    public static void main(String[] args) {
        Playable guitar = new Guitar();
        Playable piano = new Piano();
        guitar.play();
        piano.play();
    }
}
