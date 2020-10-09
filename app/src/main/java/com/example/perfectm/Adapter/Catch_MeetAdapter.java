package com.example.perfectm.Adapter;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.perfectm.Module.Object;
import com.example.perfectm.Presenter.OnClickAdapter;
import com.example.perfectm.R;
import com.squareup.picasso.Picasso;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.StackFrom;
import com.yuyakaido.android.cardstackview.SwipeableMethod;

import java.util.List;

public class Catch_MeetAdapter extends RecyclerView.Adapter<Catch_MeetAdapter.CatchMeetViewHolder> {
    OnClickAdapter onClickAdapter;
    Context context;
    private List<Object> objectList;
    public CardStackLayoutManager stackLayoutManager;
    private boolean Click = true;

    public List<Object> getObjectList() {
        return objectList;
    }

    public void setObjectList(List<Object> objectList) {
        this.objectList = objectList;
    }

    public Catch_MeetAdapter(Context context, List<Object> objectList, CardStackLayoutManager stackLayoutManager) {
        this.context = context;
        this.objectList = objectList;
        this.stackLayoutManager = stackLayoutManager;
    }

    public void setOnClickAdapter(OnClickAdapter onClickAdapter) {
        this.onClickAdapter = onClickAdapter;
    }

    @NonNull
    @Override
    public CatchMeetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_card, parent, false);
        CatchMeetViewHolder viewHolder = new CatchMeetViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(final CatchMeetViewHolder holder, int position) {
        final Object object = objectList.get(position);
        holder.getData(object);
        holder.getStackMaganer();
        holder.tV_itemName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.linear_cardinfo.setVisibility(View.GONE);
                holder.layout_troinoi.setVisibility(View.GONE);
                holder.layout_catchmeet_extend.setVisibility(View.VISIBLE);
                holder.getSizeScreen(holder.relativeLayout_image);

            }
        });
        holder.image_ex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Click) {
                    stackLayoutManager.setSwipeableMethod(SwipeableMethod.None);
                    holder.layout_extend2.setVisibility(View.VISIBLE);
                    holder.layouttroinoi_bottom.setVisibility(View.VISIBLE);
                    holder.image_ex.setImageResource(R.drawable.ic_expand_more_24);
                    Click = false;
                } else {
                    stackLayoutManager.setSwipeableMethod(SwipeableMethod.AutomaticAndManual);
                    holder.layout_extend2.setVisibility(View.GONE);
                    holder.layout_troinoi.setVisibility(View.GONE);
                    holder.image_ex.setImageResource(R.drawable.ic_loupe_24);
                    Click = true;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return objectList.size();
    }

    public class CatchMeetViewHolder extends RecyclerView.ViewHolder {
        ImageView item_image, image_ex;
        TextView tV_itemName, tV_itemAge, tV_itemCity, tV_Nameex, tV_Ageex, tV_Cityex;
        LinearLayout linear_cardinfo, layout_catchmeet_extend, layout_extend2,
                layout_troinoi, layouttroinoi_bottom;
        RelativeLayout relativeLayout_image;
        ScrollView scrollView;

        public CatchMeetViewHolder(View itemView) {
            super(itemView);
            item_image = itemView.findViewById(R.id.item_image);
            tV_itemName = itemView.findViewById(R.id.tV_Name);
            tV_itemAge = itemView.findViewById(R.id.tV_Age);
            tV_itemCity = itemView.findViewById(R.id.tV_City);
            tV_Nameex = itemView.findViewById(R.id.tV_exName);
            tV_Cityex = itemView.findViewById(R.id.tV_exCity);
            tV_Ageex = itemView.findViewById(R.id.tV_exAge);
            linear_cardinfo = itemView.findViewById(R.id.layout_cardinfo);
            image_ex = itemView.findViewById(R.id.image_ex);
            scrollView = itemView.findViewById(R.id.scrollView);
            layout_catchmeet_extend = itemView.findViewById(R.id.layout_catchmeet_extend);
            layout_troinoi = itemView.findViewById(R.id.layouttroinoi);
            layouttroinoi_bottom = itemView.findViewById(R.id.layouttroinoi_bottom);
            layout_extend2 = itemView.findViewById(R.id.layout_extend2);
            relativeLayout_image = itemView.findViewById(R.id.layout_image);


        }

        public void getData(Object object) {
            Picasso.get().load(object.getImgAvt()).into(item_image);
            tV_itemName.setText(object.getName());
            tV_itemCity.setText(object.getCity());
            tV_itemAge.setText(String.valueOf(object.getAge()));
            tV_Ageex.setText(String.valueOf(object.getAge()));
            tV_Nameex.setText(String.valueOf(object.getName()));
            tV_Cityex.setText(String.valueOf(object.getCity()));
        }

        public void getSizeScreen(RelativeLayout layout) {
            DisplayMetrics displaymetrics = new DisplayMetrics();
            ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
            //if you need three fix imageview in width
            int devicewidth = displaymetrics.widthPixels;
            //if you need 4-5-6 anything fix imageview in height
            int deviceheight = (displaymetrics.heightPixels) - (displaymetrics.heightPixels) / 2;
            // layout.getLayoutParams().width = devicewidth;
            //if you need same height as width you can set devicewidth in holder.image_view.getLayoutParams().height
            layout.getLayoutParams().height = deviceheight;
        }

        public void getStackMaganer() {
            stackLayoutManager.setStackFrom(StackFrom.None);
            // khoag thoi gian dich chuyen
            stackLayoutManager.setTranslationInterval(8.0f);
            //hieu ung chuyen canh hau. lap day 95 %
            stackLayoutManager.setScaleInterval(0.95f);
            // do co the vuot de chuyen tab
            stackLayoutManager.setSwipeThreshold(0.6f);
            // chi vuot theo chieu ngang
            stackLayoutManager.setDirections(Direction.FREEDOM);
            //manager.setMaxDegree(90f);
            // cho phep bơi tab theo chieu nao
            stackLayoutManager.setCanScrollHorizontal(true);
            stackLayoutManager.setSwipeableMethod(SwipeableMethod.AutomaticAndManual);
            // stackLayoutManager.setCanScrollVertical(false);
            stackLayoutManager.setOverlayInterpolator(new LinearInterpolator());
        }
    }
}


