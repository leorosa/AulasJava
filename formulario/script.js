const formulario = document.getElementById("formLogin");
const email = document.getElementById("email");
const senha = document.getElementById("senha");
const mensagem = document.getElementById("mensagem");

formulario.addEventListener("submit", function(evento) {
    evento.preventDefault();

    if (email.value === "") {
    mensagem.textContent = "O e-mail é obrigatório";
    email.focus();
    } else if (!validarEmail(email.value)) {
    mensagem.textContent = "verifique o e-mail informado";
    email.focus();
    } else if (senha.value.length < 6) {
    mensagem.textContent = "A senha deve ter pelo menos 6 caracteres";
    senha.focus();
    } else {
    mensagem.textContent = "Login realizado com sucesso!";
    }
});

function validarEmail(email) {
    const padrao = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return padrao.test(email);
}