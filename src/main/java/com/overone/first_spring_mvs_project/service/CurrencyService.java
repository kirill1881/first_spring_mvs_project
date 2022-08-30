package com.overone.first_spring_mvs_project.service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

@Service
public class CurrencyService {
    public double getUSDPrice(int price) throws Exception{
        URL url = new URL("https://www.nbrb.by/api/exrates/rates/USD?parammode=2");
        BufferedReader bufferedReader =
                new BufferedReader
                        (new InputStreamReader(url.openStream()));
        String cur = bufferedReader.readLine();
        JSONObject jsonObject = new JSONObject(cur);
        String str = jsonObject.get("Cur_OfficialRate").toString();
        return Math.round((double) price/Double.parseDouble(str));
    }
    public double getEURPrice(int price) throws Exception{
        URL url = new URL("https://www.nbrb.by/api/exrates/rates/EUR?parammode=2");
        BufferedReader bufferedReader =
                new BufferedReader
                        (new InputStreamReader(url.openStream()));
        String cur = bufferedReader.readLine();
        JSONObject jsonObject = new JSONObject(cur);
        String str = jsonObject.get("Cur_OfficialRate").toString();
        return Math.round((double) price/Double.parseDouble(str));
    }
}
