package ru.efimovpavel.entertainigstudy;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import ru.efimovpavel.entertainigstudy.Models.AuthController;
import ru.efimovpavel.entertainigstudy.Models.Chapter;
import ru.efimovpavel.entertainigstudy.Models.Problem;
import ru.efimovpavel.entertainigstudy.Models.Theme;
import ru.efimovpavel.entertainigstudy.Models.ThemeStorage;

public class StartActivity extends AppCompatActivity {
    Button mathbutton;
    Button physicbutton;
    public Chapter[] chapters =new Chapter[2];
    AuthController authController =new AuthController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);
        ThemeStorage themeStorage= new ThemeStorage();
        chapters[0]= new Chapter("МАТЕМАТИКА",new Theme[]{themeStorage.arithmetic, themeStorage.functions, themeStorage.derivatives, themeStorage.planimetry });
       chapters[1]=new Chapter("ФИЗИКА", new Theme[]{themeStorage.kinematic,themeStorage.dynamic,themeStorage.impulse,themeStorage.energy,});
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("ВЫБОР ТЕМЫ");
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00FF88")));
        actionBar.setDisplayHomeAsUpEnabled(true);
        mathbutton=(Button) findViewById(R.id.math);
        mathbutton.setOnClickListener(view -> {
            Intent intent = new Intent(StartActivity.this, ThemeActivity.class);
            intent.putExtra("chapter",chapters[0]);
            startActivity(intent);
        });
        physicbutton=(Button) findViewById(R.id.physic);
        physicbutton.setOnClickListener(view -> {
            Intent intent=new Intent(StartActivity.this, ThemeActivity.class);
            intent.putExtra("chapter", chapters[1]);
            startActivity(intent);
        });
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(StartActivity.this, MainActivity.class);
                startActivity(intent);
                authController.logout();
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
