package appewtc.masterung.learnsqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    //Explicit
    private EditText nameEditText, userEditText, passwordEditText;
    private Button button;
    private String nameString, userString, passwordString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        bindWidget();

        buttonController();

    }   // Main Method

    private void buttonController() {

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get Value From Edit Text
                nameString = nameEditText.getText().toString().trim();
                        // ตัดช่องว่างหน้า  to.string เป็น datatype เป็น string
                userString = userEditText.getText().toString().trim();
                passwordString = passwordEditText.getText().toString().trim();

                // Check Space
                if (nameString.equals("") || userString.equals("") || passwordString.equals(""))  {
                    // "" เป็น ค่า null
                    // || เป็น ค่า or
                    // Have Space
                    Toast.makeText(SignUp.this,
                            getResources().getString(R.string.haveSpace),
                            Toast.LENGTH_SHORT).show();

                } else {
                    // No Space
                    MyManage myManage = new MyManage(SignUp.this);
                    myManage.addNewValue(nameString, userString, passwordString);
                    finish();


                }   // if

            }   // onClick
        });

    }  // buttonController

    private void bindWidget() {

        nameEditText = (EditText) findViewById(R.id.editText);
        userEditText = (EditText) findViewById(R.id.editText2);
        passwordEditText = (EditText) findViewById(R.id.editText3);
        button = (Button) findViewById(R.id.button3);

    }

}   // Main Class