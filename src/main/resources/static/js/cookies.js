// Função para criar um cookie com validade de 3 minutos
function setCookie(name, value, maxAgeSeconds) {
    document.cookie = `${name}=${encodeURIComponent(value)}; max-age=${maxAgeSeconds}; path=/`;
}

// Função para obter todos os cookies como um objeto
function getAllCookies() {
//    const cookies = {};
//    document.cookie.split(';').forEach(cookie => {
//        const [name, value] = cookie.split('=').map(c => c.trim());
//        if (name && value) {
//            cookies[name] = decodeURIComponent(value);
//        }
//    });
//    return cookies;
    const cookies = {};
    document.cookie.split(';').forEach(cookie => {
        const [name, value] = cookie.split('=').map(c => c.trim());
        if (name && value) {
            cookies[name] = decodeURIComponent(value);
        }
    });
    return cookies;
}

// Evento para salvar cada palavra como um cookie
document.addEventListener('DOMContentLoaded', function () {
    const addButton = document.getElementById('addButton');
    const inputValue = document.getElementById('inputValue');

    if (addButton) {
        addButton.addEventListener('click', function () {
            if (inputValue && inputValue.value) {
                const uniqueKey = `word_${Date.now()}`; // Gera um nome único para cada cookie
                setCookie(uniqueKey, inputValue.value, 3 * 60); // Salva com 3 minutos de validade
                alert('Palavra adicionada ao cookie!');
                inputValue.value = ''; // Limpa o campo de entrada
            } else {
                alert('Por favor, insira uma palavra.');
            }
        });
    }
});

document.addEventListener('DOMContentLoaded', function () {
//    const cookieDisplay = document.getElementById('cookieDisplay');
//    const cookies = getAllCookies();
//
//    // Filtra os cookies que começam com "word_"
//    const words = Object.entries(cookies)
//        .filter(([key, _]) => key.startsWith('word_'))
//        .map(([_, value]) => value);
//
//    if (words.length > 0) {
//        cookieDisplay.value = words.join('\n'); // Exibe as palavras no textarea
//    } else {
//        cookieDisplay.value = 'Nenhuma palavra encontrada nos cookies.';
//    }
const cookieDisplay = document.getElementById('cookieDisplay');

    if (cookieDisplay) { // Garante que o textarea existe no DOM
        const cookies = getAllCookies();

        // Filtra os cookies que começam com "word_"
        const words = Object.entries(cookies)
            .filter(([key, _]) => key.startsWith('word_'))
            .map(([_, value]) => value);

        // Atualiza o textarea com as palavras ou exibe uma mensagem padrão
        cookieDisplay.value = words.length > 0
            ? words.join('\n')
            : 'Nenhuma palavra encontrada nos cookies.';
    } else {
        console.warn('Elemento com ID "cookieDisplay" não encontrado.');
    }
});