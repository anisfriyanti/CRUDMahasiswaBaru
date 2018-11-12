package com.example.magbas00044.crudmahasiswabaru;

import com.example.magbas00044.crudmahasiswabaru.response.ResponseGetMahasiswa;
import com.example.magbas00044.crudmahasiswabaru.response.ResponseInsert;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @GET("getMahasiswa")
    Call<ResponseGetMahasiswa> lihat();

    @FormUrlEncoded
    @POST("insertMahasiswa")
    Call<ResponseInsert> tambah(@Field("nim") String nim,
                                @Field("name") String nama,
                                @Field("majors") String jurusan);

    @FormUrlEncoded
    @POST("updateMahasiswa")
    Call<ResponseInsert> update(
            @Field("id") String id,
            @Field("nim") String nim,
            @Field("name") String nama,
            @Field("majors") String jurusan);

    @FormUrlEncoded
    @POST("deleteMahasiswa")
    Call<ResponseInsert> hapus(
            @Field("id") String id);
}
