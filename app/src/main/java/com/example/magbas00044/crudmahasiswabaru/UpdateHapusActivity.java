package com.example.magbas00044.crudmahasiswabaru;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.magbas00044.crudmahasiswabaru.response.ResponseInsert;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateHapusActivity extends AppCompatActivity {

    @BindView(R.id.edNim1)
    EditText edNim1;
    @BindView(R.id.edNama2)
    EditText edNama2;
    @BindView(R.id.edJurusan2)
    EditText edJurusan2;
    @BindView(R.id.btnUpdate)
    Button btnUpdate;

    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_hapus);
        ButterKnife.bind(this);
        id = getIntent().getStringExtra("id");
        String nim = getIntent().getStringExtra("nim");
        String nama = getIntent().getStringExtra("nama");
        String jurusan = getIntent().getStringExtra("jurusan");

        edNim1.setText(nim);
        edNama2.setText(nama);
        edJurusan2.setText(jurusan);
    }

    @OnClick(R.id.btnUpdate)
    public void onViewClicked() {

        updatedata();
    }

    private void updatedata() {
        String updateNim = edNim1.getText().toString();
        String updateNama = edNama2.getText().toString();
        String updateJurusan = edJurusan2.getText().toString();

        ConfigRetrofit.service.update(id, updateNim, updateNama, updateJurusan).enqueue(new Callback<ResponseInsert>() {
            @Override
            public void onResponse(Call<ResponseInsert> call, Response<ResponseInsert> response) {
                String pesan = response.body().getPesan();
                int status = response.body().getStatus();
                if (status == 1) {
                    Toast.makeText(UpdateHapusActivity.this, pesan, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(UpdateHapusActivity.this, MainActivity.class));
                    //finishActivity(1);
                } else {
                    Toast.makeText(UpdateHapusActivity.this, pesan, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseInsert> call, Throwable t) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_hapus, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int idMenu = item.getItemId();
        if (idMenu == R.id.btnhapus) {
            AlertDialog alert = new AlertDialog.Builder(UpdateHapusActivity.this).create();
            alert.setTitle("Konfirmasi");
            alert.setMessage("Anda yakin untuk menghapus?");
            alert.setButton(alert.BUTTON_POSITIVE, "Hapus", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ConfigRetrofit.service.hapus(id).enqueue(new Callback<ResponseInsert>() {
                        @Override
                        public void onResponse(Call<ResponseInsert> call, Response<ResponseInsert> response) {
                            String pesan = response.body().getPesan();
                            int status = response.body().getStatus();
                            if (status == 1) {
                                Toast.makeText(UpdateHapusActivity.this, pesan, Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(UpdateHapusActivity.this, MainActivity.class));
                                finish();
                            } else {
                                Toast.makeText(UpdateHapusActivity.this, pesan, Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void onFailure(Call<ResponseInsert> call, Throwable t) {

                        }
                    });

                }
            });
            alert.setButton(alert.BUTTON_NEGATIVE, "Batal", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            alert.show();
        }
        return true;
    }
}
