package com.example.perfectm.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.perfectm.Adapter.CompAdapter;
import com.example.perfectm.Helpers.CustomItemDecorator;
import com.example.perfectm.Module.Object;
import com.example.perfectm.Presenter.OnClickAdapter;
import com.example.perfectm.R;
import com.example.perfectm.databinding.CompassfragmentBinding;

import java.util.ArrayList;
import java.util.List;

public class CompassFragment extends Fragment {
    List<Object> objectList;
    CompAdapter compAdapter;
    CompassfragmentBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.compassfragment,
                container, false);

        AdapterView();
        return binding.getRoot();

    }

    public static CompassFragment newInstance() {
        return new CompassFragment();
    }

    public void AdapterView() {
        objectList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            objectList.add(new Object(R.drawable.imgavt2, "mai anh" + i, 17, "hanoi", true));
            objectList.add(new Object(R.drawable.imageavt, "hang pham" + i, 19, "danang", true));
        }
        compAdapter = new CompAdapter(objectList, getContext());
        binding.recyclerviewcompass.setAdapter(compAdapter);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        manager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
        binding.recyclerviewcompass.addItemDecoration(new CustomItemDecorator(getResources().
                getDimensionPixelSize(R.dimen._10sdp),
                getResources().getDimensionPixelSize(R.dimen._90sdp)));
        binding.recyclerviewcompass.setLayoutManager(manager);

    }
}
