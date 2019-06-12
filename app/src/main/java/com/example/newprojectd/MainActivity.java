package com.example.newprojectd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.security.acl.Owner;

import static android.view.animation.AnimationUtils.*;

public class MainActivity extends AppCompatActivity {
    User User_frag;
    Caretaker Caretaker_frag;
    Ownerhs Ownerhs_frag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        User_frag = new User();
        Caretaker_frag = new Caretaker();
        Ownerhs_frag=new Ownerhs();

        BottomNavigationView nav = findViewById(R.id.nav);
        final FrameLayout content = findViewById(R.id.content_layout);

        change_Fragment(User_frag);
        nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.profile:
                        change_Fragment(User_frag);
                        Animation a = loadAnimation(MainActivity.this, R.anim.coustomanim);
                        content.startAnimation(a);
                        return true;

                    case R.id.more:
                        change_Fragment(Caretaker_frag);
                        Animation b = loadAnimation(MainActivity.this, R.anim.coustomanim);
                        content.startAnimation(b);
                        return true;

                    case R.id.sign:
                        change_Fragment(Ownerhs_frag);
                        Animation c = loadAnimation(MainActivity.this, R.anim.coustomanim);
                        content.startAnimation(c);
                        return true;

                }

                return false;


            }






            public boolean onOptionsItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.profile:
                        Toast.makeText(MainActivity.this, "DEVELOPMENT", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.more:
                        Toast.makeText(MainActivity.this, "DESIGN", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.sign:
                        Toast.makeText(MainActivity.this, "MARKING", Toast.LENGTH_SHORT).show();
                        break;
                }


                return MainActivity.super.onOptionsItemSelected(item);
            }

        });
    }

    private void change_Fragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
        fragmentTransaction3.replace(R.id.content_layout, fragment);
        fragmentTransaction3.commit();
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;

    }


}
