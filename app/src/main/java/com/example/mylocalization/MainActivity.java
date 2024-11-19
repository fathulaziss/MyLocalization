package com.example.mylocalization;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.WindowInsets;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mylocalization.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupView();
        setupAction();
        setupData();
    }

    private void setupView() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            // For Android 11 (API level 30) and above
            if (getWindow().getInsetsController() != null) {
                getWindow().getInsetsController().hide(WindowInsets.Type.statusBars());
            }
        } else {
            // For Android 10 (API level 29) and below
            getWindow().setFlags(
                    WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN
            );
        }
        // Hide the Action Bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }

    private void setupAction() {
        binding.settingImageView.setOnClickListener(view -> {
            Intent intent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(intent);
        });
    }

    private void setupData() {
        RemoteDataSource repository = new RemoteDataSource(this);

        ProductModel product = repository.getDetailProduct();

        binding.previewImageView.setImageResource(product.getImage());
        binding.nameTextView.setText(product.getName());
        binding.storeTextView.setText(product.getStore());
        binding.colorTextView.setText(product.getColor());
        binding.sizeTextView.setText(product.getSize());
        binding.descTextView.setText(product.getDesc());
        binding.priceTextView.setText(Helper.withCurrencyFormat(product.getPrice()));

        binding.dateTextView.setText(getString(R.string.dateFormat, Helper.withDateFormat(product.getDate())));
        binding.ratingTextView.setText(String.format(getString(R.string.ratingFormat), Helper.withNumberingFormat(product.getRating()), Helper.withNumberingFormat(product.getCountRating())));
    }
}