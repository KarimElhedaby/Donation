package donation.solutions.hamza.com.donation.ui;

import butterknife.BindView;

import java.util.ArrayList;

import butterknife.ButterKnife;

import android.Manifest;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import donation.solutions.hamza.com.donation.R;
import donation.solutions.hamza.com.donation.adapter.DonationProjectImagesAdapter;
import gun0912.tedbottompicker.TedBottomPicker;

public class AddDonateProjectDialog extends DialogFragment {

    View view;

    private DonationProjectImagesAdapter donateProject_adapter;

    private ArrayList<Uri> images;

    @BindView(R.id.projectIV)
    ImageView projectIV;

    @BindView(R.id.projectDescET)
    EditText projectDescET;

    @BindView(R.id.projectTitleET)
    EditText projectTitleET;

    @BindView(R.id.doneBTN)
    Button doneBTN;

    @BindView(R.id.donateprojectRV)
    RecyclerView donateProjectRV;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.add_donate_project_dialog, container, false);
        ButterKnife.bind(this, view);


        projectIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CheckUserPermsions();
            }
        });

        doneBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (projectTitleET.getText().toString().equals("")) {
                    Toast.makeText(getContext(), "Please enter project title", Toast.LENGTH_SHORT).show();
                } else if (projectDescET.getText().toString().equals("")) {
                    Toast.makeText(getContext(), "Please enter project descreption", Toast.LENGTH_SHORT).show();
                } else if (images.size() == 0) {
                    Toast.makeText(getContext(), "Please select Project images", Toast.LENGTH_SHORT).show();
                } else {
                    dismiss();
                    Toast.makeText(getContext(), "Done :)", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    void CheckUserPermsions() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE) !=
                    PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{
                                Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE_ASK_PERMISSIONS);
                return;
            }
        }
        OpenImagePicker();
    }

    public void OpenImagePicker() {
        TedBottomPicker bottomSheetDialogFragment = new TedBottomPicker.Builder(getContext())
                .setOnMultiImageSelectedListener(new TedBottomPicker.OnMultiImageSelectedListener() {
                    @Override
                    public void onImagesSelected(ArrayList<Uri> uriList) {
                        // here is selected uri list
                        images = uriList;
                        projectIV.setVisibility(View.GONE);
                        donateProjectRV.setVisibility(View.VISIBLE);
                        donateProjectRV.setLayoutManager
                                (new LinearLayoutManager(getContext()
                                        , LinearLayoutManager.HORIZONTAL, false));
                        donateProject_adapter = new DonationProjectImagesAdapter(
                                R.layout.donate_image_row, getContext(), uriList);
                        donateProjectRV.setAdapter(donateProject_adapter);
                    }
                })
                .setPeekHeight(1600)
                .showTitle(false)
                .setCompleteButtonText("Done")
                .setEmptySelectionText("No Select")
                .create();

        bottomSheetDialogFragment.show(getActivity().getSupportFragmentManager());
    }

    //get access to Storage permsion
    final private int REQUEST_CODE_ASK_PERMISSIONS = 123;

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    OpenImagePicker();// init the contact list
                } else {
                    // Permission Denied
                    Toast.makeText(getContext(), "your message", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
}
