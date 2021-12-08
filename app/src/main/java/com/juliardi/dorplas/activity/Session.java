package com.juliardi.dorplas.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.juliardi.dorplas.model.login.LoginResponse;

import java.util.HashMap;

public class Session {
    private Context context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor shpEditor;

    public static  final String IS_LOGGED_IN ="isloggedIn";
    public static  final String STATUS ="status";
    public static  final String MESSAGE ="message";
    public static  final String DATA ="data";

    public Session(Context context) {
        this.context = context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        shpEditor=sharedPreferences.edit();

    }

    public void createLoginSession(LoginResponse employe){
        shpEditor.putBoolean(IS_LOGGED_IN, true);
        shpEditor.putString(DATA,employe.getData().getIdEmployes());
        shpEditor.putString(DATA,employe.getData().getEmailEmployes());
        shpEditor.putString(DATA,employe.getData().getNameEmployes());
        shpEditor.putString(DATA,employe.getData().getJwtTokenEmployes());


        shpEditor.commit();
    }
    public HashMap<String, String> getUserDetail(){
        HashMap<String, String> emp = new HashMap<>();
        emp.put(DATA,sharedPreferences.getString(DATA,null));

        return emp;
    }
    public void logoutSession(){
        shpEditor.clear();
        shpEditor.commit();
    }

    public boolean isLoggedIn(){
        return sharedPreferences.getBoolean(IS_LOGGED_IN,false);
    }
}
