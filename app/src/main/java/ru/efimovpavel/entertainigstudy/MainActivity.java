package ru.efimovpavel.entertainigstudy;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ru.efimovpavel.entertainigstudy.Models.AuthController;

public class MainActivity extends AppCompatActivity {


    Button registerbutton;
    Button singInButton;
    Button exit;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AuthController authController= new AuthController();
        singInButton=(Button) findViewById(R.id.singInButton);
        singInButton.setOnClickListener(v -> {
            Intent intent= new Intent(MainActivity.this, SignIn.class);
            startActivity(intent);
            finish();
        });




        exit=(Button) findViewById(R.id.exitButton);
        exit.setOnClickListener(v -> System.exit(0));
        registerbutton=(Button) findViewById(R.id.registerButton);
        registerbutton.setOnClickListener(v -> {
            Intent intent= new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intent);
            finish();
        });
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);




    }


}