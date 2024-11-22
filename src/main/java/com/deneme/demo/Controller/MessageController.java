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

    // Formdan gelen message ve id parametrelerini alacak olan POST metodu
    @PostMapping("/message")
    public String mesaj(@RequestParam("message") String message, @RequestParam("id") String id) throws ExecutionException, InterruptedException {
        if (message == null || message.isEmpty() || id == null || id.isEmpty()) {
            return "Mesaj veya ID eksik!";
        }

        Mesaj mesaj = new Mesaj();
        mesaj.setMessage(message);  // Mesajı al
        mesaj.setId(id);            // ID'yi al

        // Mesajı Firebase'e kaydet ve id parametresine göre doğru referansı güncelle
        return mesajService.saveMessage(mesaj, id);
    }

}
