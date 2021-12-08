package com.juliardi.dorplas.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.textfield.TextInputLayout;
import com.juliardi.dorplas.R;
import com.juliardi.dorplas.model.login.LoginEmploye;
import com.juliardi.dorplas.model.login.LoginResponse;
import com.juliardi.dorplas.res.ApiClient;
import com.juliardi.dorplas.res.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

   TextInputLayout email_employe,password_employe;
   Button btnLogin;
   Vibrator vibrator;

    Session session;


    ApiService apiService;

   private Long backpresed = 0L;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        email_employe = findViewById(R.id.ti_email);
        password_employe = findViewById(R.id.ti_password);
        btnLogin = findViewById(R.id.btn_login);
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
       // final View BottomSheet = findViewById(R.id.bottomsheet);

        //Menempatkan LinearLayout kedalam BottomSheetBehavior
    //    final BottomSheetBehavior SheetBehavior = BottomSheetBehavior.from(BottomSheet);

        //Set BottomSheet view agar dapat disembunyikan semuanya
      //  SheetBehavior.setHideable(true);



      //  register.setOnClickListener(this);
        btnLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                validate();
                break;
//            case R.id.btn_register:
//
//                break;

        }
    }
    private void validate() {
        final String email = String.valueOf(email_employe.getEditText().getText());
        final String pass = String.valueOf(password_employe.getEditText().getText());

        //checking if email is empty
        if (TextUtils.isEmpty(email)) {
            email_employe.setError("Please enter your email");
            email_employe.requestFocus();

            // Vibrate for 100 milliseconds
            vibrator.vibrate(100);
            btnLogin.setEnabled(true);
            return;
        }

        //checking if password is empty
        if (TextUtils.isEmpty(pass)) {
            password_employe.setError("Please enter your password");
            password_employe.requestFocus();

            //Vibrate for 100 milliseconds
            vibrator.vibrate(100);
            btnLogin.setEnabled(true);
            return;
        }

        login(email,pass);
    }

    private void login(String email, String pass){
        apiService = ApiClient.getApiService();
        Call<LoginResponse> dataLogin = apiService.loginEmploye(email,pass);
        dataLogin.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.isSuccessful()) {

                    session = new Session(LoginActivity.this);
                    LoginResponse login = response.body();
                    session.createLoginSession(login);

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    Toast.makeText(LoginActivity.this, "Berhasil Login", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this,"Gagal Login", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this,t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public void onBackPressed() {
        if(backpresed + 2000 > System.currentTimeMillis()){
            super.onBackPressed();
        }else{
            Toast.makeText(this, "Tekan Sekali lagi untuk keluar", Toast.LENGTH_SHORT).show();
            backpresed = System.currentTimeMillis();
        }
    }
}
