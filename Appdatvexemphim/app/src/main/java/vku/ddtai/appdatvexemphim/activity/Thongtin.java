package vku.ddtai.appdatvexemphim.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;

import android.os.Bundle;
import android.view.View;

import vku.ddtai.appdatvexemphim.R;

public class Thongtin extends AppCompatActivity {

    Toolbar toolbar;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongtin);
        toolbar=findViewById(R.id.toolbarthongtin);
        ActionBar();
    }
    private void ActionBar(){

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}