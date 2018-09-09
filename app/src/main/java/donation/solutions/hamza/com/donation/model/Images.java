package donation.solutions.hamza.com.donation.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Images implements Serializable {

    @SerializedName("creationDate")
    @Expose
    private String creationDate;

    @SerializedName("imgs")
    private String imgs;
    @SerializedName("id")
    private int id;
}