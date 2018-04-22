package com.wildan.coordinatorlayoutexample.adapter;

import android.annotation.SuppressLint;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wildan.coordinatorlayoutexample.R;

import java.util.ArrayList;

//Class Adapter ini Digunakan Untuk Mengatur Bagaimana Data akan Ditampilkan
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private ArrayList<String> arrayList; //Digunakan untuk Judul
    private ArrayList<Integer> memeList; //Digunakan untuk Image/Gambar

    //Membuat Konstruktor pada Class RecyclerViewAdapter
    public RecyclerViewAdapter(ArrayList<String> arrayList){
        this.arrayList = arrayList;
    }

    //ViewHolder Digunakan Untuk Menyimpan Referensi Dari View-View
    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView JudulMeme, SubMeme;
        private ImageView Meme;
        private RelativeLayout ItemList;

        ViewHolder(View itemView) {
            super(itemView);
            //Menginisialisasi View-View untuk kita gunakan pada RecyclerView
            JudulMeme = itemView.findViewById(R.id.memetitle);
            SubMeme = itemView.findViewById(R.id.sub_meme);
            Meme = itemView.findViewById(R.id.meme);
            ItemList = itemView.findViewById(R.id.item_list);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Membuat View untuk Menyiapkan dan Memasang Layout yang Akan digunakan pada RecyclerView
        View V = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_design, parent, false);
        return new ViewHolder(V);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        //Memanggil Nilai/Value Pada View-View Yang Telah Dibuat pada Posisi Tertentu
        final String Nama = arrayList.get(position);//Mengambil data sesuai dengan posisi yang telah ditentukan
        holder.JudulMeme.setText(Nama);
        holder.SubMeme.setText("Gambar Meme Ke: "+position);
        //Membuat Aksi Saat Judul Pada List ditekan
        holder.JudulMeme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Gambar Meme: "+position+" Ditekan", Snackbar.LENGTH_SHORT).show();
            }
        });
        //Membuat Aksi Saat List Ditekan
        holder.ItemList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Nama Saya: "+Nama, Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        //Menghitung Ukuran/Jumlah Data Yang Akan Ditampilkan Pada RecyclerView
        return arrayList.size();
    }

}