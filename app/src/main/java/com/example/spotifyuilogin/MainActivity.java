package com.example.spotifyuilogin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText email,password;
    ImageButton eyeToggle;

    android.widget.Button login,loginwithoutpassword;
    String pass,e;
    boolean show =true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ColorDrawable colorDrawable=new ColorDrawable(Color.parseColor("#121212"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#121212'></font>"));


        email=findViewById(R.id.mail_edit_text);
        password=findViewById(R.id.password_edit_text);
        eyeToggle=findViewById(R.id.password_toggle);
        login=findViewById(R.id.login_btn);
        loginwithoutpassword=findViewById(R.id.login_without_password);

    /*    if(email.requestFocus())
        {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }*/


        eyeToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(show)
                {
                    show=false;
                    eyeToggle.setImageResource(R.drawable.ic_baseline_visibility_off_24);
                    password.setTransformationMethod(new PasswordTransformationMethod());
                }
                else
                {
                    show=true;
                    eyeToggle.setImageResource(R.drawable.ic_baseline_visibility_24);
                    password.setTransformationMethod(null);
                }
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
            }
        });

        loginwithoutpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Login Without Password Is Clicked",Toast.LENGTH_SHORT).show();
            }
        });



        email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                {
                    e="Done";
                    email.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.edit_text_focus_bg));
                    password.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.edit_text_bg));
                }
            }
        });

        password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus)
                {
                    password.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.edit_text_focus_bg));
                    email.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.edit_text_bg));
                }
            }
        });


        password.addTextChangedListener(loginTextWatcher);
        email.addTextChangedListener(loginTextWatcher);




    }

    private TextWatcher loginTextWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            String emailinput,passwordinput;
           emailinput=email.getText().toString().trim();
           passwordinput=password.getText().toString().trim();


            if(!emailinput.isEmpty() && !passwordinput.isEmpty())

            {
                login.setEnabled(true);
                login.setClickable(true);
                login.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.btn_bg_active));
            }
            else
            {
                login.setEnabled(false);
                login.setClickable(false);
                login.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.btn_background));
            }


        /*    if(!e.isEmpty()&& !pass.isEmpty())
            {
                login.setEnabled(true);
                login.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.btn_background));
            }
*/
            //  login.setTextColor(getResources().getColor(R.color.grey))




        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

}