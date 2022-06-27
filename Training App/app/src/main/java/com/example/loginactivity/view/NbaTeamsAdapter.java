package com.example.loginactivity.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.loginactivity.data.remote.Response;
import com.example.loginactivity.data.remote.ResponseItem;
import com.example.loginactivity.databinding.NbaTeamItemsBinding;

import java.util.List;

public class NbaTeamsAdapter extends RecyclerView.Adapter<NbaTeamsAdapter.ViewHolder> {

    private final List<ResponseItem> nbaTeamItems;

    public NbaTeamsAdapter(List<ResponseItem> nbaTeamItems) {
        this.nbaTeamItems = nbaTeamItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        NbaTeamItemsBinding binding =
                NbaTeamItemsBinding.inflate(LayoutInflater.from(parent.getContext()), parent,
                        false);
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

        NbaTeamItemsBinding binding;

        public ViewHolder(@NonNull NbaTeamItemsBinding binding) {
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
