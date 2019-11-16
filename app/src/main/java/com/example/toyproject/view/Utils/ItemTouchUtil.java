package com.example.toyproject.view.Utils;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.toyproject.Model.Language;
import com.example.toyproject.Model.Model;
import com.example.toyproject.databinding.PapagoFragmentBinding;
import com.example.toyproject.view.RecyclerViewAdapter.PapgoRecyclerViewAdpater;

public class ItemTouchUtil {
    public static void papagoSwipe(Model model, PapgoRecyclerViewAdpater papgoRecyclerViewAdpater, PapagoFragmentBinding binding){
        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }
            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                Language language = papgoRecyclerViewAdpater.getPosition(position);
                model.deleteUser(language);
            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(binding.recyclerview);
    }
}
