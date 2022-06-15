//package com.aribanilia.belajar.controller;
//
//import com.aribanilia.belajar.dto.Request;
//import com.aribanilia.belajar.dto.Response;
//import com.aribanilia.belajar.entity.MataPelajaran;
//import com.aribanilia.belajar.service.MataPelajaranService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@Slf4j
//@RestController
//@RequestMapping("/matapelajaran")
//public class CrudController {
//
//    @Autowired
//    private MataPelajaranService mataPelajaranService;
//
//    @GetMapping("/savedummy")
//    public Response saveDummy() {
//        log.info("Incoming /matapelajaran/savedummy");
//
//        mataPelajaranService.saveDummy();
//
//        log.info("Outgoing /matapelajaran/savedummy");
//
//        Response response = new Response();
//        response.setMessage("Data berhasil disimpan");
//        return response;
//    }
//
//    @GetMapping("/findall")
//    public Response findAll() {
//        log.info("Incoming /matapelajaran/findall");
//
//        Object data = mataPelajaranService.findAllData();
//
//        log.info("Outgoing /matapelajaran/findall");
//
//        Response response = new Response();
//        response.setMessage("Data berhasil ditemukan");
//        response.setData(data);
//        return response;
//    }
//
//    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json")
//    public Response saveData(@RequestBody Request request) {
//        log.info("Incoming /matapelajaran/save {}", request);
//
//        MataPelajaran mataPelajaran = mataPelajaranService.save(request);
//
//        log.info("Outgoing /matapelajaran/save {}", request);
//
//        Response response = new Response();
//        response.setMessage("Data Request berhasil disimpan");
//        response.setData(mataPelajaran);
//        return response;
//    }
//
//    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = "application/json")
//    public Response deleteData(@RequestParam("id") String id) {
//        log.info("Incoming /matapelajaran/delete");
//
//        mataPelajaranService.deleteData(Long.parseLong(id));
//
//        log.info("Outgoing /matapelajaran/delete");
//        Response response = new Response();
//        response.setMessage("Data Request berhasil dihapus");
//        return response;
//    }
//
//    @RequestMapping(value = "/findbykode", method = RequestMethod.GET, produces = "application/json")
//    public Response findByKode(@RequestParam("kodeMataPelajaran") String kodeMataPelajaran) {
//        log.info("Incoming /matapelajaran/findbykode");
//
//        MataPelajaran mataPelajaran = mataPelajaranService.findByKodeMataPelajaran(kodeMataPelajaran);
//
//        log.info("Outgoing /matapelajaran/findbykode");
//        Response response = new Response();
//
//        if (mataPelajaran == null) {
//            response.setMessage("Data Gagal ditemukan");
//        } else {
//            response.setMessage("Data Berhasil ditemukan");
//            response.setData(mataPelajaran);
//        }
//
//        return response;
//    }
//    @RequestMapping(value = "/findbyname", method = RequestMethod.GET, produces = "application/json")
//    public Response findByName(@RequestParam("namaMataPelajaran") String namaMataPelajaran) {
//        log.info("Incoming /matapelajaran/findbyname");
//
//        MataPelajaran mataPelajaran = mataPelajaranService.findByNamaMataPelajaran(namaMataPelajaran);
//
//        log.info("Outgoing /matapelajaran/findbyname");
//        Response response = new Response();
//
//        if (mataPelajaran == null) {
//            response.setMessage("Data Gagal ditemukan");
//        } else {
//            response.setMessage("Data Berhasil ditemukan");
//            response.setData(mataPelajaran);
//        }
//
//        return response;
//    }
//
//    @PostMapping(value = "/update", produces = "application/json")
//    public Response updateData(@RequestBody Request request) {
//        log.info("Incoming /matapelajaran/update {}", request);
//
//        MataPelajaran mataPelajaran = mataPelajaranService.updateData(request);
//
//        log.info("Outgoing /matapelajaran/update {}", request);
//
//        Response response = new Response();
//
//        if (mataPelajaran == null) {
//            response.setMessage("Data Gagal Update");
//        } else {
//            response.setMessage("Data Berhasil diupdate");
//            response.setData(mataPelajaran);
//        }
//        return response;
//    }
//}
