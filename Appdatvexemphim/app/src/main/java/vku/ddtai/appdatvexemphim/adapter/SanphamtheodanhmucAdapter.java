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

public class SanphamtheodanhmucAdapter extends BaseAdapter {
    Context context;
    ArrayList<Sanpham> arrayListban;

    public SanphamtheodanhmucAdapter(Context context, ArrayList<Sanpham> arrayListban) {
        this.context = context;
        this.arrayListban = arrayListban;
    }

    public int getCount() {
        return arrayListban.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayListban.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder {
        public TextView txtban, txtgiaban, txtmotaban;
        public ImageView imgban;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (view == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); // giúp get được service là layout của chúng ta ra
            view = inflater.inflate(R.layout.dong_sanphamtheodanhmuc, null); // view = giao dien dòng của listview ,view để vẽ
            viewHolder.txtban = (TextView) view.findViewById(R.id.txtban);
            viewHolder.txtgiaban = (TextView) view.findViewById(R.id.txtgiaban);
            viewHolder.txtmotaban = (TextView) view.findViewById(R.id.txtmotaban);
            viewHolder.imgban = (ImageView) view.findViewById(R.id.imgban);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        Sanpham sanpham = (Sanpham) getItem(position);
        viewHolder.txtban.setText(sanpham.getTensanpham());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.txtgiaban.setText("Giá: " + decimalFormat.format(sanpham.getGia()) + " Đ");
        viewHolder.txtmotaban.setMaxLines(2);
        viewHolder.txtmotaban.setEllipsize(TextUtils.TruncateAt.END);
        viewHolder.txtmotaban.setText(sanpham.getMota());
        Picasso.get().load(sanpham.getAnh()).placeholder(R.drawable.imgload)
                .error(R.drawable.imgerror)
                .into(viewHolder.imgban);
        return view;
    }
}
