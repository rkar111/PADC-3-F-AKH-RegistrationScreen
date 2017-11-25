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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Arkar Hein on 11/12/2017.
 */

public class RegistrationFormActivity extends AppCompatActivity {

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, RegistrationFormActivity.class);
        return intent;
    }

    private TextView btnToLogin;
    private EditText etRegisterName;
    private EditText etRegisterPhone;
    private EditText etRegisterEmail;
    private EditText etRegisterPassword;
    private EditText etRegisterConfirmPassword;
    private EditText etAddress;
    private CheckBox cbIamHere;
    private RadioGroup rgMaleFemale;
    private RadioButton rbtnMale;
    private RadioButton rbtnFemale;
    private Button btnRegister;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registaration_form);

        btnToLogin = findViewById(R.id.btn_to_login);
        etRegisterName = findViewById(R.id.et_register_name);
        etRegisterPhone = findViewById(R.id.et_register_phone);
        etRegisterEmail = findViewById(R.id.et_register_email);
        etRegisterPassword = findViewById(R.id.et_register_password);
        etRegisterConfirmPassword = findViewById(R.id.et_register_confirm_password);
        etAddress = findViewById(R.id.et_address);
        cbIamHere = findViewById(R.id.cb_at_home);
        rgMaleFemale = findViewById(R.id.rg_male_female);
        rbtnMale = findViewById(R.id.rbtn_male);
        rbtnFemale = findViewById(R.id.rbtn_female);
        btnRegister = findViewById(R.id.btn_register);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Register", "Register Button Clicked");
                String name = etRegisterName.getText().toString();
                String phone = etRegisterPhone.getText().toString();
                String email = etRegisterEmail.getText().toString();
                String password = etRegisterPassword.getText().toString();
                String comfirmPassword = etRegisterConfirmPassword.getText().toString();
                String address = etAddress.getText().toString();

                if (TextUtils.isEmpty(name)) {
                    etRegisterName.setError("Name can't be empty.");
                    return;
                }
                if (TextUtils.isEmpty(phone)) {
                    etRegisterPhone.setError("Phone can't be empty.");
                    return;
                }
                if (TextUtils.isEmpty(email)) {
                    etRegisterEmail.setError("Email can't be empty.");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    etRegisterPassword.setError("Password can't be empty.");
                    return;
                }
                if (TextUtils.isEmpty(comfirmPassword)) {
                    etRegisterConfirmPassword.setError("Confirm ur password.");
                    return;
                }
                if (!TextUtils.equals(password, comfirmPassword)) {
                    Snackbar.make(v, "Password not match", Snackbar.LENGTH_INDEFINITE).show();
                    return;
                }
                if (!rbtnMale.isChecked() && !rbtnFemale.isChecked()) {
                    Snackbar.make(v, "Choose Gender", Snackbar.LENGTH_INDEFINITE).show();
                    return;
                }
                if (TextUtils.isEmpty(address)) {
                    etAddress.setError("Fill in your address");
                    return;
                }
                Intent intent = LoginActivity.newIntent(getApplicationContext());
                startActivity(intent);
            }
        });
        btnToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = LoginActivity.newIntent(getApplicationContext());
                startActivity(intent);
            }
        });

    }
}
