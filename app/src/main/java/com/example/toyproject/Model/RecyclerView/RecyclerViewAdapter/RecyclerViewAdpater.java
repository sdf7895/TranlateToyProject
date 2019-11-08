package com.example.toyproject.Model.RecyclerView.RecyclerViewAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.toyproject.Model.Language;
import com.example.toyproject.databinding.LanguageItemsBinding;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdpater extends RecyclerView.Adapter<RecyclerViewAdpater.MyViewHolder>{
    Context context;
    private List<Language> items;

    public RecyclerViewAdpater(Context context) {
        this.context = context;
        this.items = new ArrayList<>();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LanguageItemsBinding.inflate(LayoutInflater.from(viewGroup.getContext()),viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int i) {
        if(items != null) {
            Language language = items.get(i);
            viewHolder.languageItemsBinding.changelg2.setText(language.getTranslatedText());
        }else{
            viewHolder.languageItemsBinding.changelg.setText("No Language");

        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setData(List<Language> newData){
        if(items != null){
            PostDiffCallback postDiffCallback = new PostDiffCallback(items,newData);
            DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(postDiffCallback);

            items.clear();
            items.addAll(newData);
            diffResult.dispatchUpdatesTo(this);
        } else {
            items = newData;
        }
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        LanguageItemsBinding languageItemsBinding;

        public MyViewHolder(@NonNull LanguageItemsBinding binding) {
            super(binding.getRoot());
            this.languageItemsBinding = binding;
        }
    }

    class PostDiffCallback extends DiffUtil.Callback{

        private final List<Language> oldPosts, newPosts;

        public PostDiffCallback(List<Language> oldPosts, List<Language> newPosts) {
            this.oldPosts = oldPosts;
            this.newPosts = newPosts;
        }

        @Override
        public int getOldListSize() {
            return oldPosts.size();
        }

        @Override
        public int getNewListSize() {
            return newPosts.size();
        }

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
