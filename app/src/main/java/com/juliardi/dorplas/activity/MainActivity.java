package com.juliardi.dorplas.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.juliardi.dorplas.R;
import com.juliardi.dorplas.fragment.FragmentHome;
import com.juliardi.dorplas.fragment.FragmentProfile;
import com.juliardi.dorplas.fragment.Fragment_admin;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private Long backpresed = 0L;

     // Session session;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home_activity);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

       tampil(new FragmentHome());

    }

//    private void moveToLogin() {
//        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
//        startActivity(intent);
//        finish();
//    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int i = item.getItemId();
        Fragment fragment = null;
        switch (i) {
            case R.id.menuHome:
                fragment = new FragmentHome();
                break;
            case R.id.menuAdmin:
                fragment = new Fragment_admin();
                break;
            case R.id.menuProfil:
                fragment = new FragmentProfile();
                break;

        }
       return tampil(fragment);
    }

    private boolean tampil(Fragment fragment) {
        if(fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragment).commit();
            return true;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
       if(backpresed + 2000 > System.currentTimeMillis()){
           super.onBackPressed();
       }else{
           Toast.makeText(this, "Tekan Sekali lagi untuk keluar", Toast.LENGTH_SHORT).show();
           backpresed = System.currentTimeMillis();
       }
    }
}
