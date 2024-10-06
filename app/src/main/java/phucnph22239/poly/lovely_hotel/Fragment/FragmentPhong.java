package phucnph22239.poly.lovely_hotel.Fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

import phucnph22239.poly.lovely_hotel.Adapter.LoaiPhongAdapter;
import phucnph22239.poly.lovely_hotel.Adapter.PhongAdapter;
import phucnph22239.poly.lovely_hotel.Adapter.SpinnerLoaiPhongAdapter;
import phucnph22239.poly.lovely_hotel.Adapter.viewpagerAdapter;
import phucnph22239.poly.lovely_hotel.DAO.PhongDao;
import phucnph22239.poly.lovely_hotel.DAO.LoaiPhongDAO;
import phucnph22239.poly.lovely_hotel.DTO.Phong;
import phucnph22239.poly.lovely_hotel.DTO.LoaiPhong;
import phucnph22239.poly.lovely_hotel.R;


public class FragmentPhong extends Fragment {
    static final String TAG ="zzzzz";
    private RecyclerView recyclerView;
    private PhongDao phongDAO;
    private LoaiPhongDAO loaiphongDAO;
    private List<Phong> list=new ArrayList<Phong>();
    private PhongAdapter adapter;
    private FloatingActionButton button;
    private TextInputEditText dialog_ed_tenphong,dialog_ed_giaphong;
    private Spinner dialog_spn_loaiphong;
    private Button dialog_btn_themphong,dialog_btn_huythemphong;

    int loaiPhong;
    List<LoaiPhong> listLoaiPhong;
    SpinnerLoaiPhongAdapter spinnerLoaiPhongAdapter;
    Phong phong ;

    List<String> loi;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_phong, container, false);
        phongDAO=new PhongDao(getContext());
        recyclerView=view.findViewById(R.id.rcv_phong);
        list=phongDAO.getAll();
        button=view.findViewById(R.id.fab_add_phong);
        listLoaiPhong = new ArrayList<>();
        loaiphongDAO = new LoaiPhongDAO(getActivity());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listLoaiPhong = loaiphongDAO.getAll();
                if (listLoaiPhong.size()==0){
                    loi.add(" Loại phòng ");
                }
                if (loi.isEmpty()){
                    opendialog();
                }else{
                    Toast.makeText(getActivity(), "Bạn chưa thêm : "+loi, Toast.LENGTH_SHORT).show();
                    loi = new ArrayList<>();
                }

            }
        });
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter=new PhongAdapter(getContext(),list);
        recyclerView.setAdapter(adapter);
        loi = new ArrayList<>();

        return view;

    }
    private void opendialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_them_phong, null);
        builder.setView(view);
        Dialog dialog = builder.create();
        Window window = dialog.getWindow();
        if(window==null){
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
        dialog_ed_tenphong=dialog.findViewById(R.id.dialog_ed_tenphong);
        dialog_ed_giaphong=dialog.findViewById(R.id.dialog_ed_giaphong);
        dialog_spn_loaiphong=dialog.findViewById(R.id.dialog_spn_loaiphong);
        dialog_btn_themphong=dialog.findViewById(R.id.dialog_btn_themphong);
        dialog_btn_huythemphong=dialog.findViewById(R.id.dialog_btn_huythemphong);

        spinnerLoaiPhongAdapter = new SpinnerLoaiPhongAdapter(getContext(), (ArrayList<LoaiPhong>) loaiphongDAO.getAll());
        dialog_spn_loaiphong.setAdapter(spinnerLoaiPhongAdapter);
        dialog_spn_loaiphong.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                listLoaiPhong = loaiphongDAO.getAll();
                loaiPhong = listLoaiPhong.get(position).getId();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        dialog_btn_themphong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dialog_ed_tenphong.getText().length() == 0) {
                    Toast.makeText(getContext(), "Không được để trống", Toast.LENGTH_SHORT).show();
                } else {
                    phong = new Phong();
                    phong.setName(dialog_ed_tenphong.getText().toString());
                    phong.setRoom_type_id(loaiPhong);
                    phong.setPrice(Integer.parseInt(dialog_ed_giaphong.getText().toString()));
                    phong.setStatus(0);
                    if (phongDAO.insert(phong) > 0) {
                        Toast.makeText(getContext(), "Thêm phòng thành công", Toast.LENGTH_SHORT).show();
                        list.clear();
                        list.addAll(phongDAO.getAll());
                        adapter.notifyDataSetChanged();
                        dialog.dismiss();
                    } else {
                        Toast.makeText(getContext(), "Thêm phòng thất bại", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        dialog_btn_huythemphong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }

}
