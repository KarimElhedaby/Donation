package donation.solutions.hamza.com.donation.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import donation.solutions.hamza.com.donation.R;
import donation.solutions.hamza.com.donation.adapter.DonateDetails_Adapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProjectDetailsFragment extends Fragment {


    @BindView(R.id.projectDetailsRV)
    RecyclerView projectDetailsRV;

    private DonateDetails_Adapter donateDetailsAdapter;


    public static ProjectDetailsFragment newInstance() {
        ProjectDetailsFragment fragment = new ProjectDetailsFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_project_details, container, false);
        ButterKnife.bind(this, view);
        projectDetailsRV.setLayoutManager
                (new GridLayoutManager(getContext()
                        , 2));
        donateDetailsAdapter = new DonateDetails_Adapter(
                R.layout.donate_detailsrow, getContext());
        projectDetailsRV.setAdapter(donateDetailsAdapter);
        return view;
    }
}
