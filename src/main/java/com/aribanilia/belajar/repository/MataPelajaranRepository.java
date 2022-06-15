package com.aribanilia.belajar.repository;

import com.aribanilia.belajar.entity.MataPelajaran;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MataPelajaranRepository extends CrudRepository<MataPelajaran, Long> {

    MataPelajaran findByKodeMataPelajaran(String kodeMataPelajaran);

    List<MataPelajaran> findByNamaMataPelajaranLike(String namaMataPelajaran);
}
