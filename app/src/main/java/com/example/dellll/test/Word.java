package com.example.dellll.test;

/**
 * Created by DELLLL on 5/5/2017.
 */
public class Word {
    private String w_word;
    private String w_huongdan;

    public String getW_huongdan() {
        return w_huongdan;
    }

    public void setW_huongdan(String w_huongdan) {
        this.w_huongdan = w_huongdan;
    }

    private String w_consonant;
    private String w_audio;
    private String w_level;
    private String w_status;

    public Word(String w_word, String w_huongdan, String w_consonant, String w_audio, String w_level, String w_status) {
        this.w_word = w_word;
        this.w_huongdan = w_huongdan;
        this.w_consonant = w_consonant;
        this.w_audio = w_audio;
        this.w_level = w_level;
        this.w_status = w_status;
    }

    public String getW_word() {
        return w_word;
    }

    public void setW_word(String w_word) {
        this.w_word = w_word;
    }

    public String getW_consonant() {
        return w_consonant;
    }

    public void setW_consonant(String w_consonant) {
        this.w_consonant = w_consonant;
    }

    public String getW_audio() {
        return w_audio;
    }

    public void setW_audio(String w_audio) {
        this.w_audio = w_audio;
    }

    public String getW_level() {
        return w_level;
    }

    public void setW_level(String w_level) {
        this.w_level = w_level;
    }

    public String getW_status() {
        return w_status;
    }

    public void setW_status(String w_status) {
        this.w_status = w_status;
    }
}
