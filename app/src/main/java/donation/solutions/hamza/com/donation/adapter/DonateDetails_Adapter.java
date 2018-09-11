package donation.solutions.hamza.com.donation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import donation.solutions.hamza.com.donation.R;


public class DonateDetails_Adapter extends RecyclerView.Adapter<DonateDetails_Adapter.VH> {

    private int rowLayout;
    private Context context;
    private List<String> images;

//    private On_allCommunity_ClickListener on_allCommunity_clickListener;

    public static class VH extends RecyclerView.ViewHolder {

        ImageView donateDetailsIV;

        public VH(View v) {
            super(v);
            donateDetailsIV = v.findViewById(R.id.donateDetailsIV);
        }
    }

    public DonateDetails_Adapter(int rowLayout, List<String> imgs, Context context) {

        this.rowLayout = rowLayout;
        this.context = context;
        this.images = imgs;

    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(VH holder, final int position) {
        Glide.with(context).load(images.get(position)).into(holder.donateDetailsIV);


    }

    @Override
    public int getItemCount() {
        return images.size();
    }

}

