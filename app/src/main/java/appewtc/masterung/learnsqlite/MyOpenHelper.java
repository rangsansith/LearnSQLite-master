package appewtc.masterung.learnsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by T.WUT on 1/8/2017.
 */


public class MyOpenHelper extends SQLiteOpenHelper{
    // Explicit ประกาศตัวแปร ศร้าง context

    private Context context;

    public static final String database_name = "Wut.db";
    private static final int database_version = 1;
    private static final String structure_user_table = "create table userTABLE (" +
            "_id integer primary key, " +
            "Name text, " +
            "User test, " +
            "Password text);";


    public MyOpenHelper(Context context) {
        super(context,database_name,null,database_version);
        this.context = context;
    }   // Constructor

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(structure_user_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
} // Main Class
