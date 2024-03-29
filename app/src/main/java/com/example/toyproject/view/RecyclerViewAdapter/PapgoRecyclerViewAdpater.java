package com.example.toyproject.view.RecyclerViewAdapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.toyproject.Model.Language;
import com.example.toyproject.R;
import com.example.toyproject.databinding.PapagoItemsBinding;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PapgoRecyclerViewAdpater extends RecyclerView.Adapter<PapgoRecyclerViewAdpater.MyViewHolder> {
    Context context;
    List<Language> items;
    OnItemClickListener listener;
    NoteOnItemClickListener noteListener;
    Bitmap bitmap;
    boolean state = true;

    public PapgoRecyclerViewAdpater(Context context) {
        this.context = context;
        this.items = new ArrayList<>();
    }

    public static interface OnItemClickListener {
        void onItemClick(RecyclerView.ViewHolder viewHolder, View view, int position, Language language);
    }

    public static interface NoteOnItemClickListener {
        void onItemClick(RecyclerView.ViewHolder viewHolder, View view, int position, Language language);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(PapagoItemsBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int position) {
        Language language = items.get(position);
        viewHolder.papagoItemsBinding.changelg.setText(language.getText());
        viewHolder.papagoItemsBinding.changelg2.setText(language.getTranslatedText());
        noteInsertButton(viewHolder,position,language);

        viewHolder.setOnItemClickListener(listener);
        viewHolder.bind(language);
    }

    public Language getPosition(int position){
        return items.get(position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public void noteSetOnItemClickListener(NoteOnItemClickListener noteListener) {
        this.noteListener = noteListener;
    }

    private void noteInsertButton(MyViewHolder viewHolder,int position,Language language){
        viewHolder.papagoItemsBinding.insertbutton.setOnClickListener(v -> {
            if(state == true) {
                noteListener.onItemClick(viewHolder, v, position, language);
                viewHolder.papagoItemsBinding.insertbutton.setBackgroundResource(R.drawable.star1);
                state = false;
            }else{
                viewHolder.papagoItemsBinding.insertbutton.setBackgroundResource(R.drawable.star2);
                state = true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setData(List<Language> newData) {
        if (items != null) {
            PostDiffCallback postDiffCallback = new PostDiffCallback(items, newData);
            DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(postDiffCallback);

            items.clear();
            items.addAll(newData);
            diffResult.dispatchUpdatesTo(this);
        } else {
            items = newData;
        }
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        PapagoItemsBinding papagoItemsBinding;
        Language language;
        OnItemClickListener listener;

        public MyViewHolder(@NonNull PapagoItemsBinding binding) {
            super(binding.getRoot());
            this.papagoItemsBinding = binding;

            binding.getRoot().setOnClickListener(v -> {
                int position = getAdapterPosition();

                if (listener != null) {
                    listener.onItemClick(MyViewHolder.this, v, position , language);
                }
            });
        }

        public void bind(Language language){
            this.language = language;
        }

        public void setOnItemClickListener(OnItemClickListener listener) {
            this.listener = listener;
        }
    }

    class PostDiffCallback extends DiffUtil.Callback {

        private final List<Language> oldPosts, newPosts;

        public PostDiffCallback(List<Language> oldPosts, List<Language> newPosts) {
            this.oldPosts = oldPosts;
            this.newPosts = newPosts;
        }

        @Override
        public int getOldListSize() {return oldPosts.size();}

        @Override
        public int getNewListSize() {return newPosts.size();}

        @Override
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            return oldPosts.get(oldItemPosition).getId() == newPosts.get(newItemPosition).getId();
        }

        @Override
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            return oldPosts.get(oldItemPosition).equals(newPosts.get(newItemPosition));
        }
    }
}
