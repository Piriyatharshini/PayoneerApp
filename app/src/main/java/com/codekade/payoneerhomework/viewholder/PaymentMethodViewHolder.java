package com.codekade.payoneerhomework.viewholder;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.codekade.payoneerhomework.R;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class PaymentMethodViewHolder extends RecyclerView.ViewHolder {

    public TextView paymentMethodTextView;
    public ImageView paymentMethodLogoImageView;
    public CardView paymentCardView;

    public PaymentMethodViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
        super(itemView);

        paymentMethodTextView = itemView.findViewById(R.id.paymentmethod_textview);
        paymentMethodLogoImageView = itemView.findViewById(R.id.logo_imageview);
        paymentCardView = itemView.findViewById(R.id.paymentMethodCardView);
    }

    public void updateUI(String paymentMethodName, String logoString){

        //using Picasso to load images
        Picasso.with(itemView.getContext())
                .load(logoString)
                .resize(30,30)
                .into(paymentMethodLogoImageView);

        paymentMethodTextView.setText(paymentMethodName);
    }


}
