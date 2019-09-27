package com.example.recyclerviewhorizontalgridlayoutexample;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private Context context;
    private ArrayList<String>personName;
    private ArrayList<Integer>personImage;

    CustomAdapter(Context context, ArrayList<String> personName, ArrayList<Integer> personImage) {
        this.context = context;
        this.personName = personName;
        this.personImage = personImage;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from( context );
        View v = inflater.inflate( R.layout.rowlayout,parent,false );
        return new ViewHolder( v );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.name.setText( personName.get( position ) );
        holder.image.setImageResource( personImage.get( position ) );
        holder.image.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( context,SecondActivity.class );
                intent.putExtra( "image",personImage.get( position ) );
                context.startActivity( intent );
            }
        } );

    }

    @Override
    public int getItemCount() {
        return personName.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView image;
        ViewHolder(@NonNull View itemView) {
            super( itemView );
            name = itemView.findViewById( R.id.name );
            image = itemView.findViewById( R.id.image );
        }
    }
}
