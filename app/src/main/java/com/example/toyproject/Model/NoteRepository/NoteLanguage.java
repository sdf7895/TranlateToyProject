package com.example.toyproject.Model.NoteRepository;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "Note_language_table")
public class NoteLanguage {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @NonNull
    @ColumnInfo(name = "text")
    private String text;

    @NonNull
    @ColumnInfo(name = "translatedText")
    private String translatedText;

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
