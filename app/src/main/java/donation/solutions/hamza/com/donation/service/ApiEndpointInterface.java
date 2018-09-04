package donation.solutions.hamza.com.donation.service;

import donation.solutions.hamza.com.donation.model.User;
import donation.solutions.hamza.com.donation.model.UserResponce;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiEndpointInterface {

    @POST("signup")
    Call<UserResponce> signUp(@Body User user);

}
