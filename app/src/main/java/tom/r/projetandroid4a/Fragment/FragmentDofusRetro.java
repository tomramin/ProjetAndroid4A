package tom.r.projetandroid4a.Fragment;

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

public class FragmentDofusRetro extends Fragment{
    public View view;

    public FragmentDofusRetro(){
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_dofus_retro, container, false);

        // Recieve data
        String id = getActivity().getIntent().getExtras().getString("p_id");
        String name = getActivity().getIntent().getExtras().getString("p_name");
        String description = getActivity().getIntent().getExtras().getString("p_description");
        String image = getActivity().getIntent().getExtras().getString("p_image");
        String classe = getActivity().getIntent().getExtras().getString("p_classe");
        String gender = getActivity().getIntent().getExtras().getString("p_gender");
        String icone = getActivity().getIntent().getExtras().getString("p_icone");
        String sorts = getActivity().getIntent().getExtras().getString("p_sorts");
        String image_dofus_retro = getActivity().getIntent().getExtras().getString("p_image_dofus_retro");
        String lien_dofus_retro = getActivity().getIntent().getExtras().getString("p_lien_dofus_retro");

        // ini views

        CollapsingToolbarLayout collapsingToolbarLayout = view.findViewById(R.id.collapsingtoolbar_id);
        collapsingToolbarLayout.setTitleEnabled(true);

        TextView pId = view.findViewById(R.id.p_id);
        TextView pName = view.findViewById(R.id.p_name);
        TextView pClasse = view.findViewById(R.id.p_classe);
        TextView pDescription = view.findViewById(R.id.p_description);
        TextView pGender = view.findViewById(R.id.p_gender);
        TextView pSorts = view.findViewById(R.id.p_sorts);
        ImageView pImage = view.findViewById(R.id.p_image_dofus_retro);
        TextView pLien = view.findViewById(R.id.p_lien_dofus_retro);
        ImageView pIcone = view.findViewById(R.id.p_icone);

        // setting values to each view
        pName.setText(name);
        pId.setText(id);
        pClasse.setText(classe);
        pDescription.setText(description);
        pGender.setText(gender);
        pSorts.setText(sorts);
        pLien.setText(lien_dofus_retro);

        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
        RequestOptions requestOptions2 = new RequestOptions().centerCrop().placeholder(R.drawable.bgg).error(R.drawable.bgg);

        // set image using Glide
        Glide.with(this).load(image_dofus_retro).apply(requestOptions).into(pImage);
        Glide.with(this).load(icone).apply(requestOptions2).into(pIcone);

        return view;
    }
}
