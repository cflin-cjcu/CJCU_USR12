package com.example.cjcu_usr1;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.io.File;
import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder> {

    public PlaceAdapter(List<Place> places) {
        Places = places;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.place_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Place place = Places.get(position);

        String image = place.getP_img();
        String imguri = "file:///android_asset/" + image;

        Glide.with(holder.itemView)
                .load(Uri.parse(imguri))
                .thumbnail(0.2f)
                .into(holder.tv_p_img);
        holder.tv_name.setText(place.getName());
        holder.tv_dist.setText(place.getDist());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), MapsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("P",place);
                intent.putExtras(bundle);
                v.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return Places.size();
    }

    public static class ViewHolder extends  RecyclerView.ViewHolder {
        private final ImageView tv_p_img;
        private final TextView tv_name;
        private final TextView tv_dist;
        public ViewHolder(View itemView) {
            super(itemView);
            tv_p_img = itemView.findViewById(R.id.p_img);
            tv_name = itemView.findViewById(R.id.name);
            tv_dist = itemView.findViewById(R.id.Dist);
        }
    }
    private List<Place> Places;

    private static Uri resourceIdToUri(Context context, int resourceId) {
        return Uri.parse("android.resource://" + context.getPackageName() + "/" + resourceId);
    }


}
