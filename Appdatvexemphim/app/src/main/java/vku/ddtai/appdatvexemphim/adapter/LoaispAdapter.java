package vku.ddtai.appdatvexemphim.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import vku.ddtai.appdatvexemphim.R;
import vku.ddtai.appdatvexemphim.model.Loaisp;

public class LoaispAdapter extends BaseAdapter {
    ArrayList<Loaisp> arrayListLoaisp;
    Context context;

    public LoaispAdapter(ArrayList<Loaisp> arrayListLoaisp, Context context) {
        this.arrayListLoaisp = arrayListLoaisp;
        this.context = context;
    }

    public int getCount() {
        return arrayListLoaisp.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayListLoaisp.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder {
        TextView txttenloaisp;
        ImageView imgloaisp;

    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); // giúp get được service là layout của chúng ta ra
            view = inflater.inflate(R.layout.dong_listview_loaisp, null); // view = giao dien dòng của listview ,view để vẽ
            viewHolder.txttenloaisp = (TextView) view.findViewById(R.id.textviewloaisp);
            viewHolder.imgloaisp = (ImageView) view.findViewById(R.id.imageviewloaisp);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();


        }
        Loaisp loaisp = (Loaisp) getItem(position);
        viewHolder.txttenloaisp.setText(loaisp.getTenloaisp());
        Picasso.get().load(loaisp.getHinhloaisp()).placeholder(R.drawable.imgload)
                .error(R.drawable.imgerror)
                .into(viewHolder.imgloaisp);
        return view;
    }
}