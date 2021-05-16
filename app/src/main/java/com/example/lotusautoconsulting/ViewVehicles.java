package com.example.lotusautoconsulting;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewVehicles extends AppCompatActivity {
    private ArrayList<VehicleModal> VehicleArrayList;
    private DBHandler dbHandler;
    private VehicleRVAdapter vehicleRVAdapter;
    private RecyclerView vehiclesRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_vehicles);
        Intent intent = getIntent();
        final String str = intent.getStringExtra("message_key");
        VehicleArrayList = new ArrayList<>();
        dbHandler = new DBHandler(ViewVehicles.this);
        VehicleArrayList = dbHandler.readCourses(str);
        vehicleRVAdapter = new VehicleRVAdapter(VehicleArrayList, ViewVehicles.this);
        vehiclesRV = findViewById(R.id.vehicles);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewVehicles.this, RecyclerView.VERTICAL, false);
        vehiclesRV.setLayoutManager(linearLayoutManager);
        vehiclesRV.setAdapter(vehicleRVAdapter);
    }
}