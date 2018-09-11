package donation.solutions.hamza.com.donation.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import donation.solutions.hamza.com.donation.R;
import donation.solutions.hamza.com.donation.adapter.DonateDetails_Adapter;
import donation.solutions.hamza.com.donation.model.AcceptedProjects;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProjectDetailsFragment extends Fragment {


    @BindView(R.id.projectDetailsRV)
    RecyclerView projectDetailsRV;


    private static AcceptedProjects acceptedProject;
    @BindView(R.id.projectdetailsTitleTV)
    TextView projectdetailsTitleTV;
    @BindView(R.id.projectDescriptionTitleTV)
    TextView projectDescriptionTitleTV;
    @BindView(R.id.projectdetailsDonateNumTV)
    TextView projectdetailsDonateNumTV;

    @BindView(R.id.donateNowBTN)
    Button donateNowBtn;

    private DonateDetails_Adapter donateDetailsAdapter;


    public static ProjectDetailsFragment newInstance(AcceptedProjects project) {
        ProjectDetailsFragment fragment = new ProjectDetailsFragment();
        acceptedProject = new AcceptedProjects(
                project.getDoner(),
                project.getStatus(),
                project.getImg(),
                project.getCreationDate(),
                project.getId(),
                project.getTitle(),
                project.getDesc(),
                project.getUser(),
                project.getV(),
                project.isGoing());

        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_project_details, container, false);
        ButterKnife.bind(this, view);

        projectdetailsTitleTV.setText(acceptedProject.getTitle().toString());
        projectDescriptionTitleTV.setText(acceptedProject.getDesc().toString());
        projectdetailsDonateNumTV.setText("13");


        projectDetailsRV.setLayoutManager
                (new GridLayoutManager(getContext()
                        , 2));
        donateDetailsAdapter = new DonateDetails_Adapter(
                R.layout.donate_detailsrow, acceptedProject.getImg(), getContext());
        projectDetailsRV.setAdapter(donateDetailsAdapter);


        donateNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fm = getFragmentManager();
                DonateNowFragment donateDialog = DonateNowFragment.newInstance(acceptedProject);
                donateDialog.show(fm, "Show fragment");
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
