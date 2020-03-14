/*****************
   SPEECH SYSTESIS
******************/

/******************
   Global variables
*******************/
var speech;
var isInitiated = false;
// FINE GLOBAL VARIABLES

/***********************
   INITIATE
   INIZIALIZZA L'ASCOLTO
************************/
function initiate() {
    if(!isInitiated) {
        speech = new SpeechSynthesisUtterance();
        setValues(1, 1, 1);
        isInitiated = true;
        console.info("SpeechSynthesisUtterance inizializzato correttamente");
    } else {
        console.error("SpeechSynthesisUtterance è già stato inizializzato");
    }
	setBlinkTime();
	setEvent();
}

/*****************
   SET EVENT
   SET SPEAK EVENT
******************/
function setEvent(){
	document.getElementById("speak-btn").addEventListener("click", setBlinkTime);
}

/***********************
   READ OUT ALOUD
   LETTURA A VOCE ALTA
 * @param String command
************************/
function readOutLoud(message) {
    if(!isInitiated) initiate();

    // Set the text and voice attributes.
    speech.text = message;
    window.speechSynthesis.speak(speech);
}

/**************************************
   SET VALUES
 * @param volume, qualità e intonazione
***************************************/
function setValues(volume, rate, pitch) {
    speech.volume = volume;
    speech.rate = rate;
    speech.pitch = pitch;
}

// FINE CLASSE