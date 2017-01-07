package appewtc.masterung.learnsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private Button singInButton, singUpButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bingWidget();


    }   // Main Method นี่คือเมธอดหลัก

    //คือการผูกความสัมพันธ์ระหว่าง ตัวแปรและ object บน Activity
    private void bingWidget() {


    }

}   // Main Class
