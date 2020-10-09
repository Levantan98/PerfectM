package com.example.perfectm.Helpers;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.WindowManager;

import androidx.core.content.ContextCompat;

import com.example.perfectm.R;

public class MethodUsesActivity {
    public static void UsesActiveStatusBar(Activity myActivityReference) {
        // set hien thi mau statusbar theo activity
        myActivityReference.getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        //  set status theo mau
    /*    myActivityReference.getWindow().getDecorView().
                setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);//  set status text dark
        myActivityReference.getWindow().
                setStatusBarColor(ContextCompat.getColor(myActivityReference,
                        R.color.white));*/
    }


}
