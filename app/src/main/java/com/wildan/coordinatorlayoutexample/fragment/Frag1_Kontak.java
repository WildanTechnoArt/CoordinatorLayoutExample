package com.wildan.coordinatorlayoutexample.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wildan.coordinatorlayoutexample.R;
import com.wildan.coordinatorlayoutexample.adapter.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class Frag1_Kontak extends Fragment {

    private ArrayList<String> NamaMeme;
    //Daftar Teman
    private String[] Judul = {"Wildan", "Taufan", "Aish", "Ferdi", "Taufik", "Dzaki", "Annisa",
            "Diki","Sinta","Agung","Andita","Dirham","Fadhil","Azis","Mukiidi","Tata"};


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view_frag1 = inflater.inflate(R.layout.fragment_frag1_kontak, container, false);
        NamaMeme = new ArrayList<>();
        RecyclerView recyclerView = view_frag1.findViewById(R.id.recycler);
        DaftarItem();
        //Menggunakan Layout Manager, Dan Membuat List Secara Vertical
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        RecyclerView.Adapter adapter = new RecyclerViewAdapter(NamaMeme);
        //Membuat Underline pada Setiap Item Didalam List
        DividerItemDecoration itemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        itemDecoration.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.line));
        recyclerView.addItemDecoration(itemDecoration);
        //Memasang Adapter pada RecyclerView
        recyclerView.setAdapter(adapter);
        return view_frag1;
    }

    //Mengambil data dari Varibale Gambar dan Judul, lalu memasangnya pada list yang terhubung dengan Class Adapter
    private void DaftarItem(){
        NamaMeme.addAll(Arrays.asList(Judul));
    }
}