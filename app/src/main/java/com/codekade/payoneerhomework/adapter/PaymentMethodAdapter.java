package com.codekade.payoneerhomework.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codekade.payoneerhomework.R;
import com.codekade.payoneerhomework.model.PaymentMethod;
import com.codekade.payoneerhomework.viewholder.PaymentMethodViewHolder;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PaymentMethodAdapter extends RecyclerView.Adapter<PaymentMethodViewHolder> {

    ArrayList<PaymentMethod> paymentMethodArrayList = new ArrayList<PaymentMethod>();

    String logoString = "";

    public PaymentMethodAdapter(ArrayList<PaymentMethod> paymentMethodArrayList) {
        this.paymentMethodArrayList = paymentMethodArrayList;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public PaymentMethodViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View paymentMethodCard = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_payment_methods, parent, false);
        return new PaymentMethodViewHolder(paymentMethodCard);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull PaymentMethodViewHolder holder, int position) {

        Log.v("ccpp1",paymentMethodArrayList.get(position).getPaymentName() +  paymentMethodArrayList.get(position).getPaymentLogoString() );

        logoString = paymentMethodArrayList.get(position).getPaymentLogoString();

        //update payment method and logo by calling updateUI in ViewHolder
        holder.updateUI(paymentMethodArrayList.get(position).getPaymentName(), logoString);
    }

    @Override
    public int getItemCount() {
        return paymentMethodArrayList.size();
    }


}
