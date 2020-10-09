package com.example.perfectm.Fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.perfectm.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.yuyakaido.android.cardstackview.CardStackView;

public class BottomSheetFragment extends BottomSheetDialogFragment {

    CardStackView cardStackView;
    BottomSheetBehavior bottomSheetBehavior;

    public static BottomSheetFragment newInstance() {
        BottomSheetFragment fragment = new BottomSheetFragment();
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        BottomSheetDialog dialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
        View view = View.inflate(getContext(), R.layout.bottom_sheet_fragment, null);
        cardStackView = view.findViewById(R.id.card_stack_view);
//set cardStackView
//        SetManagerStackCard setManagerStackCard = new SetManagerStackCard(getContext(), cardStackView);
//        setManagerStackCard.SetOptionCardManager();
// set view
        dialog.setContentView(view);
// set color
        ((View) view.getParent()).setBackgroundColor(getResources().getColor(android.R.color.transparent));
        bottomSheetBehavior = BottomSheetBehavior.from((View) view.getParent());
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        return dialog;
    }

}