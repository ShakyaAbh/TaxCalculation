package com.example.mytaxcalulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText monthly_Salary ;
    TextView output;
    Button calculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        monthly_Salary = findViewById(R.id.monthly_Salary);
        output =findViewById(R.id.output);
        calculate = findViewById(R.id.calculate);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double salary = Double.parseDouble(monthly_Salary.getText().toString());
                output.setText("Your tax is: "+calculate(salary));

            }
            private double calculate(double salary){
                double tax;
                if (salary>=1 && salary<=200000){
                    tax = salary / 100;
                }else if (salary>200000 && salary<=350000){
                    tax = (salary - 200000)*(15f/100) + (200000f/100);
                }else {
                    tax = (salary-350000)*(25f/100) + (150000*15f)/100 + (200000f/100);
                }
                return tax;
            }
        });
    }
}
