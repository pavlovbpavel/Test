package bg.ittalents.mybazar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import bg.ittalents.mybazar.model.User;

public class LoginActivity extends AppCompatActivity {

    private Button logAsSellerButton;
    private Button logAsClientButton;
    private Button regButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        logAsClientButton = (Button) findViewById(R.id.login_as_client);//false flag
        logAsClientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, LoginSpecificActivity.class);
                intent.putExtra("role", User.Role.CLIENT.toString());
                startActivity(intent);
            }
        });
        logAsSellerButton = (Button) findViewById(R.id.login_as_seller);//true flag
        logAsSellerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, LoginSpecificActivity.class);
                intent.putExtra("role", User.Role.SELLER.toString());
                startActivity(intent);
            }
        });



        regButton = (Button) findViewById(R.id.go_to_reg_page_button);
        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(LoginActivity.this, RegisterActivity.class), 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //TODO magic happens here
        User user = (User) data.getSerializableExtra("user");
        Intent intent = new Intent(LoginActivity.this, LoginSpecificActivity.class);
        intent.putExtra("user", user);
        startActivity(intent);
    }
}
