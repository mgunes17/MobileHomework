package com.example.must.mobilehomework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.must.mobilehomework.file.FileController;
import com.example.must.mobilehomework.model.User;

public class UserMainActivity extends AppCompatActivity {
    private Button btnRent;
    private Button btnLogs;
    private Button btnExit;
    private TextView txtUserMainTitle;
    private User user;
    private String userName;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);
        initialize();
        clickButton();
    }

    private void initialize(){
        btnRent = (Button)findViewById(R.id.btnRent);
        btnLogs = (Button)findViewById(R.id.btnLogs);
        btnLogs = (Button)findViewById(R.id.btnExit);
        txtUserMainTitle = (TextView)findViewById(R.id.txtUserMainTitle);
        intent = getIntent();
        userName = intent.getStringExtra("userName");
        FileController fc = new FileController();
        String line = fc.getUser(userName, this);
        user = fc.getUser(line);
        txtUserMainTitle.setText("Hoşgeldin " + user.getName());
    }

    private void clickButton(){
        btnRent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(UserMainActivity.this, RentActivity.class);
                intent.putExtra("userName", user.getUserName());
                startActivity(intent);
            }
        });
    }
}
