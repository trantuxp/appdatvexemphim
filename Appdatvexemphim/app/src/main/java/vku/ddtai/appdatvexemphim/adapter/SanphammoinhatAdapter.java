package vku.ddtai.appdatvexemphim.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

import vku.ddtai.appdatvexemphim.R;
import vku.ddtai.appdatvexemphim.activity.Chitietsanpham;
import vku.ddtai.appdatvexemphim.model.Sanpham;
import vku.ddtai.appdatvexemphim.ultil.CheckConnection;

public class SanphammoinhatAdapter  extends RecyclerView.Adapter<SanphammoinhatAdapter.ItemHolder> {
        Context context;
        ArrayList<Sanpham> sanphamArrayList;

        public SanphammoinhatAdapter(Context context, ArrayList<Sanpham> sanphamArrayList) {
            this.context = context;
            this.sanphamArrayList = sanphamArrayList;
        }

        public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.dong_sanphammoinhat,null);
            ItemHolder itemHolder = new ItemHolder(v);

            return itemHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
            Sanpham sanpham = sanphamArrayList.get(position);
            holder.txttensanpham.setText(sanpham.getTensanpham());
            DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
            holder.txtgiasanpham.setText("Giá: "+decimalFormat.format(sanpham.getGia())+" Đ");
            holder.txtthoiluong.setText(sanpham.getThoiluong());
            Picasso.get().load(sanpham.getAnh()).error(R.drawable.imgerror).into(holder.imghinhsanpham);
        }

        @Override
        public int getItemCount() {
            return sanphamArrayList.size();
        }

        public class ItemHolder extends  RecyclerView.ViewHolder {
            public ImageView imghinhsanpham;
            public TextView txttensanpham, txtgiasanpham,txtthoiluong;

            public ItemHolder(View itemView) {
                super(itemView);
                imghinhsanpham = (ImageView) itemView.findViewById(R.id.imageviewsanpham);
                txtgiasanpham = (TextView) itemView.findViewById(R.id.textviewgiasanpham);
                txttensanpham = (TextView) itemView.findViewById(R.id.textviewtensanpham);
                txtthoiluong= (TextView) itemView.findViewById(R.id.textviewthoiluong);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(context, Chitietsanpham.class);
                        intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("thongtinsanpham",sanphamArrayList.get(getAdapterPosition()));
                        CheckConnection.ShowToast_Short(context, sanphamArrayList.get(getAdapterPosition()).getTensanpham());
                        context.startActivity(intent);

                    }
                });

            }
        }
}
