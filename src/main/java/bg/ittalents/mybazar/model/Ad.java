package bg.ittalents.mybazar.model;

import java.io.Serializable;

/**
 * Created by Daskalski on 3/21/17.
 */

public class Ad implements Serializable{

    private String title;
    private String desc;
    private int imageId;//drawable resource id
    private double price;
    private String phone;

    public Ad(String title, String desc, int imageId, double price, String phone) {
        this.title = title;
        this.desc = desc;
        this.imageId = imageId;
        this.price = price;
        this.phone = phone;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public int getImageId() {
        return imageId;
    }

    public double getPrice() {
        return price;
    }

    public String getPhone() {
        return phone;
    }
}
