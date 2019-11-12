package com.example.toyproject.view.RecyclerViewAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.toyproject.Model.Language;
import com.example.toyproject.databinding.LanguageSelectItemsBinding;
import java.util.List;

public class LanguageSelectAdapter extends RecyclerView.Adapter<LanguageSelectAdapter.LanguageViewHolder> {

    List<String> list;
    Context context;
    setOnItemClickListener listener;

    public LanguageSelectAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public static interface setOnItemClickListener {
        void onItemClick(RecyclerView.ViewHolder viewHolder, View view, int position);
    }

    @NonNull
    @Override
    public LanguageViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        return new LanguageViewHolder(LanguageSelectItemsBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LanguageViewHolder languageViewHolder, int position) {
        String language = list.get(position);

        languageViewHolder.languageItemsBinding.textView.setText(language);
        languageViewHolder.setOnItemClickListener(listener);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setOnItemClickListener(setOnItemClickListener listener) {
        this.listener = listener;
    }


    static class LanguageViewHolder extends RecyclerView.ViewHolder {
        LanguageSelectItemsBinding languageItemsBinding;
        setOnItemClickListener listener;

        public LanguageViewHolder(@NonNull LanguageSelectItemsBinding languageItemsBinding) {
            super(languageItemsBinding.getRoot());

            this.languageItemsBinding = languageItemsBinding;

            languageItemsBinding.getRoot().setOnClickListener(v -> {
                int position = getAdapterPosition();

                if (listener != null) {
                    listener.onItemClick(LanguageViewHolder.this, v, position);
                }
            });
        }

        public void setOnItemClickListener(setOnItemClickListener listener) {
            this.listener = listener;
        }
    }
}
