package donation.solutions.hamza.com.donation.service;

import java.util.List;

import donation.solutions.hamza.com.donation.model.AddRequestResponce;
import donation.solutions.hamza.com.donation.model.User;
import donation.solutions.hamza.com.donation.model.UserResponce;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiEndpointInterface {

    @POST("signup")
    Call<UserResponce> signUp(@Body User user);

    @POST("login")
    Call<UserResponce> signIn(@Body User user);


    @Multipart
    @POST("request")
    Call<AddRequestResponce> addRequest(
            @Part("title") RequestBody title,
            @Part("desc") RequestBody desc,
            @Part List<MultipartBody.Part> img);

}
