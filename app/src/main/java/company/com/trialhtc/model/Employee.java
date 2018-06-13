package company.com.trialhtc.model;

import android.support.annotation.NonNull;

import java.util.Comparator;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Employee implements Comparable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("phone_number")
    @Expose
    private String phoneNumber;
    @SerializedName("skills")
    @Expose
    private List<String> skills;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    @Override
    public int compareTo(@NonNull Object o) {
        return 0;
    }

    public static class EmployeeComparator implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            return o1.getClass().getName().compareToIgnoreCase(o2.getClass().getName());
        }
    }
}