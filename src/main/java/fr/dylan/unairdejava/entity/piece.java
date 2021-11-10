package fr.dylan.unairdejava.entity;

public class piece {
    private int id_piece;
    private String name_piece;
    private int duration_piece;

    public piece(int id_piece, String name_piece, int duration_piece) {
        this.id_piece = id_piece;
        this.name_piece = name_piece;
        this.duration_piece = duration_piece;
    }

    public int getId_piece() {
        return id_piece;
    }

    public void setId_piece(int id_piece) {
        this.id_piece = id_piece;
    }

    public String getName_piece() {
        return name_piece;
    }

    public void setName_piece(String name_piece) {
        this.name_piece = name_piece;
    }

    public int getDuration_piece() {
        return duration_piece;
    }

    public void setDuration_piece(int duration_piece) {
        this.duration_piece = duration_piece;
    }
}

