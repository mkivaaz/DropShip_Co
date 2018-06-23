package org.com.dropship_co.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.com.dropship_co.Data.Category;
import org.com.dropship_co.R;

import java.util.List;

public class HomeCategoryAdapter extends RecyclerView.Adapter<HomeCategoryAdapter.CategoryVH> {

    Context context;
    List<Category> categoryList;
    LayoutInflater inflater;

    public HomeCategoryAdapter(Context context, List<Category> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public CategoryVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.adapter_categories,null,false);
        CategoryVH holder = new CategoryVH(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(CategoryVH holder, int position) {
        holder.categoryName.setText(categoryList.get(position).getCategoryName());
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    class CategoryVH extends RecyclerView.ViewHolder{

        TextView categoryName;
        ImageView categoryIcon;

        public CategoryVH(View itemView) {
            super(itemView);

            categoryName = itemView.findViewById(R.id.categoryName);
            categoryIcon = itemView.findViewById(R.id.categoryIcon);
        }
    }
}
