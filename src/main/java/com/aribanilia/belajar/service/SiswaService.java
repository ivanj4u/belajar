package com.aribanilia.belajar.service;

import com.aribanilia.belajar.dto.SiswaRequest;
import com.aribanilia.belajar.entity.Siswa;
import com.aribanilia.belajar.repository.SiswaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Slf4j
@Service
public class SiswaService {

    @Autowired
    private SiswaRepository siswaRepository;

    public void saveDummy(){
        Siswa siswa = new Siswa();
        siswa.setId(System.currentTimeMillis());
        siswa.setNik("2021");
        siswa.setNama("reni");
        siswa.setJenisKelamin("P");

        siswaRepository.save(siswa);

        log.info("Data berhasil disimpan");
    }

    public Object findAllData(){
        return siswaRepository.findAll();
    }

    public Siswa save(SiswaRequest siswaRequest){
        
//        String jenisKelamin1 = "L";
//        String jenisKelamin2 = "P";

        Siswa siswa = new Siswa();
        siswa.setId(System.currentTimeMillis());
        siswa.setNik(siswaRequest.getNik());
        siswa.setNama(siswaRequest.getNama());
        siswa.setJenisKelamin(siswaRequest.getJenisKelamin());

        siswaRepository.save(siswa);

//        if (jenisKelamin1.equals(jenisKelamin2)){
            log.info("Data {} berhasil disimpan", siswa);
//        } else {
            log.info("Data {} tidak berhasil disimpan", siswa);
//        }
        return siswa;
    }

    public void deleteData(Long id){
        Siswa siswa = siswaRepository.findById(id).get();
        siswaRepository.delete(siswa);
        log.info("Data {} berhasil dihapus", siswa);

    }

}
