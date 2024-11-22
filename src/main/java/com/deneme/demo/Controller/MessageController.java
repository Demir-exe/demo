package com.deneme.demo.Controller;

import com.deneme.demo.Service.MesajService;
import com.deneme.demo.entity.Mesaj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RequestMapping("/api")
@RestController
public class MessageController {

    @Autowired
    private MesajService mesajService;

    // Formdan gelen message parametresini alacak olan POST metodu
    @PostMapping("/message")
    public String mesaj(@RequestParam("message") String message) throws ExecutionException, InterruptedException {
        Mesaj mesaj = new Mesaj();
        mesaj.setMessage(message);  // Formdan alınan mesajı Mesaj nesnesine set et
        return mesajService.saveMessage(mesaj);  // Mesajı Firebase'e kaydet
    }
}

