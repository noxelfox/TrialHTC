package company.com.trialhtc;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import company.com.trialhtc.adapters.EmployeeAdapter;
import company.com.trialhtc.model.Company;
import company.com.trialhtc.model.Employee;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class FragmentList extends Fragment {
    private RecyclerView recyclerView;
    private EmployeeAdapter adapter;
    private TextView textCompany;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        textCompany = view.findViewById(R.id.textCompany);
        recyclerView = view.findViewById(R.id.recycler);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        new JsonParser().execute();
    }

    private void recyclerAdapter(Company company) {
        ArrayList<Employee> employees = (ArrayList<Employee>) company.getCompany().getEmployees();
        adapter = new EmployeeAdapter(alfabet(employees));
        String companyinfo =
                "\n Company: " + company.getCompany().getName() +
                        "\n Age: " + company.getCompany().getAge() +
                        "\n Competences: " + company.getCompany().getCompetences();
        textCompany.setText(companyinfo);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private ArrayList<Employee> alfabet(ArrayList<Employee> list) {
        Collections.sort(list, new Comparator<Employee>() {
            @Override
            public int compare(Employee s1, Employee s2) {
                return s1.getName().compareToIgnoreCase(s2.getName());
            }
        });
        return list;
    }

    class JsonParser extends AsyncTask<Void, Void, Company> {
        private String getJson() {
            OkHttpClient httpClient = new OkHttpClient();
            Request request = new Request.Builder().url(MainActivity.URL).build();
            Response response;
            try {
                response = httpClient.newCall(request).execute();
                return response.body().string();

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        private Company parseCompany() {
            return new Gson().fromJson(getJson(), Company.class);
        }

        @Override
        protected Company doInBackground(Void... voids) {
            return parseCompany();
        }

        @Override
        protected void onPostExecute(Company company) {
            super.onPostExecute(company);
            recyclerAdapter(company);
            Log.i("test", "test");
        }
    }
}