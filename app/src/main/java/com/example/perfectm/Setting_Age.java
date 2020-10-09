package com.example.perfectm;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.example.perfectm.databinding.ActivitySettingAgeBinding;

public class Setting_Age extends AppCompatActivity {
    ActivitySettingAgeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_setting_age);
        binding.rangeBarAge.setMinValue(18);
        binding.rangeBarAge.setMaxValue(60);
        binding.rangeBarAge.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                binding.tVMinAge.setText("" + minValue);
                binding.tVMaxAge.setText("" + maxValue);
            }
        });

       binding.rangeBarDistance.setMinStartValue(0);
       binding.rangeBarDistance.setMaxValue(500);
        binding.rangeBarDistance.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                int distance = Integer.parseInt("" + maxValue) - Integer.parseInt("" + minValue);
                binding.tVDist.setText("" + distance + "km");

            }
        });
    }
}