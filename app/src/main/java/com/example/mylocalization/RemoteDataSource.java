package com.example.mylocalization;

import android.content.Context;

public class RemoteDataSource {
    private Context context;

    public RemoteDataSource(Context context) {
        this.context = context;
    }

    public ProductModel getDetailProduct() {
        return new ProductModel(
                context.getString(R.string.name),
                context.getString(R.string.price),
                context.getString(R.string.store),
                context.getString(R.string.date),
                context.getString(R.string.rating),
                context.getString(R.string.countRating),
                context.getString(R.string.size),
                context.getString(R.string.color),
                context.getString(R.string.description),
                R.drawable.shoes
        );
    }
}
