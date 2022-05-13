package ru.efimovpavel.entertainigstudy;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import ru.efimovpavel.entertainigstudy.Models.Chapter;
import ru.efimovpavel.entertainigstudy.Models.Theme;

public class ThemeActivity extends AppCompatActivity {
    Chapter chapter;
    Button[] buttons = new Button[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theme_activity);
        Intent intent = getIntent();
        chapter = (Chapter) intent.getSerializableExtra("chapter");
        themeList();
        buttons[0]=findViewById(R.id.one);
        buttons[1]=findViewById(R.id.two);
        buttons[2]=findViewById(R.id.three);
        buttons[3]=findViewById(R.id.four);
        for (int i = 0; i < chapter.themes.length; i++) {
            buttons[i].setText(chapter.themes[i].themeName);
            final Theme theme = chapter.themes[i];
            buttons[i].setOnClickListener(view -> {
                Intent intent1 = new Intent(ThemeActivity.this, LvActivity.class);
                intent1.putExtra("level", theme);
                startActivity(intent1);
            });
        }
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void themeList(){
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00FF88")));
        actionBar.setTitle(chapter.chapterName);
    }

}