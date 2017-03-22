package bg.ittalents.mybazar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import bg.ittalents.mybazar.model.Ad;

public class EditAdActivity extends AppCompatActivity {

    private TextView editTitle;
    private TextView editDesc;
    private TextView editPrice;
    private TextView editPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_ad);

        Ad ad = (Ad) getIntent().getSerializableExtra("ad");

        editTitle = (TextView) findViewById(R.id.edit_title);
        editDesc = (TextView) findViewById(R.id.edit_desc);
        editPrice = (TextView) findViewById(R.id.edit_price);
        editPhone = (TextView) findViewById(R.id.edit_phone);

        editTitle.setText(ad.getTitle());
        editDesc.setText(ad.getDesc());
        editPrice.setText(ad.getPrice()+"");
        editPhone.setText(ad.getPhone());
    }
}
