package com.app.navi.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.app.navi.R;
import com.app.navi.models.Path;
import com.app.navi.viewmodels.PathViewModel;


public abstract class PathListAdapter extends ListAdapter<Path, PathListAdapter.MyViewHolder> {
    protected abstract void findRoute(Double destinationLatitude, double destinationLongitude);
    PathViewModel viewModel;

    public PathListAdapter( PathViewModel viewModel,@NonNull DiffUtil.ItemCallback<Path> diffCallback) {
        super(diffCallback);
        this.viewModel = viewModel;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_path, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Path current = getItem(position);

        holder.title.setText(current.getTitle());
        holder.place.setText(current.getPlaceName());

        holder.delete.setOnClickListener(v -> {
            viewModel.deletePath(current.getId());
        });

        holder.route.setOnClickListener(v -> {
            findRoute(current.getLatitude(), current.getLongitude());
        });


    }

    static public class PathDiff extends DiffUtil.ItemCallback<Path> {

        @Override
        public boolean areItemsTheSame(@NonNull Path oldItem, @NonNull Path newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Path oldItem, @NonNull Path newItem) {
            return oldItem.getTitle().equals(newItem.getTitle());
        }
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        final TextView title;
        final TextView place;
        final ImageView delete;
        final ImageView route;

        private MyViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tvTitle);
            place = itemView.findViewById(R.id.tvPlace);
            delete = itemView.findViewById(R.id.ivDelete);
            route = itemView.findViewById(R.id.tvRoute);
        }


    }
}
