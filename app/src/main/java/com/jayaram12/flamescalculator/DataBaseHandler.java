package com.jayaram12.flamescalculator;


import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHandler extends SQLiteOpenHelper {
    public DataBaseHandler(@Nullable Context context) {
        super(context, util.DATABASE_NAME,null,util.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_FLAME_TABLE="CREATE TABLE "+util.TABLE_NAME+"("+util.KEY_ID+" INTEGER PRIMARY KEY,"+util.KEY_p1_NAME+" TEXT,"+util.KEY_p2_NAME+" TEXT,"+util.KEY_flames_result+" TEXT,"+util.KEY_IMAGE_ID+" INTEGER)";
        db.execSQL(CREATE_FLAME_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DROP_TABLE=String.valueOf("DROP TABLE IF EXISTS");
        db.execSQL(DROP_TABLE,new String[]{util.DATABASE_NAME});
        onCreate(db);
    }
    public void add_flames_data(flames_class flames){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(util.KEY_p1_NAME,flames.getP1_name());
        values.put(util.KEY_p2_NAME,flames.getP2_name());
        values.put(util.KEY_flames_result,flames.getFlames_result());
        values.put(util.KEY_IMAGE_ID,flames.getImg_id());
        db.insert(util.TABLE_NAME,null,values);

        db.close();
    }
    public List<flames_class> getAll_flames_results(){
        List<flames_class> flames_results_list=new ArrayList<>();
        SQLiteDatabase db=getReadableDatabase();
        String selectAll="SELECT * FROM "+util.TABLE_NAME;
        Cursor cursor=db.rawQuery(selectAll,null);
        if(cursor.moveToFirst())
        {
            do{
                flames_class flames=new flames_class();
                flames.setId(Integer.parseInt(cursor.getString(0)));
                flames.setP1_name(cursor.getString(1));
                flames.setP2_name(cursor.getString(2));
                flames.setFlames_result(cursor.getString(3));
                flames.setImg_id(Integer.parseInt(cursor.getString(4)));
                flames_results_list.add(flames);
            }while(cursor.moveToNext());
        }

        return flames_results_list;
    }
}

