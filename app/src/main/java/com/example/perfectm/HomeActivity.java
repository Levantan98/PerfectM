package com.example.perfectm;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.perfectm.Fragment.CatchMeet_Fragment;
import com.example.perfectm.Fragment.CompassFragment;
import com.example.perfectm.Helpers.MethodUsesActivity;
import com.example.perfectm.databinding.ActivityHomeBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
    ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        //change staus of statusbar
        MethodUsesActivity.UsesActiveStatusBar(this);
        getSupportFragmentManager().beginTransaction().
                add(R.id.container, new CompassFragment(), null).commit();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        //setting action
        binding.settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, Setting_Age.class));
                Toast.makeText(getBaseContext(), "Setting_Age", Toast.LENGTH_SHORT).show();
            }
        });

    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_compass:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, CompassFragment.newInstance()).commit();
                    binding.tVheadTitle.setText(getString(R.string.recently));
                    return true;
                case R.id.navigation_doublecard:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, CatchMeet_Fragment.newInstance()).commit();
                    binding.tVheadTitle.setText(getString(R.string.catchmeet));
                    return true;
                case R.id.navigation_message:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, CatchMeet_Fragment.newInstance()).commit();
                    binding.tVheadTitle.setText(getString(R.string.chat));
                    return true;
                case R.id.navigation_user:
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.container, CatchMeet_Fragment.newInstance()).commit();
                    binding.tVheadTitle.setText(getString(R.string.brief));
                    return true;
            }
            return false;
        }
    };


}

