package phucnph22239.poly.lovely_hotel.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import phucnph22239.poly.lovely_hotel.DAO.HoaDonDAO;
import phucnph22239.poly.lovely_hotel.DAO.KhachHangDAO;
import phucnph22239.poly.lovely_hotel.DAO.PhongDao;
import phucnph22239.poly.lovely_hotel.DTO.HoaDon;
import phucnph22239.poly.lovely_hotel.DTO.KhachHang;
import phucnph22239.poly.lovely_hotel.R;

public class SpinnerHoaDonAdapter extends ArrayAdapter<HoaDon> {
    private Context context;
    private ArrayList<HoaDon> objects;


    TextView tvspntenphong,tvspntenkhachhang,tvtungay,tvdenngay;
    public SpinnerHoaDonAdapter(@NonNull Context context, ArrayList<HoaDon> objects) {
        super(context, 0, objects);
        this.context = context;
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View holder = convertView;
        if (holder==null){
            LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            holder = inflater.inflate(R.layout.item_hoa_don_spinner,null);

        }
        final HoaDon obj = objects.get(position);
        if (obj != null){
            tvspntenphong = holder.findViewById(R.id.item_spn_hoa_don_ten_phong);
            tvspntenkhachhang = holder.findViewById(R.id.item_spn_hoa_don_ten_khach_hang);
            tvtungay = holder.findViewById(R.id.item_spn_hoa_don_tu_ngay);
            tvdenngay = holder.findViewById(R.id.item_spn_hoa_don_den_ngay);

            tvtungay.setText("Từ "+obj.getStart_date());
            tvdenngay.setText("đến "+obj.getEnd_date());

            PhongDao phongDao = new PhongDao(context);
            tvspntenphong.setText("Phòng: "+phongDao.getID(String.valueOf(obj.getRoom_id())).getName()) ;

            KhachHangDAO khachHangDAO = new KhachHangDAO(context);
            tvspntenkhachhang.setText("KH: "+khachHangDAO.getID(String.valueOf(obj.getGuest_id())).getName());


        }
        return holder;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View holder = convertView;
        if (holder==null){
            LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            holder = inflater.inflate(R.layout.item_hoa_don_spinner,null);

        }
        final HoaDon obj = objects.get(position);
        if (obj != null){
            tvspntenphong = holder.findViewById(R.id.item_spn_hoa_don_ten_phong);
            tvspntenkhachhang = holder.findViewById(R.id.item_spn_hoa_don_ten_khach_hang);
            tvtungay = holder.findViewById(R.id.item_spn_hoa_don_tu_ngay);
            tvdenngay = holder.findViewById(R.id.item_spn_hoa_don_den_ngay);

            tvtungay.setText("Từ "+obj.getStart_date());
            tvdenngay.setText("đến "+obj.getEnd_date());

            PhongDao phongDao = new PhongDao(context);
            tvspntenphong.setText("Phòng : "+phongDao.getID(String.valueOf(obj.getRoom_id())).getName());

            KhachHangDAO khachHangDAO = new KhachHangDAO(context);
            tvspntenkhachhang.setText("Khách hàng: "+khachHangDAO.getID(String.valueOf(obj.getGuest_id())).getName());


        }
        return holder;
    }
}
