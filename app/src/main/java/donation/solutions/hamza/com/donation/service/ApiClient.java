package donation.solutions.hamza.com.donation.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by karim pc on 1/24/2018.
 */

public class ApiClient {

//    public static ApiEndpointInterface apiServiceInterface;
    public static final String BASE_URL = "https://kolloh.herokuapp.com/";

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit==null) {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
//            apiServiceInterface = retrofit.create(ApiEndpointInterface.class);
        }
        return retrofit;
    }
}
