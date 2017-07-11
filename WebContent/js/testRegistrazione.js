//Questa funzione controlla che tutti i campi della registrazione siano compilati correttamente
var regex  = {
		nome:"^(?=.{3,25}$)^[A-Za-zèùàòé][a-zA-Z'èùàòé ]*$", cognome:"^[A-Za-zèùàòé][a-zA-Z'èùàòé ]*$", 
		citta:"^[A-Za-zèùàòé][a-zA-Z'èùàòé ]*$" ,provincia:"^[A-Za-zèùàòé][a-zA-Z'èùàòé ]*$" ,
		cap:"^[0-9]{5}$" , telefono:"(^[0|3]{1}[0-9]{5,10}$)" , email:"^[a-zA-Z0-9_.-]+@[a-zA-Z_]+?.[a-zA-Z]{2,3}$" ,
		username:"^(?=.{8,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$" ,
		password:"^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[A-Za-z0-9$@$!%*?&]{8,30}"
			}


function validateForm(){
	
	var nome = document.registrazione.nome.value;
	var cognome = document.registrazione.cognome.value;
	var citta = document.registrazione.citta.value;
	var provincia = document.registrazione.activityProvince.value;
	var cap = document.registrazione.cap.value;
	var telefono = document.registrazione.telefono.value;
	var email = document.registrazione.email.value;
	var username = document.registrazione.username.value;
	var password = document.registrazione.password.value;
	var confpassword= document.registrazione.confpassword.value;
	var possiediCampiSportivi = document.registrazione.possiedicampisportivi.value;

	if (isEmpty(nome,"nome")){
		return false;
	}
	if (!isAValidString(nome,regex.nome,"nome")){
		return false;
	}
	if (isEmpty(cognome,"cognome")){
		return false;
	}
	if (!isAValidString(cognome,regex.cognome,"cognome")){
		return false;
	}
	if (isEmpty(citta,"citta")){
		return false;
	}
	if (!isAValidString(citta,regex.citta,"citta")){
		return false;
	}
	if (isEmpty(provincia,"provincia")){
		return false;
	}
	if (!isAValidString(provincia,regex.provincia,"provincia")){
		return false;
	}
	if (isEmpty(cap,"cap")){
		return false;
	}
	if (!isAValidString(cap,regex.cap,"cap")){
		return false;
	}
	if (isEmpty(telefono,"telefono")){
		return false;
	}
	if (!isAValidString(telefono,regex.telefono,"telefono")){
		return false;
	}
	if (isEmpty(email,"email")){
		return false;
	}
	if (!isAValidString(email,regex.email,"email")){
		return false;
	}
	if (isEmpty(username,"username")){
		return false;
	}
	if (!isAValidString(username,regex.usurname,"username")){
		return false;
	}
	if (isEmpty(password,"password")){
		return false;
	}
	if (!isAValidString(password,regex.password,"password")){
		return false;
	}
	if (isEmpty(confpassword,"conferma password")){
		return false;
	}
	if((password.localeCompare(confpassword))!= 0){
		alert("Password e conferma password non corrispondono");
		return false;
	}
		if(document.getElementById("si").checked==false && document.getElementById("no").checked==false ){
			scelta = false;
		}
		else{
			scelta=true;
		}
		if(scelta == false){
			alert("Errore: Per favore seleziona si se possiedi un campo e no altrimenti!");
			return false;
		}
		
		return true;
}


function isEmpty(aString,nomeCampo){
	if (aString == null || aString == "" || aString.trim() == "") 
	{
        alert("Errore: Campo "+nomeCampo+" vuoto!");
        return true;
    }
	return false;

}

function isAValidString(aString, aRegex, nomeCampo){ 
	if(!aString.match(aRegex)){
		alert("Errore: "+nomeCampo+" non valido!");
		return false;
	}
	return true;
}