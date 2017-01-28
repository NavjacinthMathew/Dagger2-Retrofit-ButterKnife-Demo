package mathew.navjacinth.com.dagger2retrofitdemo.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Navjacinth Mathew on 1/29/2017.
 */

public class EmployeeList {
    @SerializedName("employeeList")
    private ArrayList<Employee> employeeList;

    public ArrayList<Employee> getEmployeeArrayList() {
        return employeeList;
    }

    public void setEmployeeArrayList(ArrayList<Employee> employeeArrayList) {
        this.employeeList = employeeArrayList;
    }
}