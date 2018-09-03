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
import donation.solutions.hamza.com.donation.adapter.Notification_Adapter;

public class NotificationFragment extends Fragment {

    @BindView(R.id.notificationRV)
    RecyclerView notificationRV;
    private Notification_Adapter notification_adapter;

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
        notification_adapter = new Notification_Adapter(
                R.layout.notification_list_row, getContext());
        notificationRV.setAdapter(notification_adapter);
        return view;
    }

}
