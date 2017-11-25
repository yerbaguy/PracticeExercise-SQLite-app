package com.yerbaguy.practiceexercise;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.IOException;
import java.lang.String;

import java.util.Random;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by root on 17.11.17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {


    private static final String DB_NAME = "sqlitedatabaseexample.db";
    private static final int DB_VERSION = 1;


    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String sqlWord = "CREATE TABLE Word(id INTEGER PRIMARY KEY AUTOINCREMENT, engword VARCHAR(200) NOT NULL, plword VARCHA(200) NOT NULL)";
      //  String sqlRandPl = "CREATE TABLE RandPl(id INTEGER PRIMARY KEY AUTOINCREMENT, randPlWord INTEGER)";
      //  String sqlRandPl = "CREATE TABLE RandPl(id INTEGER PRIMARY KEY AUTOINCREMENT, randPlWord TEXT)";
        String sqlRandPl = "CREATE TABLE RandPl(id INTEGER PRIMARY KEY AUTOINCREMENT, randPlWord VARCHAR(200) NOT NULL)";

        sqLiteDatabase.execSQL(sqlWord);
        sqLiteDatabase.execSQL(sqlRandPl);

    }

    public boolean addWord(String engword, String plword) {

        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put("engword", engword);
        contentValues.put("plword", plword);

        db.insert("Word", null, contentValues);

        db.close();

        return true;
    }

    public int countRows() {

        SQLiteDatabase db = this.getWritableDatabase();

        //  String countQuery = "SELECT COUNT(*) FROM Word";


        // Cursor cursor = db.rawQuery(countQuery, null);
        Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM Word", null);

        cursor.moveToFirst();
        // int cnt = cursor.getCount();
  //      int count = cursor.getInt(0);
        int count = cursor.getInt(0);

        cursor.close();


        // return cnt;
        return count;
   //     return result;
    }


 //   public void removeLine() {

 //       SQLiteDatabase db = this.getWritableDatabase();

 //       Cursor cursor = db.rawQuery("DELETE FROM Word WHERE id = 3", null);
 //       cursor = db.rawQuery("UPDATE SQLITE SEQUENCE SET SEQ = 2 WHERE NAME = '" + Word +"'");

 //       cursor.close();
 //   }



    public int countRandom() {

        //Random random = new Random();



        int countrows = this.countRows() + 1;

        int min = 1;
        int max = countrows;



        Random random = new Random();

       // int n = random.nextInt(countrows) + 1;
        int n1 = random.nextInt(max - min + 1) + min;

        //insertCountRandomIntoRandPl(n);
        updateCountRandomIntoRandPl(n1);

        return n1;

    }

    public void insertCountRandomIntoRandPl(int n) {

        SQLiteDatabase db = getWritableDatabase();

       // SQLiteDatabase db = db.openOrCreateDatabase();

        db.execSQL("CREATE TABLE IF NOT EXISTS RandPl(id INTEGER PRIMARY KEY AUTOINCREMENT,randPlWord INTEGER)");



        String insertcountrandomintorandpl = "INSERT INTO RandPl(id,randPlWord) VALUES (" + n + ")";

        db.execSQL(insertcountrandomintorandpl);

        db.close();


        //return true;
    }

    //public void updateCountRandomIntoRandPl(int n1) {
    public int updateCountRandomIntoRandPl(int n1) {


        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        try {

            // cv.put("randPlWord", "4");
            cv.put("randPlWord", n1);

            // return db.update("RandPl", cv, "id =" + n1, null);
           // return db.update("RandPl", cv, "id = ?", new String[]{"1"});
        } catch (Exception e) {

          //  Log.e("updateCount", "Error");
            e.getMessage();
            e.printStackTrace();

        }

        return db.update("RandPl", cv, "id = ?", new String[]{"1"});

       // db.update("RandPl", cv, "randPlWord = " + n1, null) ;

 //       db.update("RandPl", cv, "id = ?", new String[] { "1"});

  //      String update = "UPDATE RandPl SET randPlWord = 4 WHERE id = 1";

  //      db.execSQL(update);


      //  String updateQuery = "UPDATE RandPl SET randPlWord = " + n1 ;

      //  Cursor cursor = db.rawQuery(updateQuery, null);


        //Cursor cursor = db.rawQuery("update RandPL set randPlWord = " + n1 + ",where id = 1", null);

      //  cursor.moveToFirst();
      //  cursor.close();

      //  db.execSQL("UPDATE RandPl SET randPlWord = " + n1 + " WHERE id = 1");

       // String updatecountrandomintorandpl = "UPDATE RandPl SET randPlWord = " + n + " WHERE id = 1";
//        String updatecountrandomintorandpl = "UPDATE RandPl SET randPlWord = " + n1 + " WHERE id = 1";

        //String updatecountrandomintorandpl = "UPDATE RandPl SET randPlWord = 4 WHERE id = 1";


//        db.execSQL(updatecountrandomintorandpl);





      //  db.close();

    }


    public void anotherUpdate() {

        SQLiteDatabase db = getWritableDatabase();

        String updateString = "UPDATE RandPl SET randPlWord = 4 WHERE id = 1";

        db.execSQL(updateString);


    }


    public int getIdOfPlWord() {

        SQLiteDatabase db = getWritableDatabase();

        int randplword = 1;

        Cursor cursor = db.rawQuery("SELECT randPlWord FROM RandPl WHERE id = 1", null);

        if (cursor.moveToFirst()) {

            randplword = cursor.getInt(cursor.getColumnIndex("randPlWord"));
        }

        return randplword;

    }

//    public void checkRandPl() {

//        SQLiteDatabase db = getReadableDatabase();

//        int randplword = 1;

//        Cursor cursor = db.rawQuery("SELECT randPlWord FROM RandPl WHERE id = 1", null);

//        if (cursor.moveToFirst()) {

//            randplword = cursor.getInt(cursor.getColumnCount("randPlWord"));

//            if (randplword == 0) {


//            }
//        }

//    }

    public String getPLWord() {

        SQLiteDatabase db = getReadableDatabase();

        int randplword = 1;


        randplword = this.getIdOfPlWord();
      //  Integer[] randplword = new Integer[]{1};


        String plwordd = "";



      //  String getplword = "SELECT plword FROM Word WHERE id = '" + randplword + "'";

        //Cursor cursor = db.rawQuery("getplword", null);
       // Cursor cursor = db.rawQuery("SELECT plword FROM Word WHERE id = '" + randplword + "'", null);
       // Cursor cursor = db.rawQuery("SELECT plword FROM Word WHERE id = 1", null); // ok
        Cursor cursor = db.rawQuery("SELECT plword FROM Word WHERE id =  " + randplword , null );

        if (cursor.moveToFirst()) {

            plwordd = cursor.getString(cursor.getColumnIndex("plword"));
        }
       // String word = "lkajsdf";
        cursor.close();
        //db.close();

        return plwordd;
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        String sqlWord = "DROP TABLE IF EXISTS Word";
        String sqlRandPl = "DROP TABLE IF EXISTS RandPl";

        sqLiteDatabase.execSQL(sqlWord);
        sqLiteDatabase.execSQL(sqlRandPl);

        onCreate(sqLiteDatabase);

    }
}
