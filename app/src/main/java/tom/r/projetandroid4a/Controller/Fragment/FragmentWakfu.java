package tom.r.projetandroid4a.Controller.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import tom.r.projetandroid4a.R;

/**
 * @author Tom
 */
public class FragmentWakfu extends Fragment{
    public View view;

    public FragmentWakfu(){
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_wakfu, container, false);

        // Reception des données
        String id = getActivity().getIntent().getExtras().getString("p_id");
        String name = getActivity().getIntent().getExtras().getString("p_name");
        String description_wakfu = getActivity().getIntent().getExtras().getString("p_description_wakfu");
        String image = getActivity().getIntent().getExtras().getString("p_image");
        String classe = getActivity().getIntent().getExtras().getString("p_classe");
        String gender = getActivity().getIntent().getExtras().getString("p_gender");
        String icone = getActivity().getIntent().getExtras().getString("p_icone");
        String sort1 = getActivity().getIntent().getExtras().getString("p_sort1");
        String sort2 = getActivity().getIntent().getExtras().getString("p_sort2");
        String sort3 = getActivity().getIntent().getExtras().getString("p_sort3");
        String image_sort1 = getActivity().getIntent().getExtras().getString("p_image_sort1");
        String image_sort2 = getActivity().getIntent().getExtras().getString("p_image_sort2");
        String image_sort3 = getActivity().getIntent().getExtras().getString("p_image_sort3");
        String image_wakfu = getActivity().getIntent().getExtras().getString("p_image_wakfu");
        String lien_wakfu = getActivity().getIntent().getExtras().getString("p_lien_wakfu");

        // CollapsingToolbar
        CollapsingToolbarLayout collapsingToolbarLayout = view.findViewById(R.id.collapsingtoolbar_id);
        collapsingToolbarLayout.setTitleEnabled(true);

        // associe chaque view avec son id du xml
        TextView pId = view.findViewById(R.id.p_id);
        TextView pName = view.findViewById(R.id.p_name);
        TextView pClasse = view.findViewById(R.id.p_classe);
        TextView pDescription_wakfu = view.findViewById(R.id.p_description_wakfu);
        TextView pGender = view.findViewById(R.id.p_gender);
        TextView pSort1 = view.findViewById(R.id.p_sort1);
        TextView pSort2 = view.findViewById(R.id.p_sort2);
        TextView pSort3 = view.findViewById(R.id.p_sort3);
        ImageView pImageSort1 = view.findViewById(R.id.p_image_sort1);
        ImageView pImageSort2 = view.findViewById(R.id.p_image_sort2);
        ImageView pImageSort3 = view.findViewById(R.id.p_image_sort3);
        ImageView pImage = view.findViewById(R.id.p_image_wakfu);
        TextView pLien = view.findViewById(R.id.p_lien_wakfu);
        ImageView pIcone = view.findViewById(R.id.p_icone);

        // setting des valeurs de chaque view
        pName.setText(name);
        pId.setText(id);
        pClasse.setText(classe);
        pDescription_wakfu.setText(description_wakfu);
        pGender.setText(gender);
        pSort1.setText(sort1);
        pSort2.setText(sort2);
        pSort3.setText(sort3);
        pLien.setText(lien_wakfu);

        // requêtes option pour les images avec Glide en fonction du fond de l'ImageView
        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
        RequestOptions requestOptions2 = new RequestOptions().centerCrop().placeholder(R.drawable.bgg).error(R.drawable.bgg);

        // chargement des images avec Glide
        Glide.with(this).load(image_wakfu).apply(requestOptions).into(pImage);
        Glide.with(this).load(icone).apply(requestOptions2).into(pIcone);
        Glide.with(this).load(image_sort1).apply(requestOptions2).into(pImageSort1);
        Glide.with(this).load(image_sort2).apply(requestOptions2).into(pImageSort2);
        Glide.with(this).load(image_sort3).apply(requestOptions2).into(pImageSort3);

        return view;
    }
}
