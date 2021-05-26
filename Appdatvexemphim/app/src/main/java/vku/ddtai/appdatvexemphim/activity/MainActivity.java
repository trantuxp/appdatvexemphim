package vku.ddtai.appdatvexemphim.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ActionMenuItem;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import vku.ddtai.appdatvexemphim.R;
import vku.ddtai.appdatvexemphim.adapter.LoaispAdapter;
import vku.ddtai.appdatvexemphim.adapter.SanphammoinhatAdapter;
import vku.ddtai.appdatvexemphim.model.Giohang;
import vku.ddtai.appdatvexemphim.model.Loaisp;
import vku.ddtai.appdatvexemphim.model.Sanpham;
import vku.ddtai.appdatvexemphim.ultil.CheckConnection;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ViewFlipper viewFlipper;
    RecyclerView recyclerView;
    NavigationView navigationView;
    ListView listViewmanhinhchinh;
    DrawerLayout drawerLayout;

    ArrayList<Loaisp> mangloaisp;
    LoaispAdapter loaispAdapter;

    ArrayList<Sanpham> mangsanphammn;
    SanphammoinhatAdapter sanphammnadapter;

    public static ArrayList<Giohang> manggiohang ;

    int id=0;
    String tenloaisp="";
    String hinhanhloaisp= "";

    public String tensanpham="";
    public String anh="";
    public int soluongve=100;
    public long gia=60000;
    public String daodien="";
    public String dienvien="";
    public String khoichieu="";
    public String thoiluong="";
    public String ngonngu="";
    public String mota="";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        if (CheckConnection.haveNetworkConnection(getApplicationContext())){ // nếu thành công
            ActionBar();// menu
            ActionViewFlipper(); // quảng cáo
            GetLoaisp();// đổ dữ liệu loại sản phẩm vào mảng
            CatchOnItemListView();// sự kiện click của menu
            GetSanphammoinhat();


        }else {
            CheckConnection.ShowToast_Short(getApplicationContext(),"Bạn hãy kiểm tra kết nối");
            finish();
        }

    }

    private void GetSanphammoinhat() {
        mangsanphammn.add(new Sanpham(1,"Ong Nhí Phiêu Lưu Ký: Giải Cứu Công Chúa Kiến",
                "https://www.cgv.vn/media/catalog/product/cache/1/image/1800x/71252117777b696995f01934522c402d/m/a/main_poster_mtb_1_.jpg",soluongve,
                gia,"Noel Cleary","",
                "23.04.2021","88 phút","Hoạt Hình",
                "Quá háo hức chào đón mùa xuân, Maya và Willy đã thức dậy khỏi giấc ngủ đông sớm hơn thời gian dự định. Từ đây, đôi bạn vô tình phải nhận một nhiệm vụ đặc biệt – bảo vệ và đưa quả trứng vàng đến ngôi nhà mới. Tuy nhiên, mọi rắc rối bắt đầu ập đến khi quả trứng nứt và cô công chúa kiến bé nhỏ ra đời. Maya, Willy và những người bạn đồng hành phải phối hợp cùng nhau để chăm sóc và bảo vệ công chúa kiến khỏi vô vàn nguy hiểm xung quanh. Trong hành trình đầy bất ngờ và gian nan này, Willy dần dần khám phá được một khía cạnh khác của bản thân – dịu dàng và kiên nhẫn với cô công chúa nhỏ. Bộ đôi Maya và Willy cũng đã trưởng thành hơn và tình bạn giữa họ càng trở nên thêm khăng khít và gắn bó."));
        mangsanphammn.add(new Sanpham(2,"Trạng Tí Phiêu Lưu Ký",
                "https://cdnmedia.thethaovanhoa.vn/Upload/O5NP4aFt6GVwE7JTFAOaA/files/2020/12/trang-ti-trailer%20(1).jpg",soluongve, gia,"Phan Gia Nhật Linh",
                "Phan Gia Nhật Linh","30.04.2021",
                "100 phút","hài hước",
                "Trạng Tí chuyển thể từ truyện tranh nổi tiếng Thần đồng đất Việt, xoay quanh Tí - cậu bé thông minh, láu lỉnh. Cùng các bạn Sửu, Dần, Mẹo, cậu nhiều lần giúp triều đình thoát khỏi các tình huống nguy hiểm, chống lại ngoại bang"));
        mangsanphammn.add(new Sanpham(3,"Lật Mặt: 48h",
                "https://photo-cms-plo.zadn.vn/w800/Uploaded/2021/tmuihk/2021_04_17/poster-lat-mat_lpmy.jpg",soluongve, gia,"Lý Hải",
                "Tiết Cương, Huỳnh Đông, Mạc Văn Khoa, Ốc Thanh Vân","16.04.2021\"",
                "100 phút","123",
                "Lật Mặt 5: 48H kể về Hiền - một cựu vận động viên võ thuật sau khi giải nghệ vì chấn thương đã cùng vợ và con gái về quê thăm gia đình Lâm. Họ bị cuốn vào một cuộc rượt đuổi với tay phản diện A Dìn. Để bảo vệ cho gia đình nhỏ, Hiền phải đưa vợ con chạy trốn khắp miền Tây sông nước với sự trợ giúp của người bạn thật thà và hài hước."));
        mangsanphammn.add(new Sanpham(4,"Thiên Thần Hộ Mệnh - The Guardian",
                "https://www.cgv.vn/media/catalog/product/cache/1/image/c5f0a1eff4c394a251036189ccddaacd/t/t/tthm_mainposster_digital_2_1_.jpg",
                soluongve,gia,"Victor Vũ",
                "","30.04.2021",
                "124 phút","Kinh Dị, Giật Gân, Tâm Lý",
                "Cái chết của một cô ca sĩ nổi tiếng dẫn đến sự thành công của một cô ca sĩ trẻ khác. Câu chuyện này có liên quan như thế nào đến sự giúp đỡ của một \"thiên thần hộ mệnh\"?"));
            mangsanphammn.add(new Sanpham(5,"Thám Tử Lừng Danh Conan: Viên Đạn Đỏ",
                "https://www.cgv.vn/media/catalog/product/cache/1/image/c5f0a1eff4c394a251036189ccddaacd/c/o/conan_24_-_main_poster_1_.jpg", soluongve,gia,"Tomoka Nagaoka",
                "","23.04.2021",
                "110 phút","Romance, Action, Mystery, Thriller, Animation, Crime",
                "Nhật Bản đang tổ chức lễ kỷ niệm World Sports Games (WSG), sự kiện thể thao lớn nhất thế giới tại Tokyo. \"Shinkansen\", con tàu siêu dẫn ống chân không đầu tiên trên thế giới được chế tạo từ công nghệ mới nhất của Nhật Bản sẽ được mở chạy và có thời gian trùng với thời khắc khai mạc WSG. Con tàu được thiết lập chạy từ Ga Shin Nagoya đến Ga Tokyo với tốc độ 1000km/h. Tuy nhiên, một sự cố kỳ lạ đã diễn ra trong bữa tiệc của các nhà tài trợ nổi tiếng, theo sau đó chính là hàng loạt vụ bắt cóc các giám đốc điều hành. Conan đã liên kết vụ này về vụ án bắt cóc hàng loạt liên quan đến WSG vào 15 năm trước ở Boston."));
        mangsanphammn.add(new Sanpham(6,"Chiến Binh Cuối Cùng: Cuội Nguồn Của Quỷ",
                "https://www.galaxycine.vn/media/2021/4/23/1200x1800_1619167308494.jpg", soluongve,gia,"Dmitriy Dyachenko",
                "","30.04.2021",
                "122 phút","Action, Adventure",
                "Hòa bình đã được thiết lập tại Belogorie sau khi cái ác bị đánh bại và Ivan đang tận hưởng sự nổi tiếng mà anh xứng đáng. Không chỉ có được sự tín nhiệm từ gia đình, bạn bè và những điều mới lạ từ thế giới hiện đại đã mang tới cho anh một cuộc sống thoải mái, Ivan còn may mắn sở hữu thanh gươm phép thuật giúp việc di chuyển giữa hai thế giới trở nên thuận tiện hơn. Song, sự trỗi dậy của một ác quỷ cổ đại đã đe dọa thế giới ma thuật, Ivan quyết định hợp tác với những người bạn cũ và đối thủ của mình để bắt đầu cuộc hành trình dài tới vùng không gian mới, nhằm tìm cách đánh bạn kẻ thù cũng như trả lại hòa bình cho Belogorie.\n"));

        sanphammnadapter.notifyDataSetChanged();
    }

    private void GetLoaisp() {
        mangloaisp.add(0,new Loaisp(0,"Trang chính",
                "https://png.pngtree.com/png-vector/20190129/ourlarge/pngtree-home-icon-graphic-design-template-vector-png-image_358126.jpg"));
        mangloaisp.add(1,new Loaisp(1,"Phim đang chiếu ",
                "https://mayhutbuithongminh.com/images/apps/icon/4-phim-anh.png"));
        mangloaisp.add(2,new Loaisp(2,"Phim sắp chiếu",
                "https://lh3.googleusercontent.com/-JKb-keU4PjbwDmTP-0hm3aeK1lmq7p2c5eGg6tWN9hUpaSdXmeHg3FFV4SwUl0hbw"));
        mangloaisp.add(3,new Loaisp(3,"Trang chính",
                "https://cdn1.vectorstock.com/i/1000x1000/14/50/info-button-vector-3701450.jpg"));
        loaispAdapter.notifyDataSetChanged();
    }
    private void CatchOnItemListView() {
        listViewmanhinhchinh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        if (CheckConnection.haveNetworkConnection(getApplicationContext())){
                            Intent intent = new Intent(MainActivity.this,MainActivity.class);
                            startActivity(intent);
                        }else {
                            CheckConnection.ShowToast_Short(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối");

                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 1:
                        if (CheckConnection.haveNetworkConnection(getApplicationContext())){
                            Intent intent = new Intent( MainActivity.this, SanPhamTheoDanhMuc.class);
                            intent.putExtra("idloaisanpham",mangloaisp.get(position).getId());
                            intent.putExtra("tenloaisanpham",mangloaisp.get(position).getTenloaisp());
                            startActivity(intent);
                        }else {
                            CheckConnection.ShowToast_Short(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối");

                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 2:
                        if (CheckConnection.haveNetworkConnection(getApplicationContext())){
                            Intent intent = new Intent( MainActivity.this, SanPhamTheoDanhMuc.class);
                            intent.putExtra("idloaisanpham",mangloaisp.get(position).getId());
                            intent.putExtra("tenloaisanpham",mangloaisp.get(position).getTenloaisp());
                            startActivity(intent);
                        }else {
                            CheckConnection.ShowToast_Short(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối");

                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 3:
                        if (CheckConnection.haveNetworkConnection(getApplicationContext())){
                            Intent intent = new Intent( MainActivity.this, MainActivity.class);
                            startActivity(intent);
                        }else {
                            CheckConnection.ShowToast_Short(getApplicationContext(),"Bạn hãy kiểm tra lại kết nối");

                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;


                }
            }
        });
    }
    public String getURLForResource (int resourceId) {
        return Uri.parse("android.resource://"+R.class.getPackage().getName()+"/" +resourceId).toString();
    }
    private void ActionViewFlipper(){
//        String img1 = getURLForResource(R.drawable.img1);
//        String img2 = getURLForResource(R.drawable.img2);
//        String img3 = getURLForResource(R.drawable.img3);
//        String img4 = getURLForResource(R.drawable.img4);
        ArrayList<String> mangquangcao= new ArrayList<>();
        mangquangcao.add("https://www.cgv.vn/media/catalog/product/cache/1/image/1800x/71252117777b696995f01934522c402d/m/a/main_poster_mtb_1_.jpg");
        mangquangcao.add("https://cdnmedia.thethaovanhoa.vn/Upload/O5NP4aFt6GVwE7JTFAOaA/files/2020/12/trang-ti-trailer%20(1).jpg");
        mangquangcao.add("https://photo-cms-plo.zadn.vn/w800/Uploaded/2021/tmuihk/2021_04_17/poster-lat-mat_lpmy.jpg");
        mangquangcao.add("https://www.cgv.vn/media/catalog/product/cache/1/image/c5f0a1eff4c394a251036189ccddaacd/t/t/tthm_mainposster_digital_2_1_.jpg");

        for (int i =0;i<mangquangcao.size();i++){
            ImageView imageView =new ImageView(getApplicationContext());
            Picasso.get().load(mangquangcao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);
        Animation animaton = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_right);
        Animation animaton_out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_left);
        viewFlipper.setInAnimation(animaton);
        viewFlipper.setOutAnimation(animaton_out);


    }
    private void ActionBar(){

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }
    private void anhxa(){
        toolbar = findViewById(R.id.toolbartrangchinh);
        viewFlipper =  findViewById(R.id.viewflipper);
        recyclerView =  findViewById(R.id.recyclerview);
        navigationView =  findViewById(R.id.navigation);
        listViewmanhinhchinh =  findViewById(R.id.listviewmanhinhchinh);
        drawerLayout = findViewById(R.id.drawerlayout);

        mangloaisp = new ArrayList<>();
        loaispAdapter = new LoaispAdapter(mangloaisp, getApplicationContext());
        listViewmanhinhchinh.setAdapter(loaispAdapter);

        mangsanphammn =new ArrayList<>();
        sanphammnadapter = new SanphammoinhatAdapter(getApplicationContext(),mangsanphammn);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        recyclerView.setAdapter(sanphammnadapter);
        if (manggiohang!=null){

        }else {
            manggiohang= new ArrayList<>();

        }
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.account,menu);

        MenuItem item  ;
        if (Dangnhap.sessionid!=-1){
            Toast.makeText(this, Dangnhap.sessiontendn+"", Toast.LENGTH_SHORT).show();
            item = menu.findItem(R.id.menutaikhoan);;
            item.setTitle(Dangnhap.sessiontendn);
            getMenuInflater().inflate(R.menu.dangxuat,menu);
        }
        else {
            getMenuInflater().inflate(R.menu.dangnhap,menu);
        }
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }//tạo menu tới giỏ hàng


    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//

        if (item.getItemId()==R.id.menudangnhap){
            Intent intent2 = new Intent(getApplicationContext(), Dangnhap.class);
            startActivity(intent2);
        }
        else if (item.getItemId()==R.id.menudangxuat){
            Dangnhap.sessionid=-1;
            Dangnhap.sessiontendn="";
            Dangnhap.sessionmatkhaudn="";
            finish();
            startActivity(getIntent());
        }
        else {
            Intent intent1 = new Intent(getApplicationContext(), GiohangActivity.class);
            startActivity(intent1);
        }
        return super.onOptionsItemSelected(item);
    }
}