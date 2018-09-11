package donation.solutions.hamza.com.donation.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import donation.solutions.hamza.com.donation.R;
import donation.solutions.hamza.com.donation.adapter.Notification_Adapter;
import donation.solutions.hamza.com.donation.model.NotificationResponce;
import donation.solutions.hamza.com.donation.model.UserResponce;
import donation.solutions.hamza.com.donation.service.ApiClient;
import donation.solutions.hamza.com.donation.service.ApiEndpointInterface;
import donation.solutions.hamza.com.donation.service.AuthInterceptor;
import donation.solutions.hamza.com.donation.utils.MyApplication;
import donation.solutions.hamza.com.donation.utils.Utilities;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationFragment extends Fragment {

    @BindView(R.id.notificationRV)
    RecyclerView notificationRV;
    private Notification_Adapter notification_adapter;

    UserResponce user = MyApplication.getPrefManager(getContext()).getUser();


    public NotificationFragment() {
        // Required empty public constructor
    }

    public static NotificationFragment newInstance() {
        NotificationFragment fragment = new NotificationFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notification, container, false);

        ButterKnife.bind(this, view);
        notificationRV.setLayoutManager

                (new LinearLayoutManager(getContext()
                        , LinearLayoutManager.VERTICAL, false));


        Utilities.showLoadingDialog(getContext(), R.color.colorAccent);

        ApiEndpointInterface apiService =
                ApiClient.getClient(new AuthInterceptor(MyApplication.getPrefManager(getContext()).getUser().getToken())).create(ApiEndpointInterface.class);


        Call<ArrayList<NotificationResponce>> call = apiService.getNotifications(user.getUser().getUser_id());
        call.enqueue(new Callback<ArrayList<NotificationResponce>>() {

            @Override
            public void onResponse(Call<ArrayList<NotificationResponce>> call, Response<ArrayList<NotificationResponce>> response) {

                Utilities.dismissLoadingDialog();
                if (response.isSuccessful()) {

                    notification_adapter = new Notification_Adapter(
                            R.layout.notification_list_row, response.body(), getContext());
                    notificationRV.setAdapter(notification_adapter);

                }
            }

            @Override
            public void onFailure(Call<ArrayList<NotificationResponce>> call, Throwable t) {
                Utilities.dismissLoadingDialog();
            }
        });
        return view;
    }

}
