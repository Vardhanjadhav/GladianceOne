package com.example.gladiance.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gladiance.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class LoginActivity extends AppCompatActivity {

    GoogleSignInOptions gso;
    GoogleSignInClient gsc;

    RelativeLayout relativeLayoutGoogleBtn;
    ImageView googleImg;

    //Animation
    Animation topSlideAnimation;
    //View view;

    TextView textViewForgotPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        topSlideAnimation = AnimationUtils.loadAnimation(this,R.anim.top_slide);



        TextView textView = findViewById(R.id.TextView);
        final EditText editTextUserId = findViewById(R.id.editTextUserId);
        final EditText editTextPassword = findViewById(R.id.editTextPassword);
        final Button btnLogin = findViewById(R.id.Loginbtn);

        //View view = findViewById(R.id.screen1);


        btnLogin.setEnabled(false);

        editTextUserId.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable arg0) {
               // Toast.makeText(getApplicationContext(), "Please Enter Username and Password", Toast.LENGTH_SHORT).show();

                boolean isReady = editTextUserId.getText().toString().length() > 2;
                boolean isReady2 = editTextPassword.getText().toString().length() > 2;

                if(isReady && isReady2 == true){
                    enableSubmitIfReady();
                }
            }

            public void enableSubmitIfReady() {

                boolean isReady = editTextUserId.getText().toString().length() > 2;
                boolean isReady2 = editTextPassword.getText().toString().length() > 2;

                btnLogin.setEnabled(isReady && isReady2);

                btnLogin.setBackgroundResource(R.drawable.new_button_bg);

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });

        //

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);
            }
        });

        String completeText = getString(R.string.TermsAndCondition);

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

            }
        };

        // Set the ClickableSpan for the second link
        spannableString.setSpan(firstLinkSpan, startIndex, endIndex, 0);

        // Create a ClickableSpan for the first link
        ClickableSpan secondLinkSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {

            }
        };
        spannableString.setSpan(secondLinkSpan, startIndex2, endIndex2, 0);

        // Set the SpannableString to the TextView
        textView.setText(spannableString);

        // Make the links clickable
        textView.setMovementMethod(LinkMovementMethod.getInstance());

        //Second Link
        String completeText2 = getString(R.string.SignUp);

        TextView textViewLogin = findViewById(R.id.textviewSignup);

        SpannableString spannableString2 = new SpannableString(completeText2);

        // Find the start and end indices of the placeholders
        int startIndex3 = completeText2.indexOf("Sign Up");
        int endIndex3 = startIndex3 + 7; // The length of "%1$s"

        // Create a ClickableSpan for the first link
        ClickableSpan thirdLinkSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);

            }
        };

        // Set the ClickableSpan for the first link
        spannableString2.setSpan(thirdLinkSpan, startIndex3, endIndex3, 0);

        textViewLogin.setText(spannableString2);

        // Make the links clickable
        textViewLogin.setMovementMethod(LinkMovementMethod.getInstance());

        //Forgot password code
        textViewForgotPass = findViewById(R.id.textViewForgotPass);

        findViewById(R.id.textViewForgotPass).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an Intent to start the SecondActivity
                Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });






        // Google Sing in Code

        googleImg = findViewById(R.id.googleImg);

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this, gso);

        googleImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singIn();
            }
        });


    }

    void singIn() {
        Intent signInIntent = gsc.getSignInIntent();
        startActivityForResult(signInIntent, 1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);

            try {
                task.getResult(ApiException.class);
                navigateToSecondActivity();
            } catch (ApiException e) {
                Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        }
    }

    void navigateToSecondActivity() {
        finish();
        Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
        startActivity(intent);
    }

}

//    GoogleSignInOptions gso;
//    GoogleSignInClient gsc;
//
//    RelativeLayout relativeLayoutGoogleBtn;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//
//        TextView textView = findViewById(R.id.TextView);
//         EditText editTextUserId = findViewById(R.id.editTextUserId);
//         EditText editTextPassword = findViewById(R.id.editTextPassword);
//         Button btnLogin = findViewById(R.id.Loginbtn);
//
//        btnLogin.setEnabled(false);
/////////
//        editTextUserId.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void afterTextChanged(Editable arg0) {
//               // Toast.makeText(getApplicationContext(), "Please Enter Username and Password", Toast.LENGTH_SHORT).show();
//
//                enableSubmitIfReady();
//            }
//
//            public void enableSubmitIfReady() {
//
//                boolean isReady = editTextUserId.getText().toString().length() > 3;
//                boolean isReady2 = editTextPassword.getText().toString().length() > 3;
//
//
//
//                btnLogin.setEnabled(isReady && isReady2);
//
//            }
//
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//            }
//        });
//
//       /////
//
//
//
//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        String completeText = getString(R.string.sample_text);
//
//        // Create a SpannableString
//        SpannableString spannableString = new SpannableString(completeText);
//
//        // Find the start and end indices of the placeholders
//        int startIndex = completeText.indexOf("Terms and Conditions");
//        int endIndex = startIndex + 20; // The length of "%1$s"
//
//        int startIndex2 = completeText.indexOf("Privacy Police");
//        int endIndex2 = startIndex2 + 14;
//
//        // Create a ClickableSpan for the first link
//        ClickableSpan firstLinkSpan = new ClickableSpan() {
//            @Override
//            public void onClick(View widget) {
//
//            }
//        };
//
//        // Set the ClickableSpan for the second link
//        spannableString.setSpan(firstLinkSpan, startIndex, endIndex, 0);
//
//        // Create a ClickableSpan for the first link
//        ClickableSpan secondLinkSpan = new ClickableSpan() {
//            @Override
//            public void onClick(View widget) {
//
//            }
//        };
//        spannableString.setSpan(secondLinkSpan, startIndex2, endIndex2, 0);
//
//        // Set the SpannableString to the TextView
//        textView.setText(spannableString);
//
//        // Make the links clickable
//        textView.setMovementMethod(LinkMovementMethod.getInstance());
//
//        // Google Sing in Code
//        relativeLayoutGoogleBtn = findViewById(R.id.relativeLayoutGoogleBtn);
//
//        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
//        gsc = GoogleSignIn.getClient(this, gso);
//
//        relativeLayoutGoogleBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                signIn();
//            }
//        });
//
//
//    }
//
//    void signIn() {
//        Intent signInIntent = gsc.getSignInIntent();
//        startActivityForResult(signInIntent, 1000);
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 1000) {
//            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
//
//            try {
//                task.getResult(ApiException.class);
//                navigateToSecondActivity();
//            } catch (ApiException e) {
//                Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
//
//    void navigateToSecondActivity() {
//        finish();
//        Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
//        startActivity(intent);
//    }
//
//}