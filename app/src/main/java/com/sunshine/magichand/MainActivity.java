package com.sunshine.magichand;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.sunshine.magichand.annonations.BindView;
import com.sunshine.magichand.annonations.LayoutID;
import com.sunshine.magichand.injects.MagicHand;

@LayoutID(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
    @BindView(R.id.name)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MagicHand.inject(this);
        textView.setText("你好");
    }
}
