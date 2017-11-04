package com.wiseassblog.rxeventarchitecture.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.wiseassblog.rxeventarchitecture.R;
import com.wiseassblog.rxeventarchitecture.model.ServiceA;
import com.wiseassblog.rxeventarchitecture.model.ServiceB;
import com.wiseassblog.rxeventarchitecture.presenter.Presenter;

public class View extends AppCompatActivity implements ViewInterface {

    private Button submit;
    private EditText input;
    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpMvp();

        input = (EditText) findViewById(R.id.edt_input_name);

        submit = (Button) findViewById(R.id.btn_submit_event);
        submit.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                presenter.submitName(input.getText().toString());
            }
        });

    }

    private void setUpMvp() {
        presenter = new Presenter(this, new ServiceA(), new ServiceB());
    }


    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
