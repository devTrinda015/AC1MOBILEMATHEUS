package com.example.ac1_mobile;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private LivroDAO livroDAO;
    private EditText edtTitulo, edtAutor;
    private Spinner spinnerCategoria;
    private CheckBox checkLido;
    private RecyclerView recyclerLivros;
    private LivroAdapter adapter;
    private List<Livro> listaLivros;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtTitulo = findViewById(R.id.edtTitulo);
        edtAutor = findViewById(R.id.edtAutor);
        spinnerCategoria = findViewById(R.id.spinnerCategoria);
        checkLido = findViewById(R.id.checkLido);
        recyclerLivros = findViewById(R.id.recyclerLivros);
        Button btnSalvar = findViewById(R.id.btnSalvar);

        livroDAO = new LivroDAO(this);
        livroDAO.abrir();
        listaLivros = livroDAO.listarLivros();

        adapter = new LivroAdapter(listaLivros);
        recyclerLivros.setLayoutManager(new LinearLayoutManager(this));
        recyclerLivros.setAdapter(adapter);

        btnSalvar.setOnClickListener(v -> {
            Livro livro = new Livro(edtTitulo.getText().toString(), edtAutor.getText().toString(),
                    spinnerCategoria.getSelectedItem().toString(), checkLido.isChecked());

            livroDAO.inserirLivro(livro);
            listaLivros.add(livro);
            adapter.notifyDataSetChanged();
        });
    }
}
