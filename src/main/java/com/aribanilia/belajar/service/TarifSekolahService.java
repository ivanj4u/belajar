package com.aribanilia.belajar.service;

import com.aribanilia.belajar.dto.Response;
import com.aribanilia.belajar.dto.TarifSekolahRequest;
import com.aribanilia.belajar.entity.TarifSekolah;
import com.aribanilia.belajar.repository.TarifSekolahRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class TarifSekolahService {

    @Autowired
    private TarifSekolahRepository tarifSekolahRepository;

    public void saveDummy(){
        TarifSekolah tarifSekolah = new TarifSekolah();
        tarifSekolah.setId(System.currentTimeMillis());
        tarifSekolah.setNik("2020202024");
        tarifSekolah.setBulan("05");
        tarifSekolah.setNominal(new BigDecimal("50000"));

        tarifSekolahRepository.save(tarifSekolah);
        log.info("Data berhasil disave");
    }

    public List<TarifSekolah> save(TarifSekolahRequest tarifSekolahRequest){

        if(tarifSekolahRequest.getNik() == null){
            log.info("Data NIK tidak boleh kosong");
            return null;
        }

        if (tarifSekolahRequest.getNik().length() !=10){
            log.info("Data NIK yang dimasukan salah");
            return null;
        }

        List<TarifSekolah> daftarIuran = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            log.info("NIlai i : {}", i);
            TarifSekolah tarifSekolah = new TarifSekolah();
            tarifSekolah.setId(System.currentTimeMillis());
            tarifSekolah.setNik(tarifSekolahRequest.getNik());
            tarifSekolah.setBulan(String.valueOf((i + 1))); // Bulan iuran
            tarifSekolah.setNominal(new BigDecimal(50000)); // Iuran per bulan 50rb

            tarifSekolahRepository.save(tarifSekolah);
            daftarIuran.add(tarifSekolah);
        }
        return daftarIuran;
    }

    public Object findAllData(){
        return tarifSekolahRepository.findAll();
    }

    public void deleteData(Long id){
        TarifSekolah tarifSekolah = tarifSekolahRepository.findById(id).get();
        tarifSekolahRepository.delete(tarifSekolah);
        log.info("Data {} berhasil dihapus", tarifSekolah);
    }

    public TarifSekolah findByNik(String nik){
        TarifSekolah tarifSekolah = tarifSekolahRepository.findByNik(nik);

        log.info("Data {} berhasil ditemukan", tarifSekolah);
        return tarifSekolah;
    }

    public TarifSekolah updateData(TarifSekolahRequest tarifSekolahRequest){
        TarifSekolah tarifSekolah = tarifSekolahRepository.findByNik(tarifSekolahRequest.getNik());

        if (tarifSekolah == null){
            log.info("Data Tarif Sekolah dengan NIK {} tidak ditemukan", tarifSekolahRequest.getNik());
            return null;
        }

        tarifSekolahRepository.save(tarifSekolah);

        log.info("Data {} berhasil diupdate", tarifSekolah);
        return tarifSekolah;
    }

}
