package com.example.kingcheda;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kingcheda.HomeActivity;
import com.example.kingcheda.Prevalent.Prevalent;
import com.example.kingcheda.R;
import com.flutterwave.raveandroid.RavePayActivity;
import com.flutterwave.raveandroid.RaveUiManager;
import com.flutterwave.raveandroid.rave_java_commons.RaveConstants;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class ConfirmFinalOrderActivity extends AppCompatActivity
{
    private EditText nameEditText, phoneEditText, addressEditText, cityEditText, stateEditText;
    private Button makePaymentButton;
    private String totalAmount = "";



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_final_order);

        totalAmount =  getIntent().getStringExtra("Total Price");

        Toast.makeText(this, "Total Price = " + totalAmount + " KSH", Toast.LENGTH_SHORT).show();


        makePaymentButton = (Button) findViewById(R.id.confirm_final_order_btn);
        nameEditText = (EditText) findViewById(R.id.shipment_name);
        phoneEditText = (EditText) findViewById(R.id.shipment_phone_number);
        addressEditText = (EditText) findViewById(R.id.shipment_address);
        cityEditText = (EditText) findViewById(R.id.shipment_city);
        stateEditText = (EditText) findViewById(R.id.shipment_state);

        makePaymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Check();

            }
        });
    }




    private void Check()
    {
        if(TextUtils.isEmpty(nameEditText.getText().toString()))
        {
            Toast.makeText(this, "Please provide your full name.", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(phoneEditText.getText().toString()))
        {
            Toast.makeText(this, "Please provide your phone number.", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(addressEditText.getText().toString()))
        {
            Toast.makeText(this, "Please provide your address.", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(cityEditText.getText().toString()))
        {
            Toast.makeText(this, "Please provide your city.", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(stateEditText.getText().toString()))
        {
            Toast.makeText(this, "Please provide your state.", Toast.LENGTH_SHORT).show();
        }
        else
        {
            makePayment();
        }

    }

    private void makePayment()
    {
        new RaveUiManager(this)
                .setAmount(10000)
                .setEmail("birthevents11@gmail.com")
                .setfName("fam")
                .setlName("john")
                .setNarration("samsung")
                .setCurrency("NGN")
                .setPublicKey("FLWPUBK_TEST-9f25f4aa47eb0ccd95828093aa596f82-X")
                .setEncryptionKey("FLWSECK_TESTee740efaf8ef")
                .setTxRef(System.currentTimeMillis() + "Ref")
                .acceptCardPayments(true)
                .acceptMpesaPayments(true)
                .allowSaveCardFeature(true)
                .onStagingEnv(true)
                .shouldDisplayFee(true)
                .showStagingLabel(true)
                .withTheme(R.style.MyCustomTheme)
                .initialize();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == RaveConstants.RAVE_REQUEST_CODE && data != null) {
            String message = data.getStringExtra("response");
            Log.d("transaction_response", message);


            if (resultCode == RavePayActivity.RESULT_SUCCESS) {
                Toast.makeText(this, "SUCCESS ", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ConfirmFinalOrderActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
            else if (resultCode == RavePayActivity.RESULT_ERROR) {
                Toast.makeText(this, "ERROR ", Toast.LENGTH_LONG).show();
            }
            else if (resultCode == RavePayActivity.RESULT_CANCELLED) {
                Toast.makeText(this, "CANCELLED ", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }


}
