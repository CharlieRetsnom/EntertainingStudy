package ru.efimovpavel.entertainigstudy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import ru.efimovpavel.entertainigstudy.Models.Problem;
import ru.efimovpavel.entertainigstudy.Models.Theme;


public class LvActivity extends AppCompatActivity {
    Theme theme;


    @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.lv_activity);
       Intent intent = getIntent();
        theme=(Theme) intent.getSerializableExtra("level");
        themeList();
        GridLayout gridLayout= findViewById(R.id.gridlay);
        for (int i = 0; i < theme.problems.length; i++) {
           final Problem problem = theme.problems[i];
           final  GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
           final Button button = new Button(this);
           button.setText(i+1+"");
           button.setBackgroundResource(R.drawable.button_style);
           layoutParams.width=200;
           layoutParams.height=200;
           layoutParams.setMargins(35, 60, 35, 60 );
            button.setOnClickListener(view -> {
               Intent intent1 =new Intent(LvActivity.this, ProblemActivity.class);
               intent1.putExtra("problem", problem);
               startActivity(intent1);
           });
           gridLayout.addView(button, layoutParams);
       }
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
   }

   @Override
   public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       switch (item.getItemId()) {
           case android.R.id.home:
               this.finish();
               return true;
       }
       return super.onOptionsItemSelected(item);
   }

   public void themeList(){
       ActionBar actionBar = getSupportActionBar();
       actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00FF88")));
       actionBar.setDisplayHomeAsUpEnabled(true);
       actionBar.setTitle(theme.themeName);
   }

}