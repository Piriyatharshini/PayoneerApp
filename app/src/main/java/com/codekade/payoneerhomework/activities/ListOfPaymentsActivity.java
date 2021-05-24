package com.codekade.payoneerhomework.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;

import com.codekade.payoneerhomework.R;
import com.codekade.payoneerhomework.adapter.PaymentMethodAdapter;
import com.codekade.payoneerhomework.model.PaymentMethod;
import com.codekade.payoneerhomework.viewmodels.PaymentMethodViewModel;

import java.util.ArrayList;

public class ListOfPaymentsActivity extends AppCompatActivity {


    boolean connectedToInternet = false;
    RecyclerView paymentMethodsRecyclerView;
    PaymentMethodAdapter paymentMethodAdapter;
    RecyclerView.LayoutManager linearLayoutManager;

    ArrayList<PaymentMethod> paymentMethodArrayList = new ArrayList<PaymentMethod>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_payments);
        Log.v("ccpp3", "1. internet: "+ connectedToInternet);

        paymentMethodsRecyclerView = findViewById(R.id.recycler_payment_methods);




        PaymentMethodViewModel paymentMethodViewModel = new ViewModelProvider(this).get(PaymentMethodViewModel.class);

        //check whether there is  Internet connection
        if(checkInternetConnectivity()) {
            Log.v("ccpp3", "2. internet: "+ connectedToInternet);
            //if there is internet connection download data
            paymentMethodViewModel.downloadDataForPaymentMethods();
        }else{
            //display dialog
            Log.v("ccpp3", "3. internet: "+ connectedToInternet);
            showDialogInternetConnection();
        }



        paymentMethodViewModel.getPaymentLiveData().observe(this, new Observer<ArrayList<PaymentMethod>>() {
            @Override
            public void onChanged(ArrayList<PaymentMethod> paymentMethodArrayList) {
                // update UI
                loadRecyclerView(paymentMethodArrayList);
            }
        });
        Log.v("ccpp1", "arraylist " + paymentMethodArrayList.size());
    }



    // method to check Internet connection
    public boolean checkInternetConnectivity(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected()) {
            //we are connected to a network
            return connectedToInternet = true;
        }
        else {
            return connectedToInternet = false;
        }
    }


    //load RecyclerView

    public void loadRecyclerView(ArrayList<PaymentMethod> paymentMethodArrayList){
        linearLayoutManager = new LinearLayoutManager(ListOfPaymentsActivity.this, LinearLayoutManager.VERTICAL, false);
        paymentMethodsRecyclerView.setLayoutManager(linearLayoutManager);

        paymentMethodAdapter = new PaymentMethodAdapter(paymentMethodArrayList);
        paymentMethodsRecyclerView.setAdapter(paymentMethodAdapter);
    }


    //show Alert Dialog to display that there is no Internet connection

    public void showDialogInternetConnection(){
        AlertDialog alertDialog = new AlertDialog.Builder(ListOfPaymentsActivity.this).create();
        alertDialog.setTitle("Alert");
        alertDialog.setMessage("There is no Internet connectivity. Please check your network settings.");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL,"OK",new
                DialogInterface.OnClickListener() {
                    public void onClick (DialogInterface dialog,int which){
                        //When the ok button is clicked the Network settings will open and users will be able to check their network connectivity there
                        Intent intent=new Intent(Settings.ACTION_WIRELESS_SETTINGS);
                        startActivity(intent);
                    }
                });
        alertDialog.show();
    }
}