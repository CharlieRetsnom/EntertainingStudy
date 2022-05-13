package ru.efimovpavel.entertainigstudy;

import android.app.Dialog;
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
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import ru.efimovpavel.entertainigstudy.Models.Problem;


public class ProblemActivity extends AppCompatActivity {
    TextView problemText;
    Button buttonCheck;
    EditText answer;
    Dialog dialog;
    Button dialogButton;
    TextView dialogText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.problem_activity);
        Problem problem = (Problem) getIntent().getSerializableExtra("problem");
        problemText = (TextView) findViewById(R.id.problemText);
        problemText.setText((problem.taskText));
        buttonCheck = (Button) findViewById(R.id.buttonCheck);
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_activity);
        dialog.setCancelable(false);
        dialogButton=(Button) dialog.findViewById(R.id.dialogButton);
        dialogText=(TextView) dialog.findViewById(R.id.dialogText);
        answer=(EditText) findViewById(R.id.answer);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00FF88")));
        actionBar.setTitle("ЗАДАЧА");

        actionBar.setDisplayHomeAsUpEnabled(true);
        buttonCheck.setOnClickListener(view -> {
            if(problem.isCorrectAnswer(answer.getText().toString())){
                dialog.show();
                dialogText.setText("ПРОДОЛЖАЙ В ТОМ ЖЕ ДУХЕ!");
                dialogButton.setText("МЕНЮ");
                dialogButton.setOnClickListener(view1 -> {
                    Intent intent = new Intent(ProblemActivity.this, LvActivity.class);
                    startActivity(intent);
                    finish();
                });
            }
            else{
                dialog.show();
                dialogText.setText("ПОПРОБУЙ ЗАНОВО!");
                dialogButton.setText("ЗАНОВО");
                dialogButton.setOnClickListener(view12 -> dialog.dismiss());
            }

        });
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
}
