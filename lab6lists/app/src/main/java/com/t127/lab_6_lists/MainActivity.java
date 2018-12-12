package com.t127.lab_6_lists;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Item> items;     // here is my class item
    private ItemsAdapter itemsAdapter; // adapter translate data type to view  // and here is the class adapter created with the methods
    private ListView lvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvItems = findViewById(R.id.itemList);
        items = new ArrayList<>();
        items.add(new Item("learn Android","School ")); // here i am instantiate a class
        items.add(new Item("Complete Assignment -1","School "));

        itemsAdapter = new ItemsAdapter(this,R.layout.row_layout,items);
        lvItems.setAdapter(itemsAdapter);

        Button btn = findViewById(R.id.add);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText et = findViewById(R.id.addItem);
                String text = et.getText().toString();
                if(!text.isEmpty())
                {
                    itemsAdapter.add(new Item(text, "Default text"));
                    et.setText("");
                }
            }
        });

        lvItems.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {

                final int pos = position;

                new AlertDialog.Builder(view.getContext()).setTitle("Warning!")
                        .setMessage("Do you want to remove this item!")
                        .setNegativeButton(android.R.string.no,null)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                items.remove(pos);
                                itemsAdapter.notifyDataSetChanged();
                            }
                        }).show();


                return true;
            }
        });

        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i = new Intent(view.getContext(), Details.class);
                i.putExtra("position",position);
                i.putExtra("title",items.get(position).getTitle());
                i.putExtra("note",items.get(position).getNote());
                startActivityForResult(i,EDIT_ITEM);

            }
        });

    }


    public static final int EDIT_ITEM =1;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode ==EDIT_ITEM){
            if(resultCode == RESULT_OK){
                int pos = data.getIntExtra("position",-1);
                if(pos!=-1){
                    String title = data.getStringExtra("title");
                    String note = data.getStringExtra("note");
                    Item item = items.get(pos);
                    item.setNote(note);
                    item.setTitle(title);
                    items.set(pos,item);
                    itemsAdapter.notifyDataSetChanged();
                }
            }
        }
    }
}
