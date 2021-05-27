package com.example.vcode;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.vcode.ui.main.SectionsPagerAdapter;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        Button floatBtn=(Button)findViewById(R.id.floatingActionButton);



    }
    public void clkFloat(View view){
        Intent intent=new Intent(getApplicationContext(),Note.class);
        startActivity(intent);
    }
    public void clkcode(View view) {
        gotoUrl("https://www.onlinegdb.com/online_c_compiler");
    }
    private void gotoUrl(String s) {
        Uri uri=Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    public void clk20(View view){
    startActivity(new Intent(getApplicationContext(),Editor.class));
    finish();
}
    public void clk1(View view){
        Intent intent=new Intent(MainActivity.this,Code1.class);
        startActivity(intent);
    }
    public void clk2(View view){
        Intent intent=new Intent(MainActivity.this,Code2.class);
        startActivity(intent);
    }
    public void clk3(View view){
        Intent intent=new Intent(MainActivity.this,Code3.class);
        startActivity(intent);
    }
    public void clk4(View view){
        Intent intent=new Intent(MainActivity.this,Code4.class);
        startActivity(intent);
    }
    public void clk5(View view){
        Intent intent=new Intent(MainActivity.this,Code5.class);
        startActivity(intent);
    }
    public void clk6(View view){
        Intent intent=new Intent(MainActivity.this,Code6.class);
        startActivity(intent);
    }
    public void clk7(View view){
        Intent intent=new Intent(MainActivity.this,Code7.class);
        startActivity(intent);
    }
    public void clk8(View view){
        Intent intent=new Intent(MainActivity.this,Code8.class);
        startActivity(intent);
    }
    public void clk9(View view){
        Intent intent=new Intent(MainActivity.this,Code9.class);
        startActivity(intent);
    }
    public void clk10(View view){
        Intent intent=new Intent(MainActivity.this,Code10.class);
        startActivity(intent);
    }
    public void clk11(View view){
        Intent intent=new Intent(MainActivity.this,Code11.class);
        startActivity(intent);
    }
    public void clk12(View view){
        Intent intent=new Intent(MainActivity.this,Code12.class);
        startActivity(intent);
    }
    public void clk13(View view){
        Intent intent=new Intent(MainActivity.this,Code13.class);
        startActivity(intent);
    }
    public void clk14(View view){
        Intent intent=new Intent(MainActivity.this,Code14.class);
        startActivity(intent);
    }
    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),Login.class));
        finish();

    }


}