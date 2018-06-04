package br.edu.ifpe.tads.pdm.chatoff;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ErrorCodes;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Arrays;

public class CadastroActivity extends AppCompatActivity {

    public static final int RC_SIGN_IN = 123;

    FirebaseAuth auth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        logarAplicacao();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    public void logarAplicacao(){
        if(!(auth.getCurrentUser() != null)){
            startActivityForResult(
                    AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .setAvailableProviders(Arrays.asList(
                                    new AuthUI.IdpConfig.PhoneBuilder().build()
                            ))
                            .build(),
                    RC_SIGN_IN);
            
        }else
        {
        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // RC_SIGN_IN is the request code you passed into startActivityForResult(...) when starting the sign in flow.
        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            // Successfully signed in
            if (resultCode == RESULT_OK) {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);

                finish();
            } else {
                // Sign in failed
                if (response == null) {
                    // User pressed back button

                    return;
                }


            }
        }
    }

}
