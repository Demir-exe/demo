// Veriyi Firebase'den almak için API'ye GET isteği gönderme
function loadMessages() {
    fetch('http://localhost:8080/api/message/1')  // message/1 verisini çek
        .then(response => response.text())
        .then(data => {
            document.getElementById("message1").innerText = data;  // Panel 1'e mesajı yerleştir
        });

    fetch('http://localhost:8080/api/message/2')  // message/2 verisini çek
        .then(response => response.text())
        .then(data => {
            document.getElementById("message2").innerText = data;  // Panel 2'ye mesajı yerleştir
        });
}

// Firebase'deki mesajı güncellemek için API'ye POST isteği gönderme
function updateMessage(panelId) {
    const message = document.getElementById(`updateMessage${panelId}`).value;  // Girilen mesajı al

    // Mesajı Firebase'e POST isteği ile gönder
    fetch(`http://localhost:8080/api/message/${panelId}?message=${message}`, {
        method: 'POST',
    })
    .then(response => response.text())  // Yanıtı al
    .then(data => {
        alert(data);  // Mesajın güncellendiğini bildiren alert
        loadMessages();  // Mesajları yeniden yükle
    });
}

// Sayfa yüklendiğinde mesajları yükle
window.onload = loadMessages;
