package com.example.lotusautoconsulting;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
public class emi_confirm extends AppCompatActivity {
    Button button,button1;
    SQLiteDatabase db;
    String string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emi_confirm);
        Intent intent = getIntent();
        final String str = intent.getStringExtra("message_key");
        string=str;
        final Context context = this;
        try{
            db=openOrCreateDatabase("LotusAutoConsultingDB",SQLiteDatabase.CREATE_IF_NECESSARY,null);
        }catch(SQLException e)
        {
            System.out.println(e);
        }
        button = (Button) findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Toast.makeText(emi_confirm.this, "Full Cashed Paid", 2000).show();
                Intent intent = new Intent(context,MainActivity.class);
                startActivity(intent);
            }
        });
        button1 = (Button) findViewById(R.id.button5);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String emi1 = "YES";
                db.execSQL("UPDATE Vehicledetails SET emi = "+"'"+emi1+"' "+ "WHERE Reg_num = "+"'"+string+"'");
                Intent intent = new Intent(context,emi_details.class);
                intent.putExtra("message_key",string);
                startActivity(intent);
            }
        });
    }
}
