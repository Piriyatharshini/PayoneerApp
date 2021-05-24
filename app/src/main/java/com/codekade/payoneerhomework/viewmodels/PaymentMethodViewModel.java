package com.codekade.payoneerhomework.viewmodels;



import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.codekade.payoneerhomework.model.PaymentMethod;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class PaymentMethodViewModel extends AndroidViewModel {


    public MutableLiveData<ArrayList<PaymentMethod>> paymentMethodMutableLiveData = new MutableLiveData<>();

    private RequestQueue requestQueue;
    ArrayList<PaymentMethod> paymentMethodArrayList = new ArrayList<>();

    public PaymentMethodViewModel(@NonNull @NotNull Application application) {
        super(application);
    }


    //get method
    public LiveData<ArrayList<PaymentMethod>> getPaymentLiveData(){
        return paymentMethodMutableLiveData;
    }



    public void downloadDataForPaymentMethods() {
        //Volley request

        requestQueue = Volley.newRequestQueue(getApplication().getBaseContext());

        String url = "https://raw.githubusercontent.com/optile/checkout-android/develop/shared-test/lists/listresult.json";
        Log.v("ccpp", "https://raw.githubusercontent.com/optile/checkout-android/develop/shared-test/lists/listresult.json");
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject details = new JSONObject(response);

                            JSONObject networksJSONObject = details.getJSONObject("networks");
                            JSONArray applicableJSONArray = networksJSONObject.getJSONArray("applicable");


                            for (int i = 0; i < applicableJSONArray.length(); i++) {
                                JSONObject insideApplicableJSONObject = applicableJSONArray.getJSONObject(i);

                                String label = insideApplicableJSONObject.getString("label");

                                JSONObject linksJSONObject = insideApplicableJSONObject.getJSONObject("links");
                                String logoString = linksJSONObject.getString("logo");

                                PaymentMethod paymentMethod = new PaymentMethod(label, logoString);
                                Log.v("ccpp", paymentMethod.getPaymentLogoString() + "   " + paymentMethod.getPaymentName());
                                paymentMethodArrayList.add(paymentMethod);

                                Log.v("ccpp1", "size: " + String.valueOf(paymentMethodArrayList.size()));
                                paymentMethodMutableLiveData.setValue(paymentMethodArrayList);
                            }



                        } catch (JSONException e) {
                            Log.v("ccpp", String.valueOf(e));
                            e.printStackTrace();
                            AlertDialog alertDialog = new AlertDialog.Builder(getApplication()).create();
                            alertDialog.setTitle("Alert");
                            alertDialog.setMessage("We encountered a problem.");
                            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL,"OK",new
                                    DialogInterface.OnClickListener() {
                                        public void onClick (DialogInterface dialog,int which){
                                            dialog.dismiss();
                                        }
                                    });
                            alertDialog.show();


                        }


                        Log.v("ccpp2", "1  "+ String.valueOf(paymentMethodArrayList.size()));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                if (error instanceof NoConnectionError) {
                    showDialog(getApplication(), "There is a problem in the connection! Please check your network connectivity and try again");
                } else if (error instanceof TimeoutError) {
                    showDialog(getApplication(), "There is a Timeout Error! Please try again");
                } else if (error instanceof AuthFailureError) {
                    showDialog(getApplication(), "There is an Authentication failure! Please check your credentials and try again");
                } else if (error instanceof ServerError) {
                    showDialog(getApplication(), "There is a ServerError! Please try again");
                } else if (error instanceof NetworkError) {
                    showDialog(getApplication(), "There is a problem in the Network! Please try again");
                } else if (error instanceof ParseError) {
                    showDialog(getApplication(), "There is a ParseError! Please try again");
                }else{
                    showDialog(getApplication(), "We encountered an error!");
                }


                Log.v("ccpp", "error: " + error.getLocalizedMessage());
            }
        });

        int socketTimeout = 2500;
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(policy);
        requestQueue.add(stringRequest);



    }

    public void showDialog(Context context, String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Alert");
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL,"OK",new
                DialogInterface.OnClickListener() {
                    public void onClick (DialogInterface dialog,int which){
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }


}
