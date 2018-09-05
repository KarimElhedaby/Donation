package donation.solutions.hamza.com.donation.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import donation.solutions.hamza.com.donation.R;


public class DonationProjectImagesAdapter extends RecyclerView.Adapter<DonationProjectImagesAdapter.VH> {

    private int rowLayout;
    private Context context;
    private ArrayList<Uri> images;

    public static class VH extends RecyclerView.ViewHolder {

        private ImageView image;


        public VH(View v) {
            super(v);
            image = v.findViewById(R.id.donateImageIV);

        }
    }

    public DonationProjectImagesAdapter(int rowLayout, Context context, ArrayList<Uri> uriList) {

        this.rowLayout = rowLayout;
        this.context = context;
        this.images = uriList;


    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(VH holder, final int position) {

        Glide.with(context).load(images.get(position)).into(holder.image);
        //holder.image.setImageURI(images.get(position));
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

}

