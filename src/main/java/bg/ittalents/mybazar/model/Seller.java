package bg.ittalents.mybazar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import bg.ittalents.mybazar.R;

/**
 * Created by Daskalski on 3/21/17.
 */

public class Seller extends User {

    private ArrayList<Ad> advertisements;

    public Seller(String username, String password) {
        super(username, password);
        this.role = Role.SELLER;
        this.advertisements = new ArrayList<>();
        advertisements.add(new Ad("Obqva 1", "Koito razbira tuka se spira", R.drawable.ad1 , 13.99 , "0876554433"));
        advertisements.add(new Ad("Obqva 2", "Koito ne razbira ai chao", R.drawable.ad2 , 563.99 , "0874558877"));
        advertisements.add(new Ad("Obqva 3", "Koito kakvoto kudeto", R.drawable.ad3 , 99.99 , "0888669955"));
    }

    public List<Ad> getAdvertisements() {
        return Collections.unmodifiableList(advertisements);
    }

}
