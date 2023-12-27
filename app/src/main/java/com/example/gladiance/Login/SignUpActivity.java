package com.example.gladiance.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.gladiance.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class SignUpActivity extends AppCompatActivity {

    Button btnSignUp;

    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    TextView name,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        btnSignUp = findViewById(R.id.btnSignUp);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getApplicationContext(), OTPVerificationActivity.class);
                startActivity(intent);
            }
        });

        String completeText = getString(R.string.TermsAndCondition);

        TextView textView = findViewById(R.id.TextView);

        // Create a SpannableString
        SpannableString spannableString = new SpannableString(completeText);

        // Find the start and end indices of the placeholders
        int startIndex = completeText.indexOf("Privacy Police");
        int endIndex = startIndex + 14; // The length of "%1$s"

        int startIndex2 = completeText.indexOf("User Agreement");
        int endIndex2 = startIndex2 + 14;

        // Create a ClickableSpan for the first link
        ClickableSpan firstLinkSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                // Handle the click action for the first link

            }
        };

        // Set the ClickableSpan for the first link
        spannableString.setSpan(firstLinkSpan, startIndex, endIndex, 0);

        // Create a ClickableSpan for the first link
        ClickableSpan secondLinkSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                // Handle the click action for the first link
            }
        };
        spannableString.setSpan(secondLinkSpan, startIndex2, endIndex2, 0);

        // Set the SpannableString to the TextView
        textView.setText(spannableString);

        // Make the links clickable
        textView.setMovementMethod(LinkMovementMethod.getInstance());

        //second string
        String completeText2 = getString(R.string.Login);

        TextView textViewLogin = findViewById(R.id.textViewLogin);

        SpannableString spannableString2 = new SpannableString(completeText2);

        // Find the start and end indices of the placeholders
        int startIndex3 = completeText2.indexOf("Login");
        int endIndex3 = startIndex3 + 5; // The length of "%1$s"

        // Create a ClickableSpan for the first link
        ClickableSpan thirdLinkSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);

            }
        };

        // Set the ClickableSpan for the first link
        spannableString2.setSpan(thirdLinkSpan, startIndex3, endIndex3, 0);

        textViewLogin.setText(spannableString2);

        // Make the links clickable
        textViewLogin.setMovementMethod(LinkMovementMethod.getInstance());


        //Google sing up code

        name = findViewById(R.id.editTextName);
        email = findViewById(R.id.editTextEmail);

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this,gso);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if(acct!=null){
            String personName = acct.getDisplayName();
            String personEmail = acct.getEmail();
            name.setText(personName);
            email.setText(personEmail);
        }


    }
}