package donation.solutions.hamza.com.donation.service;

import com.androidnetworking.interceptors.HttpLoggingInterceptor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by karim pc on 1/24/2018.
 */

public class ApiClient {

    //    public static ApiEndpointInterface apiServiceInterface;
    public static final String BASE_URL = "https://donationp.herokuapp.com/";

    private static Retrofit retrofit = null;

    public static Retrofit getClient(AuthInterceptor authInterceptor) {

        OkHttpClient.Builder clientBuilder;
        OkHttpClient client;
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        clientBuilder = new OkHttpClient.Builder()
                .addInterceptor(interceptor);


        clientBuilder.addInterceptor(authInterceptor);

        client = clientBuilder.build();

        if (retrofit == null) {
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
//            apiServiceInterface = retrofit.create(ApiEndpointInterface.class);
        }
        return retrofit;
    }
}
