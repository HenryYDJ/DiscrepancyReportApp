package com.mooney.discrepancyreportapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class NavigationActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener{
    ImageButton createNewReportButton;
    ImageButton myReportsButton;
    ImageButton findAReportButton;
    ImageButton myAccountButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        createNewReportButton = (ImageButton)findViewById(R.id.createNewReportButton);
        createNewReportButton.setOnClickListener(this);
        createNewReportButton.setOnLongClickListener(this);

        myReportsButton = (ImageButton)findViewById(R.id.myReportsButton);
        myReportsButton.setOnClickListener(this);

        findAReportButton = (ImageButton)findViewById(R.id.searchForReportsButton);
        findAReportButton.setOnClickListener(this);

        myAccountButton = (ImageButton)findViewById(R.id.myAccountButton);
        myAccountButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.createNewReportButton:
                Intent createNewReportIntent = new Intent(this, CreateNewReportActivity1.class);
                startActivity(createNewReportIntent);
                break;

            case R.id.myReportsButton:
                break;

            case R.id.searchForReportsButton:
                Intent searchForReportIntent = new Intent(this, SearchForReportActivity.class);
                startActivity(searchForReportIntent);
                break;

            case R.id.myAccountButton:
                break;
        }
    }

    @Override
    public boolean onLongClick(View v){
        Toast toast = Toast.makeText(getApplicationContext(), "Stop pressing me NOW!", Toast.LENGTH_SHORT);
        toast.show();
        return true;
    }
}
