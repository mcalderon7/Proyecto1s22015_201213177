function validLogin() {
    alert("Usuario incorrecto!");
}

function adminCorrecto() {
    alert("Administrador creado con éxito!");
}

function choferCorrecto() {
    alert("Chofer creado con éxito!");
}

function claveCorrecto() {
    alert("Estacion Clave creada con éxito!");
}

function generalCorrecto() {
    alert("Estacion General creada con éxito!");
}

function rutaCorrecto() {
    alert("Ruta creada con éxito!");
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