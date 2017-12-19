package nyc.c4q.testreview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by amirahoxendine on 12/18/17.
 */

public class ItemViewAdapter extends RecyclerView.Adapter<ItemViewHolder>{

    private List<String> stringList;

    public ItemViewAdapter(List<String> stringList){
        this.stringList = stringList;

    }//could also create a setter in the adapter to set the data, dont always need to pass it in the

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childview = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
                //inflated the view that you want for your recyclerview, this is the view displayed in recycler view for each item.
                //when you have recycler view in fragment- its difficult because there are two layers of context going on. multiple layesrs.
                //attach to root- has something to do witht hte recycler views container.
        return new ItemViewHolder(childview);
        //just passed childview we created into the viewholder, so now it has a layout to bind to
        //cmd + p should show you which parameters go into a method
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        String string = stringList.get(position);
        //position is position of the recyclerview, on bind it outs the string at that position in the recycler view.
        //because data is bound to recycler view, position of recycler view matches the list position.

        holder.onBind(string);
        //we're passing the string into the onbind method of the viewholder.

    }

    @Override
    public int getItemCount() {
        return stringList.size();
        //this is telling the recycler view how large it needs to be, recycler view needs to know how many times to recycle these views. increases the efficiency of recycler view.
        //notifydatasetchanged.
    }
}
