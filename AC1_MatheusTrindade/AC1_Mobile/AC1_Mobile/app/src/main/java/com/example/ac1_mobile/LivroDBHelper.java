package com.example.ac1_mobile;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class LivroDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "livros.db";
    private static final int DATABASE_VERSION = 1;

    public LivroDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE livros (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "titulo TEXT NOT NULL, " +
                "autor TEXT NOT NULL, " +
                "categoria TEXT NOT NULL, " +
                "lido INTEGER NOT NULL DEFAULT 0)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS livros");
        onCreate(db);
    }
}
