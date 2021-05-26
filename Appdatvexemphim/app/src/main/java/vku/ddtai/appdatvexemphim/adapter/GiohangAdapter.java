package vku.ddtai.appdatvexemphim.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

import vku.ddtai.appdatvexemphim.R;
import vku.ddtai.appdatvexemphim.activity.GiohangActivity;
import vku.ddtai.appdatvexemphim.activity.MainActivity;
import vku.ddtai.appdatvexemphim.model.Giohang;

public class GiohangAdapter  extends BaseAdapter {
    Context context;
    ArrayList<Giohang> giohangArrayList;

    public GiohangAdapter(Context context, ArrayList<Giohang> giohangArrayList) {
        this.context = context;
        this.giohangArrayList = giohangArrayList;
    }

    @Override
    public int getCount() {
        return giohangArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return giohangArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public class Viewholder {
        TextView txttengiohang,txtgiagiohang;
        ImageView imgdonggiohang;
        Button btnminus,btnvalues,btnplus;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Viewholder viewholder= null;
        if (viewholder==null){
            viewholder = new Viewholder();
            LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.dong_giohang,null);
            viewholder.txttengiohang= view.findViewById(R.id.txttengiohang);
            viewholder.txtgiagiohang= view.findViewById(R.id.txtgiagiohang);
            viewholder.imgdonggiohang= view.findViewById(R.id.imgdonggiohang);
            viewholder.btnminus= view.findViewById(R.id.btnminus);
            viewholder.btnvalues= view.findViewById(R.id.btnvalues);
            viewholder.btnplus= view.findViewById(R.id.btnplus);
            view.setTag(viewholder);

        }else {
            viewholder = (Viewholder) view.getTag();
        }
        Giohang giohang= (Giohang) getItem(position);
        viewholder.txttengiohang.setText(giohang.getTensp());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewholder.txtgiagiohang.setText(decimalFormat.format(giohang.getGiasp())+"Đ");
        Picasso.get().load(giohang.getHinhsp()).placeholder(R.drawable.imgload).error(R.drawable.imgerror).into(viewholder.imgdonggiohang);
        viewholder.btnvalues.setText(giohang.getSoluongsp() + "");
        int sl=Integer.parseInt(viewholder.btnvalues.getText().toString());
        if (sl>=10){
            viewholder.btnplus.setVisibility(View.INVISIBLE);
            viewholder.btnminus.setVisibility(View.VISIBLE);

        }else if(sl<=1){
            viewholder.btnminus.setVisibility(View.INVISIBLE);
        }else if (sl>=1){
            viewholder.btnplus.setVisibility(View.VISIBLE);
            viewholder.btnminus.setVisibility(View.VISIBLE);
        }
        Viewholder finalViewholder = viewholder;
        viewholder.btnplus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                int slmoinhat=Integer.parseInt(finalViewholder.btnvalues.getText().toString())+1;
                int slhientai= MainActivity.manggiohang.get(position).getSoluongsp();
                double giahientai= MainActivity.manggiohang.get(position).getGiasp();
                MainActivity.manggiohang.get(position).setSoluongsp(slmoinhat);
                double giamoinhat = (giahientai*slmoinhat)/slhientai;
                MainActivity.manggiohang.get(position).setGiasp(giamoinhat);
                DecimalFormat decimalFormat1 = new DecimalFormat("###,###,###");
                finalViewholder.txtgiagiohang.setText(decimalFormat1.format(giamoinhat)+"Đ");
                GiohangActivity.EventUltil();
                if (slmoinhat >9){
                    finalViewholder.btnplus.setVisibility(View.INVISIBLE);
                    finalViewholder.btnminus.setVisibility(View.VISIBLE);
                    finalViewholder.btnvalues.setText(String.valueOf(slmoinhat));

                }else {
                    finalViewholder.btnminus.setVisibility(View.VISIBLE);
                    finalViewholder.btnplus.setVisibility(View.VISIBLE);
                    finalViewholder.btnvalues.setText(String.valueOf(slmoinhat));

                }
            }
        });
        viewholder.btnminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int slmoinhat=Integer.parseInt(finalViewholder.btnvalues.getText().toString())-1;
                int slhientai= MainActivity.manggiohang.get(position).getSoluongsp();
                double giahientai= MainActivity.manggiohang.get(position).getGiasp();
                MainActivity.manggiohang.get(position).setSoluongsp(slmoinhat);
                double giamoinhat = (giahientai*slmoinhat)/slhientai;
                MainActivity.manggiohang.get(position).setGiasp(giamoinhat);
                DecimalFormat decimalFormat1 = new DecimalFormat("###,###,###");
                finalViewholder.txtgiagiohang.setText(decimalFormat1.format(giamoinhat)+"Đ");
                GiohangActivity.EventUltil();
                if (slmoinhat <2){
                    finalViewholder.btnvalues.setText(String.valueOf(slmoinhat));
                    finalViewholder.btnplus.setVisibility(View.VISIBLE);
                    finalViewholder.btnminus.setVisibility(View.INVISIBLE);


                }else {
                    finalViewholder.btnvalues.setText(String.valueOf(slmoinhat));
                    finalViewholder.btnminus.setVisibility(View.VISIBLE);
                    finalViewholder.btnplus.setVisibility(View.VISIBLE);

                }
            }
        });
        return view;
    }
}

