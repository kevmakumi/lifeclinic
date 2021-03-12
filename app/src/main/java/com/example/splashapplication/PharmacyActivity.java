package com.example.splashapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class PharmacyActivity extends AppCompatActivity {
    ListView listView;
    String rTitle[]={"Dental","Optical","Maternal"};
    int images[]={R.drawable.dental,R.drawable.optical,R.drawable.marter};
    String mContent[]={"Dental","Optical","Maternal"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pharmacy);
        listView= findViewById(R.id.List);
        //create an adapter
        PharmacyActivity.MyAdapter adapter=new PharmacyActivity.MyAdapter(this, rTitle,images);
        listView.setAdapter(adapter);
        //now set item click on list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                if (position== 0) {
//                    Toast.makeText(ListActivity.this, "Teethwhitening", Toast.LENGTH_SHORT).show();
//                }
//                if (position== 0) {
//                    Toast.makeText(ListActivity.this, "Bracelets", Toast.LENGTH_SHORT).show();
//                }
//                if (position== 0) {
//                    Toast.makeText(ListActivity.this, "Fillings", Toast.LENGTH_SHORT).show();
//                }
//                if (position== 0) {
//                    Toast.makeText(ListActivity.this, "Extraction", Toast.LENGTH_SHORT).show();
//                }
//                if (position== 0) {
//                    Toast.makeText(ListActivity.this, "Rootcanal", Toast.LENGTH_SHORT).show();
//                }
                String title = rTitle[position];
                String content = mContent[position];
                int image = images[position];

                Intent tembea = new Intent(getApplicationContext(),DetailsActivity2.class);
                tembea.putExtra("title",title);
                tembea.putExtra("image",image);
                tembea.putExtra("content",content);
                startActivity(tembea);
            }
        });
        //check list view
    }
    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String rTitle[];
        int rImgs[];
        MyAdapter(Context c, String title[],int imgs[]){
            super(c, R.layout.row_data, R.id.tv_dental,title);
            this.context=c;
            this.rTitle=title;
            this.rImgs=imgs;


        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater=  (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row=getLayoutInflater().inflate(R.layout.row2,parent,false);
            ImageView images=row.findViewById(R.id.image2);
            TextView myTitle=row.findViewById(R.id.tv_dental);
            //now set our resources on view
            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            return row;
        }
    }
}