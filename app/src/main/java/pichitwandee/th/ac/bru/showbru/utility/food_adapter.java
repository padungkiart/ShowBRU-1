package pichitwandee.th.ac.bru.showbru.utility;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import pichitwandee.th.ac.bru.showbru.R;

public class food_adapter extends BaseAdapter{

    private Context context;
    private String[]imageString, foodString, priceString ,detailStrings;

    public food_adapter(Context context,
                        String[] imageString,
                        String[] foodString,
                        String[] priceString,
                        String[] detailStrings) {
        this.context = context;
        this.imageString = imageString;
        this.foodString = foodString;
        this.priceString = priceString;
        this.detailStrings = detailStrings;
    }

    @Override
    public int getCount() {
        return foodString.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 =layoutInflater.inflate(R.layout.listview_food,ViewGroup,false);

        TextView FoodTextView = view.findViewById(R.id.txtFood);
        TextView priceTextView = view.findViewById(R.id.txtPrice);
        TextView detailTextView = view.findViewById(R.id.txtDetail);
        ImageView imageView =view.findViewById(R.id.imvFood);

        FoodTextView.setText(foodString[i]);
        priceTextView.setText(priceString[i]);
        priceTextView.setText(detailStrings[i]);

        Picasso.get().load(imageString[i]).into(imageView);




        return null;
    }
}
