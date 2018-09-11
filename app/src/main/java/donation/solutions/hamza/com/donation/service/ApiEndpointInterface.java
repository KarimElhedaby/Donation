package donation.solutions.hamza.com.donation.service;

import java.util.ArrayList;

import donation.solutions.hamza.com.donation.model.AcceptedProjects;
import donation.solutions.hamza.com.donation.model.DonateModel;
import donation.solutions.hamza.com.donation.model.DonateResponse;
import donation.solutions.hamza.com.donation.model.HistoryOfDonation;
import donation.solutions.hamza.com.donation.model.RequestDonateHistory;
import donation.solutions.hamza.com.donation.model.User;
import donation.solutions.hamza.com.donation.model.UserResponce;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiEndpointInterface {

    @POST("signup")
    Call<UserResponce> signUp(@Body User user);

    @POST("login")
    Call<UserResponce> signIn(@Body User user);

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
