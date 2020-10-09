package com.example.perfectm.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.perfectm.Fragment.BottomSheetFragment;
import com.example.perfectm.Module.Object;
import com.example.perfectm.Presenter.OnClickAdapter;
import com.example.perfectm.R;

import java.util.List;

public class CompAdapter extends RecyclerView.Adapter<CompAdapter.CompViewHoder> {
    List<Object> objectList;
    OnClickAdapter clickCompassAdapter;
    Context context;

    public CompAdapter(List<Object> objectList, Context context) {
        this.objectList = objectList;
        this.context = context;
    }

    public void setClickCompassAdapter(OnClickAdapter clickCompassAdapter) {
        this.clickCompassAdapter = clickCompassAdapter;
    }

    @NonNull
    @Override
    public CompViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout._menu_comprecyc_ic, parent, false);
        //viewhoder truyen view vap
        CompViewHoder compViewHoder = new CompViewHoder(view);
        return compViewHoder;
    }

    @Override
    public void onBindViewHolder(@NonNull final CompViewHoder holder, final int position) {
        final Object object = objectList.get(position);
        holder.tVNameCompass.setText(object.getName());
        holder.imgAvt.setImageResource(object.getImgAvt());
        if (object.isOnline()) {
            holder.isOnline.setVisibility(View.VISIBLE);
        } else {
            holder.isOnline.setVisibility(View.GONE);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetFragment bottomSheetDialog = BottomSheetFragment.newInstance();
                bottomSheetDialog.show(((AppCompatActivity) context).getSupportFragmentManager(), "Bottom Sheet Dialog Fragment");
            }
            //clickCompassAdapter.onClick(object.getName());
//                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context, );
//                View bottom = LayoutInflater.from(context).
//                        inflate(R.layout.item_bottom_sheet_fragment, null);
//
//                RoundedImageView itemImage;
//                TextView itemName;
//                TextView itemCity;
//                TextView itemAge;


//                itemImage = bottom.findViewById(R.id.imgAvt);
//                 itemName = bottom.findViewById(R.id.tVnameCompass);
//
////                itemAge.setText(String.valueOf(object.getName());
////                itemCity.setText(people1.getAdress());
//                itemName.setText(object.getName());
//               itemImage.setImageResource(object.getImgAvt());
//                bottomSheetDialog.setContentView(bottom);
//                bottomSheetDialog.show();
//        }
        });
    }

    @Override
    public int getItemCount() {
        return objectList.size();
    }

    public class CompViewHoder extends RecyclerView.ViewHolder {
        ImageView imgAvt, isOnline;
        TextView tVNameCompass;

        public CompViewHoder(@NonNull View itemView) {
            super(itemView);
            tVNameCompass = itemView.findViewById(R.id.tVnameCompass);
            imgAvt = itemView.findViewById(R.id.imgAvt);
            isOnline = itemView.findViewById(R.id.imgStatus);

        }
    }
}
