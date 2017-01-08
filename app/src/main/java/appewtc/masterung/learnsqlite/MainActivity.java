package appewtc.masterung.learnsqlite;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private Button singInButton, singUpButton;
    private MyManage myManage;
    private EditText userEditText, passwordEditText ;
    private String userString, passwordString , passwordTrueString, nameString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myManage = new MyManage(MainActivity.this);
        

        bingWidget();
        buttonController();

    }   // Main Method นี่คือเมธอดหลัก

    private void buttonController() {
        //for signUp
        singUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent (MainActivity.this, SignUp.class));
            }
        });
        // For SingIn
        singInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAuthen();

            }
        });


    } // buttonController

    private void checkAuthen() {
        // Get Value
        userString = userEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();

        if (userString.equals("") || passwordString.equals("")) {
            // Have Space
            myDialog(getResources().getString(R.string.haveSpace));
        } else if (checkUser()) {
            // User false
            myDialog(getResources().getString(R.string.userFalse));
        } else if (!passwordString.equals(passwordTrueString)) {
            // Password False
            myDialog(getResources().getString(R.string.passFalse));
        } else {
            // Welcome
            myDialog("Welcome " + nameString);
        }

    } // checkAuthen

    private boolean checkUser() {

        boolean result = true;  // true ==> User False

        try {

            // Connected SQLite
            SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                    MODE_PRIVATE, null);
            // Create Cursor  การเเอาฐานข้อมูล ไปประมวลผลใน แรม
            Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM userTABLE",null);
            cursor.moveToFirst();
            for (int i=0;i<cursor.getCount();i++)   {

                if (userString.equals(cursor.getString(2))) {

                    result = false;
                    passwordTrueString = cursor.getString(3);
                    nameString = cursor.getString(1);

                }
                cursor.moveToNext();
            }   // for



        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;

    }

    private void myDialog(String string) {
        Toast.makeText(MainActivity.this,string, Toast.LENGTH_SHORT).show();

    }

    //คือการผูกความสัมพันธ์ระหว่าง ตัวแปรและ object บน Activity
    private void bingWidget() {

        singInButton = (Button) findViewById(R.id.button);
        singUpButton = (Button) findViewById(R.id.button2);
        userEditText = (EditText) findViewById(R.id.editText4);
        passwordEditText = (EditText) findViewById(R.id.editText5);

    }

}   // Main Class
