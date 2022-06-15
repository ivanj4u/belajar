package com.aribanilia.belajar.controller;

import com.aribanilia.belajar.dto.SiswaRequest;
import com.aribanilia.belajar.dto.SiswaResponse;
import com.aribanilia.belajar.entity.Siswa;
import com.aribanilia.belajar.service.SiswaService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping ("/siswa")
public class SiswaCrudController {

    private final SiswaService siswaService;

    @Autowired
    public SiswaCrudController(SiswaService siswaService) {
        this.siswaService = siswaService;
    }

    @GetMapping ("/saveDummy")
    public SiswaResponse saveDummy(){
        log.info("incoming /siswa/savedummy");

        siswaService.saveDummy();

        log.info("outgoing /siswa/savedummy");

        SiswaResponse siswaResponse = new SiswaResponse();
        siswaResponse.setMessage("Data berhasil disimpan");
        return siswaResponse;
    }

    @GetMapping("/findall")
    public SiswaResponse findAll(){
        log.info("incoming /siswa/findall");

        Object data = siswaService.findAllData();

        log.info("outcoming /siswa/findall");

        SiswaResponse siswaResponse = new SiswaResponse();
        siswaResponse.setMessage("Data berhasil ditemukan");
        siswaResponse.setData(data);
        return siswaResponse;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json")
    public SiswaResponse saveData (@RequestBody SiswaRequest siswaRequest){

        log.info("incoming /siswa/save {}", siswaRequest);

        Siswa siswa = siswaService.save(siswaRequest);

        log.info("outcoming /siswa/save {}", siswaRequest);

        SiswaResponse siswaResponse = new SiswaResponse();

//        if (siswa == null){
//            siswaResponse.setMessage("Data tidak bisa disave");
//        } else {
            siswaResponse.setMessage("Data berhasil disimpan");
            siswaResponse.setData(siswa);
//        }
        return siswaResponse;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = "application/json")
    public SiswaResponse deleteData (@RequestParam ("id") String id){
        log.info("incoming /siswa/delete");

        siswaService.deleteData(Long.parseLong(id));

        log.info("outcoming /siswa/delete");
        SiswaResponse siswaResponse = new SiswaResponse();
        siswaResponse.setMessage("Data berhasil dihapus");
        return siswaResponse;
    }

}
