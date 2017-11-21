package com.abdulaziz.ezz.presistingdata;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String EXTRA_SAVE_MESSAGE = "extra_save_message";
    private EditText mMessage;
    private TextView mSavedMessage;
    private Button mSaved;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMessage = findViewById(R.id.etMessage);
        mSavedMessage = findViewById(R.id.tvSavedMessage);
        mSaved = findViewById(R.id.btnSave);

        mSaved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSavedMessage.setText(mMessage.getText().toString());
            }
        });

        // Step (2) if Bundle not empty get String from it with key and then set textView with your Message
        if (savedInstanceState != null) {
            mSavedMessage.setText(savedInstanceState.getString(EXTRA_SAVE_MESSAGE));
        }

    }

    // Step (1) override onSaveInstanceState and put what you want to save in Bundle
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(EXTRA_SAVE_MESSAGE, mMessage.getText().toString());
    }
}
