package br.edu.ifpe.tads.pdm.chatoff;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import com.firebase.ui.auth.AuthUI;

import java.util.Arrays;

public class CadastroActivity extends AppCompatActivity {

    public static final int RC_SIGN_IN = 1234;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        logarAplicacao();
    }

    @Override
    protected void onResume() {
        super.onResume();
        logarAplicacao();
    }

    public void logarAplicacao(){
        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(Arrays.asList(
                                new AuthUI.IdpConfig.PhoneBuilder().build()
                               ))
                        .build(),
                RC_SIGN_IN);
    }

}
