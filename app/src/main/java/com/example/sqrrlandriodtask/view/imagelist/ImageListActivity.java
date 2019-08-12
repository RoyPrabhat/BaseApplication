package com.example.sqrrlandriodtask.view.imagelist;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;
import com.example.sqrrlandriodtask.R;
import com.example.sqrrlandriodtask.constant.Constants;

public class ImageListActivity extends AppCompatActivity {

    private Toolbar myToolbar;
    private String mDogName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_list);
        setUp();
    }

    private void setUp() {
        setUpToolBar();
        setUpFragment();
    }

    public void setUpToolBar() {
        mDogName = getIntent().getStringExtra(Constants.DOG_NAME);
        myToolbar = findViewById(R.id.dog_name);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(mDogName);
    }

    private void setUpFragment() {
        ImageListFragment imageListFragment = new ImageListFragment();
        Bundle args = new Bundle();
        args.putString(Constants.DOG_NAME, mDogName);
        imageListFragment.setArguments(args);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.image_list_fragment, imageListFragment);
        transaction.commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

