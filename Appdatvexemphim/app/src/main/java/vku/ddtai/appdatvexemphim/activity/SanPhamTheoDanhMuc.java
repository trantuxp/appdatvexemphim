package vku.ddtai.appdatvexemphim.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import vku.ddtai.appdatvexemphim.R;
import vku.ddtai.appdatvexemphim.adapter.SanphamtheodanhmucAdapter;
import vku.ddtai.appdatvexemphim.model.Sanpham;
import vku.ddtai.appdatvexemphim.ultil.CheckConnection;

public class SanPhamTheoDanhMuc extends AppCompatActivity {

    Toolbar toolbar;
    ListView listView;
    SanphamtheodanhmucAdapter sanphamtheodanhmucAdapter;
    ArrayList<Sanpham> mangsanphamtheodanhmuc;

    int id=0;
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

    public int idloaisp=0;
    public String tenloaisp="";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_san_pham_theo_danh_muc);

        Anhxa();
        GetdataLoaisp();
        //
        if (CheckConnection.haveNetworkConnection(getApplicationContext())){ // nếu thành công
            toolbar.setTitle(tenloaisp);
            ActionToolBar();
            Getdata();
            setDataSanpham();
        }else {
            CheckConnection.ShowToast_Short(getApplicationContext(),"Bạn hãy kiểm tra kết nối");
            finish();
        }
    }
    private void setDataSanpham() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),Chitietsanpham.class);
                intent.putExtra("thongtinsanpham", mangsanphamtheodanhmuc.get(position));
                startActivity(intent);
            }
        });
    }
    private void GetdataLoaisp() {
        idloaisp= getIntent().getIntExtra("idloaisanpham",-1);
        tenloaisp=getIntent().getStringExtra("tenloaisanpham");
    }

    private void Getdata() {
        if (idloaisp==1) {
            mangsanphamtheodanhmuc.add(new Sanpham(1,"Ong Nhí Phiêu Lưu Ký: Giải Cứu Công Chúa Kiến",
                    "https://www.cgv.vn/media/catalog/product/cache/1/image/1800x/71252117777b696995f01934522c402d/m/a/main_poster_mtb_1_.jpg",
                    soluongve,gia,"Noel Cleary","",
                    "23.04.2021","88 phút","Hoạt Hình",
                    "Quá háo hức chào đón mùa xuân, Maya và Willy đã thức dậy khỏi giấc ngủ đông sớm hơn thời gian dự định. Từ đây, đôi bạn vô tình phải nhận một nhiệm vụ đặc biệt – bảo vệ và đưa quả trứng vàng đến ngôi nhà mới. Tuy nhiên, mọi rắc rối bắt đầu ập đến khi quả trứng nứt và cô công chúa kiến bé nhỏ ra đời. Maya, Willy và những người bạn đồng hành phải phối hợp cùng nhau để chăm sóc và bảo vệ công chúa kiến khỏi vô vàn nguy hiểm xung quanh. Trong hành trình đầy bất ngờ và gian nan này, Willy dần dần khám phá được một khía cạnh khác của bản thân – dịu dàng và kiên nhẫn với cô công chúa nhỏ. Bộ đôi Maya và Willy cũng đã trưởng thành hơn và tình bạn giữa họ càng trở nên thêm khăng khít và gắn bó."));

            mangsanphamtheodanhmuc.add(new Sanpham(2,"Trạng Tí Phiêu Lưu Ký",
                    "https://cdnmedia.thethaovanhoa.vn/Upload/O5NP4aFt6GVwE7JTFAOaA/files/2020/12/trang-ti-trailer%20(1).jpg", soluongve,gia,"Phan Gia Nhật Linh",
                    "Phan Gia Nhật Linh","30.04.2021",
                    "100 phút","hài hước",
                    "Trạng Tí chuyển thể từ truyện tranh nổi tiếng Thần đồng đất Việt, xoay quanh Tí - cậu bé thông minh, láu lỉnh. Cùng các bạn Sửu, Dần, Mẹo, cậu nhiều lần giúp triều đình thoát khỏi các tình huống nguy hiểm, chống lại ngoại bang"));
            mangsanphamtheodanhmuc.add(new Sanpham(3,"Lật Mặt: 48h",
                    "https://photo-cms-plo.zadn.vn/w800/Uploaded/2021/tmuihk/2021_04_17/poster-lat-mat_lpmy.jpg", soluongve,gia,"Lý Hải",
                    "Tiết Cương, Huỳnh Đông, Mạc Văn Khoa, Ốc Thanh Vân","16.04.20210",
                    "100 phút","123",
                    "Lật Mặt 5: 48H kể về Hiền - một cựu vận động viên võ thuật sau khi giải nghệ vì chấn thương đã cùng vợ và con gái về quê thăm gia đình Lâm. Họ bị cuốn vào một cuộc rượt đuổi với tay phản diện A Dìn. Để bảo vệ cho gia đình nhỏ, Hiền phải đưa vợ con chạy trốn khắp miền Tây sông nước với sự trợ giúp của người bạn thật thà và hài hước."));
            mangsanphamtheodanhmuc.add(new Sanpham(4,"Thiên Thần Hộ Mệnh - The Guardian",
                    "https://www.cgv.vn/media/catalog/product/cache/1/image/c5f0a1eff4c394a251036189ccddaacd/t/t/tthm_mainposster_digital_2_1_.jpg", soluongve,gia,"Victor Vũ",
                    "","30.04.2021",
                    "124 phút","Kinh Dị, Giật Gân, Tâm Lý",
                    "Cái chết của một cô ca sĩ nổi tiếng dẫn đến sự thành công của một cô ca sĩ trẻ khác. Câu chuyện này có liên quan như thế nào đến sự giúp đỡ của một \"thiên thần hộ mệnh\"?"));
            mangsanphamtheodanhmuc.add(new Sanpham(5,"Thám Tử Lừng Danh Conan: Viên Đạn Đỏ",
                    "https://www.cgv.vn/media/catalog/product/cache/1/image/c5f0a1eff4c394a251036189ccddaacd/c/o/conan_24_-_main_poster_1_.jpg", soluongve,gia,"Tomoka Nagaoka",
                    "","23.04.2021",
                    "110 phút","Romance, Action, Mystery, Thriller, Animation, Crime",
                    "Nhật Bản đang tổ chức lễ kỷ niệm World Sports Games (WSG), sự kiện thể thao lớn nhất thế giới tại Tokyo. \"Shinkansen\", con tàu siêu dẫn ống chân không đầu tiên trên thế giới được chế tạo từ công nghệ mới nhất của Nhật Bản sẽ được mở chạy và có thời gian trùng với thời khắc khai mạc WSG. Con tàu được thiết lập chạy từ Ga Shin Nagoya đến Ga Tokyo với tốc độ 1000km/h. Tuy nhiên, một sự cố kỳ lạ đã diễn ra trong bữa tiệc của các nhà tài trợ nổi tiếng, theo sau đó chính là hàng loạt vụ bắt cóc các giám đốc điều hành. Conan đã liên kết vụ này về vụ án bắt cóc hàng loạt liên quan đến WSG vào 15 năm trước ở Boston."));
            mangsanphamtheodanhmuc.add(new Sanpham(6,"Chiến Binh Cuối Cùng: Cuội Nguồn Của Quỷ",
                    "https://www.galaxycine.vn/media/2021/4/23/1200x1800_1619167308494.jpg", soluongve,gia,"Dmitriy Dyachenko",
                    "","30.04.2021",
                    "122 phút","Action, Adventure",
                    "Hòa bình đã được thiết lập tại Belogorie sau khi cái ác bị đánh bại và Ivan đang tận hưởng sự nổi tiếng mà anh xứng đáng. Không chỉ có được sự tín nhiệm từ gia đình, bạn bè và những điều mới lạ từ thế giới hiện đại đã mang tới cho anh một cuộc sống thoải mái, Ivan còn may mắn sở hữu thanh gươm phép thuật giúp việc di chuyển giữa hai thế giới trở nên thuận tiện hơn. Song, sự trỗi dậy của một ác quỷ cổ đại đã đe dọa thế giới ma thuật, Ivan quyết định hợp tác với những người bạn cũ và đối thủ của mình để bắt đầu cuộc hành trình dài tới vùng không gian mới, nhằm tìm cách đánh bạn kẻ thù cũng như trả lại hòa bình cho Belogorie.\n"));

            sanphamtheodanhmucAdapter.notifyDataSetChanged();
        }else {
            mangsanphamtheodanhmuc.add(new Sanpham(7,"Người Nhân Bản - Seobok",
                    "https://www.cgv.vn/media/catalog/product/cache/1/image/1800x/71252117777b696995f01934522c402d/m/a/main_poster_seobok_15.jpg", soluongve,gia,"Lee Yong-zoo","Park Bo Gum, Gong Yoo",
                    "15.04.2021","114 phút ","Hành Động, Khoa học giả tưởng",
                    "Người Nhân Bản kể về Ki-hun – một cựu đặc vụ sống tách biệt với thế giới bên ngoài kể từ sau biến cố trong quá khứ, chấp nhận thực hiện nhiệm vụ cuối cùng từ Cơ quan Tình báo. Anh phải chịu trách nhiệm di chuyển Seobok, một đối tượng thử nghiệm được tạo ra bằng cách nhân bản tế bào gốc và biến đổi gen. Tuy nhiên mọi việc không hề suôn sẻ với họ, khi Seobok trở thành mục tiêu của các thế lực khác với những tham vọng và âm mưu khó đoán. Ki-hun sẽ vượt qua tất cả những hiểm nguy đang chực chờ phía trước, hay Seobok cuối cùng sẽ rơi vào tay kẻ muốn chiếm đoạt vận mệnh của toàn nhân loại?"));
            mangsanphamtheodanhmuc.add(new Sanpham(8,"John Wick: Chapter 4",
                    "https://i.ytimg.com/vi/f204ICpO0fA/maxresdefault.jpg", soluongve,gia,"Keanu Reeves", "",
                    "21.05.2021","100 phút",
                    "hành động, tội phạm",
                    "to be updated"));
            mangsanphamtheodanhmuc.add(new Sanpham(9,"Biệt Đội Săn Ma Chuyển Kiếp - Ghostbusters Afterlife",
                    "https://dep.com.vn/wp-content/uploads/2019/12/featured-image-cua-phim-bie-doi-san-ma.jpg",soluongve, gia,"Jason Reitman", "Paul Rudd",
                    "05.03.2021","100 phút",
                    "hài hước, hành động, ly kỳ",
                    "Thương hiệu đình đám Ghostbusters tung trailer hậu truyện, hé lộ Biệt đội săn ma nhí. Phần phim sẽ có sự tham gia của \"Người Kiến\" Raul Rudd. Phim khởi chiếu tháng 7 năm 2020."));
            mangsanphamtheodanhmuc.add(new Sanpham(10,"Fast & Furious 9",
                    "https://www.cgv.vn/media/catalog/product/cache/1/image/c5f0a1eff4c394a251036189ccddaacd/f/f/ff9-fast-furious-9-cgv-poster.jpg", soluongve,gia,"Justin Lin", "Nathalie Emmanuel, Helen Mirren, Michelle Rodriguez, Charlize Theron, Vin Diesel",
                    "02.04.2021","100 phút",
                    "hành động, phiêu lưu",
                    ""));
            mangsanphamtheodanhmuc.add(new Sanpham(11,"Tà Năng Phan Dũng",
                    "https://phuotvivu.com/blog/wp-content/uploads/2017/12/trekking-ta-nang-phan-dung.jpg",soluongve, gia,"Trần Hữu Tấn", "",
                    "21.04.2021","100 phút",
                    "sinh tồn",
                    "to be updated"));
            mangsanphamtheodanhmuc.add(new Sanpham(12,"The Matrix 4",
                    "https://i.ytimg.com/vi/PRGbv1KT5O4/maxresdefault.jpg",soluongve, gia,"Lana Wachowski", "Carrie-Anne Moss, Keanu Reeves",
                    "21.05.2021","00 phút",
                    "hành động, giả tưởng",
                    "to be updated"));

        }
    }

    private void ActionToolBar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    private void Anhxa() {
        toolbar= findViewById(R.id.toolbarban);
        listView = findViewById(R.id.listviewban);
        mangsanphamtheodanhmuc = new ArrayList<>();
        sanphamtheodanhmucAdapter = new SanphamtheodanhmucAdapter(getApplicationContext(), mangsanphamtheodanhmuc);
        listView.setAdapter(sanphamtheodanhmucAdapter);

    }
}