package com.example.and_03;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText name = (EditText) findViewById(R.id.name);
        final EditText price = (EditText) findViewById(R.id.count);
        final Button button = (Button) findViewById(R.id.button);
        final ListView listView = (ListView) findViewById(R.id.list);
        final ItemsAdapter itemsAdapter = new ItemsAdapter();
        listView.setAdapter(itemsAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemsAdapter.add(new Item(name.getText().toString(),Integer.valueOf(price.getText().toString())));
            }
        });
    }

    static class Item{
         String name;
         int price;

        public Item(){}

        public Item(String name, int price) {
            this.setName(name);
            this.setPrice(price);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }

    class ItemsAdapter extends ArrayAdapter<Item> {

         ItemsAdapter() {
            super(MainActivity.this, R.layout.second_layout);
        }

        @NotNull
        @Override
        public View getView(int position, @Nullable View convertView,@NotNull ViewGroup parent){
            //инициализация View и превращение second_layout в объект для использования в методе
            @SuppressLint("ViewHolder") final View view = getLayoutInflater().inflate(R.layout.second_layout,null);

            final Item item = getItem(position);

            ((TextView) view.findViewById(R.id.first_text)).setText(item.getName());
            ((TextView) view.findViewById(R.id.second_text)).setText(item.getPrice());

            return view;
        }
    }
}
