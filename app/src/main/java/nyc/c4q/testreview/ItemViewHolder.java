package nyc.c4q.testreview;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by amirahoxendine on 12/18/17.
 */

public class ItemViewHolder extends RecyclerView.ViewHolder {
    private TextView myTextView;
    private String str;
    private Context context;

    public ItemViewHolder(View itemView) {
        super(itemView);//inheritance, allows the item view to take on the same powers as the parent item view.
        //itemview only contains textview
        //cmd + E lets you go through your files, cmd + w Closes the tab

        myTextView = (TextView) itemView.findViewById(R.id.item_textview);
        context = itemView.getContext();
    }

    public void onBind(String string){//no model class, so only passing strings.
        //onBind sets things
        //opt + shift + down switches the string
        this.str = string;// setting a varable to e
        myTextView.setText(str);
        //makes sense to put onClick in ViewHolder. we could set it to the textview, but the click will only appy to texttview
        //makes more sense to set it to item view.
        //any view can be clickable.
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(itemView.getContext(), str,Toast.LENGTH_LONG).show();
                Log.d("RecyclerView", "itemview has been clicked");
                Bundle bundle = new Bundle();
                bundle.putString("string", str);
                JSONFragment jsonFragment = new JSONFragment();
                jsonFragment.setArguments(bundle);

                //fragment or activity = getApplication context or this. When its a view, view.getcontext.
                //log.d = debug; log.i = info log.v= verbose (prints everything) log.e = error (prints in red) warn, error assert.

                FragmentManager fragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.addToBackStack(null).replace(R.id.fragment_container,jsonFragment );
                fragmentTransaction.commit();
            }
        });
    }

}
