package com.example.recyclerview;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;

//SingleTon class (because it use for database or web service)
public class CountryRespo {
    private static CountryRespo instance;
    private ArrayList<Country> countries = new ArrayList<>();
    private CountryRespo(){};
    public static CountryRespo getInstance()
    {
        if (instance==null)
        {
            instance = new CountryRespo();
        }
        return instance;
    }

    public MutableLiveData<ArrayList<Country>> getCountryData()
    {
        addData();
        MutableLiveData<ArrayList<Country>> data = new MutableLiveData<>();
        data.setValue(countries);
        return data;

    }


    public void addData()
    {
        countries.add(new Country("Afghanistan","https://www.countries-ofthe-world.com/flags-normal/flag-of-Afghanistan.png"));
        countries.add(new Country("Albania  ","https://www.countries-ofthe-world.com/flags-normal/flag-of-Albania.png"));
        countries.add(new Country("Argentina","https://www.countries-ofthe-world.com/flags-normal/flag-of-Argentina.png"));
        countries.add(new Country("Bangladesh","https://www.countries-ofthe-world.com/flags-normal/flag-of-Bangladesh.png"));
        countries.add(new Country("Belgium","https://www.countries-ofthe-world.com/flags-normal/flag-of-Belgium.png"));
        countries.add(new Country("Brazil","https://www.countries-ofthe-world.com/flags-normal/flag-of-Brazil.png"));
        countries.add(new Country("Canada","https://www.countries-ofthe-world.com/flags-normal/flag-of-Canada.png")); countries.add(new Country("Afghanistan","https://www.countries-ofthe-world.com/flags-normal/flag-of-Afghanistan.png"));
        countries.add(new Country("Albania  ","https://www.countries-ofthe-world.com/flags-normal/flag-of-Albania.png"));
        countries.add(new Country("Argentina","https://www.countries-ofthe-world.com/flags-normal/flag-of-Argentina.png"));
        countries.add(new Country("Bangladesh","https://www.countries-ofthe-world.com/flags-normal/flag-of-Bangladesh.png"));
        countries.add(new Country("Belgium","https://www.countries-ofthe-world.com/flags-normal/flag-of-Belgium.png"));
        countries.add(new Country("Brazil","https://www.countries-ofthe-world.com/flags-normal/flag-of-Brazil.png"));
        countries.add(new Country("Canada","https://www.countries-ofthe-world.com/flags-normal/flag-of-Canada.png"));

    }



}
