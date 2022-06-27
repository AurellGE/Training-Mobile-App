package com.severianfw.training_mobile.view.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.severianfw.training_mobile.databinding.ItemNbaTeamsBinding;
import com.severianfw.training_mobile.view.data.remote.ResponseItem;

import java.util.List;

public class NbaTeamsAdapter extends RecyclerView.Adapter<NbaTeamsAdapter.ViewHolder> {

    private final List<ResponseItem> nbaTeamItems;

    public NbaTeamsAdapter(List<ResponseItem> nbaTeamItems) {
        this.nbaTeamItems = nbaTeamItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemNbaTeamsBinding binding =
                ItemNbaTeamsBinding.inflate(LayoutInflater.from(parent.getContext()
                ), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(nbaTeamItems.get(position));
    }

    @Override
    public int getItemCount() {
        return nbaTeamItems.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ItemNbaTeamsBinding binding;

        public ViewHolder(@NonNull ItemNbaTeamsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(ResponseItem nbaTeamItems) {
            binding.tvName.setText(nbaTeamItems.getName());
            Glide.with(binding.getRoot())
                    .load(nbaTeamItems.getLogo())
                    .into(binding.ivLogo);
        }
    }
}
