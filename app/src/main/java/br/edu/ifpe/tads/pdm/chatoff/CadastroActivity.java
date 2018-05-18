package br.edu.ifpe.tads.pdm.chatoff;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class CadastroActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE =
            "chatoff.pdm.tads.ifpe.edu.br.chatoff.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
    }
    public void sendCadastro(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        EditText editText = (EditText) findViewById(R.id.numero);
        String numero = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, numero);
        startActivity(intent);
    }
}
