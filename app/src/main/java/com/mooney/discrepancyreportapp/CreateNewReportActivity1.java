package com.mooney.discrepancyreportapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CreateNewReportActivity1 extends AppCompatActivity implements View.OnClickListener{
    Button firstNextButton;
    Button firstResetButton;

    TextView partName;
    TextView mooneyPartNumber;
    TextView codeNumber;
    TextView vendorNumber;
    TextView vendorPartNumber;
    TextView qty;
    TextView wOrD;
    TextView poOrSoNumber;
    TextView vendor;
    TextView model;
    TextView unitSerialNumber;
    TextView aircraftSerialNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_report1);

        partName = (TextView)findViewById(R.id.partName);
        mooneyPartNumber = (TextView)findViewById(R.id.mooneyPartNumber);
        codeNumber = (TextView)findViewById(R.id.codeNumber);
        vendorNumber = (TextView)findViewById(R.id.vendorNumber);
        vendorPartNumber = (TextView)findViewById(R.id.vendorPartNumber);
        qty = (TextView)findViewById(R.id.qty);
        wOrD = (TextView)findViewById(R.id.wOrD);
        poOrSoNumber = (TextView)findViewById(R.id.poOrSoNumber);
        vendor = (TextView)findViewById(R.id.vendor);
        model = (TextView)findViewById(R.id.model);
        unitSerialNumber = (TextView)findViewById(R.id.unitSerialNumber);
        aircraftSerialNumber = (TextView)findViewById(R.id.aircraftSerialNumber);

        firstNextButton = (Button)findViewById(R.id.firstNextButton);
        firstNextButton.setOnClickListener(this);

        firstResetButton = (Button)findViewById(R.id.firstResetButton);
        firstResetButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.firstNextButton:
                Intent goToSecondPage = new Intent(this, CreateNewReportActivity2.class);
                startActivity(goToSecondPage);
                break;

            // Reset button clears all the text fields
            case R.id.firstResetButton:
                partName.setText(null);
                mooneyPartNumber.setText(null);
                codeNumber.setText(null);
                vendorNumber.setText(null);
                vendorPartNumber.setText(null);
                qty.setText(null);
                wOrD.setText(null);
                poOrSoNumber.setText(null);
                vendor.setText(null);
                model.setText(null);
                unitSerialNumber.setText(null);
                aircraftSerialNumber.setText(null);
                break;
        }
    }
}
