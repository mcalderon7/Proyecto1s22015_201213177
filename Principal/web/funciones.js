function validLogin() {
    alert("Usuario incorrecto!");
}

function adminCorrecto() {
    alert("Usuario creado con éxito!");
}

function redirectCorrect() {
    document.forms[0].action = "crear_administrador.jsp";
    document.forms[0].method = "post";
    document.forms[0].submit();   
}

function redirectError() {
    document.forms[0].action = "index.jsp";
    document.forms[0].method = "post";
    document.forms[0].submit();
}