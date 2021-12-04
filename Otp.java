package com.example.vaapkaaaaa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

public class Otp extends AppCompatActivity {
    Button b1;
    FirebaseAuth firebaseAuth;
    EditText e1;
    String phone;
    String otp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        phone=getIntent().getStringExtra("Mobile").toString();
        b1=(Button)findViewById(R.id.button2);
        e1=(EditText)findViewById(R.id.editText2);
        firebaseAuth=FirebaseAuth.getInstance();
        genotp();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(e1.getText().toString().isEmpty())
                {
                    Toast.makeText(Otp.this, "Please Enter OTP", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(e1.getText().toString().length()!=6)
                    {
                        Toast.makeText(Otp.this, "Invalid OTP", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        PhoneAuthCredential credential= PhoneAuthProvider.getCredential(otp,e1.getText().toString());
                        signInWithPhoneAuthCredential(credential);
                    }
                }
            }
        });

    }private void genotp()
    {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phone,
                60,
                TimeUnit.SECONDS,
                this,
                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onCodeSent(@NonNull @NotNull String s, @NonNull @NotNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        super.onCodeSent(s, forceResendingToken);
                        otp=s;

                    }

                    @Override
                    public void onVerificationCompleted(@NonNull @org.jetbrains.annotations.NotNull PhoneAuthCredential phoneAuthCredential)
                    {
                        signInWithPhoneAuthCredential(phoneAuthCredential);
                    }

                    @Override
                    public void onVerificationFailed(@NonNull @org.jetbrains.annotations.NotNull FirebaseException e)
                    {
                        Toast.makeText(Otp.this, "OTP Mismatched", Toast.LENGTH_SHORT).show();
                    }
                }


        );
    }private void signInWithPhoneAuthCredential(PhoneAuthCredential credential)
    {
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(Otp.this, "Login Done", Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(Otp.this,Selection.class);
                    startActivity(i);
                    finish();
                }
                else
                {
                    Toast.makeText(Otp.this, "Not Done", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}