package com.example.sport;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "dbfav";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "table_fav";

    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_HOME = "Home";
    private static final String COLUMN_AWAY = "Away";
    private static final String COLUMN_HOMESCORE = "HomeScore";
    private static final String COLUMN_AWAYSCORE = "year";
    private static final String COLUMN_DATE = "Date";
    private static final String COLUMN_IMG = "img";

    private static final String CREATE_TABLE_FAVORITE = "CREATE TABLE " + TABLE_NAME + "(" + COLUMN_TITLE + " TEXT," + COLUMN_HOME + " TEXT," + COLUMN_AWAY + " TEXT," + COLUMN_HOMESCORE + " TEXT)," + COLUMN_AWAYSCORE + " TEXT)," + COLUMN_DATE + " TEXT)," + COLUMN_IMG + " TEXT);";



    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }




    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_FAVORITE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_NAME + "'");
        onCreate(db);

    }

//    public long addFav(String title, String deskripsi, String year, String img) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_TITLE, title);
//        values.put(COLUMN_DESCRIPTION, deskripsi);
//        values.put(COLUMN_YEAR,  year);
//        values.put(COLUMN_IMAGE, img);
//        long insert = db.insert(TABLE_NAME, null, values);
//        return insert;
//
//
//    }
    public void insertData(String title, String Home, String Away, String HomeScore, String AwayScore, String Date, String img) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_TITLE,title);

        contentValues.put(COLUMN_HOME,Home);
        contentValues.put(COLUMN_AWAY,Away);
        contentValues.put(COLUMN_HOMESCORE,HomeScore);
        contentValues.put(COLUMN_AWAYSCORE,AwayScore);
        contentValues.put(COLUMN_DATE,Date);
        contentValues.put(COLUMN_IMG,img);

        db.insert(TABLE_NAME, null, contentValues);

        db.close();

    }
//    public void addFav(Favorite Fav) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_TITLE, Fav.getTitle());
//        values.put(COLUMN_DESCRIPTION, Fav.getDeskripsi());
//        values.put(COLUMN_YEAR, Fav.getTahun());
//        values.put(COLUMN_IMAGE, Fav.getImg());
//        db.insert(TABLE_NAME, null, values);
//        db.close();
//
//
//    }
//    public ArrayList<Favorite> getAllData(){
//        ArrayList<Favorite> favlist = new ArrayList<Favorite>();
//        String selectQuery = "SELECT * FROM " +TABLE_NAME;
//        SQLiteDatabase db =this.getReadableDatabase();
//        Cursor c = db.rawQuery(selectQuery,null);
//
//        if(c.moveToFirst()){
//            do{
//                Favorite fav = new Favorite();
//                fav.setTitle(c.getString(c.getColumnIndex(COLUMN_TITLE)));
//                fav.setDeskripsi(c.getString(c.getColumnIndex(COLUMN_DESCRIPTION)));
//                fav.setTahun(c.getString(c.getColumnIndex(COLUMN_YEAR)));
//                fav.setImg(c.getString(c.getColumnIndex(COLUMN_IMAGE)));
//                favlist.add(fav);
//
//            }while(c.moveToNext());
//        }
//        return favlist;
//    }



//    public void  insertIntoDb(String title, String deskripsi, String tahun,String img){
//        SQLiteDatabase db;
//        db = this.getWritableDatabase();
//        ContentValues cv =new ContentValues();
//        cv.put(COLUMN_TITLE,title);
//        cv.put(COLUMN_DESCRIPTION,deskripsi);
//        cv.put(COLUMN_YEAR, tahun);
//        cv.put(COLUMN_IMAGE, img);
//        db.insert( TABLE_NAME,null,cv);
//        Log.d("DatabaseHelper Status", title + ", favstatus - "+favstatus+"- ." + cv);
//
//    }

//    public Cursor readAlldata(String title){
//        SQLiteDatabase db = this.getReadableDatabase();
//        String sql = "select * from" + TABLE_NAME +"where " + COLUMN_TITLE +"="+title+"";
//        db.execSQL(sql);
//        return db.rawQuery(sql,null,null);
//    }
//
//    public Void removeFav(String title){
//        SQLiteDatabase db = this.getReadableDatabase();
//        String sql = "UPDATE * from" + TABLE_NAME +"SET " + FAVORITE_STATUS +"='0' WHERE" + COLUMN_TITLE +"="+title+"";
//        db.execSQL(sql);
//        Log.d("remove", title.toString());
//    }
//
//    public Cursor readAllfav(){
//        SQLiteDatabase db = this.getReadableDatabase();
//        String sql = "select * from" + TABLE_NAME +"where " + FAVORITE_STATUS +"='1'";
//        return db.rawQuery(sql,null,null);
//    }

}

