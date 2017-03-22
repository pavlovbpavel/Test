package bg.ittalents.mybazar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import bg.ittalents.mybazar.model.User;

public class WelcomeClientActivity extends AppCompatActivity {

    private User loggedUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_client);

        if(getIntent().getSerializableExtra("user")!= null){
            loggedUser = (User) getIntent().getSerializableExtra("user");
        }
    }
}
