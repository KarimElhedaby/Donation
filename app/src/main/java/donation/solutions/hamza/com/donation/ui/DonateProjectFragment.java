package donation.solutions.hamza.com.donation.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import donation.solutions.hamza.com.donation.R;
import donation.solutions.hamza.com.donation.adapter.DonateProject_Adapter;

public class DonateProjectFragment extends Fragment implements DonateProject_Adapter.onProjectClickListner {

    @BindView(R.id.donateprojectRV)
    RecyclerView donateprojectRV;
    private DonateProject_Adapter donateProject_adapter;


    @BindView(R.id.addProjectFBV)
    FloatingActionButton addProjectBTN;

//    private FragmentActivity myContext;
//    android.app.FragmentManager fragManager = myContext.getFragmentManager();


    public static DonateProjectFragment newInstance() {
        DonateProjectFragment fragment = new DonateProjectFragment();
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
        View view = inflater.inflate(R.layout.fragment_donate_project, container, false);

        ButterKnife.bind(this, view);
        donateprojectRV.setLayoutManager
                (new LinearLayoutManager(getContext()
                        , LinearLayoutManager.VERTICAL, false));
        donateProject_adapter = new DonateProject_Adapter(
                R.layout.donateprojectrow, getContext(), this);
        donateprojectRV.setAdapter(donateProject_adapter);

//        donateprojectRV.addOnItemTouchListener(
//                new RecyclerItemClickListener(this, donateprojectRV
//                        , new RecyclerItemClickListener.OnItemClickListener() {
//
//                    @Override
//                    public void onItemClick(View view, int position) {
//
//                        fragManager
//                                .beginTransaction()
//                                .replace(R.id.cointaner, ProjectDetailsFragment.newInstance())
//                                .addToBackStack(null)
//                                .commit();
//                    }
//
//                    @Override
//                    public void onLongItemClick(View view, int position) {
//
//                    }
//                })
//        );


        addProjectBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fm = getFragmentManager();
                AddDonateProjectDialog donateDialog = new AddDonateProjectDialog();
                donateDialog.show(fm, "Show fragment");

            }
        });

        return view;
    }

    @Override
    public void onProjectClickListner() {
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.cointaner, ProjectDetailsFragment.newInstance())
                .addToBackStack(null)
                .commit();
    }
}
