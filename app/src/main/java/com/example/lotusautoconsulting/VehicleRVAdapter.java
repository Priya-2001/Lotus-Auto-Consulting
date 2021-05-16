package com.example.lotusautoconsulting;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
public class VehicleRVAdapter extends RecyclerView.Adapter<VehicleRVAdapter.ViewHolder> {

    private ArrayList<VehicleModal> VehicleArrayList;
    private Context context;
    String s,r;
    public VehicleRVAdapter(ArrayList<VehicleModal> VehicleArrayList, Context context) {
        this.VehicleArrayList = VehicleArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vehicle_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final VehicleModal modal = VehicleArrayList.get(position);
        holder.reg.setText(modal.getRegistrationNumber());
        holder.brand.setText(modal.getBrand());
        holder.variant.setText(modal.getVariant());
        holder.model.setText(modal.getModel());
        holder.status.setText(modal.getStatus());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s = modal.getStatus();
                r = modal.getRegistrationNumber();
                if(s.equals("Available"))
                {
                    Intent intent = new Intent(holder.itemView.getContext(), Vehicleinfo.class);
                    intent.putExtra("message_key", r);
                    holder.itemView.getContext().startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(holder.itemView.getContext(), Vehiclestatinfo.class);
                    intent.putExtra("message_key", r);
                    holder.itemView.getContext().startActivity(intent);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return VehicleArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView reg,brand,variant,model,status;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            reg = itemView.findViewById(R.id.reg);
            brand = itemView.findViewById(R.id.brand);
            variant = itemView.findViewById(R.id.variant);
            model = itemView.findViewById(R.id.model);
            status = itemView.findViewById(R.id.status);
        }
    }
}