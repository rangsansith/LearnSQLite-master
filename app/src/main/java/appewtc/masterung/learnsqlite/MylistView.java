package appewtc.masterung.learnsqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MylistView extends AppCompatActivity {

    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mylist_view);

        listView = (ListView) findViewById(R.id.livList);

        createListView();

    } // Main Method

    private void createListView() {

        SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE,null);
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FRPM userTABLE", null);
        cursor.moveToFirst();
        String[] nameStrings = new String[cursor.getCount()];
        for (int i=0;i<nameStrings.length;i++) {
            nameStrings[i] = cursor.getString(1);
            cursor.moveToNext();
        }
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(MylistView.this,
                android.R.layout.simple_list_item_1, nameStrings);
        listView.setAdapter(stringArrayAdapter);

    }  // createListView
}  //Main Class
