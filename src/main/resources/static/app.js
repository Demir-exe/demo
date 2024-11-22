function sendMessage() {
    const message = document.getElementById("message").value;
    const id = document.getElementById("messageId").value;

    // Mesaj ve ID kontrolü
    if (!message || !id) {
        document.getElementById("response").innerHTML = "Mesaj ve ID boş olamaz!";
        return;
    }

    // API'ye veri gönderme
    fetch('http://localhost:8080/api/message', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: `message=${encodeURIComponent(message)}&id=${encodeURIComponent(id)}`
    })
    .then(response => response.text())
    .then(data => {
        document.getElementById("response").innerHTML = data;
    })
    .catch(error => {
        document.getElementById("response").innerHTML = "Bir hata oluştu!";
        console.error('Error:', error);
    });
}
