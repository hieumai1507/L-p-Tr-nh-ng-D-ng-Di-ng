package com.example.a43204_new.ui.theme.tuan6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a43204_new.R;
import com.squareup.picasso.Picasso;
//import com.squareup.picasso.Picasso;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends BaseAdapter {
    private Context mContext;
    private List<Product> mProductList;

    public ProductAdapter(Context context, List<Product> productList) {
        this.mContext = context;
        this.mProductList = productList != null ? productList : new ArrayList<>();
    }

    @Override
    public int getCount() {
        if (mProductList == null) {
            return 0;
        } else {
            return mProductList.size();
        }
    }

    @Override
    public Object getItem(int position) {
        return mProductList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //create view
        ViewHolderT61 holder;
        if(convertView == null) {//create new view
            //object generate layout
            convertView=LayoutInflater.from(mContext).inflate(R.layout.item_viewt61, parent, false);
            holder = new ViewHolderT61();
            //reference each field
            holder.imageView = convertView.findViewById(R.id.item_product_imageView);
            holder.styleidTv = convertView.findViewById(R.id.item_styleid_textview);
            holder.brandTv = convertView.findViewById(R.id.item_brand_textview);
            holder.priceTv = convertView.findViewById(R.id.item_price_textview);
            holder.additionalInfoTv = convertView.findViewById(R.id.item_additionInfo_textview);
            //create a template for later
            convertView.setTag(holder);
        }
        else {
            //get old view
            holder=(ViewHolderT61)
 convertView.getTag();
        }
        //set data for view
        Product product=mProductList.get(position);
        if(product != null) {
            //display image
            Picasso.get().load(product.getSearchImage()).into(holder.imageView);
            //set data for other fields
            holder.additionalInfoTv.setText(product.getAdditionInfo());
            holder.brandTv.setText(product.getBrand());
            holder.priceTv.setText(product.getPrice());
            holder.styleidTv.setText(product.getStyleId());

        }
        return convertView;
    }
    static  class ViewHolderT61 {
        ImageView imageView;
        TextView styleidTv, brandTv, priceTv, additionalInfoTv;
    }
}