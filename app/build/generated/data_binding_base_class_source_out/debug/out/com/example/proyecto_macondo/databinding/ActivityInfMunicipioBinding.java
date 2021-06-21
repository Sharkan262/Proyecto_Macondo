// Generated by view binder compiler. Do not edit!
package com.example.proyecto_macondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.example.proyecto_macondo.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityInfMunicipioBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView informacion;

  @NonNull
  public final RecyclerView listInf;

  private ActivityInfMunicipioBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView informacion, @NonNull RecyclerView listInf) {
    this.rootView = rootView;
    this.informacion = informacion;
    this.listInf = listInf;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityInfMunicipioBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityInfMunicipioBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_inf_municipio, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityInfMunicipioBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.informacion;
      TextView informacion = rootView.findViewById(id);
      if (informacion == null) {
        break missingId;
      }

      id = R.id.listInf;
      RecyclerView listInf = rootView.findViewById(id);
      if (listInf == null) {
        break missingId;
      }

      return new ActivityInfMunicipioBinding((ConstraintLayout) rootView, informacion, listInf);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
