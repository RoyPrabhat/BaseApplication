package com.example.sqrrlandriodtask.view.breedlist;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.sqrrlandriodtask.R;

public class BreedListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breed_list);
        setUpFragment();
    }

    private void setUpFragment() {
        BreedListFragment breedListFragment = new BreedListFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.breed_list_fragment, breedListFragment);
        transaction.commit();
    }
}
