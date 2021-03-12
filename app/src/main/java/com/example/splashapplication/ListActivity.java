package com.example.splashapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListActivity extends AppCompatActivity {
    ListView listView;
    String mTitle[]={"Teethwhitening","Bracelets","Fillings","Extraction","Rootcanal"};
    int images[]={R.drawable.whitening,R.drawable.bracelets,R.drawable.fillings,R.drawable.extraction,R.drawable.rootcanal};
    String mContent[]={"The process involves lightening of the tooth. It helps get rid of stains and discoloration from your teeth.Charges range from Kshs300 to Ksh500 per tooth. ","The use of devices to move teeth or adjust underlying bone.Charges are from Kshs50,000.","This is a way to restore a tooth damaged by decay back to its normal function and shape.","This is a relatively quick outpatient procedure with either local, general, intravenous anesthesia, or a combination.Charges are Kshs5,000. "," This is needed for a cracked tooth from injury or genetics, a deep cavity, or issues from a previous filling.The charges are Kshs12,000"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        listView= findViewById(R.id.listview);
        //create an adapter
            MyAdapter adapter=new MyAdapter(this,mTitle,images);
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
                String title = mTitle[position];
                String content = mContent[position];
                int image = images[position];

                Intent tembea = new Intent(getApplicationContext(),DetailsActivity.class);
                tembea.putExtra("title",title);
                tembea.putExtra("image",image);
                tembea.putExtra("content",content);
                startActivity(tembea);
            }
        });
        //check list view
    }
    class MyAdapter extends ArrayAdapter<String>{
        Context context;
        String rTitle[];
        int rImgs[];
        MyAdapter(Context c, String title[],int imgs[]){
            super(c, R.layout.row_data, R.id.tv_white,title);
            this.context=c;
            this.rTitle=title;
            this.rImgs=imgs;


        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater=  (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row=layoutInflater.inflate(R.layout.row_data,parent,false);
            ImageView images=row.findViewById(R.id.image);
            TextView myTitle=row.findViewById(R.id.tv_white);
            //now set our resources on view
            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            return row;
        }
    }
}