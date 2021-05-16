package com.example.lotusautoconsulting;
import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class AddVehicleForm extends AppCompatActivity {
    SQLiteDatabase db;
    Button btnInsert;
    boolean isAllFieldsChecked = false;
    EditText Register_num,Brand,Variant,Model,Purchase_date,Purchase_amount,Insurance_expiry_date,status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vehicle_form);
        Intent intent = getIntent();
        final String str = intent.getStringExtra("message_key");
        Register_num=(EditText) findViewById(R.id.register);
        if(str.matches("^[A-Z]{2}\\d{2}[A-Z]{1}\\d{4}"))
            Register_num.setText(str);
        btnInsert=(Button)findViewById(R.id.button3);
        try{
            db=openOrCreateDatabase("LotusAutoConsultingDB",SQLiteDatabase.CREATE_IF_NECESSARY,null);
        }catch(SQLException e)
        {
            System.out.println(e);
        }
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emi_details="NO";
                Register_num = (EditText) findViewById(R.id.register);
                Brand = (EditText) findViewById(R.id.brand);
                Variant = (EditText) findViewById(R.id.var);
                Model = (EditText) findViewById(R.id.model);
                Purchase_date = (EditText) findViewById(R.id.purdate);
                String pd = Purchase_date.getText().toString();
                int c = pd.indexOf('/');
                Purchase_amount = (EditText) findViewById(R.id.puramount);
                Insurance_expiry_date = (EditText) findViewById(R.id.insexp);
                String ied = Insurance_expiry_date.getText().toString();
                int d = ied.indexOf('/');
                status = (EditText) findViewById(R.id.status);
                isAllFieldsChecked = CheckAllFields();
                if ((isAllFieldsChecked) && (c >= 0) && (d >= 0)) {
                    ContentValues values = new ContentValues();
                    values.put("Reg_num", Register_num.getText().toString());
                    values.put("Brand", Brand.getText().toString());
                    values.put("Variant", Variant.getText().toString());
                    values.put("Model", Model.getText().toString());
                    values.put("Purchase_date", Purchase_date.getText().toString());
                    values.put("Purchase_amount", Purchase_amount.getText().toString());
                    values.put("Insurance_expiry_date", Insurance_expiry_date.getText().toString());
                    values.put("Status", status.getText().toString());
                    values.put("emi", emi_details);
                    if ((db.insert("Vehicledetails", null, values)) != -1) {
                        Toast.makeText(AddVehicleForm.this, "Vehicle added", 2000).show();
                        homepage();
                    } else {
                        Toast.makeText(AddVehicleForm.this, "Vehicle cannot be added", 4000).show();
                    }
                    Register_num.setText("");
                    Brand.setText("");
                    Variant.setText("");
                    Model.setText("");
                    Purchase_date.setText("");
                    Purchase_amount.setText("");
                    Insurance_expiry_date.setText("");
                    status.setText("Available");
                }
                else if (Brand.length() == 0 || Variant.length() == 0 || Model.length() == 0) {
                    Toast.makeText(AddVehicleForm.this, "Fill the Field", 5000).show();
                } else {
                    Toast.makeText(AddVehicleForm.this, "Date should be DD/MM/YYYY FORMAT", 5000).show();
                }
            }
        });

    }
    public boolean CheckAllFields()
    {
        if (Brand.length() == 0) {
            Brand.setError("This field is required");
            return false;
        }
        if(Variant.length()==0)
        {
            Variant.setError("This field is required");
            return false;
        }
        if(Model.length()==0)
        {
            Model.setError("This field is required");
            return false;
        }
        if(Purchase_date.length()==0) {
            Purchase_date.setError("This field is required");
            return false;
        }
        if(Insurance_expiry_date.length()==0) {
            Insurance_expiry_date.setError("This field is required");
            return false;
        }
        return true;

    }
    void homepage() {
        final Context context = this;
        Intent intent = new Intent(context,MainActivity.class);
        startActivity(intent);
    }
}
