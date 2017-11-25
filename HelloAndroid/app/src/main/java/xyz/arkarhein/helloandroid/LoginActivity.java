package xyz.arkarhein.helloandroid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Arkar Hein on 11/5/2017.
 */

public class LoginActivity extends AppCompatActivity {

    public static Intent newIntent(Context context){
        Intent intent=new Intent(context,LoginActivity.class);
        return intent;
    }

    private static final String CORRECT_EMAIL = "abc@gmail.com";
    private static final String CORRECT_PASSWORD = "Abcdefg";//Constant Attribute

    private Button btnLogin;
    private EditText etEmailOrPhone;
    private EditText etPassword;
    private TextView btnForgetPassword;
    private TextView btnNewUser;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btn_login);
        etEmailOrPhone = findViewById(R.id.et_email_or_phone);
        etPassword = findViewById(R.id.et_password);
        btnForgetPassword = findViewById(R.id.btn_forget_password);
        btnNewUser = findViewById(R.id.btn_new_user);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG", "Login Button Click");
                String emailOrPhone = etEmailOrPhone.getText().toString();
                String password = etPassword.getText().toString();
                if (TextUtils.isEmpty(emailOrPhone)) {
                    etEmailOrPhone.setError("Email or Phone cannot be empty");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    etPassword.setError("Password cannot be empty");
                    return;
                }

                if (TextUtils.equals(emailOrPhone, CORRECT_EMAIL)
                        && TextUtils.equals(password, CORRECT_PASSWORD)) {
                    //Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_LONG).show();
                    Intent intent = HelloAndroidActivity.newIntent(getApplicationContext());
                    startActivity(intent);
                } else {
                    Snackbar.make(v, "Incorrect Email or Password. Please try again", Snackbar.LENGTH_INDEFINITE).show();
                }


                //Snackbar.make(v, "Login Button Clicked", Snackbar.LENGTH_SHORT).show();

            }
        });

        btnForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "\"Forgot Password\" is coming soon.", Snackbar.LENGTH_INDEFINITE).show();
            }
        });
        btnNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Snackbar.make(v, "Registration Screen coming soon", Snackbar.LENGTH_INDEFINITE).show();
                Intent intent=RegistrationFormActivity.newIntent(getApplicationContext());
                startActivity(intent);
            }
        });
    }
}
