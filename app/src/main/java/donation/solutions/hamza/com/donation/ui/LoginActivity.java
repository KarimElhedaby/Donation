package donation.solutions.hamza.com.donation.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import donation.solutions.hamza.com.donation.MainActivity;
import donation.solutions.hamza.com.donation.R;


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

    String password, email;

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
        email = emailET.getText().toString().trim();
    }

    @OnClick(R.id.loginB)
    public void goHome() {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
    }

}