package fr.dylan.unairdejava.entity;

public class band {
    private int id_band;
    private String name_band;

    public band(String name_band) {
       // this.id_band = id_band;
        this.name_band = name_band;
    }

    public int getId_band() {
        return id_band;
    }

    public void setId_band(int id_band) {
        this.id_band = id_band;
    }

    public String getName_band() {
        return name_band;
    }

    public void setName_band(String name_band) {
        this.name_band = name_band;
    }
}
