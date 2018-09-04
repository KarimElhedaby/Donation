package donation.solutions.hamza.com.donation.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by karim on 3/12/18.
 */

public class User implements Serializable {
    @SerializedName("_id")
    @Expose
    private String user_id;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("Gender")
    @Expose
    private String gender;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("img")
    @Expose
    private String Picture;


    public User() {
    }

    public User(String name, String email, String password, String phone) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", Picture='" + Picture + '\'' +
                '}';
    }
}
