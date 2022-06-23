package com.aribanilia.belajar.controller;

import com.aribanilia.belajar.dto.Response;
import com.aribanilia.belajar.dto.SiswaRequest;
import com.aribanilia.belajar.entity.Siswa;
import com.aribanilia.belajar.service.SiswaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping ("/siswa")
public class SiswaController {

    private final SiswaService siswaService;

    @Autowired
    public SiswaController(SiswaService siswaService) {
        this.siswaService = siswaService;
    }

    @GetMapping ("/saveDummy")
    public Response saveDummy(){
        log.info("incoming /siswa/savedummy");

        siswaService.saveDummy();

        log.info("outgoing /siswa/savedummy");

        Response siswaResponse = new Response();
        siswaResponse.setMessage("Data berhasil disimpan");
        return siswaResponse;
    }

    @GetMapping("/findall")
    public Response findAll(){
        log.info("incoming /siswa/findall");

        Object data = siswaService.findAllData();

        log.info("outcoming /siswa/findall");

        Response siswaResponse = new Response();
        siswaResponse.setMessage("Data berhasil ditemukan");
        siswaResponse.setData(data);
        return siswaResponse;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json")
    public Response saveData (@RequestBody SiswaRequest siswaRequest){

        log.info("incoming /siswa/save {}", siswaRequest);

        Siswa siswa = siswaService.save(siswaRequest);

        log.info("outcoming /siswa/save {}", siswaRequest);

        Response siswaResponse = new Response();

        if (siswa == null){
            siswaResponse.setMessage("Data tidak bisa disave");
        } else {
            siswaResponse.setMessage("Data berhasil disimpan");
            siswaResponse.setData(siswa);
        }
        return siswaResponse;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = "application/json")
    public Response deleteData (@RequestParam ("id") String id){
        log.info("incoming /siswa/delete");

        siswaService.deleteData(Long.parseLong(id));

        log.info("outcoming /siswa/delete");
        Response siswaResponse = new Response();
        siswaResponse.setMessage("Data berhasil dihapus");
        return siswaResponse;
    }

    @RequestMapping (value = "/findbynik", method = RequestMethod.GET, produces = "application/json")
    public Response findByNik(@RequestParam ("nik") String nik){
        log.info("incoming /siswa/findbynik");

        Siswa siswa = siswaService.findByNik(nik);

        log.info("outcoming /siswa/findbynik");
        Response siswaResponse = new Response();

        if (siswa == null){
            siswaResponse.setMessage("Data gagal ditemukan");
        } else {
            siswaResponse.setMessage("Data berhasil ditemukan");
            siswaResponse.setData(siswa);
        }
        return siswaResponse;
    }

    @RequestMapping (value = "/findbyname", method = RequestMethod.GET, produces = "application/json")
    public Response findByName (@RequestParam ("nama") String nama){
        log.info("incoming /siswa/findbyname");

        Siswa siswa = siswaService.findByName(nama);

        log.info("outcoming /siswa/findbyname");
        Response siswaResponse = new Response();

        if (siswa == null){
            siswaResponse.setMessage("Data gagal ditemukan");
        } else {
            siswaResponse.setMessage("Data berhasil ditemukan");
            siswaResponse.setData(siswa);
        }
        return siswaResponse;
    }

    @RequestMapping (value = "/findbyjeniskelamin", method = RequestMethod.GET, produces = "application/json")
    public Response findByJenisKelamin (@RequestParam ("jeniskelamin") String jeniskelamin){
        log.info("incoming /siswa/findbyjeniskelamin");

        Siswa siswa = siswaService.findByJenisKelamin(jeniskelamin);

        log.info("outcoming /siswa/findbyjeniskelamin");
        Response response = new Response();

        if (siswa == null){
            response.setMessage("Data gagal ditemukan");
        }else {
            response.setMessage("Data berhasil ditemukan");
            response.setData(siswa);
        }
        return response;
    }

    @PostMapping (value = "/update", produces = "application/json")
    public Response updateData (@RequestBody SiswaRequest siswaRequest){
        log.info("incoming /siswa/update {}", siswaRequest);

        Siswa siswa = siswaService.updateData(siswaRequest);

        log.info("outcoming /siswa/update {}", siswaRequest);

        Response response = new Response();

        if (siswa == null){
            response.setMessage("Data gagal diupdate");
        } else {
            response.setMessage("Data berhasil diupdate");
            response.setData(siswa);
        }
        return response;
    }

}
