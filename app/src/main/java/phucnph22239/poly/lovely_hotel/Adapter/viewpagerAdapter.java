package phucnph22239.poly.lovely_hotel.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import phucnph22239.poly.lovely_hotel.Fragment.FragmentDoiMatKhau;
import phucnph22239.poly.lovely_hotel.Fragment.FragmentHoaDon;
import phucnph22239.poly.lovely_hotel.Fragment.FragmentPhong;
import phucnph22239.poly.lovely_hotel.Fragment.FragmentTabDichVu;
import phucnph22239.poly.lovely_hotel.Fragment.FragmentTabPhong;
import phucnph22239.poly.lovely_hotel.Fragment.FragmentThongKe;
import phucnph22239.poly.lovely_hotel.Fragment.Fragment_don_dich_vu;
import phucnph22239.poly.lovely_hotel.Fragment.Fragment_khachhang;

public class viewpagerAdapter extends FragmentStatePagerAdapter {
    public viewpagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                return new FragmentHoaDon();
            case 1:
                return new FragmentTabDichVu();
            case 2:
                return new FragmentTabPhong();
            case 3:
                return new Fragment_khachhang();
            case 4:
                return new FragmentThongKe();
        }
        return fragment;
    }
    @Override
    public int getCount() {
        return 5;
    }
}
