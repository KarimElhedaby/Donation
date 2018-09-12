package donation.solutions.hamza.com.donation.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import donation.solutions.hamza.com.donation.R;
import donation.solutions.hamza.com.donation.model.UserResponce;
import donation.solutions.hamza.com.donation.utils.MyApplication;

public class ProfileFragment extends Fragment {
    @BindView(R.id.nameTV)
    TextView nameTV;

    @BindView(R.id.mailTV)
    TextView mailTV;
    @BindView(R.id.phoneTV)
    TextView phoneTV;
    @BindView(R.id.logoutB)
    Button logoutB;

    UserResponce userResponce = MyApplication.getPrefManager(getContext()).getUser();
    MyApplication myApplication = new MyApplication() ;

    String name, phone, mail;

    public ProfileFragment() {
        // Required empty public constructor
    }


    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        ButterKnife.bind(this, view);

        name = userResponce.getUser().getName();
        phone = userResponce.getUser().getPhone();
        mail = userResponce.getUser().getEmail();

        mailTV.setText(mail);
        nameTV.setText(name);
        phoneTV.setText(phone);
        logoutB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myApplication.logout();

                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });


        return view;
    }

}

