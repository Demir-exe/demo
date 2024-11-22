package com.deneme.demo.Service;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import org.springframework.stereotype.Service;

@Service
public class MesajService {

    private static final String MESSAGE_PATH = "message";  // Firebase Realtime Database path

    // message/1 ve message/2 altındaki mesajları almak
    public String getMessage(String id) {
        final String[] result = {null}; // Mesajı tutacak değişken
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

        // Firebase'den message/1 ve message/2 verilerini almak
        databaseReference.child(MESSAGE_PATH).child(id).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    result[0] = dataSnapshot.getValue(String.class);  // Mesajı al
                } else {
                    result[0] = "Mesaj bulunamadı";
                }
            }

            @Override
            public void onCancelled(com.google.firebase.database.DatabaseError databaseError) {
                result[0] = "Veri alınamadı: " + databaseError.getMessage();  // Hata durumu
            }
        });

        // Asenkron işlemin hemen ardından sonucu döndüremeyiz, bu yüzden bir gecikme ekliyoruz
        try {
            Thread.sleep(1000);  // Hızlı bir gecikme, işlemin tamamlanmasını beklemek için
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return result[0];  // Bu satır hala asenkron bir şekilde çalışacak.
    }

    // message/id altındaki mesajı güncellemek
    public String updateMessage(String id, String message) {
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

        try {
            // Firebase'e mesajı güncelleme
            databaseReference.child(MESSAGE_PATH).child(id).setValueAsync(message).get();  // Asenkron güncelleme
            return "Mesaj başarıyla güncellendi: " + message;  // Başarılı güncelleme mesajı
        } catch (Exception e) {
            e.printStackTrace();
            return "Mesaj güncellenemedi: " + e.getMessage(); // Hata mesajı
        }
    }
}
