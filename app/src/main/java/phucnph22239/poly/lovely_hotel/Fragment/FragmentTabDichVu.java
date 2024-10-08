package phucnph22239.poly.lovely_hotel.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import phucnph22239.poly.lovely_hotel.Adapter.TabDichVuViewPagerAdapter;
import phucnph22239.poly.lovely_hotel.R;

public class FragmentTabDichVu extends Fragment {
    private TabLayout mTabLayout;
    private ViewPager2 mViewPager2;
    private TabDichVuViewPagerAdapter tabDichVuViewPagerAdapter;

    public FragmentTabDichVu() {
        // Required empty public constructor
    }


    public static FragmentTabDichVu newInstance(String param1, String param2) {
        FragmentTabDichVu fragment = new FragmentTabDichVu();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab_dich_vu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTabLayout = view.findViewById(R.id.id_tablayout_dich_vu);
        mViewPager2 = view.findViewById(R.id.id_viewpager_dich_vu);
        tabDichVuViewPagerAdapter  = new TabDichVuViewPagerAdapter(getActivity());
        mViewPager2.setAdapter(tabDichVuViewPagerAdapter);
        TabLayoutMediator mediator = new TabLayoutMediator(mTabLayout, mViewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText("Đơn dịch vụ");
                        break;
                    case 1:
                        tab.setText("Loại dịch vụ");
                        break;

                }
            }
        });
        mediator.attach();
    }
}