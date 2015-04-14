package br.upf.ppgca.jogodetabuada;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class JogoNumeroOculto extends Activity {
    protected int base,resp,ocultCerto,ocultResp;
    protected EditText edtOculto;
    protected TextView txtRespOc,txtBaseOc;
    ImageView fig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo_numero_oculto);



        Bundle b = getIntent().getExtras();
        base = Integer.parseInt(b.get("base").toString());

        txtBaseOc = (TextView)findViewById(R.id.txtBaseOc);
        txtRespOc = (TextView)findViewById(R.id.txtRespOc);
        edtOculto = (EditText)findViewById(R.id.edtOculto);
        fig = (ImageView)findViewById(R.id.imageViewOc);


        Random r = new Random();
        ocultCerto = r.nextInt(8)+1;

        resp = base * ocultCerto;

        txtBaseOc.setText(""+base);
        txtRespOc.setText(""+resp);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.jogo_numero_oculto, menu);
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

    public void responde(View v){
        String resposta = edtOculto.getText().toString();
        if(!resposta.isEmpty()){
            ocultResp = Integer.parseInt(resposta);
            if(ocultCerto == ocultResp){
                //acertou a resposta - minion feliz e som bonito
                Random rand = new Random();
                int numMiniom = rand.nextInt(7)+1;

                switch(numMiniom){
                    case 1:
                        fig.setImageResource(R.drawable.f1);
                        MediaPlayer s1 = MediaPlayer.create(getApplicationContext(), R.raw.sucesso1);
                        s1.start();
                        break;
                    case 2:
                        fig.setImageResource(R.drawable.f2);
                        MediaPlayer s2 = MediaPlayer.create(getApplicationContext(), R.raw.sucesso2);
                        s2.start();
                        break;
                    case 3:
                        fig.setImageResource(R.drawable.f3);
                        MediaPlayer s3 = MediaPlayer.create(getApplicationContext(), R.raw.sucesso3);
                        s3.start();
                        break;
                    case 4:
                        fig.setImageResource(R.drawable.f4);
                        MediaPlayer s4 = MediaPlayer.create(getApplicationContext(), R.raw.sucesso4);
                        s4.start();
                        break;
                    case 5:
                        fig.setImageResource(R.drawable.f5);
                        MediaPlayer s5 = MediaPlayer.create(getApplicationContext(), R.raw.sucesso5);
                        s5.start();
                        break;
                    case 6:
                        fig.setImageResource(R.drawable.f6);
                        MediaPlayer s6 = MediaPlayer.create(getApplicationContext(), R.raw.sucesso6);
                        s6.start();
                        break;
                    case 7:
                        fig.setImageResource(R.drawable.f7);
                        MediaPlayer s7 = MediaPlayer.create(getApplicationContext(), R.raw.sucesso7);
                        s7.start();
                        break;
                    case 8:
                        fig.setImageResource(R.drawable.f8);
                        MediaPlayer s8 = MediaPlayer.create(getApplicationContext(), R.raw.sucesso7);
                        s8.start();
                        break;
                }
                Random r = new Random();
                ocultCerto = r.nextInt(8)+1;

                resp = base * ocultCerto;

                txtBaseOc.setText(""+base);
                txtRespOc.setText(""+resp);

            }else{
                //errou a resposta - minion zangado e e som feio
                Random r = new Random();
                int numMiniom = r.nextInt(4)+1;

                switch(numMiniom){
                    case 1:
                        fig.setImageResource(R.drawable.t1);
                        MediaPlayer e1 = MediaPlayer.create(getApplicationContext(), R.raw.erro1);
                        e1.start();
                        break;
                    case 2:
                        fig.setImageResource(R.drawable.t2);
                        MediaPlayer e2 = MediaPlayer.create(getApplicationContext(), R.raw.erro2);
                        e2.start();
                        break;
                    case 3:
                        fig.setImageResource(R.drawable.t3);
                        MediaPlayer e3 = MediaPlayer.create(getApplicationContext(), R.raw.erro3);
                        e3.start();
                        break;
                    case 4:
                        fig.setImageResource(R.drawable.t4);
                        MediaPlayer e4 = MediaPlayer.create(getApplicationContext(), R.raw.erro4);
                        e4.start();
                        break;
                    case 5:
                        fig.setImageResource(R.drawable.t5);
                        MediaPlayer e5 = MediaPlayer.create(getApplicationContext(), R.raw.erro5);
                        e5.start();
                        break;
                }
            }


        }else{
            Toast.makeText(this,getResources().getString(R.string.strMsgEmptyResponse),Toast.LENGTH_SHORT).show();
        }
        limpar(v);

    }

    public void limpar(View v){
        edtOculto.setText("");
    }

}
