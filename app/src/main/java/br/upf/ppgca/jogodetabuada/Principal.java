package br.upf.ppgca.jogodetabuada;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class Principal extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void nivel1(View v){
        Intent it = new Intent(this,EscolhaBase.class);
        it.putExtra("nivel",1);
        startActivity(it);
    }

    public void nivel2(View v){
        Intent it = new Intent(this,EscolhaBase.class);
        it.putExtra("nivel",2);
        startActivity(it);
    }

    public void nivel3(View v){
        Intent it = new Intent(this,Jogo.class);
        it.putExtra("nivel",3);
        it.putExtra("base",2);
        startActivity(it);
    }
    public void nivel4(View v){
        Intent it = new Intent(this,Jogo.class);
        it.putExtra("nivel",4);
        it.putExtra("base",2);
        startActivity(it);
    }
    public void nivel5(View v){
        Intent it = new Intent(this,EscolhaBase.class);
        it.putExtra("nivel",5);
        startActivity(it);
    }
}
