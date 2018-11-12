package com.example.magbas00044.crudmahasiswabaru;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConfigRetrofit {

    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.43.215/server_mahasiswa/index.php/Server/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

   public static ApiService service = retrofit.create(ApiService.class);
}
