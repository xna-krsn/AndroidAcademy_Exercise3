package com.example.android.exercise3;

public class Cat {
    private final int id;
    private final String name;
    private final String photoUrl;
    private final String albumUrl;

    public Cat(int id, String name, String photoUrl, String albumUrl) {
        this.id = id;
        this.name = name;
        this.photoUrl = photoUrl;
        this.albumUrl = albumUrl;
    }

    public String getName() {
        return name;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public String getAlbumUrl() {
        return albumUrl;
    }
}
