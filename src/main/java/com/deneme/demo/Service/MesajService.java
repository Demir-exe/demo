package com.deneme.demo.Service;
import com.deneme.demo.entity.Mesaj;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class MesajService {

    private static final String MESSAGE_PATH = "message_1";  // Firebase Realtime Database path

    public String saveMessage(Mesaj mesaj) throws ExecutionException, InterruptedException {
        // Firebase Realtime Database bağlantısı
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

        // Mesajı "message" path'ine kaydediyoruz
        databaseReference.child(MESSAGE_PATH).setValueAsync(mesaj);

        return "Mesaj başarıyla kaydedildi <br> Mesaj : "+mesaj.getMessage();
    }
}

