package donation.solutions.hamza.com.donation.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;



import butterknife.BindView;
import butterknife.ButterKnife;
import donation.solutions.hamza.com.donation.R;

public class RegisterActivity extends AppCompatActivity {
    @BindView(R.id.UsernameET)
    EditText UsernameET;
    @BindView(R.id.emailET)
    EditText emailET;
    @BindView(R.id.PasswordET)
    EditText PasswordET;
    @BindView(R.id.CpasswordET)
    EditText CpasswordET;
    @BindView(R.id.genderRG)
    RadioGroup genderRG;
    @BindView(R.id.registerB)
    Button registerB;

    String userName, password, cPassword, gender, email;
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


    }
}

