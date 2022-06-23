package com.aribanilia.belajar.controller;

import com.aribanilia.belajar.dto.Response;
import com.aribanilia.belajar.dto.TarifSekolahRequest;
import com.aribanilia.belajar.entity.TarifSekolah;
import com.aribanilia.belajar.service.TarifSekolahService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/tarifsekolah")
public class TarifSekolahController {

    @Autowired
    private TarifSekolahService tarifSekolahService;

    @GetMapping("/savedummy")
    public Response saveDummy(){
        log.info("incoming /tarifsekolah/savedummy");

        tarifSekolahService.saveDummy();

        log.info("outcoming /tarifsekolah/savedummy");

        Response response = new Response();
        response.setMessage("Data berhasil disimpan");
        return response;
    }

    @GetMapping("/findall")
    public Response findAll(){
        log.info("incoming /tarifsekolah/findall");

        Object data = tarifSekolahService.findAllData();

        log.info("outcoming /tarifsekolah/findall");

        Response response = new Response();
        response.setMessage("Data berhasil ditemukan");
        response.setData(data);
        return response;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json")
    public Response save(@RequestBody TarifSekolahRequest tarifSekolahRequest){
        log.info("incoming /tarifsekolah/save {}", tarifSekolahRequest);

        TarifSekolah tarifSekolah = (TarifSekolah) tarifSekolahService.save(tarifSekolahRequest);

        log.info("outcoming /tarifsekolah/save {}", tarifSekolahRequest);

        Response response = new Response();
        response.setMessage("Data berhasil disimpan");
        response.setData(tarifSekolah);
        return response;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = "application/json")
    public Response deleteData(@RequestParam("id") String id){
        log.info("incoming /tarifsekolah/delete");

        tarifSekolahService.deleteData(Long.parseLong(id));

        log.info("outcoming /tarifsekolah/delete");

        Response response = new Response();
        response.setMessage("Data berhasil didelete");
        return response;
    }

    @RequestMapping(value = "/findbynik", method = RequestMethod.GET, produces = "application/json")
    public Response findByNik(@RequestParam("nik") String nik){
        log.info("incoming /tarifsekolah/findbynik");

        TarifSekolah tarifSekolah = tarifSekolahService.findByNik(nik);

        log.info("outcoming /tarifsekolah/findbynik");
        Response response = new Response();

        if (tarifSekolah == null){
            response.setMessage("Data gagal ditemukan");
        } else {
            response.setMessage("Data berhasil ditemukan");
            response.setData(tarifSekolah);
        }
        return response;
    }

    @PostMapping(value = "/update", produces = "application/json")
    public Response updateData(@RequestBody TarifSekolahRequest request) {
        log.info("Incoming /matapelajaran/update {}", request);

        TarifSekolah tarifSekolah = tarifSekolahService.updateData(request);

        log.info("Outgoing /matapelajaran/update {}", request);

        Response response = new Response();

        if (tarifSekolah == null) {
            response.setMessage("Data Gagal Update");
        } else {
            response.setMessage("Data Berhasil diupdate");
            response.setData(tarifSekolah);
        }
        return response;
    }


}
