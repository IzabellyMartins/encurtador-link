// Consumindo a api para encurtar o Link
async function encurtarUrl() {
    const longUrl = document.getElementById("longUrl").value;

    if (!longUrl) {
        alert("Por favor, insira uma URL válida!");
        return;
    }

    try {
        // Faz a requisição POST para encurtar a URL
        const response = await fetch("/url/encurtar", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({ url: longUrl })
        });

        if (!response.ok) {
            const errorData = await response.json();
            throw new Error(errorData.erro || "Erro ao encurtar a URL");
        }

        const data = await response.json();

        // Monta a URL encurtada completa usando a URL atual da página
        const urlEncurtadaCompleta = `${window.location.origin}/url/${data.urlEncurtada}`;

        document.getElementById("result").innerHTML = `
            <p>URL Encurtada: <a href="${urlEncurtadaCompleta}" target="_blank">${urlEncurtadaCompleta}</a></p>
        `;
    } catch (error) {
        console.error("Erro:", error);
        document.getElementById("result").innerHTML = `<p style="color:red;">${error.message}</p>`;
    }
}

// Adiciona um listener para o botão de encurtar URL
document.getElementById("shortenButton").addEventListener("click", encurtarUrl);mentById("shortenButton").addEventListener("click", shortenUrl);

// Função para alternar entre os modos claro e escuro
function toggleTheme() {
    const body = document.body;
    const themeToggleIcon = document.querySelector('.theme-toggle i');

    body.classList.toggle('dark-mode');

    // Alterna entre os ícones de sol e lua
    if (body.classList.contains('dark-mode')) {
        themeToggleIcon.classList.remove('fa-sun');
        themeToggleIcon.classList.add('fa-moon');
    } else {
        themeToggleIcon.classList.remove('fa-moon');
        themeToggleIcon.classList.add('fa-sun');
    }
}

// Função para encurtar a URL
async function encurtarUrl() {
    const longUrl = document.getElementById("longUrl").value;

    if (!longUrl) {
        alert("Por favor, insira uma URL válida!");
        return;
    }

    try {
        const response = await fetch("/url/encurtar", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({ url: longUrl })
        });

        if (!response.ok) {
            const errorData = await response.json();
            throw new Error(errorData.erro || "Erro ao encurtar a URL");
        }

        const data = await response.json();
        const urlEncurtadaCompleta = `${window.location.origin}/url/${data.urlEncurtada}`;

        document.getElementById("result").innerHTML = `
            <p>URL Encurtada: <a href="${urlEncurtadaCompleta}" target="_blank">${urlEncurtadaCompleta}</a> !😄🎉</p>
        `;
    } catch (error) {
        console.error("Erro:", error);
        document.getElementById("result").innerHTML = `<p style="color:red;">${error.message}</p>`;
    }
}