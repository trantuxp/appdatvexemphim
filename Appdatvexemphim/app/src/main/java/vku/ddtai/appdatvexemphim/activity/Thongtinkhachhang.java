package vku.ddtai.appdatvexemphim.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import vku.ddtai.appdatvexemphim.R;
import vku.ddtai.appdatvexemphim.ultil.CheckConnection;

public class Thongtinkhachhang extends AppCompatActivity {

    EditText edittenkhachhang,editemail,editsdt;
    Button btnxacnhan,btntrove;
    public static String sessiontenkhachhang="";
    public static String sessionsodtkhachhang="";
    public static String sessionemailkhachhang="";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongtinkhachhang);
        Anhxa();
        
        EventButton();
    }

    private void EventButton() {
        btntrove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnxacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sessiontenkhachhang =edittenkhachhang.getText().toString().trim();
                sessionsodtkhachhang =editsdt.getText().toString().trim();
                sessionemailkhachhang =editemail.getText().toString().trim();
                if (sessiontenkhachhang.length()>0&&sessionsodtkhachhang.length()>0&&sessionemailkhachhang.length()>0){
                    Intent intent = new Intent(getApplicationContext(),Hoadon.class);
                    startActivity(intent);
                }else {
                    CheckConnection.ShowToast_Short(getApplicationContext(),"Bạn hãy kiểm tra lại kết nói");
                }
            }
        });
    }

    private void Anhxa() {
        edittenkhachhang= findViewById(R.id.edittexttenkhachhang);
        editsdt= findViewById(R.id.edittextsodtkhachhang);
        editemail= findViewById(R.id.edittextemail);
        btnxacnhan= findViewById(R.id.btnxacnhan);
        btntrove= findViewById(R.id.btntrove);
    }
}