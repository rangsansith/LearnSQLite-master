package appewtc.masterung.learnsqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private Button singInButton, singUpButton;
    private MyManage myManage;


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

    } // buttonController

    //คือการผูกความสัมพันธ์ระหว่าง ตัวแปรและ object บน Activity
    private void bingWidget() {

        singInButton = (Button) findViewById(R.id.button);
        singUpButton = (Button) findViewById(R.id.button2);

    }

}   // Main Class
