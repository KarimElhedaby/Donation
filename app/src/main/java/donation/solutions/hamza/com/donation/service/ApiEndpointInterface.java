package donation.solutions.hamza.com.donation.service;

import java.util.List;

import donation.solutions.hamza.com.donation.model.AddRequestResponce;
import java.util.ArrayList;

import donation.solutions.hamza.com.donation.model.AcceptedProjects;
import donation.solutions.hamza.com.donation.model.DonateModel;
import donation.solutions.hamza.com.donation.model.DonateResponse;
import donation.solutions.hamza.com.donation.model.HistoryOfDonation;
import donation.solutions.hamza.com.donation.model.RequestDonateHistory;
import donation.solutions.hamza.com.donation.model.User;
import donation.solutions.hamza.com.donation.model.UserResponce;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Path;
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

    @GET("request/history/user/donation")
    Call<ArrayList<HistoryOfDonation>> getDonationHistory();

    @GET("request")
    Call<ArrayList<AcceptedProjects>> getAcceptedProjects();

    @GET("request/history/user/requests")
    Call<ArrayList<RequestDonateHistory>> getRequestDonateHistory();

    @POST("request/{id}/donate")
    Call<DonateResponse> donateSend(@Path("id") String projectId,
                                    @Body DonateModel donateModel);

}
