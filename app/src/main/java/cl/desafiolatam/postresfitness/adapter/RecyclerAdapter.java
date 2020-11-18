package cl.desafiolatam.postresfitness.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cl.desafiolatam.postresfitness.DetailActivity;
import cl.desafiolatam.postresfitness.R;
import cl.desafiolatam.postresfitness.model.itemList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyvlerHolder> {

    private List<itemList> items;
    private recyclerItemClick itemClick;

    //Se modifica el constructor para enviar instancia del recyclerItemClick
    public RecyclerAdapter(List<itemList> items, recyclerItemClick itemClick) {
        this.items = items;
        this.itemClick = itemClick;
    }


    @NonNull
    @Override
    public RecyvlerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new RecyvlerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyvlerHolder holder, int position) {
        itemList item = items.get(position);
        holder.imgItem.setImageResource(item.getImgResource());
        holder.tvTitulo.setText(item.getTitulo());
        holder.tvDescripcion.setText(item.getDescripcion());

        //Usando la interface
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClick.itemClick(item);
            }
        });

        //Para llamar al Detalle Froma 1 (en este caso sólo quiero pasar los datos del item
        /*holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);
                intent.putExtra("itemDetail", item);
                holder.itemView.getContext().startActivity(intent);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class RecyvlerHolder extends RecyclerView.ViewHolder {
        private ImageView imgItem;
        private TextView tvTitulo;
        private TextView tvDescripcion;

        public RecyvlerHolder(@NonNull View itemView) {
            super(itemView);
            imgItem = itemView.findViewById(R.id.imgItem);
            tvTitulo = itemView.findViewById(R.id.tvTitulo);
            tvDescripcion = itemView.findViewById(R.id.tvDescripcion);
        }
    }

    //Forma 2 para llamar al detalle desde el ActivityMain
    public interface recyclerItemClick {
        void itemClick(itemList item);
    }
}
