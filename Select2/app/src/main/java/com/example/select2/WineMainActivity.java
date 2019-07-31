package com.example.select2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class WineMainActivity extends AppCompatActivity {
    Spinner style,filter,region,togowith,type;
    String[] strings = {"Red Wine","White Wine"};
    String[] string2 = {"Smart filter","White Wine"};
    String[] string3 = {"Region","White"};
    String[] string4 = {"To go with","White"};
    String[] string5 = {"Type","White"};
    ArrayList<GridModel> gridModelArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wine_main);
        style = findViewById(R.id.spinner);
        filter = findViewById(R.id.spinner2);
        region = findViewById(R.id.spinner3);
        togowith = findViewById(R.id.spinner4);
        type = findViewById(R.id.spinner5);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,strings);
        style.setAdapter(adapter);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,string2);
        filter.setAdapter(adapter2);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,R.layout.spinner_item,string3);
        region.setAdapter(adapter3);
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this,R.layout.spinner_item,string4);
        togowith.setAdapter(adapter4);
        ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(this,R.layout.spinner_item,string5);
        type.setAdapter(adapter5);


        GridData();
        RecyclerView gridView = findViewById(R.id.gridView);
        Grid_Adapter grid_adapter = new Grid_Adapter(gridModelArrayList,this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        gridView.setLayoutManager(layoutManager);
        gridView.setAdapter(grid_adapter);

        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setHomeAsUpIndicator(R.drawable.back_icon);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
    private void GridData(){
        GridModel gridModel = new GridModel(R.drawable.wine_image,"Empreinte Tradition 2011 - Cotes Du Jura","Intense garnet red color, great balance and complexity elegant.","30USD / Bottle",true,false);
        GridModel gridModel2 = new GridModel(R.drawable.wine2_image,"Cabernet Sauvignon 2013","A rich, dense ruby color, hints at the dark fruit nose of blackberry.","130USD / Bottle",false,true);
        GridModel gridModel3 = new GridModel(R.drawable.wine3_image,"Cabernet Sauvignon 2013","A rich, dense ruby color, hints at the dark fruit nose of blackberry.","130USD / Bottle",true,true);
        GridModel gridModel4 = new GridModel(R.drawable.rectangle_5,"Cabernet Sauvignon 2013","A rich, dense ruby color, hints at the dark fruit nose of blackberry.","130USD / Bottle",false,false);
        gridModelArrayList.add(gridModel);
        gridModelArrayList.add(gridModel2);
        gridModelArrayList.add(gridModel3);
        gridModelArrayList.add(gridModel4);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:break;
        }

        return super.onOptionsItemSelected(item);
    }
}
