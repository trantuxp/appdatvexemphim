package vku.ddtai.appdatvexemphim.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

import vku.ddtai.appdatvexemphim.R;
import vku.ddtai.appdatvexemphim.model.Sanpham;

public class SanphammuaAdapter extends BaseAdapter {
    Context context;
    ArrayList<Sanpham> arrayListsanphammua;

    public SanphammuaAdapter(Context context, ArrayList<Sanpham> arrayListsanphammua) {
        this.context = context;
        this.arrayListsanphammua = arrayListsanphammua;
    }

    public int getCount() {
        return arrayListsanphammua.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayListsanphammua.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder {
        public TextView txttensanphammua, txtsovesanphammua, txtdongiasanphammua,txttongtienspmua;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (view == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); // giúp get được service là layout của chúng ta ra
            view = inflater.inflate(R.layout.dong_sanphammua, null); // view = giao dien dòng của listview ,view để vẽ
            viewHolder.txttensanphammua = (TextView) view.findViewById(R.id.txttenspmua);
            viewHolder.txtsovesanphammua = (TextView) view.findViewById(R.id.txtsovespmua);
            viewHolder.txtdongiasanphammua = (TextView) view.findViewById(R.id.txtdongiaspmua);
            viewHolder.txttongtienspmua =  view.findViewById(R.id.txttongtienspmua);

            view.setTag(viewHolder);
        } else {
            viewHolder = (SanphammuaAdapter.ViewHolder) view.getTag();
        }
        Sanpham sanpham = (Sanpham) getItem(position);
        viewHolder.txttensanphammua.setText(sanpham.getTensanpham()+"");
        viewHolder.txtsovesanphammua.setText(sanpham.getSoluongve()+"");
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.txtdongiasanphammua.setText("Giá: " + decimalFormat.format(sanpham.getGia()) + " Đ");
        viewHolder.txttongtienspmua.setText(String.valueOf(sanpham.getGia()+sanpham.getSoluongve()));
        return view;
    }
}
