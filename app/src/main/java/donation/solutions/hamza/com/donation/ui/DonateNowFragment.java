package donation.solutions.hamza.com.donation.ui;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import donation.solutions.hamza.com.donation.R;
import donation.solutions.hamza.com.donation.model.AcceptedProjects;
import donation.solutions.hamza.com.donation.model.DonateModel;
import donation.solutions.hamza.com.donation.model.DonateResponse;
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
public class DonateNowFragment extends DialogFragment {


    private static AcceptedProjects acceptedProject;
    @BindView(R.id.priceET)
    EditText priceET;
    @BindView(R.id.descET)
    EditText descET;
    @BindView(R.id.donateBTN)
    Button donateBTN;


    public static DonateNowFragment newInstance(AcceptedProjects project) {
        DonateNowFragment fragment = new DonateNowFragment();
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

    @OnClick(R.id.donateBTN)
    public void onViewClicked() {

        if (priceET.getText().toString().isEmpty()) {
            Toast.makeText(getContext(), R.string.price, Toast.LENGTH_SHORT).show();
        } else if (descET.getText().toString().isEmpty()) {
            Toast.makeText(getContext(), R.string.description, Toast.LENGTH_SHORT).show();
        } else {
            DonateModel model = new DonateModel(Integer.parseInt(priceET.getText().toString()), descET.getText().toString());
            Utilities.showLoadingDialog(getContext(), R.color.colorAccent);

            ApiEndpointInterface apiService =
                    ApiClient.getClient(new AuthInterceptor(MyApplication.getPrefManager(getContext()).getUser().getToken())).create(ApiEndpointInterface.class);

            Call<DonateResponse> call = apiService.donateSend(acceptedProject.getId().toString(), model);

            call.enqueue(new Callback<DonateResponse>() {
                @Override
                public void onResponse(Call<DonateResponse> call, Response<DonateResponse> response) {
                    Utilities.dismissLoadingDialog();
                    if (response.isSuccessful()) {
                        Toast.makeText(getContext(), R.string.thank, Toast.LENGTH_SHORT).show();
                        dismiss();
                    }
                }

                @Override
                public void onFailure(Call<DonateResponse> call, Throwable t) {
                    Utilities.dismissLoadingDialog();
                    Toast.makeText(getContext(), t.getMessage().toString(), Toast.LENGTH_SHORT).show();
                    dismiss();
                }
            });
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.donate_now_fragment, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


}
