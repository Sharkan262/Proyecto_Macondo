// Generated by view binder compiler. Do not edit!
package com.example.proyecto_macondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.example.proyecto_macondo.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivitySplashBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final CardView contenedorimagen;

  @NonNull
  public final ImageView mariposa;

  @NonNull
  public final TextView nombreApp;

  @NonNull
  public final TextView texto;

  private ActivitySplashBinding(@NonNull ConstraintLayout rootView,
      @NonNull CardView contenedorimagen, @NonNull ImageView mariposa, @NonNull TextView nombreApp,
      @NonNull TextView texto) {
    this.rootView = rootView;
    this.contenedorimagen = contenedorimagen;
    this.mariposa = mariposa;
    this.nombreApp = nombreApp;
    this.texto = texto;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySplashBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySplashBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_splash, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySplashBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.contenedorimagen;
      CardView contenedorimagen = rootView.findViewById(id);
      if (contenedorimagen == null) {
        break missingId;
      }

      id = R.id.mariposa;
      ImageView mariposa = rootView.findViewById(id);
      if (mariposa == null) {
        break missingId;
      }

      id = R.id.nombreApp;
      TextView nombreApp = rootView.findViewById(id);
      if (nombreApp == null) {
        break missingId;
      }

      id = R.id.texto;
      TextView texto = rootView.findViewById(id);
      if (texto == null) {
        break missingId;
      }

      return new ActivitySplashBinding((ConstraintLayout) rootView, contenedorimagen, mariposa,
          nombreApp, texto);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
