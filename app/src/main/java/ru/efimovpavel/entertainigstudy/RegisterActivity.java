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


public class RegisterActivity extends AppCompatActivity {
    EditText emailRegister, passwordRegister, passwordDoubleRegister;
    Button register;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00FF88")));
        actionBar.setTitle("РЕГИСТРАЦИЯ");
        actionBar.setDisplayHomeAsUpEnabled(true);
        register=(Button) findViewById(R.id.register);
        emailRegister=(EditText) findViewById(R.id.emailRegister);
        passwordRegister=(EditText) findViewById(R.id.passwordRegister);
        passwordDoubleRegister=(EditText) findViewById(R.id.passwordDoubleRegister);


        AuthController authController = new AuthController();
        register.setOnClickListener(view -> {
            String email = emailRegister.getText().toString();
            String password = passwordRegister.getText().toString();
            String confirmPassword = passwordDoubleRegister.getText().toString();
            if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "ВСЕ ПОЛЯ ДОЛЖНЫ БЫТЬ ЗАПОЛНЕНЫ", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!password.equals(confirmPassword)) {
                Toast.makeText(this, "РАЗНЫЕ ПАРОЛИ", Toast.LENGTH_SHORT).show();
                return;
            }
            if(password.length()<6){
                Toast.makeText(this, "ПАРОЛЬ СЛИШКОМ КОРОТКИМ, МИНИМАЛЬНАЯ ДЛИНА 6", Toast.LENGTH_SHORT).show();
                return;
            }
            if(password.length()>12){
                Toast.makeText(this, "ПАРОЛЬ СЛИШКОМ ДЛИННЫЙ, МАКСИМАЛЬНАЯ ДЛИНА 12", Toast.LENGTH_SHORT).show();
                return;
            }
            authController.registerNewUser(email, password, task -> {
                if (task.isSuccessful()) {
                    Toast.makeText(this, task.getResult().getUser().getEmail(), Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                    finish();
                } else
                    Toast.makeText(this, "ОШИБКА РЕГИСТРАЦИИ", Toast.LENGTH_SHORT).show();
            });
        });
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
