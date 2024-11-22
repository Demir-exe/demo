package com.deneme.demo.Controller;

import com.deneme.demo.Service.MesajService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
public class MessageController {

    @Autowired
    private MesajService mesajService;

    // message/1 ve message/2 altındaki mesajları al
    @GetMapping("/message/{id}")
    public String getMessage(@PathVariable String id) {
        return mesajService.getMessage(id);  // message/id'den mesajı al
    }

    // message/id altındaki mesajı güncelle
    @PostMapping("/message/{id}")
    public String updateMessage(@PathVariable String id, @RequestParam String message) {
        return mesajService.updateMessage(id, message);  // message/id'yi güncelle
    }
}
