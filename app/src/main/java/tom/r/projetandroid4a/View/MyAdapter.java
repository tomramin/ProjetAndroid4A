package tom.r.projetandroid4a.View;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.squareup.picasso.Picasso;

import tom.r.projetandroid4a.Controller.DetailActivity;
import tom.r.projetandroid4a.Model.Personnage;
import tom.r.projetandroid4a.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tom
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements Filterable {

    private Context mContext ;
    private List<Personnage> listePersonnages ;
    private List<Personnage> listePersonnagesFull;
    private RequestOptions option;


    public MyAdapter(Context mContext, List<Personnage> listePersonnages) {
        this.mContext = mContext;
        this.listePersonnages = listePersonnages;
        listePersonnagesFull = new ArrayList<>(listePersonnages);

        // requête option pour Glide
        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.dofus_list_perso,parent,false) ;
        final MyViewHolder viewHolder = new MyViewHolder(view) ;
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(mContext, DetailActivity.class);
                i.putExtra("p_name",listePersonnages.get(viewHolder.getAdapterPosition()).getName());
                i.putExtra("p_description_wakfu",listePersonnages.get(viewHolder.getAdapterPosition()).getDescription_wakfu());
                i.putExtra("p_description_dofus",listePersonnages.get(viewHolder.getAdapterPosition()).getDescription_dofus());
                i.putExtra("p_description_dofus_retro",listePersonnages.get(viewHolder.getAdapterPosition()).getDescription_dofus_retro());
                i.putExtra("p_id",listePersonnages.get(viewHolder.getAdapterPosition()).getId());
                i.putExtra("p_image",listePersonnages.get(viewHolder.getAdapterPosition()).getImage());
                i.putExtra("p_classe",listePersonnages.get(viewHolder.getAdapterPosition()).getClasse());
                i.putExtra("p_gender",listePersonnages.get(viewHolder.getAdapterPosition()).getGender());
                i.putExtra("p_icone",listePersonnages.get(viewHolder.getAdapterPosition()).getIcone());
                i.putExtra("p_sort1",listePersonnages.get(viewHolder.getAdapterPosition()).getSort1());
                i.putExtra("p_sort2",listePersonnages.get(viewHolder.getAdapterPosition()).getSort2());
                i.putExtra("p_sort3",listePersonnages.get(viewHolder.getAdapterPosition()).getSort3());
                i.putExtra("p_image_sort1",listePersonnages.get(viewHolder.getAdapterPosition()).getImage_sort1());
                i.putExtra("p_image_sort2",listePersonnages.get(viewHolder.getAdapterPosition()).getImage_sort2());
                i.putExtra("p_image_sort3",listePersonnages.get(viewHolder.getAdapterPosition()).getImage_sort3());
                i.putExtra("p_image_wakfu",listePersonnages.get(viewHolder.getAdapterPosition()).getImage_wakfu());
                i.putExtra("p_image_dofus",listePersonnages.get(viewHolder.getAdapterPosition()).getImage_dofus());
                i.putExtra("p_image_dofus_retro",listePersonnages.get(viewHolder.getAdapterPosition()).getImage_dofus_retro());
                i.putExtra("p_lien_wakfu",listePersonnages.get(viewHolder.getAdapterPosition()).getLien_wakfu());
                i.putExtra("p_lien_dofus",listePersonnages.get(viewHolder.getAdapterPosition()).getLien_dofus());
                i.putExtra("p_lien_dofus_retro",listePersonnages.get(viewHolder.getAdapterPosition()).getLien_dofus_retro());
                
                mContext.startActivity(i);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tv_classe.setText(listePersonnages.get(position).getClasse());
        holder.tv_id.setText(listePersonnages.get(position).getId());

        // charge les images dans les Imageview en utilisant Glide
        Glide.with(mContext).load(listePersonnages.get(position).getImage()).apply(option).into(holder.img_thumbnail);
        Glide.with(mContext).load(listePersonnages.get(position).getIcone()).apply(option).into(holder.img_icone);
    }

    @Override
    public int getItemCount() {
        return listePersonnages.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_classe ;
        TextView tv_id ;
        ImageView img_thumbnail;
        ImageView img_icone;
        LinearLayout view_container;

        public MyViewHolder(View itemView) {
            super(itemView);

            view_container = itemView.findViewById(R.id.container);
            tv_classe = itemView.findViewById(R.id.p_classe);
            tv_id = itemView.findViewById(R.id.p_id);
            img_thumbnail = itemView.findViewById(R.id.p_image_wakfu);
            img_icone = itemView.findViewById(R.id.p_icone);
        }
    }

    @Override
    public Filter getFilter() {
        return listePersonnagesFilter;
    }

    // filtrer la liste du recyclerView en fonction de la classe entrée
    private Filter listePersonnagesFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Personnage> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0){
                filteredList.addAll(listePersonnagesFull);
            }else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Personnage perso: listePersonnagesFull){
                    if (perso.getClasse().toLowerCase().contains(filterPattern)){
                        filteredList.add(perso);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        // on vide la liste initiale et on lui ajoute les personnages correspondant avec la classe entrée
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            listePersonnages.clear();
            listePersonnages.addAll((List)results.values);
            notifyDataSetChanged();
        }
    };
}
