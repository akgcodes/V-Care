package com.minor.e_commerce;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HorizontalProductScrollAdapter extends RecyclerView.Adapter<HorizontalProductScrollAdapter.ViewHolder> {


    private List<HorizontProductScrollModel> horizontProductScrollModelList;

    public HorizontalProductScrollAdapter(List<HorizontProductScrollModel> horizontProductScrollModelList) {
        this.horizontProductScrollModelList = horizontProductScrollModelList;
    }

    @NonNull
    @Override
    public HorizontalProductScrollAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizont_scroll_item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalProductScrollAdapter.ViewHolder holder, int position) {

        int resource = horizontProductScrollModelList.get(position).getProductImage();
        String title = horizontProductScrollModelList.get(position).getProductTitle();
        String description = horizontProductScrollModelList.get(position).getProductDescription();
        String price = horizontProductScrollModelList.get(position).getProductPrice();
        holder.setProductImage(resource);
        holder.setProductTitle(title);
        holder.setProductDescription(description);
        holder.setProductPrice(price);

    }

    @Override
    public int getItemCount() {
        return horizontProductScrollModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView productImage;
        private TextView productTitle;
        private  TextView productDescription;
        private  TextView productPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            productImage = itemView.findViewById(R.id.h_s_product_image);
            productTitle = itemView.findViewById(R.id.h_s_product_title);
            productDescription = itemView.findViewById(R.id.h_s_product_description);
            productPrice = itemView.findViewById(R.id.h_s_product_price);
        }

        private void setProductImage(int resource) {
            productImage.setImageResource(resource);

        }
        private  void setProductTitle(String title){
            productTitle.setText(title);
        }
        private  void setProductDescription(String description){
            productDescription.setText(description);
        }
        private  void setProductPrice(String price){
            productPrice.setText(price);
        }
    }
}
