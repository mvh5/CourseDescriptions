package com.example.mauricio.twoweekproject6;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Mauricio on 8/13/18.
 */


public class ListAdapter extends RecyclerView.Adapter {
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
            return new ListViewHolder(view);
        }
        View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item2,parent,false);
        return new SecondListViewHolder(view2);

    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return 2;
        } else {
            return 1;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (position % 2 == 1) {
            ((ListViewHolder)holder).bindView(position);
        } else {
            ((SecondListViewHolder) holder).bindView(position);
        }

    }

    @Override
    public int getItemCount() {
        return OurData.title.length;
    }

    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mItemText;
        private ImageView mItemImage;
        LinearLayout parentLayout;
        int position1;

        public ListViewHolder(View itemView) {
            super(itemView);
            mItemText = (TextView)itemView.findViewById(R.id.itemText);
            mItemImage = (ImageView) itemView.findViewById(R.id.itemImage);

            //Bitmap bitmap = BitmapFactory.decodeResource(itemView.getResources(),R.drawable.stlsm

            parentLayout = itemView.findViewById(R.id.parent_layout);
            itemView.setOnClickListener(this);

        }

        public void bindView(int position) {
            mItemText.setText(OurData.title[position]);
            //mItemImage.setImageResource(OurData.picturePath[position]); this line was originally

            Bitmap bitmap = BitmapFactory.decodeResource(itemView.getResources(),OurData.picturePath[position]);
            RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(mItemImage.getResources(),bitmap);
            roundedBitmapDrawable.setCircular(true);
            mItemImage.setImageDrawable(roundedBitmapDrawable);

            position1 = position;

        }

        public void onClick(View view) {
            //Toast.makeText(itemView.getContext(),mItemText.getText(),Toast.LENGTH_SHORT).show();
            //go to another screen when clicking
            Bundle bundle = new Bundle();
            bundle.putString("val1",mItemText.getText().toString());
            bundle.putInt("val2",OurData.picturePath[position1]);
            bundle.putString("val4",OurData.descriptions[position1]);
            Intent intent = new Intent(view.getContext(),GalleryActivity.class);
            //intent.putExtra("val1",mItemText.getText().toString());
            intent.putExtras(bundle);
            view.getContext().startActivity(intent);

            //intent.putExtra("image_url",mItemImage.get())

            //**note** not working. Still not able to go to another screen
        }
    }

    private class SecondListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mItemText;
        private ImageView mItemImage;
        LinearLayout parentLayout;
        int position1;
        //private TextView mItemText4;

        public SecondListViewHolder(View itemView) {
            super(itemView);
            mItemText = (TextView)itemView.findViewById(R.id.itemText2);
            mItemImage = (ImageView) itemView.findViewById(R.id.itemImage2);

            //Bitmap bitmap = BitmapFactory.decodeResource(itemView.getResources(),R.drawable.stlsm

            parentLayout = itemView.findViewById(R.id.parent_layout2);
            itemView.setOnClickListener(this);

        }

        public void bindView(int position) {
            mItemText.setText(OurData.title[position]);
            //mItemImage.setImageResource(OurData.picturePath[position]); this line was originally

            Bitmap bitmap = BitmapFactory.decodeResource(itemView.getResources(),OurData.picturePath[position]);
            RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(mItemImage.getResources(),bitmap);
            roundedBitmapDrawable.setCircular(true);
            mItemImage.setImageDrawable(roundedBitmapDrawable);

            position1 = position;

        }

        public void onClick(View view) {
            //Toast.makeText(itemView.getContext(),mItemText.getText(),Toast.LENGTH_SHORT).show();
            //go to another screen when clicking
            Bundle bundle = new Bundle();
            bundle.putString("val1",mItemText.getText().toString());
            bundle.putInt("val2",OurData.picturePath[position1]);
            bundle.putString("val4",OurData.descriptions[position1]);
            Intent intent = new Intent(view.getContext(),GalleryActivity.class);
            //intent.putExtra("val1",mItemText.getText().toString());
            intent.putExtras(bundle);
            view.getContext().startActivity(intent);

            //intent.putExtra("image_url",mItemImage.get())

            //**note** not working. Still not able to go to another screen
        }
    }
}
