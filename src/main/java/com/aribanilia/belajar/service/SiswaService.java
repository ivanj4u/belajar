package com.aribanilia.belajar.service;

import com.aribanilia.belajar.dto.SiswaRequest;
import com.aribanilia.belajar.entity.Siswa;
import com.aribanilia.belajar.repository.SiswaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        if (siswaRequest.getNik().length()!=10){
            log.error("Data NIK yang dimasukan salah");
            return null;
        }
        if (siswaRequest.getJenisKelamin().equals("L")
            && !siswaRequest.getJenisKelamin().equals("P")){
            log.error("Jenis Kelamin wajib L atau P");
            return null;
        }

        Siswa siswa = new Siswa();
        siswa.setId(System.currentTimeMillis());
        siswa.setNik(siswaRequest.getNik());
        siswa.setNama(siswaRequest.getNama());
        siswa.setJenisKelamin(siswaRequest.getJenisKelamin());

        siswaRepository.save(siswa);
        return siswa;
    }

    public void deleteData(Long id){
        Siswa siswa = siswaRepository.findById(id).get();
        siswaRepository.delete(siswa);
        log.info("Data {} berhasil dihapus", siswa);

    }

}
