package com.example.ac1_mobile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class LivroAdapter extends RecyclerView.Adapter<LivroAdapter.LivroViewHolder> {
    private List<Livro> livros;

    public LivroAdapter(List<Livro> livros) {
        this.livros = livros;
    }

    @NonNull
    @Override
    public LivroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main, parent, false);
        return new LivroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LivroViewHolder holder, int position) {
        Livro livro = livros.get(position);
        holder.txtTitulo.setText(livro.getTitulo());
        holder.txtAutor.setText(livro.getAutor());
    }

    @Override
    public int getItemCount() {
        return livros.size();
    }

    public static class LivroViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitulo, txtAutor;

        public LivroViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitulo = itemView.findViewById(R.id.txtTitulo);
            txtAutor = itemView.findViewById(R.id.txtAutor);
        }
    }
}
