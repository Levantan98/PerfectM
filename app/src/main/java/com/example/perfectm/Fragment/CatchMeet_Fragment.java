package com.example.perfectm.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DiffUtil;

import com.example.perfectm.Adapter.Catch_MeetAdapter;
import com.example.perfectm.Helpers.CardStackCallback;
import com.example.perfectm.Module.Object;
import com.example.perfectm.Presenter.OnClickAdapter;
import com.example.perfectm.R;
import com.example.perfectm.databinding.CatchmeetFragmentsBinding;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.Direction;

import java.util.ArrayList;
import java.util.List;

public class CatchMeet_Fragment extends Fragment {
    CatchmeetFragmentsBinding binding;
    private CardStackLayoutManager stackLayoutManager;
    // private CardAdapter cardAdapter;
    private List<Object> objectList;
    OnClickAdapter onClickAdapter;
    private Catch_MeetAdapter catch_meetAdapter;
    private static String TAG = "Catch_fragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.
                inflate(inflater, R.layout.catchmeet_fragments,
                        container, false);


        return binding.getRoot();
    }

    public static CatchMeet_Fragment newInstance() {
        return new CatchMeet_Fragment();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        GetObjectList();

        final CardStackView cardStackView = view.findViewById(R.id.card_stack_view_catch);
        stackLayoutManager = new CardStackLayoutManager(getContext(), new CardStackListener() {
            @Override
            public void onCardDragging(Direction direction, float ratio) {

            }


            @Override
            public void onCardSwiped(Direction direction) {
                Log.d(TAG, "onCardSwiped: p=" + stackLayoutManager.getTopPosition() + " d=" + direction);
                if (direction == Direction.Right) {
                    // Toast.makeText(getContext(), "Direction Right", Toast.LENGTH_SHORT).show();
                }
                if (direction == Direction.Top) {
                    //Toast.makeText(getContext(), "Direction Top", Toast.LENGTH_SHORT).show();
                }
                if (direction == Direction.Left) {
                    //Toast.makeText(getContext(), "Direction Left", Toast.LENGTH_SHORT).show();
                }
                if (direction == Direction.Bottom) {
                    //Toast.makeText(getContext(), "Direction Bottom", Toast.LENGTH_SHORT).show();
                }

                // Paginating
                // lay vi tri vuot
                if (stackLayoutManager.getTopPosition() == catch_meetAdapter.getItemCount() - 1) {
                    Paginate();
                }

            }

            @Override
            public void onCardRewound() {

            }

            @Override
            public void onCardCanceled() {

            }

            @Override
            public void onCardAppeared(View view, int position) {
                GetObjectList();
            }

            @Override
            public void onCardDisappeared(View view, int position) {
                GetObjectList();

            }
        });
        // chuyen dong vuot tu trai qua

        catch_meetAdapter = new Catch_MeetAdapter(getContext(), objectList, stackLayoutManager);
        cardStackView.setLayoutManager(stackLayoutManager);
        cardStackView.setAdapter(catch_meetAdapter);
        cardStackView.setItemAnimator(new DefaultItemAnimator());
    }

    private void Paginate() {
        // tao 2 list cu va moi de vuot di vuot lai
        List<Object> old = catch_meetAdapter.getObjectList();
        List<Object> benew = new ArrayList<>(objectList);
        // goi thuoc tinh call back xu ly cho list
        CardStackCallback callback = new CardStackCallback(old, benew);
        // tra ket qua
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(callback);

        catch_meetAdapter.setObjectList(benew);

        diffResult.dispatchUpdatesTo(catch_meetAdapter);

    }


    public void GetObjectList() {
        objectList = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            objectList.add(new Object(R.drawable.imgavt2, "mai anh" + i, 17, "hanoi", true));
            objectList.add(new Object(R.drawable.imageavt, "hang pham" + i, 19, "danag", true));
        }
    }

}
