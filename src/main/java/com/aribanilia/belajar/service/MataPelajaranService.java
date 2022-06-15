package com.aribanilia.belajar.service;

import com.aribanilia.belajar.dto.MataPelajaranRequest;
import com.aribanilia.belajar.entity.MataPelajaran;
import com.aribanilia.belajar.repository.MataPelajaranRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MataPelajaranService {

    @Autowired
    private MataPelajaranRepository mataPelajaranRepository;

    public void saveDummy() {
        MataPelajaran mataPelajaran = new MataPelajaran();
        mataPelajaran.setId(System.currentTimeMillis()); // id yang digenerate otomatis dari time milis
        mataPelajaran.setKodeMataPelajaran("0001");
        mataPelajaran.setNamaMataPelajaran("PPKN");

        mataPelajaranRepository.save(mataPelajaran);

        log.info("Data berhasil disimpan");
    }

    public Object findAllData() {
        return mataPelajaranRepository.findAll();
    }

    public MataPelajaran save(MataPelajaranRequest request) {
        MataPelajaran mataPelajaran = new MataPelajaran();
        mataPelajaran.setId(System.currentTimeMillis());
        mataPelajaran.setNamaMataPelajaran(request.getNamaMataPelajaran());
        mataPelajaran.setKodeMataPelajaran(request.getKodeMataPelajaran());

        mataPelajaranRepository.save(mataPelajaran);

        log.info("Data {} berhasil disimpan", mataPelajaran);
        return mataPelajaran;
    }

    public void deleteData(Long id) {
        MataPelajaran mataPelajaran = mataPelajaranRepository.findById(id).get();
        mataPelajaranRepository.delete(mataPelajaran);
        log.info("Data {} berhasil dihapus", mataPelajaran);
    }

    public MataPelajaran findByKodeMataPelajaran(String kodeMataPelajaran) {
        MataPelajaran mataPelajaran = mataPelajaranRepository.findByKodeMataPelajaran(kodeMataPelajaran);

        log.info("Data {} berhasil ditemukan", mataPelajaran);
        return mataPelajaran;
    }

    public MataPelajaran findByNamaMataPelajaran(String namaMataPelajaran) {
        MataPelajaran mataPelajaran = mataPelajaranRepository.findByNamaMataPelajaran(namaMataPelajaran);

        log.info("Data {} berhasil ditemukan", mataPelajaran);
        return mataPelajaran;
    }

    public MataPelajaran updateData(MataPelajaranRequest request) {
        MataPelajaran mataPelajaran = mataPelajaranRepository.findByKodeMataPelajaran(request.getKodeMataPelajaran());

        if (mataPelajaran == null) {
            log.error("Data Mata Pelajaran dengan kode {} tidak ditemukan", request.getKodeMataPelajaran());
            return null;
        }

        mataPelajaran.setNamaMataPelajaran(request.getNamaMataPelajaran());
        mataPelajaranRepository.save(mataPelajaran); // update

        log.info("Data {} berhasil diupdate", mataPelajaran);
        return mataPelajaran;
    }
}
