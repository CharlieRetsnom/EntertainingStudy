package ru.efimovpavel.entertainigstudy;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import ru.efimovpavel.entertainigstudy.Models.AuthController;

public class SignIn extends AppCompatActivity {
    Button singInt;
    EditText passwordSingIn, emailSingIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in_activity);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("ВХОД В АККАУНТ");
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00FF88")));
        actionBar.setDisplayHomeAsUpEnabled(true);
        AuthController authController= new AuthController();
       if (authController.isRegistered()) { startActivity(new Intent(SignIn.this, StartActivity.class));
            finish(); }

        singInt =(Button) findViewById(R.id.singIn) ;
        passwordSingIn=(EditText) findViewById(R.id.passwordSingIn);
        emailSingIn=(EditText) findViewById(R.id.emailSingIn);
        singInt.setOnClickListener(view -> {
            String email = emailSingIn.getText().toString();
            String password = passwordSingIn.getText().toString();
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "ЗАПОЛНИТЕ ВСЕ ПОЛЯ", Toast.LENGTH_SHORT).show();
                return;
            }
            authController.signIn(email, password, task -> {
                if (task.isSuccessful()) {
                    Toast.makeText(this, task.getResult().getUser().getEmail(), Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignIn.this, StartActivity.class));
                    finish();
                } else
                    Toast.makeText(this, "ТАКОГО ПОЛЬЗОВАТЕЛЯ НЕТ, ИЛИ ПОЛЯ ЗАПОЛНЕНЫ НЕ ПРАВИЛЬНО", Toast.LENGTH_SHORT).show();
            });
        });
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
    }}
