package com.example.toyproject.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "language_table")
public class Language {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @NonNull
    @ColumnInfo(name = "text")
    private String text;

    @NonNull
    @ColumnInfo(name = "translatedText")
    private String translatedText;

    public Language(@NonNull String text, @NonNull String translatedText) {
        this.text = text;
        this.translatedText = translatedText;
    }

    //----------------set --------------
    public void setId(int id) { this.id = id; }

    public void setText(@NonNull String text) {this.text = text;}

    public void setTranslatedText(@NonNull String translatedText) { this.translatedText = translatedText; }


    //----------------get --------------
    public int getId() { return id; }

    @NonNull
    public String getText() { return text; }

    @NonNull
    public String getTranslatedText() { return translatedText; }


}
