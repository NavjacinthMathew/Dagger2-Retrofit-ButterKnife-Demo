package mathew.navjacinth.com.dagger2retrofitdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import mathew.navjacinth.com.dagger2retrofitdemo.R;
import mathew.navjacinth.com.dagger2retrofitdemo.adapter.EmployeeAdapter;
import mathew.navjacinth.com.dagger2retrofitdemo.dagger.component.DaggerMainActivityComponent;
import mathew.navjacinth.com.dagger2retrofitdemo.dagger.component.MainActivityComponent;
import mathew.navjacinth.com.dagger2retrofitdemo.dagger.module.RetrofitModule;
import mathew.navjacinth.com.dagger2retrofitdemo.model.Employee;
import mathew.navjacinth.com.dagger2retrofitdemo.model.EmployeeList;
import mathew.navjacinth.com.dagger2retrofitdemo.network.GetEmployeeDataService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Inject
    Retrofit retrofit;

    @BindView(R.id.recyc_list)
    RecyclerView recyclerViewList;

    private EmployeeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        MainActivityComponent component = DaggerMainActivityComponent.builder()
                .retrofitModule(new RetrofitModule())
                .build();

        component.injectMainActivity(this);

        getEmployeeData();
    }

    private void getEmployeeData() {
        /*Create handle for the RetrofitInstance interface*/
        GetEmployeeDataService service = retrofit.create(GetEmployeeDataService.class);

        /*Call the method with parameter in the interface to get the employee data*/
        Call<EmployeeList> call = service.getEmployeeData(100);

        /*Log the URL called*/
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<EmployeeList>() {
            @Override
            public void onResponse(Call<EmployeeList> call, Response<EmployeeList> response) {
                generateEmployeeList(response.body().getEmployeeArrayList());
            }

            @Override
            public void onFailure(Call<EmployeeList> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*Method to generate List of employees using RecyclerView with custom adapter*/
    private void generateEmployeeList(ArrayList<Employee> empDataList) {

        adapter = new EmployeeAdapter(empDataList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);

        recyclerViewList.setLayoutManager(layoutManager);

        recyclerViewList.setAdapter(adapter);
    }
}
