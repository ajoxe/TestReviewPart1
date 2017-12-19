package nyc.c4q.testreview;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class JSONFragment extends Fragment {

    private TextView fragmentText;
    private Bundle bundle;
    String str;
    public JSONFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_json, container, false);
        fragmentText = view.findViewById(R.id.fragment_textview);

        return view;

    }
    //Bare minimum of fragment

    //extra methods
    //ctrl + O brings up all the overrides
    //fragments have different lifecycle from activities, they have extra lifecyle methods than activity life cycle.


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        //gets called before onCreate View. good place to get datat thats not getting data from fragment

        bundle = getArguments();
        str = bundle.getString("string");
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentText.setText(str);
    }
}
