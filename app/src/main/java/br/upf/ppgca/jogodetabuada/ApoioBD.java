package br.upf.ppgca.jogodetabuada;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jose on 13/04/15.
 */
public class ApoioBD extends SQLiteOpenHelper{
    private static final String banco = "pontuacao.db";
    private static final int ver = 1;

    public ApoioBD(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, banco, factory, ver);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE pontos(pontos INTEGER);";
        sqLiteDatabase.execSQL(sql);
        sql = "CREATE TABLE recorde(recorde INTEGER);";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {


    }
}
