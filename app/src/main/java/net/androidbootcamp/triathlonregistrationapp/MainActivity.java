package net.androidbootcamp.triathlonregistrationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double costPerAthlete = 725.00;
    int numAthletes;
    double totalFee;
    String locationSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText fee = (EditText)findViewById(R.id.txtAthletes);
        final Spinner location = (Spinner)findViewById(R.id.txtLocation);
        Button cost = (Button)findViewById(R.id.btnCost);
        cost.setOnClickListener(new View.OnClickListener() {
            final TextView result = ((TextView)findViewById(R.id.txtResult));
            @Override
            public void onClick(View v) {
                numAthletes = Integer.parseInt(fee.getText().toString());
                totalFee = costPerAthlete * numAthletes;
                DecimalFormat currency = new DecimalFormat("$###,###.##");
                locationSelect = location.getSelectedItem().toString();
                result.setText("Team fee for " + locationSelect + " is " + currency.format(totalFee));
            }
        });
    }
}
