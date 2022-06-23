package com.aribanilia.belajar.repository;

import com.aribanilia.belajar.entity.TarifSekolah;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarifSekolahRepository extends CrudRepository<TarifSekolah,Long> {

    TarifSekolah findByNik(String nik);

    TarifSekolah findByBulan (String bulan);

    TarifSekolah findByNominal (String nominal);

}
