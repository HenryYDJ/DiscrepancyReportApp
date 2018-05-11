package com.mooney.discrepancyreportapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class CreateNewReportActivity1 extends AppCompatActivity implements View.OnClickListener{
    private Button firstNextButton;
    private Button firstResetButton;

    private EditText reportNumber;
    private EditText date;
    private EditText partName;
    private EditText mooneyPartNumber;
    private EditText codeNumber;
    private EditText vendorNumber;
    private EditText vendorPartNumber;
    private EditText qty;
    private EditText wOrD;
    private EditText poOrSoNumber;
    private EditText vendor;
    private EditText model;
    private EditText unitSerialNumber;
    private EditText aircraftSerialNumber;

    private EditText[] allFieldsArray;

    private DatabaseReference firebaseDatabase;

    // static string variable for Database
    private static String DISCREPENCY_REPORT_CHILD_NODE = "DRReport";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_report1);

        // Find all the text fields
        reportNumber = findViewById(R.id.reportNumber);
        date = findViewById(R.id.date);
        partName = findViewById(R.id.partName);
        mooneyPartNumber = findViewById(R.id.mooneyPartNumber);
        codeNumber = findViewById(R.id.codeNumber);
        vendorNumber = findViewById(R.id.vendorNumber);
        vendorPartNumber = findViewById(R.id.vendorPartNumber);
        qty = findViewById(R.id.qty);
        wOrD = findViewById(R.id.wOrD);
        poOrSoNumber = findViewById(R.id.poOrSoNumber);
        vendor = findViewById(R.id.vendor);
        model = findViewById(R.id.model);
        unitSerialNumber = findViewById(R.id.unitSerialNumber);
        aircraftSerialNumber = findViewById(R.id.aircraftSerialNumber);

        // Put all text fields in an array for convenience.
        allFieldsArray = new EditText[]{reportNumber, date, partName, mooneyPartNumber, codeNumber, vendorNumber,
                vendorPartNumber, qty, wOrD, poOrSoNumber, vendor, model,
                unitSerialNumber, aircraftSerialNumber};

        // Find all the button and set up on click listeners.
        firstNextButton = findViewById(R.id.firstNextButton);
        firstNextButton.setOnClickListener(this);
        firstResetButton = findViewById(R.id.firstResetButton);
        firstResetButton.setOnClickListener(this);

        // Initialize database reference
        firebaseDatabase = FirebaseDatabase.getInstance().getReference();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.firstNextButton:
                if(areAllFieldsEmpty(allFieldsArray)){
                    Toast.makeText(this, "All Fields Are Empty!", Toast.LENGTH_SHORT).show();
                } else if(reportNumber.getText().toString().length() <= 0){
                    Toast.makeText(this, "Report Number is empty!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Map<String, String> DRMetaData = new HashMap<String, String>();
                    DRMetaData.put("reportNumber", reportNumber.getText().toString());
                    DRMetaData.put("date", date.getText().toString());
                    DRMetaData.put("partName", partName.getText().toString());
                    DRMetaData.put("mooneyPartNumber", mooneyPartNumber.getText().toString());
                    DRMetaData.put("codeNumber", codeNumber.getText().toString());
                    DRMetaData.put("vendorNumber", vendorNumber.getText().toString());
                    DRMetaData.put("vendorPartNumber", vendorPartNumber.getText().toString());
                    DRMetaData.put("qty", qty.getText().toString());
                    DRMetaData.put("wOrD", wOrD.getText().toString());
                    DRMetaData.put("poOrSoNumber", poOrSoNumber.getText().toString());
                    DRMetaData.put("vendor", vendor.getText().toString());
                    DRMetaData.put("model", model.getText().toString());
                    DRMetaData.put("unitSerialNumber", unitSerialNumber.getText().toString());
                    DRMetaData.put("aircraftSerialNumber", aircraftSerialNumber.getText().toString());
                    firebaseDatabase.child(DISCREPENCY_REPORT_CHILD_NODE).child(reportNumber.getText().toString()).setValue(DRMetaData);

                    Intent goToSecondPage = new Intent(this, CreateNewReportActivity2.class);
                    startActivity(goToSecondPage);
                }
                break;

            // Reset button clears all the text fields
            case R.id.firstResetButton:
                setFieldsToNull(allFieldsArray);
                break;
        }
    }

    // Method to check if an array of EditText fields are empty
    private boolean areAllFieldsEmpty(EditText[] fields){
        for(int i = 0; i < fields.length; i++){
            if(fields[i].getText().toString().length() > 0){
                return false;
            }
        }
        return true;
    }

    // Method to set all fields to null
    private void setFieldsToNull(EditText[] fields){
        for(int i = 0; i < fields.length; i++){
            fields[i].setText(null);
        }
    }
}
