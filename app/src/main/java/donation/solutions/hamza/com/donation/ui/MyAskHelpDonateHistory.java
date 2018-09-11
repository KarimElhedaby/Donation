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
import donation.solutions.hamza.com.donation.adapter.DonateReqHistory_Adapter;
import donation.solutions.hamza.com.donation.model.RequestDonateHistory;
import donation.solutions.hamza.com.donation.service.ApiClient;
import donation.solutions.hamza.com.donation.service.ApiEndpointInterface;
import donation.solutions.hamza.com.donation.service.AuthInterceptor;
import donation.solutions.hamza.com.donation.utils.MyApplication;
import donation.solutions.hamza.com.donation.utils.Utilities;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyAskHelpDonateHistory extends Fragment {

    @BindView(R.id.myAskDonateHistoryRv)
    RecyclerView myAskDonateHistoryRv;
    private DonateReqHistory_Adapter donateHistory_adapter;

    public MyAskHelpDonateHistory() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_myask_help_donate_history, container, false);
        ButterKnife.bind(this, view);
        myAskDonateHistoryRv.setLayoutManager
                (new LinearLayoutManager(getContext()
                        , LinearLayoutManager.VERTICAL, false));

        ArrayList<RequestDonateHistory> donation = new ArrayList<>();


        Utilities.showLoadingDialog(getContext(), R.color.colorAccent);

        ApiEndpointInterface apiService =
                ApiClient.getClient(new AuthInterceptor(MyApplication.getPrefManager(getContext()).getUser().getToken())).create(ApiEndpointInterface.class);

        Call<ArrayList<RequestDonateHistory>> call = apiService.getRequestDonateHistory();

        call.enqueue(new Callback<ArrayList<RequestDonateHistory>>() {
            @Override
            public void onResponse(Call<ArrayList<RequestDonateHistory>> call, Response<ArrayList<RequestDonateHistory>> response) {
                Utilities.dismissLoadingDialog();
                if (response.isSuccessful()) {

                    donateHistory_adapter = new DonateReqHistory_Adapter(
                            R.layout.donate_history_row, response.body(), getContext());
                    myAskDonateHistoryRv.setAdapter(donateHistory_adapter);

                }
            }

            @Override
            public void onFailure(Call<ArrayList<RequestDonateHistory>> call, Throwable t) {
                Utilities.dismissLoadingDialog();
            }
        });

        return view;
    }
}
