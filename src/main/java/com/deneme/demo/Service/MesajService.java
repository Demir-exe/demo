package com.deneme.demo.Service;

import com.deneme.demo.entity.Mesaj;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import org.springframework.stereotype.Service;

@Service
public class MesajService {

    public String saveMessage(Mesaj mesaj, String id) {
        // Firebase Realtime Database bağlantısı
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

        // Seçilen ID'ye göre mesajı güncelle
        databaseReference.child("message").child(id).setValueAsync(mesaj.getMessage());

        return "Mesaj başarıyla kaydedildi <br> Mesaj : " + mesaj.getMessage() + " ID: " + id;
    }
}
