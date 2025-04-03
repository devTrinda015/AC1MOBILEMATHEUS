package com.example.ac1_mobile;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {
    private SQLiteDatabase db;
    private LivroDBHelper dbHelper;

    public LivroDAO(Context context) {
        dbHelper = new LivroDBHelper(context);
    }

    public void abrir() {
        db = dbHelper.getWritableDatabase();
    }

    public void fechar() {
        dbHelper.close();
    }

    public void inserirLivro(Livro livro) {
        ContentValues values = new ContentValues();
        values.put("titulo", livro.getTitulo());
        values.put("autor", livro.getAutor());
        values.put("categoria", livro.getCategoria());
        values.put("lido", livro.isLido() ? 1 : 0);
        db.insert("livros", null, values);
    }

    public List<Livro> listarLivros() {
        List<Livro> lista = new ArrayList<>();
        Cursor cursor = db.query("livros", null, null, null, null, null, "titulo ASC");

        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String titulo = cursor.getString(1);
            String autor = cursor.getString(2);
            String categoria = cursor.getString(3);
            boolean lido = cursor.getInt(4) == 1;

            lista.add(new Livro(id, titulo, autor, categoria, lido));
        }
        cursor.close();
        return lista;
    }
}
