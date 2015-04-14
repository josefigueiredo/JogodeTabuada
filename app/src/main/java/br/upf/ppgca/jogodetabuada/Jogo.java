package br.upf.ppgca.jogodetabuada;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class Jogo extends Activity {
    private ApoioBD helper;

    protected EditText edtResposta;
    protected TextView txtBase,txtOper,txtPontos;
    protected int respCerta,respDada, base,oper, nivel, contaAcertos = 0;
    private long pontos = 0;
    ImageView fig;


    @Override
    protected void onDestroy() {
       /* int recorde;
        //salva a pontuação no banco na finalização do jogo...
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "SELECT pontos FROM pontos WHERE _id = "+1+";";
        Cursor c = db.rawQuery(sql,null);
        c.moveToFirst();
        recorde = Integer.parseInt(c.getString(0).toString());

        if(pontos > recorde){
            Toast.makeText(this,"Novo recorde: "+recorde,Toast.LENGTH_LONG).show();
            ContentValues valores = new ContentValues();
            valores.put("pontos",pontos);
            db.insert("pontos","",valores);
        }
        c.close();
        db.close();

*/
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);

        //instancia objeto de apoio para acesso ao Banco
        helper = new ApoioBD(this);

        edtResposta = (EditText)findViewById(R.id.edtResposta);
        txtBase = (TextView)findViewById(R.id.txtBase);
        txtOper = (TextView)findViewById(R.id.txtOper);
        txtPontos = (TextView)findViewById(R.id.txtPontos);

        fig = (ImageView)findViewById(R.id.imageView);

        Bundle b = getIntent().getExtras();

        base =  Integer.parseInt(b.get("base").toString());
        nivel = Integer.parseInt(b.get("nivel").toString());
        txtPontos.setText(getResources().getString(R.string.strPontos) + pontos);
        fig.setImageResource(R.drawable.ic_launcher);
        switch (nivel){
            case 1:
                oper = 1;
                txtBase.setText(""+base);
                txtOper.setText(""+oper);

                respCerta = base * oper;
                break;
            case 2:
                Random r = new Random();
                oper = r.nextInt(9)+1;
                txtBase.setText(""+base);
                txtOper.setText(""+oper);

                respCerta = base * oper;
                break;
            case 3:
                Random n3 = new Random();
                oper = n3.nextInt(9)+1;
                base = n3.nextInt(4)+1;

                txtBase.setText(""+base);
                txtOper.setText(""+oper);
                respCerta = base * oper;
                break;

            case 4:
                Random n4 = new Random();
                oper = n4.nextInt(9)+1;
                base = n4.nextInt(8)+1;

                txtBase.setText(""+base);
                txtOper.setText(""+oper);
                respCerta = base * oper;
                break;

            case 5:
                Intent it = new Intent(this,JogoNumeroOculto.class);
                it.putExtra("base",base);
                startActivity(it);
                finish();
                break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.jogo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.menuLimpar) {
            edtResposta.setText("");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void limpar(View v){
        edtResposta.setText("");
    }

    public void responde(View v){
        String resposta = edtResposta.getText().toString();
        if(resposta.equals("")){
            Toast.makeText(this,getResources().getString(R.string.strMsgEmptyResponse),Toast.LENGTH_SHORT).show();
            //limpar(v);
        }else{
            respDada = Integer.parseInt(resposta);
            if(respCerta == respDada){
                //calcula a pontuação acumula valor de nivel * respostaCerta...
                pontos += (nivel * respCerta);
                contaAcertos++;

                //bonus a cada 10 acertos corridos
                if(contaAcertos == 10){
                    Toast.makeText(this,getResources().getString(R.string.strPontos),Toast.LENGTH_SHORT).show();
                    pontos += 100;
                    contaAcertos = 0; //zera contador de acertos
                }
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
                switch(this.nivel){
                    case 1:
                        if (this.oper < 10) {
                            this.oper++;
                            txtOper.setText("" + oper);
                            respCerta = base * oper;
                        } else {
                            this.oper = 1;
                            txtOper.setText("" + oper);
                            respCerta = base * oper;
                        }
                        break;
                    case 2:
                        Random r = new Random();
                        this.oper = r.nextInt(9)+1;
                        txtOper.setText("" + oper);
                        respCerta = base * oper;
                        break;

                    case 3:
                        Random r4 = new Random();
                        this.oper = r4.nextInt(9)+1;
                        txtOper.setText("" + oper);
                        this.base = r4.nextInt(4)+1;
                        txtBase.setText("" + base);

                        respCerta = base * oper;
                        break;

                    case 4:
                        Random r3 = new Random();
                        this.oper = r3.nextInt(9)+1;
                        txtOper.setText("" + oper);
                        this.base = r3.nextInt(8)+1;
                        txtBase.setText("" + base);

                        respCerta = base * oper;
                        break;
                }
            }else{
                //errou a resposta - minion zangado e e som feio
                //calcula a pontuação acumula valor de nivel * respostaCerta...
                pontos -= (nivel * respCerta);

                Random r = new Random();
                int numMiniom = r.nextInt(4)+1;

                    switch(numMiniom){
                    case 1:
                        int t = R.drawable.t1;
                        fig.setImageResource(t);
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
            limpar(v);
            txtPontos.setText(getResources().getString(R.string.strPontos) + pontos);
        }

    }
}
