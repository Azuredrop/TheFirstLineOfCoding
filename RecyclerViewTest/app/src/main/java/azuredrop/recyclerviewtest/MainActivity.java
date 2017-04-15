package azuredrop.recyclerviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Fruit> mFruitList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFruits();

        // vertical
        RecyclerView recyclerView_vertical = (RecyclerView) findViewById(R.id.recycler_view_vertical);
        LinearLayoutManager layoutManager_vertical = new LinearLayoutManager(this);
        recyclerView_vertical.setLayoutManager(layoutManager_vertical);
        FruitAdapter adapter_vertical = new FruitAdapter(mFruitList, R.layout.fruit_item_vertical);
        recyclerView_vertical.setAdapter(adapter_vertical);

        // vertical
        RecyclerView recyclerView_horizontal = (RecyclerView) findViewById(R.id.recycler_view_horizontal);
        LinearLayoutManager layoutManager_horizontal = new LinearLayoutManager(this);
        layoutManager_horizontal.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView_horizontal.setLayoutManager(layoutManager_horizontal);
        FruitAdapter adapter_horizontal = new FruitAdapter(mFruitList, R.layout.fruit_item_horizontal);
        recyclerView_horizontal.setAdapter(adapter_horizontal);

        // stagger
        RecyclerView recyclerView_stagger = (RecyclerView) findViewById(R.id.recycler_view_stagger);
        StaggeredGridLayoutManager layoutManager_stagger = new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);
        recyclerView_stagger.setLayoutManager(layoutManager_stagger);
        FruitAdapter adapter_stagger = new FruitAdapter(mFruitList, R.layout.fruit_item_stagger);
        recyclerView_stagger.setAdapter(adapter_stagger);
    }

    private void initFruits(){
        for (int i = 0; i < 3; i++) {
            Fruit apple = new Fruit("Apple", R.drawable.apple_pic);
            mFruitList.add(apple);
            Fruit banana = new Fruit("Banana", R.drawable.banana_pic);
            mFruitList.add(banana);
            Fruit orange = new Fruit("Orange", R.drawable.orange_pic);
            mFruitList.add(orange);
            Fruit watermelon = new Fruit("Watermelon", R.drawable.watermelon_pic);
            mFruitList.add(watermelon);
            Fruit pear = new Fruit("Pear", R.drawable.pear_pic);
            mFruitList.add(pear);
            Fruit grape = new Fruit("Grape", R.drawable.grape_pic);
            mFruitList.add(grape);
            Fruit pineapple = new Fruit("Pineapple", R.drawable.pineapple_pic);
            mFruitList.add(pineapple);
            Fruit strawberry = new Fruit("Strawberry", R.drawable.strawberry_pic);
            mFruitList.add(strawberry);
            Fruit cherry = new Fruit("Cherry", R.drawable.cherry_pic);
            mFruitList.add(cherry);
            Fruit mango = new Fruit("Mango", R.drawable.mango_pic);
            mFruitList.add(mango);
        }
    }
}
