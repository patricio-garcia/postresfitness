package cl.desafiolatam.postresfitness;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import cl.desafiolatam.postresfitness.model.itemList;

public class DetailActivity extends AppCompatActivity {

    private ImageView imgItemDetail;
    private TextView tvTitluloDetail;
    private TextView tvDescripcionDetail;

    private itemList itemDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setTitle(getClass().getSimpleName());

        initViews();
        initValues();
    }

    private void initViews() {
        imgItemDetail = findViewById(R.id.imgItemDetail);
        tvTitluloDetail = findViewById(R.id.tvTituloDetail);
        tvDescripcionDetail = findViewById(R.id.tvDescripcionDetail);

    }

    private void initValues() {
        itemDetail = (itemList) getIntent().getExtras().getSerializable("itemDetail");
        imgItemDetail.setImageResource(itemDetail.getImgResource());
        tvTitluloDetail.setText(itemDetail.getTitulo());
        tvDescripcionDetail.setText(itemDetail.getDescripcion());
    }
}