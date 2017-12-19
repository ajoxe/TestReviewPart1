package nyc.c4q.testreview;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
                //layou manager informs recycler view how to layout views.
        recyclerView.setLayoutManager(linearLayoutManager);
        List<String> names = new ArrayList<>();
        names.add("AJ");//cmd + D
        names.add("Jose");//opt + drag - edit multiple lines at once
        names.add("Mel");
        names.add("Amy");
        names.add("Mo Naz");
        names.add("Yisandy");
        names.add("Siran");

        ItemViewAdapter itemViewAdapter = new ItemViewAdapter(names);
        recyclerView.setAdapter(itemViewAdapter);

        /*FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //puts fragment in container.
        //using tags can have multiple fragment
        fragmentTransaction.addToBackStack(null).replace(R.id.fragment_container, new JSONFragment());
        //instead of null, could also add a ta*//**//*g.
        fragmentTransaction.commit();*/


    }
}
