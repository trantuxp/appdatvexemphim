package vku.ddtai.appdatvexemphim.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

import vku.ddtai.appdatvexemphim.R;
import vku.ddtai.appdatvexemphim.model.Giohang;
import vku.ddtai.appdatvexemphim.model.Sanpham;

public class Chitietsanpham extends AppCompatActivity {

    Toolbar toolbarchitiet;
    TextView txtten,txtgia,txtmota,txtkhoichieu,txtthoiluong,txtdaodien,txtdienvien,txttheloai;
    ImageView imgchitiet;
    Spinner spinner;
    Button btndatmua;

    ArrayAdapter arrayAdapter;
    ArrayList<String> mangdanhgia;
    EditText editdanhgia;
    ListView listview;
    ImageView imgguidanhgia;

    int id=0;
    String tenchitiet= "";
    String anhchitiet="";
    long giachitiet=0;
    String daodien="";
    String dienvien="";
    String thoiluongchitiet="";
    String khoichieuchitiet="";
    String ngonngu="";
    String motachitiet="";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chitietsanpham);

        Anhxa();
        ActionToolBar();// thanh menu ngang
        GetInformation(); // đổ dữ liệu vào
        CatchEventSpinner(); // tạo giá trị cho ô số lượng
        EventButton();
        setDanhgia();
    }
    private void CatchEventSpinner() {
        Integer[] soluong =new Integer[]{1,2,3,4,5,6,7,8,9,10};
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this,R.layout.support_simple_spinner_dropdown_item,soluong);
        spinner.setAdapter(adapter);
    }
    private void GetInformation() {

        Sanpham sanpham = (Sanpham) getIntent().getSerializableExtra("thongtinsanpham");
        id=sanpham.getId();
        tenchitiet=sanpham.getTensanpham();
        anhchitiet=sanpham.getAnh();
        giachitiet=sanpham.getGia();
        daodien=sanpham.getDaodien();
        dienvien=sanpham.getDienvien();
        thoiluongchitiet=sanpham.getThoiluong();
        khoichieuchitiet=sanpham.getKhoichieu();
        ngonngu=sanpham.getTheloai();
        motachitiet=sanpham.getMota();

        txtten.setText(tenchitiet);
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        txtgia.setText("Giá vé : "+ decimalFormat.format(giachitiet)+ "Đ" );
        txtmota.setText(motachitiet);
        Picasso.get().load(anhchitiet).placeholder(R.drawable.imgload)
                .error(R.drawable.imgerror)
                .into(imgchitiet);
        txtkhoichieu.setText("Khởi chiếu:"+sanpham.getKhoichieu());
        txtthoiluong.setText("Thời lượng: "+sanpham.getThoiluong());
        txtdaodien.setText("Đạo diễn: "+sanpham.getDaodien());
        txtdienvien.setText("Diễn viên: "+sanpham.getDienvien());
        txttheloai.setText("Thể loại: "+sanpham.getTheloai());

    }
    private void EventButton() {
        btndatmua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainActivity.manggiohang.size() > 0) {
                    boolean exists = false;
                    int sl = Integer.parseInt(spinner.getSelectedItem().toString());
                    for (int i = 0; i < MainActivity.manggiohang.size(); i++) {
                        if (MainActivity.manggiohang.get(i).getIdsp() == id) {
                            MainActivity.manggiohang.get(i).setSoluongsp(MainActivity.manggiohang.get(i).getSoluongsp() + sl);
                            if (MainActivity.manggiohang.get(i).getSoluongsp() >= 10) {
                                MainActivity.manggiohang.get(i).setSoluongsp(10);

                            }
                            MainActivity.manggiohang.get(i).setGiasp(giachitiet * MainActivity.manggiohang.get(i).getSoluongsp());
                            exists = true;
                        }
                    }
                    if (exists == false) {
                        int soluong = Integer.parseInt(spinner.getSelectedItem().toString());
                        double giamoi = soluong * giachitiet;
                        MainActivity.manggiohang.add(new Giohang(id, tenchitiet, giamoi, anhchitiet, soluong));
                    }
                } else {
                    int soluong = Integer.parseInt(spinner.getSelectedItem().toString());
                    double giamoi = soluong* giachitiet;
                    MainActivity.manggiohang.add(new Giohang(id,tenchitiet,giamoi,anhchitiet,soluong));
                }
                Intent intent  = new Intent(getApplicationContext(),GiohangActivity.class);
                startActivity(intent);
            }
        });
    }
    private void ActionToolBar() {
        setSupportActionBar(toolbarchitiet);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarchitiet.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void setDanhgia(){
        imgguidanhgia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String danhgia=editdanhgia.getText().toString().trim();
                mangdanhgia.add(Dangnhap.sessiontendn+": "+danhgia);
                arrayAdapter.notifyDataSetChanged();
            }
        });
    }
    private  void Anhxa(){
        toolbarchitiet = findViewById(R.id.toolbarchitietsp);
        txtten = findViewById(R.id.texttenchitietsp);
        txtgia = findViewById(R.id.textgiachitietsp);

        txtkhoichieu = findViewById(R.id.txtkhoichieu);
        txtthoiluong = findViewById(R.id.txtthoiluong);
        txtdaodien = findViewById(R.id.txtdaodien);
        txtdienvien = findViewById(R.id.txtdienvien);
        txttheloai = findViewById(R.id.txttheloai);

        mangdanhgia= new ArrayList<>();
        imgguidanhgia=findViewById(R.id.imgguidanhgia);
        editdanhgia=findViewById(R.id.editdanhgia);
        listview=findViewById(R.id.listviewdanhgia);
        arrayAdapter= new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1,mangdanhgia);
        mangdanhgia.add(Dangnhap.sessiontendn+": "+"Good");
        listview.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();

        txtmota = findViewById(R.id.txtmotachitietsanpham);
        imgchitiet = findViewById(R.id.imgchitietsp);
        spinner = findViewById(R.id.spinner);
        btndatmua = findViewById(R.id.btndatmua);


    }
}