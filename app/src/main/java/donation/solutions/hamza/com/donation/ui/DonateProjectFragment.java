package donation.solutions.hamza.com.donation.ui;

import android.content.Intent;
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
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import donation.solutions.hamza.com.donation.R;
import donation.solutions.hamza.com.donation.adapter.AcceptedProjectsAdapter;
import donation.solutions.hamza.com.donation.adapter.DonateProject_Adapter;
import donation.solutions.hamza.com.donation.model.AcceptedProjects;
import donation.solutions.hamza.com.donation.service.ApiClient;
import donation.solutions.hamza.com.donation.service.ApiEndpointInterface;
import donation.solutions.hamza.com.donation.service.AuthInterceptor;
import donation.solutions.hamza.com.donation.utils.MyApplication;
import donation.solutions.hamza.com.donation.utils.RecyclerItemClickListener;
import donation.solutions.hamza.com.donation.utils.Utilities;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DonateProjectFragment extends Fragment {

    @BindView(R.id.donateprojectRV)
    RecyclerView donateprojectRV;

    @BindView(R.id.addProjectFBV)
    FloatingActionButton addProjectBTN;

    ArrayList<AcceptedProjects> projects;
    private AcceptedProjectsAdapter acceptedAdapter;

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

        Utilities.showLoadingDialog(getContext(), R.color.colorAccent);

        ApiEndpointInterface apiService =
                ApiClient.getClient(new AuthInterceptor(MyApplication.getPrefManager(getContext()).getUser().getToken())).create(ApiEndpointInterface.class);

        Call<ArrayList<AcceptedProjects>> call = apiService.getAcceptedProjects();

        call.enqueue(new Callback<ArrayList<AcceptedProjects>>() {
            @Override
            public void onResponse(Call<ArrayList<AcceptedProjects>> call, Response<ArrayList<AcceptedProjects>> response) {
                Utilities.dismissLoadingDialog();
                if (response.isSuccessful()) {
                    projects = new ArrayList<>();
                    projects = response.body();

                    acceptedAdapter = new AcceptedProjectsAdapter(
                            R.layout.donate_history_row, response.body(), getContext(), new AcceptedProjectsAdapter.onProjectClickListner() {


                        @Override
                        public void onProjectClickListner(AcceptedProjects project) {
                            getActivity().getSupportFragmentManager()
                                    .beginTransaction()
                                    .replace(R.id.cointaner, ProjectDetailsFragment.newInstance(project))
                                    .addToBackStack(null)
                                    .commit();
                        }
                    });
                    donateprojectRV.setAdapter(acceptedAdapter);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<AcceptedProjects>> call, Throwable t) {
                Utilities.dismissLoadingDialog();
            }
        });

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
}
