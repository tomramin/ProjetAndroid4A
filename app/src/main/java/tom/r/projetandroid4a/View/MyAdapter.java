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
    private List<Personnage> mData ;
    private List<Personnage> mDataFull;
    RequestOptions option;


    public MyAdapter(Context mContext, List<Personnage> mData) {
        this.mContext = mContext;
        this.mData = mData;
        mDataFull = new ArrayList<>(mData);

        // Request option for Glide
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
                i.putExtra("p_name",mData.get(viewHolder.getAdapterPosition()).getName());
                i.putExtra("p_description",mData.get(viewHolder.getAdapterPosition()).getDescription());
                i.putExtra("p_id",mData.get(viewHolder.getAdapterPosition()).getId());
                i.putExtra("p_image",mData.get(viewHolder.getAdapterPosition()).getImage());
                i.putExtra("p_classe",mData.get(viewHolder.getAdapterPosition()).getClasse());
                i.putExtra("p_gender",mData.get(viewHolder.getAdapterPosition()).getGender());
                i.putExtra("p_icone",mData.get(viewHolder.getAdapterPosition()).getIcone());
                i.putExtra("p_sorts",mData.get(viewHolder.getAdapterPosition()).getSorts());
                i.putExtra("p_image_wakfu",mData.get(viewHolder.getAdapterPosition()).getImage_wakfu());
                i.putExtra("p_image_dofus",mData.get(viewHolder.getAdapterPosition()).getImage_dofus());
                i.putExtra("p_image_dofus_retro",mData.get(viewHolder.getAdapterPosition()).getImage_dofus_retro());
                i.putExtra("p_lien_wakfu",mData.get(viewHolder.getAdapterPosition()).getLien_wakfu());
                i.putExtra("p_lien_dofus",mData.get(viewHolder.getAdapterPosition()).getLien_dofus());
                i.putExtra("p_lien_dofus_retro",mData.get(viewHolder.getAdapterPosition()).getLien_dofus_retro());


                mContext.startActivity(i);

            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tv_classe.setText(mData.get(position).getClasse());
        holder.tv_id.setText(mData.get(position).getId());

        // Load Image from the internet and set it into Imageview using Glide

        Glide.with(mContext).load(mData.get(position).getImage()).apply(option).into(holder.img_thumbnail);
        Glide.with(mContext).load(mData.get(position).getIcone()).apply(option).into(holder.img_icone);
    }

    @Override
    public int getItemCount() {
        return mData.size();
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
        return mDataFilter;
    }

    private Filter mDataFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Personnage> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0){
                filteredList.addAll(mDataFull);
            }else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Personnage perso: mDataFull){
                    if (perso.getClasse().toLowerCase().contains(filterPattern)){
                        filteredList.add(perso);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mData.clear();
            mData.addAll((List)results.values);
            notifyDataSetChanged();
        }
    };
}
