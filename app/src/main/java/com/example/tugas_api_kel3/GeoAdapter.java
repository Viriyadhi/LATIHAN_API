package com.example.tugas_api_kel3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GeoAdapter extends RecyclerView.Adapter<GeoAdapter.ListViewHolder> {

    private ArrayList<GeoModel> dataList;
    private OnItemClickListener mListener;
    private Context mContext;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public GeoAdapter(Context mContext, ArrayList<GeoModel> dataList) {
        this.mContext = mContext;
        this.dataList = dataList;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.rv_list, parent, false);
        return new ListViewHolder(view,mListener);
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        holder.tv_title.setText(dataList.get(position).getGeoName());
        holder.tv_region.setText(dataList.get(position).getGeoRegion());
        holder.tv_population.setText(dataList.get(position).getGeoPopulation());
        Glide.with(mContext)
             .load(dataList.get(position).getGeoFlag())
             .into(holder.img_list);


    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_title, tv_region, tv_population;
        private ImageView img_list;
        private RelativeLayout relativeLayout;

        public ListViewHolder(View itemView,final OnItemClickListener listener) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title_list);
            tv_region = itemView.findViewById(R.id.tv_region_list);
            tv_population = itemView.findViewById(R.id.tv_population_list);
            img_list = itemView.findViewById(R.id.img_list);
            relativeLayout = itemView.findViewById(R.id.rv_layout_list);

            relativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}