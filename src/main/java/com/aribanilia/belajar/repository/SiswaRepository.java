package com.aribanilia.belajar.repository;

import com.aribanilia.belajar.entity.Siswa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiswaRepository extends CrudRepository<Siswa, Long> {

    Siswa findByNik (String nik);

    Siswa findByNama (String nama);

    Siswa findByJenisKelamin (String jenisKelamin);

}
