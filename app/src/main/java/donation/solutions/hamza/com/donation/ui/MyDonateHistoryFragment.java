package donation.solutions.hamza.com.donation.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import donation.solutions.hamza.com.donation.R;
import donation.solutions.hamza.com.donation.adapter.DonateHistory_Adapter;
import donation.solutions.hamza.com.donation.model.HistoryOfDonation;
import donation.solutions.hamza.com.donation.service.ApiClient;
import donation.solutions.hamza.com.donation.service.ApiEndpointInterface;
import donation.solutions.hamza.com.donation.service.AuthInterceptor;
import donation.solutions.hamza.com.donation.utils.MyApplication;
import donation.solutions.hamza.com.donation.utils.Utilities;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyDonateHistoryFragment extends Fragment {

    @BindView(R.id.myDonateHistoryRv)
    RecyclerView myDonateHistoryRv;
    private DonateHistory_Adapter donateHistory_adapter;

    public MyDonateHistoryFragment() {
        // Required empty public constructor
    }


    public static MyDonateHistoryFragment newInstance() {
        MyDonateHistoryFragment fragment = new MyDonateHistoryFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_donate_history, container, false);
        ButterKnife.bind(this, view);
        myDonateHistoryRv.setLayoutManager
                (new LinearLayoutManager(getContext()
                        , LinearLayoutManager.VERTICAL, false));


        Utilities.showLoadingDialog(getContext(), R.color.colorAccent);

        ApiEndpointInterface apiService =
                ApiClient.getClient(new AuthInterceptor(MyApplication.getPrefManager(getContext()).getUser().getToken())).create(ApiEndpointInterface.class);

        Call<ArrayList<HistoryOfDonation>> call = apiService.getDonationHistory();

        call.enqueue(new Callback<ArrayList<HistoryOfDonation>>() {
            @Override
            public void onResponse(Call<ArrayList<HistoryOfDonation>> call, Response<ArrayList<HistoryOfDonation>> response) {
                Utilities.dismissLoadingDialog();
                if (response.isSuccessful()) {

                    donateHistory_adapter = new DonateHistory_Adapter(
                            R.layout.donate_history_row, response.body(), getContext());
                    myDonateHistoryRv.setAdapter(donateHistory_adapter);

                }
            }

            @Override
            public void onFailure(Call<ArrayList<HistoryOfDonation>> call, Throwable t) {
                Utilities.dismissLoadingDialog();
            }
        });


        return view;
    }

}
