package vku.ddtai.appdatvexemphim.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import vku.ddtai.appdatvexemphim.R;
import vku.ddtai.appdatvexemphim.model.Taikhoan;


public class Dangnhap extends AppCompatActivity {

    EditText edittendangnhap,editmatkhaudangnhap;
    Button btndangky,btndangnhap;
    int id=-1;
    String tendn="",matkhaudn="";
    public static int sessionid=-1;
    public static String sessiontendn="",sessionmatkhaudn="";
    public static  ArrayList<Taikhoan> mangtaikhoan;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);
        Anhxa();
        EventButton();
    }

    private void EventButton() {
        btndangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(Dangnhap.this);
                dialog.setTitle("Hộp thoại xử lý");
                dialog.setCancelable(false);// bấm ra ngoài mà k tắt
                dialog.setContentView(R.layout.dangky);
                final EditText edittendangky = (EditText)dialog.findViewById(R.id.edittendangky);
                final EditText editmatkhaudangky =(EditText) dialog.findViewById(R.id.editmatkhaudangky);
                Button btnhuy = (Button)dialog.findViewById(R.id.btnhuydangky);
                Button btnxacnhandangky =(Button) dialog.findViewById(R.id.btnxacnhandangky);

                btnxacnhandangky.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (edittendangky.getText().length()!=0&&editmatkhaudangky.getText().length()!=0) {
                            tendn = edittendangky.getText().toString().trim();
                            matkhaudn = editmatkhaudangky.getText().toString().trim();

                            edittendangnhap.setText(tendn);
                            editmatkhaudangnhap.setText(matkhaudn);
                            mangtaikhoan.add(new Taikhoan(mangtaikhoan.size(), tendn, matkhaudn));
                            dialog.cancel();
                        }
                        else Toast.makeText(Dangnhap.this, "hãy điền đủ thông tin", Toast.LENGTH_SHORT).show();
                        }
                    });
                btnhuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });

                dialog.show();
            }
        });
        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edittendangnhap.getText().length()!=0&&editmatkhaudangnhap.getText().length()!=0){
                    for (int i =0;i<mangtaikhoan.size();i++){
                        if (edittendangnhap.getText().toString().equals(mangtaikhoan.get(i).getTendn())
                                && editmatkhaudangnhap.getText().toString().equals(mangtaikhoan.get(i).getMatkhau())){
                            Toast.makeText(Dangnhap.this, "Bạn đã đăng nhập thành công", Toast.LENGTH_SHORT).show();
                            id=mangtaikhoan.get(i).getId();
                            sessionid=mangtaikhoan.get(i).getId();
                            sessiontendn=mangtaikhoan.get(i).getTendn();
                            sessionmatkhaudn=mangtaikhoan.get(i).getMatkhau();
                            Intent intent =new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(intent);
                        }
                    }
                    if (id<0)   Toast.makeText(Dangnhap.this, "Bạn đã đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                    id=-1;
                }else {
                    Toast.makeText(Dangnhap.this, "Mời bạn điền đủ thông tin", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void Anhxa() {
        edittendangnhap= findViewById(R.id.edittendangnhap);
        editmatkhaudangnhap= findViewById(R.id.editmatkhaudangnhap);
        btndangky= findViewById(R.id.btndangky);
        btndangnhap= findViewById(R.id.btndangnhap);

        if (mangtaikhoan!=null){

        }
        else  {
            mangtaikhoan= new ArrayList<>();
            mangtaikhoan.add(new Taikhoan(0,"tai","123"));
        }
    }
}