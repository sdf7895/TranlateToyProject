package com.example.toyproject.Model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "language_table")
public class Language {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @NonNull
    @ColumnInfo(name = "language")
    private String language;

    @NonNull
    @ColumnInfo(name = "language2")
    private String language2;

    public String getLanguage() {
        return language;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLanguage(@NonNull String language) {
        this.language = language;
    }

    @NonNull
    public String getLanguage2() {
        return language2;
    }

    public void setLanguage2(@NonNull String language2) {
        this.language2 = language2;
    }
}
