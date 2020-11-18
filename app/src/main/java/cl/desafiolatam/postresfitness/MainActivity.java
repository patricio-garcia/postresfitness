package cl.desafiolatam.postresfitness;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import cl.desafiolatam.postresfitness.adapter.RecyclerAdapter;
import cl.desafiolatam.postresfitness.model.itemList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvLista;
    private RecyclerAdapter adapter;
    private List<itemList> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initValues();
    }

    private void initViews() {
        rvLista = findViewById(R.id.rvLista);
    }

    private void initValues() {
        LinearLayoutManager manager = new LinearLayoutManager(this);
        //GridLayoutManager manager = new GridLayoutManager(this, 2, RecyclerView.VERTICAL, false);
        rvLista.setLayoutManager(manager);
        items = getItems();
        adapter = new RecyclerAdapter(items);
        rvLista.setAdapter(adapter);
    }

    private List<itemList> getItems() {
        List<itemList> itemLists = new ArrayList<>();
        itemLists.add(new itemList("Brownie Banana","Brownies de banana", R.drawable.brownie_banana));
        itemLists.add(new itemList("Galletas","Galletas de auyuma y banana", R.drawable.galletas_rapidas_de_auyama_y_banano));
        itemLists.add(new itemList("Mandocas","mandocas horneadas", R.drawable.mandocas_hormenadas));
        itemLists.add(new itemList("Muffin Zanahoria","Muffins de zanahoria", R.drawable.muffins_de_pan_con_zanohoria));
        itemLists.add(new itemList("Muffin Integra","Muffins integrales", R.drawable.muffins_integrales));
        itemLists.add(new itemList("Palmeras Banana","Palmeras de banana", R.drawable.palmeritas_de_banana));
        itemLists.add(new itemList("Pn Calabaza","Pan de calabaza", R.drawable.pan_de_calabacin_750x300));
        itemLists.add(new itemList("Panqueques","Panqueques de chocolate con toppins de banana", R.drawable.panquecas_de_cacao_con_topping_de_banana));
        return itemLists;
    }
}