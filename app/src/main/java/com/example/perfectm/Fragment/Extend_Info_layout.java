package com.example.perfectm.Fragment;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.perfectm.R;
import com.example.perfectm.databinding.ExtendInfoLayoutBinding;

public class Extend_Info_layout extends Fragment {
    ExtendInfoLayoutBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.extend_info_layout, container, false);

        return binding.getRoot();
    }
}
