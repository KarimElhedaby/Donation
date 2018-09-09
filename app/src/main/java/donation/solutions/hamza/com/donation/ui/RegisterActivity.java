package donation.solutions.hamza.com.donation.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
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

public class RegisterActivity extends AppCompatActivity {
    @BindView(R.id.UsernameET)
    EditText UsernameET;
    @BindView(R.id.emailET)
    EditText emailET;
    @BindView(R.id.PasswordET)
    EditText PasswordET;
    @BindView(R.id.CpasswordET)
    EditText CpasswordET;
    @BindView(R.id.phoneET)
    EditText phoneET;
    @BindView(R.id.genderRG)
    RadioGroup genderRG;
    @BindView(R.id.registerB)
    Button registerB;

    String userName, password, cPassword, gender, email, phone;
    String gender_index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        genderRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.genderRB1:
                        gender_index = "Male";
                        break;
                    case R.id.genderRB2:
                        gender_index = "Female";
                        break;

                }
            }
        });
        get_EnteredData();
    }

    private void get_EnteredData() {
        userName = UsernameET.getText().toString().trim();
        password = PasswordET.getText().toString().trim();
        cPassword = CpasswordET.getText().toString().trim();
        gender = gender_index;
        email = emailET.getText().toString().trim();
        phone = phoneET.getText().toString().trim();
    }

    @OnClick(R.id.registerB)
    void signUp() {
        get_EnteredData();

        if (userName.isEmpty()) {
            UsernameET.setError(getString(R.string.enter_name));
        } else if (email.isEmpty()) {
            emailET.setError(getString(R.string.enter_email));
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailET.setError(getString(R.string.email_not_formatted));
        }
        else if (!Patterns.PHONE.matcher(phone).matches()) {
            emailET.setError(getString(R.string.phone_format));
        }
        else if (password.isEmpty()) {
            PasswordET.setError(getString(R.string.enter_password));
        } else if (cPassword.isEmpty()) {
            CpasswordET.setError(getString(R.string.enter_cpassword));
        } else if (password.equals(cPassword) != true) {
            CpasswordET.setError(getString(R.string.confirm_pass_error));
        } else if (genderRG.getCheckedRadioButtonId() == -1) {
            Toast.makeText(RegisterActivity.this, R.string.check_gender, Toast.LENGTH_LONG).show();
        } else {
            Utilities.showLoadingDialog(RegisterActivity.this, R.color.colorAccent);
            final User user = new User(userName, email, password, phone);

            ApiEndpointInterface apiService =
                    ApiClient.getClient().create(ApiEndpointInterface.class);

            Call<UserResponce> call = apiService.signUp(user);

            call.enqueue(new Callback<UserResponce>() {
                @Override
                public void onResponse(Call<UserResponce> call, Response<UserResponce> response) {

                    Utilities.dismissLoadingDialog();
                    if (response.isSuccessful()) {
                        MyApplication.getPrefManager(RegisterActivity.this).storeUser(response.body());

                        startActivity(new Intent(RegisterActivity.this,MainActivity.class));
                    }
                }

                @Override
                public void onFailure(Call<UserResponce> call, Throwable t) {
                    Utilities.dismissLoadingDialog();
                    Timber.d(t.getMessage().toString());
                    Toast.makeText(RegisterActivity.this, "some thing went wrong", Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}

