package pichitwandee.th.ac.bru.showbru.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import pichitwandee.th.ac.bru.showbru.R;
import pichitwandee.th.ac.bru.showbru.utility.GetAllData;
import pichitwandee.th.ac.bru.showbru.utility.MyConstant;

public class ServiceFragment extends Fragment {

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

//        Create ListView
        createListView();


    } //Main Method


    private void createListView() {

        ListView listView = getView().findViewById(R.id.ListViewFood);
        MyConstant myConstant = new MyConstant();

        try {

            GetAllData getAllData = new GetAllData(getActivity());
            getAllData.execute(myConstant.getUrlGetAllFood());

            String jsonString = getAllData.get();

            JSONArray jsonArray = new JSONArray(jsonString);
            String[] foodStrings = new String[jsonArray.length()];
            String[] PriceStrings = new String[jsonArray.length()];
            String[] DetailStrings = new String[jsonArray.length()];
            String[] ImageStrings = new String[jsonArray.length()];


            for (int i=0; i< jsonArray.length(); i+=1) {


                JSONObject jsonObject= jsonArray.getJSONObject(i);
                foodStrings[i] = jsonObject.getString("NameFood");
                PriceStrings[i] = jsonObject.getString("Price");
                DetailStrings[i] = jsonObject.getString("Detail");
                ImageStrings[i] = jsonObject.getString("ImagePath");
                food

            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_service, container, false);
        return view;
    }
}
