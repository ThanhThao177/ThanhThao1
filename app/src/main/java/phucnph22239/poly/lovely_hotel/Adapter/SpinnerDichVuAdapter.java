package phucnph22239.poly.lovely_hotel.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import phucnph22239.poly.lovely_hotel.DAO.PhongDao;
import phucnph22239.poly.lovely_hotel.DTO.HoaDon;
import phucnph22239.poly.lovely_hotel.DTO.LoaiDichVu;
import phucnph22239.poly.lovely_hotel.DTO.LoaiPhong;
import phucnph22239.poly.lovely_hotel.R;

public class SpinnerDichVuAdapter extends ArrayAdapter<LoaiDichVu> {
    private Context context;
    private ArrayList<LoaiDichVu> objects;

    TextView tvspntendv;

    public SpinnerDichVuAdapter( Context context, ArrayList<LoaiDichVu> objects) {
        super(context, 0, objects);
        this.context = context;
        this.objects = objects;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View holder = convertView;
        if (holder==null){
            LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            holder = inflater.inflate(R.layout.item_loai_dv_spinner,null);

        }
        final LoaiDichVu obj = objects.get(position);
        if (obj != null){
            tvspntendv = holder.findViewById(R.id.item_spn_loai_dv);
            tvspntendv.setText(obj.getName());
            }
        return holder;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View holder = convertView;
        if (holder==null){
            LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            holder = inflater.inflate(R.layout.item_loai_dv_spinner,null);

        }
        final LoaiDichVu obj = objects.get(position);
        if (obj != null){
            tvspntendv = holder.findViewById(R.id.item_spn_loai_dv);
            tvspntendv.setText(obj.getName());
        }
        return holder;
    }
}
