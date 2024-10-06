package phucnph22239.poly.lovely_hotel.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import phucnph22239.poly.lovely_hotel.Fragment.FragmentLoaiPhong;
import phucnph22239.poly.lovely_hotel.Fragment.FragmentPhong;

public class TabPhongViewPagerAdapter extends FragmentStateAdapter {
    public TabPhongViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                return new FragmentPhong();
            case 1:
                return new FragmentLoaiPhong();

        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
