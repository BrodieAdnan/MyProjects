/********************
   SPEECH RECOGNITION
*********************/

/*******************
   INITIALIZE EVENTS
********************/
// If false, the recording will stop after a few seconds of silence.
// When true, the silence period is longer (about 15 seconds),
// allowing us to keep recording even when the user pauses. 
recognition.continuous = true;

// This block is called every time the Speech APi captures a line. 
recognition.onresult = function(event) {
  // event is a SpeechRecognitionEvent object.
  // It holds all the lines we have captured so far. 
  // We only need the current one.
  var current = event.resultIndex;

  // Get a transcript of what was said.
  var transcript = event.results[current][0].transcript;

  // Add the current transcript to the contents of our Note.
  // There is a weird bug on mobile, where everything is repeated twice.
  // There is no official solution so far so we have to handle an edge case.
  var mobileRepeatBug = (current == 1 && transcript == event.results[0][0].transcript);
  if(!mobileRepeatBug) {
      noteContent = transcript;
      document.getElementById("noteTextarea").value = noteContent;
      interpret(noteContent);
  }
};
// FINE INIZIALIZZAZIONE EVENTI

/*************************************
   INDEX OF COMMAND
   CERCA INIZIO E FINE COMANDA ASCOLTO
 * @param String command
 * @return indice di fine comando
**************************************/
function indexOfCommand(command){
    console.log("inizio indexOfCommand("+command+")");
    const command_min = command.toLocaleLowerCase();
    let j;
    for (j = 0; j < commands.length; j++){
        if (commands[j].toLocaleLowerCase().localeCompare(command_min) == 0){
            console.log("fine indexOfCommand("+command+")");
            return j;
        }
    }
    console.log("fine indexOfCommand("+command+")");
    return NOT_FOUND;
}

/******************************
   INTERPRET
   ELABORAZIONE RICHIESTA VIDEO
 * @param String command
*******************************/
function interpret(line) {
    console.log("inizio interpret("+line+")");
    const list = line.split(" ");
    const i = indexOfCommand(list[0]);
    list[0] = "";
    switch (i){
        case Commands.CERCA:
            var str = list.join(" ");
            search(str);
            // displays the player card
            document.getElementById('videoPlayer').style.display = "inline";
            document.getElementById("videoPlayer").scrollIntoView({block: 'end', behavior: 'smooth'});
            break;
        case Commands.NONE:
            console.log("Comando non trovato.");
            break;
    }
    console.log("fine interpret("+line+")");
    document.getElementById("cloudContent").innerHTML = "Sto cercando " + line.substring(6);
}