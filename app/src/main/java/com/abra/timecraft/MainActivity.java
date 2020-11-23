package com.abra.timecraft;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.abra.timecraft.data.PointsRepository;
import com.abra.timecraft.data.UserConfig;
import com.abra.timecraft.fragments.CategoriaMainFragment;
import com.abra.timecraft.models.UserModel;
import com.abra.timecraft.models.categoriaMain;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();
    public static final String USER_KEY = "USER";
    public static final String EMAIL_KEY = "EMAIL";
    public static final String PASSWORD_KEY = "PASSWORD";

    private PointsRepository mPointsRepository;
    private List<categoriaMain> mModelList;
    private ViewGroup rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setup();
    }

  /*  @Override
    protected void onResume() {
        super.onResume();
        loadData();
    }*/

    public void setup(){
        setupViewFromData();
    }

    private void setupViewFromData() {
        Intent startIntent = getIntent();
        if(startIntent == null) {
            Toast.makeText(
                    this,
                    "Algo salió mal al obtener los datos :(",
                    Toast.LENGTH_SHORT
            ).show();
            return;
        }
        UserModel userModel = getUserModelFromSources(startIntent.getExtras());

        if(getSupportActionBar() != null) {
            String fullname = TextUtils.isEmpty(userModel.getEmail()) ?
                    "Usuario" : userModel.getUser();
            getSupportActionBar()
                    .setTitle(getString(R.string.welcome_user_title, fullname));
        }

        if(TextUtils.isEmpty(userModel.getEmail())) {
            Toast.makeText(
                    this,
                    R.string.cannot_get_email,
                    Toast.LENGTH_SHORT
            ).show();
        }
    }

    @NonNull
    private UserModel getUserModelFromSources(Bundle extras) {
        UserConfig userConfig = new UserConfig(getApplicationContext());
        final UserModel user = userConfig.getUser();
        if(user != null) {
            return user;
        }
        if(extras == null) {
            throw new InvalidParameterException("Extras");
        }
        return new UserModel(extras.getString(USER_KEY), extras.getString(EMAIL_KEY), extras.getString(PASSWORD_KEY));
    }

    private void loadData() {
        if(!mModelList.isEmpty()) {
            Log.d(TAG, "Ya existen valores en la lista");
            return;
        }
        if(mPointsRepository == null) {
            Log.e(TAG, "mPointsRepository no debería ser null");
            return;
        }
        mModelList = mPointsRepository.getAll();

        loadPointsFragment(new ArrayList<categoriaMain>(mModelList));
    }

    private void loadPointsFragment(ArrayList<categoriaMain> cmain) {
        FragmentTransaction frgTran = getSupportFragmentManager().beginTransaction();
        frgTran.replace(R.id.categoriasMain_ph, CategoriaMainFragment.newInstance(cmain));
        frgTran.commit();
    }


    public void onItemTap(View view, int position) {
        showMessageWithSelectedItem(position);
    }

    private void showMessageWithSelectedItem(int position) {
        if(mModelList == null) {
            Log.e(TAG, "invalid mModelList");
            return;
        }
        if(position > mModelList.size()) {
            Log.e(TAG, "invalid position");
            return;
        }

        //PointModel selectedItemModel = mModelList.get(position);
       // navigateToProfile(selectedItemModel);
    }

}