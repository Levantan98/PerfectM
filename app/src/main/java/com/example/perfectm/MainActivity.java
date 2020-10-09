package com.example.perfectm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.perfectm.Helpers.MethodUsesActivity;
import com.example.perfectm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    com.example.perfectm.databinding.ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //get color statusbar
        MethodUsesActivity.UsesActiveStatusBar(this);
        binding.btnLoginFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, HomeActivity.class));
            }
        });
    }

}