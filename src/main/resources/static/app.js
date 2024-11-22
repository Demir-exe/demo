// Formu seç
const form = document.getElementById('messageForm');
const responseElement = document.getElementById('response');

// Form gönderme işlemi
form.addEventListener('submit', async (event) => {
    event.preventDefault(); // Sayfanın yeniden yüklenmesini engelle

    // Formdan mesajı al
    const message = document.getElementById('message').value;

    try {
        // Backend'e POST isteği gönder
        const response = await fetch('/api/message', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
            },
            body: `message=${encodeURIComponent(message)}`, // Veriyi gönder
        });

        // Backend'den gelen cevabı al
        const result = await response.text();

        // Başarılı mesajı göster
        responseElement.innerHTML = `Sunucu cevabı: ${result}`;

        responseElement.className = "mt-4 alert alert-success";
        responseElement.classList.remove("d-none");
    } catch (error) {
        console.error('Mesaj gönderme sırasında hata oluştu:', error);
        responseElement.textContent = 'Bir hata oluştu. Lütfen tekrar deneyin.';
        responseElement.className = "mt-4 alert alert-danger";
        responseElement.classList.remove("d-none");
    }
});
