// Generated by view binder compiler. Do not edit!
package com.study.pizzaapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.study.pizzaapp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentPersonalBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final EditText EmailAddress;

  @NonNull
  public final EditText Number;

  @NonNull
  public final Button Order;

  @NonNull
  public final EditText address;

  @NonNull
  public final EditText card;

  @NonNull
  public final ImageView imageView2;

  @NonNull
  public final Button leave;

  @NonNull
  public final TextView personalName;

  @NonNull
  public final TextView pesonalBirthday;

  @NonNull
  public final Button saveChanges;

  @NonNull
  public final TextView textView10;

  @NonNull
  public final TextView textView7;

  @NonNull
  public final TextView textView8;

  @NonNull
  public final TextView textView9;

  private FragmentPersonalBinding(@NonNull FrameLayout rootView, @NonNull EditText EmailAddress,
      @NonNull EditText Number, @NonNull Button Order, @NonNull EditText address,
      @NonNull EditText card, @NonNull ImageView imageView2, @NonNull Button leave,
      @NonNull TextView personalName, @NonNull TextView pesonalBirthday,
      @NonNull Button saveChanges, @NonNull TextView textView10, @NonNull TextView textView7,
      @NonNull TextView textView8, @NonNull TextView textView9) {
    this.rootView = rootView;
    this.EmailAddress = EmailAddress;
    this.Number = Number;
    this.Order = Order;
    this.address = address;
    this.card = card;
    this.imageView2 = imageView2;
    this.leave = leave;
    this.personalName = personalName;
    this.pesonalBirthday = pesonalBirthday;
    this.saveChanges = saveChanges;
    this.textView10 = textView10;
    this.textView7 = textView7;
    this.textView8 = textView8;
    this.textView9 = textView9;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentPersonalBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentPersonalBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_personal, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentPersonalBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.EmailAddress;
      EditText EmailAddress = rootView.findViewById(id);
      if (EmailAddress == null) {
        break missingId;
      }

      id = R.id.Number;
      EditText Number = rootView.findViewById(id);
      if (Number == null) {
        break missingId;
      }

      id = R.id.Order;
      Button Order = rootView.findViewById(id);
      if (Order == null) {
        break missingId;
      }

      id = R.id.address;
      EditText address = rootView.findViewById(id);
      if (address == null) {
        break missingId;
      }

      id = R.id.card;
      EditText card = rootView.findViewById(id);
      if (card == null) {
        break missingId;
      }

      id = R.id.imageView2;
      ImageView imageView2 = rootView.findViewById(id);
      if (imageView2 == null) {
        break missingId;
      }

      id = R.id.leave;
      Button leave = rootView.findViewById(id);
      if (leave == null) {
        break missingId;
      }

      id = R.id.personalName;
      TextView personalName = rootView.findViewById(id);
      if (personalName == null) {
        break missingId;
      }

      id = R.id.pesonalBirthday;
      TextView pesonalBirthday = rootView.findViewById(id);
      if (pesonalBirthday == null) {
        break missingId;
      }

      id = R.id.save_changes;
      Button saveChanges = rootView.findViewById(id);
      if (saveChanges == null) {
        break missingId;
      }

      id = R.id.textView10;
      TextView textView10 = rootView.findViewById(id);
      if (textView10 == null) {
        break missingId;
      }

      id = R.id.textView7;
      TextView textView7 = rootView.findViewById(id);
      if (textView7 == null) {
        break missingId;
      }

      id = R.id.textView8;
      TextView textView8 = rootView.findViewById(id);
      if (textView8 == null) {
        break missingId;
      }

      id = R.id.textView9;
      TextView textView9 = rootView.findViewById(id);
      if (textView9 == null) {
        break missingId;
      }

      return new FragmentPersonalBinding((FrameLayout) rootView, EmailAddress, Number, Order,
          address, card, imageView2, leave, personalName, pesonalBirthday, saveChanges, textView10,
          textView7, textView8, textView9);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
