package bg.ittalents.mybazar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import bg.ittalents.mybazar.model.Seller;
import bg.ittalents.mybazar.model.User;
import bg.ittalents.mybazar.model.UsersManager;

public class LoginSpecificActivity extends AppCompatActivity {

    private User.Role role;
    private EditText username;
    private EditText password;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_specific);


        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        if(getIntent().getExtras() != null){
            Bundle bagaj = getIntent().getExtras();
            if(bagaj.getString("role") != null){
                role = bagaj.getString("role").equals(User.Role.CLIENT) ? User.Role.CLIENT : User.Role.SELLER;
            }
            else{
                if(bagaj.getSerializable("user") != null){
                    User u = (User) bagaj.getSerializable("user");
                    this.role = u.getRole();
                    this.username.setText(u.getUsername());
                    this.password.setText(u.getPassword());
                }
            }
        }


        login = (Button) findViewById(R.id.loginButton);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userTxt = username.getText().toString();
                String passTxt = password.getText().toString();
                if(validData(userTxt, passTxt)){
                    switch (role){
                        case CLIENT:
                            User user = new User(userTxt, passTxt);
                            Intent i = new Intent(LoginSpecificActivity.this, WelcomeClientActivity.class);
                            i.putExtra("user", user);
                            startActivity(i);
                            break;
                        case SELLER:
                            Seller seller = new Seller(userTxt, passTxt);
                            Intent i2 = new Intent(LoginSpecificActivity.this, WelcomeSellerActivity.class);
                            i2.putExtra("user", seller);
                            startActivity(i2);
                            break;
                    }
                }
            }
        });
    }

    private boolean validData(String userTxt, String passTxt) {
        if(userTxt.isEmpty()){
            username.setError("Username cannot be empty");
            return false;
        }
        if(passTxt.isEmpty()){
            password.setError("Password cannot be empty");
            return false;
        }
        if(!UsersManager.getInstance().validLogin(role, userTxt, passTxt)){
            username.setError("Credentials not valid. Try to register first!");
            return false;
        }
        return true;
    }
}
