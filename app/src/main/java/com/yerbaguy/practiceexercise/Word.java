package com.yerbaguy.practiceexercise;

/**
 * Created by root on 06.09.17.
 */

public class Word {

    private int id;
    private String engword;
    private String plword;

    public Word() {

    }

    public Word(String engword, String plword ) {
        super();
        this.engword = engword;
        this.plword = plword;

    }


    public void setId(int id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    public void setEngWord(String engWord) {
        this.engword = engword;
    }

    public String getEngWord() {
        return this.engword;
    }

    public void setPlWord(String plword) {
        this.plword = plword;
    }

    public String getPlWord() {
        return this.plword;
    }


    @Override
    public String toString() {

        return "Word [id = " + id + ", engword = " + engword + ", plword " + plword + "]";
    }

}
