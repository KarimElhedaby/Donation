package donation.solutions.hamza.com.donation.model;

import com.google.gson.annotations.Expose ;
import com.google.gson.annotations.SerializedName ;

import java.io.Serializable;
import java.util.ArrayList;

public class ImagesResponse implements Serializable {
    @SerializedName("data")
    @Expose
    private ArrayList<Images> data ;
    @SerializedName("page")
    @Expose
    private  int page ;
    @SerializedName("pageCount")
    @Expose
    private  int pageCount;
    @SerializedName("limit")
    @Expose
    private int limit ;
    @SerializedName("totalCount")
    @Expose
    private int totalCount  ;
}