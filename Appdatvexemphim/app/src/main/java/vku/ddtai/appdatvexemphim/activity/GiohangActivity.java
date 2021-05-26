package vku.ddtai.appdatvexemphim.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DecimalFormat;

import vku.ddtai.appdatvexemphim.R;
import vku.ddtai.appdatvexemphim.adapter.GiohangAdapter;
import vku.ddtai.appdatvexemphim.ultil.CheckConnection;

public class GiohangActivity extends AppCompatActivity {

    ListView listViewgiohang;
    TextView txtthongbao;
    static TextView txttongtien;
    Button btnthanhtoan,btntieptucmua;
    Toolbar toolbargiohang;
    GiohangAdapter giohangAdapter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giohang);
        Anhxa();
        ActionToolBar();
        Checkdata();
        EventUltil();
        CatchOnItemListView();
        EventButton();


    }

    private void EventButton() {
        btntieptucmua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        btnthanhtoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainActivity.manggiohang.size()>0){
                    Intent intent = new Intent(getApplicationContext(),Thongtinkhachhang.class);
                    startActivity(intent);

                }else {
                    CheckConnection.ShowToast_Short(getApplicationContext(),"Giỏ hàng của bạn chưa có sản phẩm ");
                }
            }
        });
    }

    private void CatchOnItemListView(){
        listViewgiohang.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(GiohangActivity.this);
                builder.setTitle("Xác nhận xóa sản phẩm");
                builder.setMessage("Bạn có chắc muốn xóa sản phẩm này ");
                builder.setPositiveButton("có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (MainActivity.manggiohang.size()<0){
                            txtthongbao.setVisibility(View.VISIBLE);
                        }else {
                            MainActivity.manggiohang.remove(position);
                            giohangAdapter.notifyDataSetInvalidated();
                            EventUltil();
                            if (MainActivity.manggiohang.size()<=0){
                                txtthongbao.setVisibility(View.VISIBLE);
                            }else {
                                txtthongbao.setVisibility(View.INVISIBLE);
                                giohangAdapter.notifyDataSetInvalidated();
                                EventUltil();
                            }
                        }
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        giohangAdapter.notifyDataSetInvalidated();
                        EventUltil();
                    }
                });
                builder.show();

                return false;
            }
        });

    }

    public static void EventUltil() {
        long tongtien=0;
        for (int i =0;i<MainActivity.manggiohang.size();i++){
            tongtien+=MainActivity.manggiohang.get(i).giasp;

        }
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        txttongtien.setText(decimalFormat.format(tongtien)+ "Đ");

    }

    private void Checkdata() {
        if (MainActivity.manggiohang.size()<=0){
            giohangAdapter.notifyDataSetChanged();
            txtthongbao.setVisibility(View.VISIBLE);
            listViewgiohang.setVisibility(View.INVISIBLE);
        }else {
            giohangAdapter.notifyDataSetChanged();
            listViewgiohang.setVisibility(View.VISIBLE);
            txtthongbao.setVisibility(View.INVISIBLE);
        }
    }

    private void ActionToolBar(){

        setSupportActionBar(toolbargiohang);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbargiohang.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void Anhxa() {
        listViewgiohang= findViewById(R.id.listviewgiohang);
        txtthongbao= findViewById(R.id.txtthongbao);
        txttongtien= findViewById(R.id.txttongtien);
        btnthanhtoan= findViewById(R.id.btnthanhtoangiohang);
        btntieptucmua= findViewById(R.id.btntieptucmua);
        toolbargiohang= findViewById(R.id.toolbargiohang);
        if (MainActivity.manggiohang!= null) {
            giohangAdapter = new GiohangAdapter(GiohangActivity.this, MainActivity.manggiohang);
            listViewgiohang.setAdapter(giohangAdapter);
        }

    }
}