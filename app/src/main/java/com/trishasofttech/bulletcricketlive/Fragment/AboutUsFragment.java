package com.trishasofttech.bulletcricketlive.Fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.trishasofttech.bulletcricketlive.Helper.TextJustification;
import com.trishasofttech.bulletcricketlive.R;

public class AboutUsFragment extends AppCompatActivity {
private TextView tv_about_msg1, tv_about_msg2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_about_us);
        /*to change the Actionbar title name*/
        getSupportActionBar().setTitle("About Us");

        tv_about_msg1 = findViewById(R.id.tv_about_msg);
        tv_about_msg2 = findViewById(R.id.tv_about_msg1);

        /*tv_about_msg1.setText(new SpannableString(tv_about_msg1.getText()));
        tv_about_msg2.setText(new SpannableString(tv_about_msg2.getText()));
        TextJustification.justify(tv_about_msg1);
        TextJustification.justify(tv_about_msg2);*/
    }
}