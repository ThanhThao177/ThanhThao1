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

import phucnph22239.poly.lovely_hotel.DTO.KhachHang;
import phucnph22239.poly.lovely_hotel.R;

public class SpinnerKhachHangAdapter extends ArrayAdapter<KhachHang> {
    private Context context;
    private ArrayList<KhachHang> objects;
    TextView tvspnten;

    public SpinnerKhachHangAdapter(Context context, ArrayList<KhachHang> objects) {
        super(context, 0, objects);
        this.context = context;
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View holder = convertView;
        if (holder==null){
            LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            holder = inflater.inflate(R.layout.item_khach_hang_spinner,null);

        }
        final KhachHang obj = objects.get(position);
        if (obj != null){

            tvspnten = holder.findViewById(R.id.item_spn_khach_hang_ten);
            tvspnten.setText(obj.getName());
        }
        return holder;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View holder = convertView;
        if (holder==null){
            LayoutInflater inflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            holder = inflater.inflate(R.layout.item_khach_hang_spinner,null);

        }
        final KhachHang obj = objects.get(position);
        if (obj != null){
            tvspnten = holder.findViewById(R.id.item_spn_khach_hang_ten);
            tvspnten.setText(obj.getName());
        }
        return holder;
    }
}
