package com.example.lotusautoconsulting;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
public class DBHandler extends SQLiteOpenHelper {
    private static final String DB_NAME = "LotusAutoConsultingDB";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "Vehicledetails";
    private static final String REG_COL = "Reg_num";
    private static final String BRAND_COL = "Brand";
    private static final String VARIANT_COL = "Variant";
    private static final String MODEL_COL = "Model";
    private static final String DATE_COL = "Purchase_date";
    private static final String AMOUNT_COL = "Purchase_amount";
    private static final String EXPIRY_COL= "Insurance_expiry_date";
    private static final String STATUS_COL = "Status";
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
                + REG_COL + " TEXT,"
                + BRAND_COL + " TEXT,"
                + VARIANT_COL + " TEXT,"
                + MODEL_COL + " TEXT,"
                + DATE_COL + " TEXT,"
                + AMOUNT_COL + " NUMBER,"
                + EXPIRY_COL + " TEXT,"
                + STATUS_COL + " TEXT)";
        db.execSQL(query);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public ArrayList<VehicleModal> readCourses(String str) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c1 = db.rawQuery("SELECT * FROM " + TABLE_NAME+ " WHERE Model = "+"'"+str+"'", null);
        Cursor c2 = db.rawQuery("SELECT * FROM " + TABLE_NAME+ " WHERE Brand = "+"'"+str+"'", null);
        Cursor c3 = db.rawQuery("SELECT * FROM " + TABLE_NAME+ " WHERE Variant = "+"'"+str+"'", null);
        ArrayList<VehicleModal> VehicleArrayList = new ArrayList<>();
        if(c1.getCount() > 0)
        {
            if (c1.moveToFirst())
            {
                do
                {
                    VehicleArrayList.add(new VehicleModal(c1.getString(0),
                            c1.getString(1),
                            c1.getString(2),
                            c1.getString(3),
                            c1.getString(4),
                            c1.getInt(5),
                            c1.getString(6),
                            c1.getString(7)));
                } while (c1.moveToNext());
            }
            c1.close();
        }
        if(c2.getCount() > 0)
        {
            if (c2.moveToFirst())
            {
                do
                {
                    VehicleArrayList.add(new VehicleModal(c2.getString(0),
                            c2.getString(1),
                            c2.getString(2),
                            c2.getString(3),
                            c2.getString(4),
                            c2.getInt(5),
                            c2.getString(6),
                            c2.getString(7)));
                } while (c2.moveToNext());
            }
            c2.close();
        }
        if(c3.getCount() > 0)
        {
            if (c3.moveToFirst())
            {
                do
                {
                    VehicleArrayList.add(new VehicleModal(c3.getString(0),
                            c3.getString(1),
                            c3.getString(2),
                            c3.getString(3),
                            c3.getString(4),
                            c3.getInt(5),
                            c3.getString(6),
                            c3.getString(7)));
                } while (c3.moveToNext());
            }
            c3.close();
        }
        return VehicleArrayList;
    }
}