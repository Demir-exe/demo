package com.deneme.demo.entity;

public class Mesaj {
    private String message;
    private String id;  // Mesajın ID'si
    private long timestamp;  // Mesajın gönderilme zamanı

    // Getter ve Setter metotları
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
