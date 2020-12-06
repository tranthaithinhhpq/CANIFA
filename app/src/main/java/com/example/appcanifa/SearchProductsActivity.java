package com.example.appcanifa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;

import com.example.appcanifa.Model.Products;
import com.example.appcanifa.ViewHolder.ProductViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SearchProductsActivity extends AppCompatActivity {
    private Button SearchBtn;
    private String Search_Input;
    private EditText inputText;
    private RecyclerView searchList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_products);

        inputText = findViewById(R.id.search_products_name);
        SearchBtn = findViewById(R.id.search_btn);
        searchList = findViewById(R.id.search_list);
        searchList.setLayoutManager(new LinearLayoutManager(SearchProductsActivity.this));
        SearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Search_Input = inputText.getText().toString();
                onStart();
            }
        });
    }



    protected void OnStart() {
        super.onStart();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Products");
        FirebaseRecyclerOptions<Products>options=
                 new FirebaseRecyclerOptions.Builder<Products>().setQuery(reference.orderByChild("pname"),Products.class)
                .build();
        FirebaseRecyclerAdapter<Products , ProductViewHolder> adapter =
                 new FirebaseRecyclerAdapter<Products, ProductViewHolder>(options) {
                     @Override
                     protected void onBindViewHolder(@NonNull ProductViewHolder holder, int position, @NonNull Products model) {

                     }

                     @NonNull
                     @Override
                     public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                         return null;
                     }
                 };
            }

        }
