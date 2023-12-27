package com.example.gladiance.Navigation.ControlBouquet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gladiance.R;

import java.util.List;

public class ControlBouquetAdapter extends RecyclerView.Adapter<ControlBouquetAdapter.MyViewHolder>{


    private static Context context;
    private List<String> titles;
    private List<Integer> images;



    public ControlBouquetAdapter(Context context, List<String> titles, List<Integer> images){

        this.context=context;
        this.titles=titles;
        this.images=images;
    }


    @NonNull
    @Override
    public ControlBouquetAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = LayoutInflater.from(context).inflate(R.layout.grid_item_control_bouquet,parent,false);
        return new ControlBouquetAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mTextView.setText(titles.get(position));
        holder.mImageView.setImageResource(images.get(position));
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        RelativeLayout bg2;


        ImageView mImageView;
        TextView mTextView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.imageView);
            mTextView = itemView.findViewById(R.id.textview);
            bg2 = itemView.findViewById(R.id.bg2);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Intent intent = new Intent(context, Seekbar.class);
                    // context.startActivities(new Intent[]{intent});
                    //  v.setBackgroundResource(R.drawable.recycleview_border);
                    bg2.setBackgroundResource(R.drawable.card_border);


                    Toast.makeText(v.getContext(), "You clicked "+ getAdapterPosition(), Toast.LENGTH_LONG).show();


//                    ControlBouquetHorizontalParentFragment fragment1 = new ControlBouquetHorizontalParentFragment();
//                    FragmentManager fragmentManager = fragment1.getChildFragmentManager();
//                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                    //fragmentTransaction.replace(android.R.id.fragment_control_bouquet_horizontal_parent, fragment1);
//                    fragmentTransaction.replace(R.id.frm, fragment1);
//
//                    fragmentTransaction.commit();

//                    Fragment fragment = CustomFragment.newInstance();
//
//                    FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
//                    transaction.replace(R.layout.fragment_control_bouquet_horizontal_parent, ControlBouquetHorizontalParentFragment.class);
//                    transaction.addToBackStack(null);
//                    transaction.commit();

//                   mImageView.setBackgroundResource(R.drawable.sun__glow3);

                    mImageView.setImageResource(R.drawable.sun__glow);



                }
            });


        }
    }

}
