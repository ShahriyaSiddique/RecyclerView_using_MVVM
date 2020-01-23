package com.example.recyclerview;

import android.annotation.SuppressLint;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Country>> countries;
    private MutableLiveData<Boolean> isLoading = new MutableLiveData<>();

    public void init()
    {
        if (countries!=null)
        {
            return;
        }
        CountryRespo countryRespo = CountryRespo.getInstance();
        countries = countryRespo.getCountryData();
    }

    @SuppressLint("StaticFieldLeak")
    public void addNewItem(final Country country)
    {
        isLoading.setValue(true);
        new AsyncTask<Void,Void,Void>()
        {
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                ArrayList<Country> newCountries = countries.getValue();
                newCountries.add(country);
                countries.setValue(newCountries);
                isLoading.setValue(false);

            }

            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();
    }

    public LiveData<ArrayList<Country>> getCountries(){
     return countries;
    }
    public LiveData<Boolean> isUpdating()
    {
        return isLoading;
    }
}
