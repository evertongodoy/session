document.addEventListener("DOMContentLoaded", function () {
    const bodyElement = document.querySelector("body");
    const sessionTimeout = parseInt(bodyElement.getAttribute("data-session-timeout"), 10);

    let remainingTime = sessionTimeout;

    function updateCountdown() {
        if (remainingTime > 0) {
            const minutes = Math.floor(remainingTime / 60);
            const seconds = remainingTime % 60;

            document.getElementById("timeoutCountdown").textContent =
                `${minutes}m ${seconds}s`;

            remainingTime--;
        } else {
            document.getElementById("timeoutCountdown").textContent = "Sessão expirada!";
        }
    }

    setInterval(updateCountdown, 1000);
    updateCountdown();
});
