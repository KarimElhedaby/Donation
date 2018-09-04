package donation.solutions.hamza.com.donation.model;

import com.google.gson.annotations.SerializedName;

public class UserResponce {

    @SerializedName("user")
    private User user;

    @SerializedName("token")
    private String token;

    @Override
    public String toString() {
        return "UserResponce{" +
                "user=" + user +
                ", token='" + token + '\'' +
                '}';
    }
}
