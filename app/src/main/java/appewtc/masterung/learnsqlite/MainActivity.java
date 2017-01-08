package appewtc.masterung.learnsqlite;

import android.content.Intent;
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
    private EditText userEditText, passwordEditText;
    private String userString, passwordString;


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


        }

    } // checkAuthen

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
