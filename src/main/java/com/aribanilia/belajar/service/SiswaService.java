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

    /**
     * TODO :
     * - Validasi Request tidak boleh null
     * - Endpoint find by nik, find by name
     */

    @Autowired
    private SiswaRepository siswaRepository;

    public void saveDummy() {
        Siswa siswa = new Siswa();
        siswa.setId(System.currentTimeMillis());
        siswa.setNik("2021");
        siswa.setNama("reni");
        siswa.setJenisKelamin("P");

        siswaRepository.save(siswa);

        log.info("Data berhasil disimpan");
    }

    public Object findAllData() {
        return siswaRepository.findAll();
    }

    public Siswa save(SiswaRequest siswaRequest) {

        if (siswaRequest.getNik() == null){
            log.info("Data NIK tidak boleh kosong");
            return null;
        }

        if (siswaRequest.getNik().length() != 10) {
            log.error("Data NIK yang dimasukan salah");
            return null;
        }

        if (siswaRequest.getNama() == null){
            log.info("Data Nama tidak boleh kosong");
            return null;
        }

        /**
         * Jika jenis kelamin yang dikirimkan tidak sama dengan L
         * dan
         * Jika jenis kelamin yang dikirimkan tidak sama dengan P
         * maka
         * return null
         */
        if (siswaRequest.getJenisKelamin() == null){
            log.info("Data Jenis Kelamin tidak boleh kosong");
            return null;
        }

        if (!siswaRequest.getJenisKelamin().equals("L")
                && !siswaRequest.getJenisKelamin().equals("P")) {
            log.error("Jenis Kelamin wajib L atau P");
            return null;
        }

        Siswa siswa = siswaRepository.findByNik(siswaRequest.getNik());
        if (siswa != null){
            log.error("NIK sudah digunakan");
            return null;
        }

        siswa = new Siswa();
        siswa.setId(System.currentTimeMillis());
        siswa.setNik(siswaRequest.getNik());
        siswa.setNama(siswaRequest.getNama());
        siswa.setJenisKelamin(siswaRequest.getJenisKelamin());

        siswaRepository.save(siswa);
        return siswa;
    }

    public void deleteData(Long id) {
        Siswa siswa = siswaRepository.findById(id).get();
        siswaRepository.delete(siswa);
        log.info("Data {} berhasil dihapus", siswa);
    }

    public Siswa findByNik(String nik) {
        Siswa siswa = siswaRepository.findByNik(nik);

        log.info("Data {} berhasil ditemukan", siswa);
        return siswa;
    }

    public Siswa findByName(String nama){
        Siswa siswa = siswaRepository.findByNama(nama);

        log.info("Data {} berhasil ditemukan", siswa);
        return siswa;
    }

    public Siswa findByJenisKelamin (String jeniskelamin){
        Siswa siswa = siswaRepository.findByJenisKelamin(jeniskelamin);

        log.info("Data {} berhasil ditemukan", siswa);
        return siswa;
    }

    public Siswa updateData (SiswaRequest siswaRequest){
        Siswa siswa = siswaRepository.findByNik(siswaRequest.getNik());

        if (siswa == null){
            log.info("Data Siswa dengan NIK {} tidak ditemukan", siswaRequest.getNik());
            return null;
        }

//        if (siswaRequest.getJenisKelamin() == null){
//            log.info("Data Jenis Kelamin tidak boleh kosong");
//        }
//        if (!siswaRequest.getJenisKelamin().equals("L")
//                && !siswaRequest.getJenisKelamin().equals("P")){
//            log.error("Jenis Kelamin wajib L atau P");
//            return null;
//        }

        siswa.setNama(siswaRequest.getNama());
//        siswa.setJenisKelamin(siswaRequest.getJenisKelamin());
        siswaRepository.save(siswa);

        log.info("Data {} berhasil diupdate", siswa);
        return siswa;
    }

}
