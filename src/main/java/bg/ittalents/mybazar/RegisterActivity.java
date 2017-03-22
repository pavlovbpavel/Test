package bg.ittalents.mybazar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import bg.ittalents.mybazar.model.Seller;
import bg.ittalents.mybazar.model.User;
import bg.ittalents.mybazar.model.UsersManager;

public class RegisterActivity extends AppCompatActivity {

    private EditText username;
    private EditText password1;
    private EditText password2;
    private RadioGroup roleGroup;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = (EditText) findViewById(R.id.reg_username);
        password1 = (EditText) findViewById(R.id.reg_password);
        password2 = (EditText) findViewById(R.id.reg_password2);
        register = (Button) findViewById(R.id.reg_button);
        roleGroup = (RadioGroup) findViewById(R.id.role_radio_group);
        roleGroup.check(R.id.role_client);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userTxt = username.getText().toString();
                String pass1Txt = password1.getText().toString();
                String pass2Txt = password2.getText().toString();
                User.Role role = roleGroup.getCheckedRadioButtonId() == R.id.role_client ? User.Role.CLIENT : User.Role.SELLER;

                if(validData(userTxt, pass1Txt, pass2Txt)){
                    User u = role == User.Role.CLIENT ? new User(userTxt, pass1Txt) : new Seller(userTxt, pass1Txt);
                    UsersManager.getInstance().addUser(u);
                    Intent intent = new Intent();
                    intent.putExtra("user", u);
                    setResult(5, intent);
                    finish();
                }
            }
        });
    }

    private boolean validData(String userTxt, String pass1Txt, String pass2Txt) {
        if(userTxt.isEmpty()){
            username.setError("Username cannot be empty");
            username.requestFocus();
            return false;
        }
        if(pass1Txt.isEmpty()){
            password1.setError("Password cannot be empty");
            password1.requestFocus();
            return false;
        }
        if(!pass1Txt.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")){
            password1.setError("Pass must have Minimum 8 characters, at least 1 Alphabet and 1 Number symbol");
            password1.setText("");
            password1.requestFocus();
            return false;
        }
        if(pass2Txt.isEmpty()){
            password2.setError("Please confirm password");
            password2.requestFocus();
            return false;
        }
        if(!pass1Txt.equals(pass2Txt)){
            password1.setError("Passwords do not match");
            password1.setText("");
            password2.setText("");
            password1.requestFocus();
            return false;
        }
        return true;
    }
}
