package com.example.glassshop.models.forms;

import com.example.glassshop.models.forms.Art;

import java.util.ArrayList;

public class ArtData {

    static ArrayList<Art> arts = new ArrayList<>();

    public static ArrayList<Art> getAll() {
        return arts; }

    public static void add(Art newArt) {
        arts.add(newArt); }

    public static void remove(int id) {
        Art artToRemove = getById(id);
        arts.remove(artToRemove); }

    public static Art getById(int id) {

        Art theArt = null;

        for (Art candidateArt : arts) {
            if (candidateArt.getArtId() == id) {
                theArt = candidateArt;
            }
        }
        return theArt;
    }

}
