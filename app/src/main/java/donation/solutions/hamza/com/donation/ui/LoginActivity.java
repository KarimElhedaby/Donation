package donation.solutions.hamza.com.donation.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import donation.solutions.hamza.com.donation.R;
import donation.solutions.hamza.com.donation.model.User;
import donation.solutions.hamza.com.donation.model.UserResponce;
import donation.solutions.hamza.com.donation.service.ApiClient;
import donation.solutions.hamza.com.donation.service.ApiEndpointInterface;
import donation.solutions.hamza.com.donation.utils.MyApplication;
import donation.solutions.hamza.com.donation.utils.Utilities;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;


public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.LoginemailET)
    EditText emailET;
    @BindView(R.id.LoginPasswordET)
    EditText passwordET;
    @BindView(R.id.loginB)
    Button loginB;
    @BindView(R.id.gmailloginTV)
    TextView gmailloginTV;
    @BindView(R.id.RegisterTV)
    TextView registerTV;
    String password, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        registerTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));

            }
        });
    }

    private void get_EnteredData() {
        password = passwordET.getText().toString().trim();
        phone = emailET.getText().toString().trim();
    }


    @OnClick(R.id.loginB)
    void signIN() {
        Utilities.showLoadingDialog(LoginActivity.this, R.color.colorAccent);
        get_EnteredData();

        User user = new User(phone, password);

        ApiEndpointInterface apiService =
                ApiClient.getClient().create(ApiEndpointInterface.class);

        Call<UserResponce> call = apiService.signIn(user);

        call.enqueue(new Callback<UserResponce>() {
            @Override
            public void onResponse(Call<UserResponce> call, Response<UserResponce> response) {
                Utilities.dismissLoadingDialog();
                if (response.isSuccessful()) {
                    MyApplication.getPrefManager(LoginActivity.this).storeUser(response.body());
                    Timber.d(response.message().toString());
                    Toast.makeText(LoginActivity.this, response.body().toString(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<UserResponce> call, Throwable t) {
                Utilities.dismissLoadingDialog();
                Timber.d(t.getMessage().toString());
                Toast.makeText(LoginActivity.this, "Error in mail or password", Toast.LENGTH_LONG).show();
            }
        });

    }


//    @OnClick(R.id.loginB)
//    public void goHome() {
//        startActivity(new Intent(LoginActivity.this, MainActivity.class));
//    }

}