package br.edu.ifpe.tads.pdm.chatoff;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int x = 2;
       if(x == 2){
           Intent intent = new Intent(this, CadastroActivity.class);
           intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
           intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
           startActivity(intent);
           finish();
       }else{
           setContentView(R.layout.activity_main);
           Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
           setSupportActionBar(toolbar);

           TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
           tabLayout.addTab(tabLayout.newTab().setText("Mensagens"));
           tabLayout.addTab(tabLayout.newTab().setText("Contatos"));
           tabLayout.addTab(tabLayout.newTab().setText("Perfil"));
           tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

           final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
           final AdaptadorPagina adapter = new AdaptadorPagina
                   (getSupportFragmentManager(), tabLayout.getTabCount());
           viewPager.setAdapter(adapter);
           viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
           tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
               @Override
               public void onTabSelected(TabLayout.Tab tab) {
                   viewPager.setCurrentItem(tab.getPosition());
               }

               @Override
               public void onTabUnselected(TabLayout.Tab tab) {

               }

               @Override
               public void onTabReselected(TabLayout.Tab tab) {

               }
           });
       }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    /** Abre conversa */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, MensagemActivity.class);
        //EditText editText = (EditText)findViewById(R.id.editText);
        // String message = editText.getText().toString();
        // intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}