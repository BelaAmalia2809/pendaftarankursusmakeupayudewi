package id.sch.smktelkom_mlg.tugas01.xirpl2005.pendaftarankursusmakeupayudewi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    TextView tvhasil, tvgenre;
    int nGenre;
    EditText etnama, etumur, etasal;
    CheckBox cbM, cbT, cbMus;
    RadioButton rbk, rbs, rbm;
    RadioGroup rgpaket;
    Spinner spcabang;
    Button btndaftar, btnkembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvhasil = (TextView) findViewById(R.id.textViewHasil);
        tvgenre = (TextView) findViewById(R.id.textViewGenre);
        etnama = (EditText) findViewById(R.id.editTextNama);
        etumur = (EditText) findViewById(R.id.editTextUmur);
        etasal = (EditText) findViewById(R.id.editTextAsal);
        cbM = (CheckBox) findViewById(R.id.checkBoxM);
        cbT = (CheckBox) findViewById(R.id.checkBoxT);
        cbMus = (CheckBox) findViewById(R.id.checkBoxMus);
        rgpaket = (RadioGroup) findViewById(R.id.RadioGroupPaket);
        rbk = (RadioButton) findViewById(R.id.radioButtonK);
        rbs = (RadioButton) findViewById(R.id.radioButtonS);
        rbm = (RadioButton) findViewById(R.id.radioButtonM);
        spcabang = (Spinner) findViewById(R.id.spinnerCabang);
        btndaftar = (Button) findViewById(R.id.buttondaftar);
        btnkembali = (Button) findViewById(R.id.buttonkembali);

        cbM.setOnCheckedChangeListener(this);
        cbT.setOnCheckedChangeListener(this);
        cbMus.setOnCheckedChangeListener(this);


        btndaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doProccess();
            }
        });
        btnkembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doKembali();
            }
        });

    }

    private void doKembali() {
        findViewById(R.id.buttondaftar).setVisibility(View.VISIBLE);
        findViewById(R.id.imageView).setVisibility(View.VISIBLE);
        findViewById(R.id.editTextNama).setVisibility(View.VISIBLE);
        findViewById(R.id.editTextUmur).setVisibility(View.VISIBLE);
        findViewById(R.id.editTextAsal).setVisibility(View.VISIBLE);
        findViewById(R.id.textView2).setVisibility(View.VISIBLE);
        findViewById(R.id.spinnerCabang).setVisibility(View.VISIBLE);
        findViewById(R.id.textView3).setVisibility(View.VISIBLE);
        findViewById(R.id.RadioGroupPaket).setVisibility(View.VISIBLE);
        findViewById(R.id.textViewGenre).setVisibility(View.VISIBLE);
        findViewById(R.id.checkBoxM).setVisibility(View.VISIBLE);
        findViewById(R.id.checkBoxT).setVisibility(View.VISIBLE);
        findViewById(R.id.checkBoxMus).setVisibility(View.VISIBLE);
        findViewById(R.id.buttonkembali).setVisibility(View.GONE);
        findViewById(R.id.textViewHasil).setVisibility(View.GONE);
    }

    private void doProccess() {
        if (isValid()) {
            String nama = etnama.getText().toString();
            int umur = Integer.parseInt(etumur.getText().toString());
            String asal = etasal.getText().toString();
            String hasil = "\n Genre                          : ";
            if (cbM.isChecked()) hasil += cbM.getText() + " ";
            if (cbT.isChecked()) hasil += cbT.getText() + " ";
            if (cbMus.isChecked()) hasil += cbMus.getText() + " ";
            String hasilpaket = null;
            String cabang = spcabang.getSelectedItem().toString();

            if (rbk.isChecked()) {
                hasilpaket = rbk.getText().toString();
            } else if (rbs.isChecked()) {
                hasilpaket = rbs.getText().toString();
            } else if (rbm.isChecked()) {
                hasilpaket = rbm.getText().toString();
            } else {
                hasilpaket = "Anda belum memilih paket";
            }

            findViewById(R.id.buttondaftar).setVisibility(View.GONE);
            findViewById(R.id.imageView).setVisibility(View.GONE);
            findViewById(R.id.editTextNama).setVisibility(View.GONE);
            findViewById(R.id.editTextUmur).setVisibility(View.GONE);
            findViewById(R.id.editTextAsal).setVisibility(View.GONE);
            findViewById(R.id.textView2).setVisibility(View.GONE);
            findViewById(R.id.spinnerCabang).setVisibility(View.GONE);
            findViewById(R.id.textView3).setVisibility(View.GONE);
            findViewById(R.id.RadioGroupPaket).setVisibility(View.GONE);
            findViewById(R.id.textViewGenre).setVisibility(View.GONE);
            findViewById(R.id.checkBoxM).setVisibility(View.GONE);
            findViewById(R.id.checkBoxT).setVisibility(View.GONE);
            findViewById(R.id.checkBoxMus).setVisibility(View.GONE);
            findViewById(R.id.buttonkembali).setVisibility(View.VISIBLE);
            findViewById(R.id.textViewHasil).setVisibility(View.VISIBLE);

            tvhasil.setText(
                    " Nama                           : " + nama + " " + "\n Umur                           : " + umur + " " + "\n Asal                             : " + asal + " " + "\n Cabang yang dipilih : " + cabang + " " + "\n Pilihan Paket              : " + hasilpaket + " " + hasil);
        }
    }

    private boolean isValid() {
        boolean valid = true;

        String nama = etnama.getText().toString();
        String umur = etumur.getText().toString();
        String asal = etasal.getText().toString();

        int umurangka = 0;

        if (nama.isEmpty()) {
            etnama.setError("Nama harus terisi untuk mendaftar");
            valid = false;
        } else if (nama.length() < 5) {
            etnama.setError("Nama minimal 5 karakter");
            valid = false;
        } else {
            etnama.setError(null);
        }

        if (umur.isEmpty()) {
            etumur.setError("Umur harus terisi untuk mendatar");
            valid = false;
        } else {
            umurangka = Integer.parseInt(umur);
        }

        if (umurangka == 0) {
            etumur.setError("Umur harus terisi untuk mendatar");
            valid = false;
        } else if (umurangka < 12) {
            etumur.setError("Anda minimal harus berusia 12 tahun");
            valid = false;
        } else if (umurangka > 50) {
            etumur.setError("Maksimal, umur anda adalah 50 tahun untuk mengikuti kursus");
            valid = false;
        } else {
            etumur.setError(null);
        }

        if (asal.isEmpty()) {
            etasal.setError("Asal kota harus terisi untuk mendaftar");
            valid = false;
        } else {
            etasal.setError(null);
        }

        return valid;
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        if (isChecked) nGenre += 1;
        else nGenre -= 1;

        tvgenre.setText("Genre (" + nGenre + " terpilih)");
    }
}