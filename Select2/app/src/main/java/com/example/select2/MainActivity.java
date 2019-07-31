package com.example.select2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Child_type> childType1s = new ArrayList<>();
    ArrayList<Child_type> child2type1s = new ArrayList<>();
    ArrayList<Child_type> child3type1s = new ArrayList<>();
    ArrayList<Child_type> child4type1s = new ArrayList<>();
    ArrayList<Parent> parents;

    RecyclerView parent_rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
        }
        parents = new ArrayList<>();
        Parent_data();
        Parent_adapter parent_adapter = new Parent_adapter(this,parents);
        parent_rv = findViewById(R.id.parent_recyclerview);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(MainActivity.this,RecyclerView.VERTICAL,false);
        parent_rv.setLayoutManager(layoutManager1);
        parent_rv.setAdapter(parent_adapter);
    }

    private void Child1_data() {
        Child_type child1 = new Child_type(R.drawable.recommendation_banner_1, "Wendsaday deal", "25% off for a table of two", "Dinner 25% off, and only 68USD/each in Solois Coffee",Child_type.CTYPE1);
        Child_type child2 = new Child_type(R.drawable.recommendation_banner_1,getResources().getString(R.string.deal_date),getResources().getString(R.string.tittle_deal),getResources().getString(R.string.content_deal),Child_type.CTYPE1);
        Child_type child3 = new Child_type(R.drawable.recommendation_banner_1,getResources().getString(R.string.deal_date),getResources().getString(R.string.tittle_deal),getResources().getString(R.string.content_deal),Child_type.CTYPE1);
        Child_type child4 = new Child_type(R.drawable.recommendation_banner_1,getResources().getString(R.string.deal_date),getResources().getString(R.string.tittle_deal),getResources().getString(R.string.content_deal),Child_type.CTYPE1);
        childType1s.add(child1);
        childType1s.add(child2);
        childType1s.add(child3);
        childType1s.add(child4);
    }
    private void  Child2_data() {
        Child_type child1 = new Child_type(R.drawable.drinks,getResources().getString(R.string.drinks),R.color.drink,Child_type.CTYPE2);
        Child_type child2 = new Child_type(R.drawable.greens,getResources().getString(R.string.greens),R.color.greens,Child_type.CTYPE2);
        child2type1s.add(child1);
        child2type1s.add(child2);
        child2type1s.add(child1);
        child2type1s.add(child2);
    }
    private void  Child3_data() {
        Child_type child1 = new Child_type(R.drawable.rectangle,getResources().getString(R.string.name1),getResources().getString(R.string.describ1),getResources().getString(R.string.price_saled1),getResources().getString(R.string.tx_price1),Child_type.CTYPE3);
        Child_type child2 = new Child_type(R.drawable.rectangle_2,getResources().getString(R.string.name2),getResources().getString(R.string.describ2),getResources().getString(R.string.price_saled2),getResources().getString(R.string.tx_price2),Child_type.CTYPE3);
        child3type1s.add(child1);
        child3type1s.add(child2);
        child3type1s.add(child1);
        child3type1s.add(child2);
    }
    private void Child4_data(){
        Child_type child1 = new Child_type(R.drawable.arrow_right_336,getResources().getString(R.string.tittle_child4_1),Child_type.CTYPE4);
        Child_type child2 = new Child_type(R.drawable.arrow_right_336,getResources().getString(R.string.tittle_child4_2),Child_type.CTYPE4);
        Child_type child3 = new Child_type(R.drawable.arrow_right_336,getResources().getString(R.string.tittle_child4_3),Child_type.CTYPE4);
        child4type1s.add(child1);
        child4type1s.add(child2);
        child4type1s.add(child3);
    }
    private void Parent_data(){
        Child1_data();
        Child2_data();
        Child3_data();
        Child4_data();
        Parent parent = new Parent(getResources().getString(R.string.tittle),getResources().getString(R.string.des),getResources().getString(R.string.stidk),childType1s,Parent.TYPE1);
        //Parent parent2 = new Parent(getResources().getString(R.string.tittle),getResources().getString(R.string.des),childType1s,Parent.TYPE2);
        Parent parent3 = new Parent(Parent.TYPE3);
        Parent parent4 = new Parent(getResources().getString(R.string.tittle2),getResources().getString(R.string.describ),child2type1s,Parent.TYPE1);
        Parent parent5 = new Parent(getResources().getString(R.string.tittle3),getResources().getString(R.string.des3),getResources().getString(R.string.stidk3),child3type1s,Parent.TYPE2);
        Parent parent6 = new Parent(getResources().getString(R.string.collumn),child4type1s,Parent.TYPE4);
        parents.add(parent);
        parents.add(parent3);
        parents.add(parent4);
        parents.add(parent5);
        parents.add(parent6);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
