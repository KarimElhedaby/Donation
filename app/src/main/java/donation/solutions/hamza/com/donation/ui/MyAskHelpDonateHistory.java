package donation.solutions.hamza.com.donation.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import donation.solutions.hamza.com.donation.R;
import donation.solutions.hamza.com.donation.adapter.DonateHistory_Adapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyAskHelpDonateHistory extends Fragment {

    @BindView(R.id.myAskDonateHistoryRv)
    RecyclerView myAskDonateHistoryRv;
    private DonateHistory_Adapter donateHistory_adapter;

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
        donateHistory_adapter = new DonateHistory_Adapter(
                R.layout.donate_history_row, getContext());
        myAskDonateHistoryRv.setAdapter(donateHistory_adapter);
        return view;

    }

}
