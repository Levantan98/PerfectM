package com.example.perfectm.Helpers;

import androidx.recyclerview.widget.DiffUtil;

import com.example.perfectm.Module.Object;

import java.util.List;

public class CardStackCallback extends DiffUtil.Callback {
    List<Object> old, benew;


    public CardStackCallback(List<Object> old, List<Object> benew) {
        this.old = old;
        this.benew = benew;
    }

    @Override
    public int getOldListSize() {
        return old.size();
    }

    @Override
    public int getNewListSize() {
        return benew.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return old.get(oldItemPosition) == benew.get(newItemPosition);
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return old.get(oldItemPosition) == benew.get(newItemPosition);
    }
}
