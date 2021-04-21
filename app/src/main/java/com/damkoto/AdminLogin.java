package com.damkoto;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class AdminLogin extends AppCompatActivity {
    private EditText Login_Email,Login_Password;
    private Button Login_Button,Click_SinupButton;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        Login_Email=findViewById(R.id.login_email);
        Login_Password=findViewById(R.id.login_passwword);
        Login_Button=findViewById(R.id.login_button);

        mAuth = FirebaseAuth.getInstance();

        Login_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });
    }

    private void Login() {

        String Email=Login_Email.getText().toString().trim();
        String Password=Login_Password.getText().toString().trim();

        if(Email.isEmpty()){
            Login_Email.setError("Enter Email");
            Login_Email.requestFocus();
            return;
        }
        if(Password.isEmpty()){
            // Toast.makeText(this,"Must not be empty",Toast.LENGTH_LONG).show();
            Login_Password.setError("Enter Password");
            Login_Password.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
            Login_Email.setError("Enter Valid Email Addres");
            Login_Email.requestFocus();
            return;
        }
        if (Password.length()<6) {
            Login_Password.setError("At least 6 Number");
            Login_Password.requestFocus();
        }

        mAuth.signInWithEmailAndPassword(Email, Password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            finish();
                            Intent intent=new Intent(getApplicationContext(),AdminPanel.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);

                        } else {
                            Toast.makeText(getApplicationContext(),"Sign in fail",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}