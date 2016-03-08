package com.imaginat.justhejist.jist.DBHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by generalassembly on 3/8/16.
 */
public class TopStoryDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "top_story";
    public static final String TABLE_NAME = "top_story_table";
    public static final int DATABASE_VERSION = 1;

    public static final String COL_ID = "_id";
    public static final String COL_SECTION = "section";
    public static final String COL_SUBSECTION = "subsection";
    public static final String COL_ABSTRACT = "abstract";
    public static final String COL_BYLINE = "byline";
    public static final String COL_UPDATE = "updated";
    public static final String COL_CREATED = "created";
    public static final String COL_TITLE = "title";
    public static final String COL_PUBLISHED = "published";
    public static final String COL_KEYWORDS = "keywords";
    public static final String COL_MULTIMEDIA = "multimedia";
    public static final String COL_URL = "url";
    public static final String [] All_COLUMNS = new String[] {COL_ID, COL_SECTION, COL_SUBSECTION, COL_ABSTRACT, COL_BYLINE, COL_UPDATE,
    COL_CREATED, COL_TITLE, COL_PUBLISHED, COL_KEYWORDS, COL_MULTIMEDIA, COL_URL};


    public static final String CREATE = "CREATE TABLE " + DATABASE_NAME
            + " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_SECTION + " TEXT, "
            + COL_SUBSECTION + " TEXT, "
            + COL_ABSTRACT + " TEXT, "
            + COL_BYLINE + " TEXT, "
            + COL_UPDATE + " TEXT, "
            + COL_CREATED + " TEXT, "
            + COL_TITLE + " TEXT, "
            + COL_PUBLISHED + " TEXT, "
            + COL_KEYWORDS + " TEXT, "
            + COL_MULTIMEDIA + " TEXT, "
            + COL_URL + " TEXT)";

    public TopStoryDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public long addStock(ContentValues values){
        SQLiteDatabase db = this.getWritableDatabase();
        long rowAdded = db.insert(TABLE_NAME, null, values);
        db.close();
        return rowAdded;
    }

    public Cursor getAllStocks() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME,
                All_COLUMNS,
                null,
                null,
                null,
                null,
                null,
                null);

        return cursor;
    }

    public Cursor getStockById(String id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME,
                All_COLUMNS,
                COL_ID + " = ?",
                new String[]{id},
                null,
                null,
                null,
                null);

        return cursor;
    }

    public int updateStockById(String id, ContentValues values) {
        SQLiteDatabase db = this.getWritableDatabase();
        int rowsChanged = db.update(TABLE_NAME,
                values,
                COL_ID + " = ?",
                new String[]{id});
        db.close();

        return rowsChanged;
    }

    public Cursor searchArticlesListByTitle (String query) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorSearch = db.query(TABLE_NAME, // a. table
                All_COLUMNS, // b. column names
                COL_TITLE + " LIKE ? ", // c. selections
                new String[]{"%" + query + "%", "%" + query + "%", "%" + query + "%"}, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        return cursorSearch;
    }

    public Cursor searchArticlesListByKeywords (String query) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorSearch = db.query(TABLE_NAME, // a. table
                All_COLUMNS, // b. column names
                COL_KEYWORDS + " LIKE ?", // c. selections
                new String[]{"%" + query + "%", "%" + query + "%", "%" + query + "%"}, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        return cursorSearch;
    }

    public Cursor searchArticlesListBySection (String query) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorSearch = db.query(TABLE_NAME, // a. table
                All_COLUMNS, // b. column names
                COL_SECTION + " LIKE ?", // c. selections
                new String[]{"%" + query + "%", "%" + query + "%", "%" + query + "%"}, // d. selections args
                null, // e. group by
                null, // f. having
                null, // g. order by
                null); // h. limit

        return cursorSearch;
    }
}
