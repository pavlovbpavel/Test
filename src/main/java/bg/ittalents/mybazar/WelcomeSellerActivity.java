package bg.ittalents.mybazar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import bg.ittalents.mybazar.model.Ad;
import bg.ittalents.mybazar.model.Seller;
import bg.ittalents.mybazar.model.User;

public class WelcomeSellerActivity extends AppCompatActivity {

    private Seller loggedUser;
    private TextView welcome;
    private ImageView add1Image;
    private TextView add1Title;
    private TextView add1Desc;
    private TextView add1Price;
    private TextView add1Phone;
    private Button add1Edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_seller);

        if(getIntent().getSerializableExtra("user")!= null){
            loggedUser = (Seller) getIntent().getSerializableExtra("user");
        }
        welcome = (TextView) findViewById(R.id.welcome_tv);
        welcome.setText("Welcome, " + loggedUser.getUsername() + " ( logged as " +loggedUser.getRole().toString()+ ")");

        add1Title = (TextView) findViewById(R.id.add1_title);
        add1Image = (ImageView) findViewById(R.id.add1_image);
        add1Desc = (TextView) findViewById(R.id.add1_desc);
        add1Price = (TextView) findViewById(R.id.add1_price);
        add1Phone = (TextView) findViewById(R.id.add1_phone);
        add1Edit = (Button) findViewById(R.id.add1_edit);

        add1Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeSellerActivity.this, EditAdActivity.class);
                intent.putExtra("ad", loggedUser.getAdvertisements().get(0));
                startActivityForResult(intent, 1);
            }
        });

        Ad ad = loggedUser.getAdvertisements().get(0);
        add1Title.setText(ad.getTitle());
        add1Image.setImageResource(ad.getImageId());
        add1Desc.setText(ad.getDesc());
        add1Price.setText(ad.getPrice()+"");
        add1Phone.setText(ad.getPhone());

    }
}
