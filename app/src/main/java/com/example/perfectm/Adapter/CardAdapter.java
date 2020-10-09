package com.example.perfectm.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class CardAdapter extends ArrayAdapter<Integer> {

    public CardAdapter(Context context, int resource) {
        super(context, resource);
    }

    public View getView(int position, View convertview, ViewGroup parent) {
        return super.getView(position, convertview, parent);
    }
}
