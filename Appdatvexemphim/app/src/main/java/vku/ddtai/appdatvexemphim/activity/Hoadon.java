package vku.ddtai.appdatvexemphim.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

import vku.ddtai.appdatvexemphim.R;
import vku.ddtai.appdatvexemphim.adapter.SanphammuaAdapter;
import vku.ddtai.appdatvexemphim.model.Sanpham;

public class Hoadon extends AppCompatActivity {

    Toolbar toolbar;
    TextView txttenkhach,txtsodtkhach,txtemailkhach,txttongtientra;
    ListView listViewspmua;
    ArrayList<Sanpham> mangsanphammua;
    SanphammuaAdapter sanphammuaAdapter;
    long tongtien=0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoadon);
        Anhxa();
        ActionBar();
        getThongtinkhach();
        getSanphammua();
        //get tong tien
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        txttongtientra.setText("Tổng số tiền cần trả: "+decimalFormat.format(tongtien)+"");

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
    private void getThongtinkhach() {
        txttenkhach.setText("Tên khách hàng: "+Thongtinkhachhang.sessiontenkhachhang);
        txtsodtkhach.setText("Số điện thoại: "+Thongtinkhachhang.sessionsodtkhachhang);
        txtemailkhach.setText("Email: "+Thongtinkhachhang.sessionemailkhachhang);
    }

    private void getSanphammua() {
        for (int i =0;i<MainActivity.manggiohang.size();i++){
            String tensanpham= MainActivity.manggiohang.get(i).getTensp();
            int soluongve= MainActivity.manggiohang.get(i).getIdsp();
            long gia= (long) MainActivity.manggiohang.get(i).getGiasp();
            tongtien+=gia;
            mangsanphammua.add(new Sanpham(0,tensanpham,"",soluongve,gia,"","","","","",""));
            sanphammuaAdapter.notifyDataSetChanged();
        }
    }

    private void Anhxa() {
        toolbar= findViewById(R.id.toolbarhoadon);
        txttenkhach=findViewById(R.id.txttenkhachhang);
        txtsodtkhach=findViewById(R.id.txtsodtkhachhang);
        txtemailkhach=findViewById(R.id.txtemailkhachhang);
        txttongtientra=findViewById(R.id.txttongtientra);
        listViewspmua=findViewById(R.id.listviewsanphammua);
        mangsanphammua= new ArrayList<>();
        sanphammuaAdapter= new SanphammuaAdapter(Hoadon.this,mangsanphammua);
        listViewspmua.setAdapter(sanphammuaAdapter);
    }

}