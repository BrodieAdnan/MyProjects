/******
   MAIN
*******/

/******************
   Global variables
*******************/
commands = ["cerca"];
Commands = {
    CERCA: 0,
    NONE: -1
};
NOT_FOUND = -1; // index not found

var noteTextarea = document.getElementById("noteTextarea");
var noteContent = '';
var isRecording = false; // maybe the speech recognition api already has this

// try to initialize speech recognition
try {
    var SpeechRecognition = window.SpeechRecognition || window.webkitSpeechRecognition;
    var recognition = new SpeechRecognition();
    recognition.lang = 'it-IT';
} catch(e) {
    console.error(e);
    $('.no-browser-support').show();
    $('.app').hide();
}

// bottoni che cambiano immagine del contenuto
var state = [["play.svg", "pause.svg"], ["leggi.svg", "smettiDiLeggere.svg"], ["login.svg", "loged-in.svg"]];
var boolSt = [false, false, false];
// FINE GLOBAL VARIABLES

// ONLOAD
window.onload = function () {
    initializeEvents();
    handleClientLoad();
};

// ONSCROLL
window.onscroll = function () {
    scrollFunction()
};

/**********************
   APP BUTTON AND INPUT
***********************/
/*******************
   INITIALIZE EVENTS
********************/
function initializeEvents() {
	// panel slide-down nel menu 'About'
    var acc = document.getElementsByClassName("accordion");
    var i;
    for (i = 0; i < acc.length; i++) {
        acc[i].addEventListener("click", function () {
            this.classList.toggle("active");
            var panel = this.nextElementSibling;
            if (panel.style.maxHeight) {
                panel.style.maxHeight = null;
            } else {
                panel.style.maxHeight = panel.scrollHeight + "px";
            }
        });
    }
	
	// canvas
    prepareCanvas(document.getElementById("canvasDiv"), 500, 500);
    document.getElementById("canvasDiv").onmousedown = function () {
        jump();
    };
	
	// star recording button
    document.getElementById('start-record-btn').onclick = function(e) {
        if(!isRecording) {
            if (noteContent.length) {
                noteContent += ' ';
            }
            recognition.start();
            isRecording = true;
        } else {
            recognition.stop();
            isRecording = false;
        }
    };

	// reset recording button
    document.getElementById('reset-btn').onclick = function(e) {
        recognition.stop();
        player.stopVideo();
        document.getElementById("noteTextarea").value = "";
        document.getElementById('videoPlayer').style.display = "none";
    };
	
	// speak aloud button
    document.getElementById('speak-btn').onclick = function(e) {
        recognition.stop();
        readOutLoud(noteContent);
    };

	// text area input
     document.getElementById("noteTextarea").oninput = function () {
        noteContent = noteTextarea.value;
    };

}

/************************
   CLOSE VP
   CHIUDE IL VIDEO PLAYER
*************************/
function closeVP(){
    document.getElementById('videoPlayer').style.display = "none";
    document.getElementById("noteTextarea").value = "";
    document.getElementById("navbar").scrollIntoView({block: 'end', behavior: 'smooth'});
	player.stopVideo();
}

/************************
   SCROLL CLICK
   RESIZE NAVBAR ON CLICK
*************************/
function scrollClick() {
    document.getElementById("navbar").style.padding = "0px 0px";
    document.getElementById("logo").style.fontSize = "20px";
}

/*****************
   SCROLL FUNCTION
   RESIZE NAVBAR
******************/
function scrollFunction() {
    if (document.body.scrollTop > 80 || document.documentElement.scrollTop > 80) {
        document.getElementById("navbar-center").innerHTML = "IFIYT";
        document.getElementById("navbar").style.padding = "0px 0px";
    } else {
        document.getElementById("navbar-center").innerHTML = "I Fix It For YouTube";
        document.getElementById("navbar").style.padding = "30px 0px";
    }
}

/**********************************************************
   BUTTON TEMP SWITCHER
   CAMBIA IMMAGINE DEL BOTTONE FINCHè SI LEGGE AD ALTA VOCE
 * @param path immagine
***********************************************************/
function buttonTempSwitcher(rel){
    document.getElementById("secondo").src = rel + "smettiDiLeggere.svg";
    console.log("prima img");
    setTimeout(function(){
        console.log("init");
        document.getElementById("secondo").src = rel + "leggi.svg";
        setBlinkTime();
        console.log("seconda img");
    }, 1500);
}

/*******************************************************************
   BUTTON SWITCHER
   CAMBIA IMMAGINE DEL BOTTONE FINO A NUOVO CLICK
 * @param id immagine corrente, numero bottone, path nuova immagine
********************************************************************/
function buttonSwitcher(id, pos, rel) {
    var x = document.getElementById(id);
    if (!boolSt[pos]) {
        x.src = rel + state[pos][1];
        boolSt[pos] = true;
    } else {
        x.src = rel + state[pos][0];
        boolSt[pos] = false;
    }
}

/****************
   YOUTUBE IFRAME
*****************/
var tag = document.createElement('script');
tag.src = "https://www.youtube.com/iframe_api";
var firstScriptTag = document.getElementsByTagName('script')[0];
firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);
var player;

/******************************************
   LOADS THE iFRAME WITH THE SELECTED VIDEO
 * @param q video id
 ******************************************/
function onYouTubeIframeAPIReady() {
    player = new YT.Player('iframe_area', {
        height: '390',
        width: '640'
    });
}

/****************************
   AUTHENTICATION & API CLASS
*****************************/
var CLIENT_ID = '548474516755-p035k1hs3nji28ocs7udlfmkqcqovtvf.apps.googleusercontent.com';
var SCOPES = 'https://www.googleapis.com/auth/youtube';
var API_KEY = 'AIzaSyBBGz-MQudU6P6EBfepWAYABVO1qTrUYZE';
var GoogleAuth;

/********************
   CLIENT HANDLE LOAD
   LOG IN
*********************/
function handleClientLoad() {
    gapi.load('client:auth2', initClient);
}

/*************
   INIT CLIENT
   LOG IN
**************/
function initClient() {
    var discoveryUrl = 'https://www.googleapis.com/discovery/v1/apis/youtube/v3/rest';

    gapi.client.init({
        'apiKey': API_KEY,
        'discoveryDocs': [discoveryUrl],
        'clientId': CLIENT_ID,
        'scope': SCOPES
    }).then(function () {
        GoogleAuth = gapi.auth2.getAuthInstance();
        GoogleAuth.isSignedIn.listen(updateSigninStatus);

        setSigninStatus();

        document.getElementById('signInOutBtn').onclick = handleAuthClick();
    }, function (error) {
        window.alert("Si sono verificati degli errori");
        console.error(error);
    });
}

/*****************************
   HANDLE AUTHENTICATION CLICK
 *****************************/
function handleAuthClick() {
    if (GoogleAuth.isSignedIn.get()) {
        GoogleAuth.signOut();
    } else {
        GoogleAuth.signIn();
    }
}

/*************************
   REMOVE ACCESS
   RIMUOVE ACCESSO ACCOUNT
 *************************/
function revokeAccess() {
    GoogleAuth.disconnect();
}

/************************
   SET SIGNIN STATUS
   LOGED IN STATUS SHOWED
 * @param state
 ************************/
function setSigninStatus(isSignedIn) {
    var user = GoogleAuth.currentUser.get();
    var isAuthorized = user.hasGrantedScopes(SCOPES);
    if (isAuthorized) {
        console.log("Authorized");
    } else {
        console.log("Not authorized");
    }
}

/***********************
   UPDATE SIGNING STATUS
 * @param state
 ***********************/
function updateSigninStatus(isSignedIn) {
    setSigninStatus();
}

/********
   SEARCH
*********/
/****************************
   SEARCH
   CERCA VIDEO DALLA KEYBOARD
 * @param q keyword
 ****************************/
function search(q) {
    var request = gapi.client.youtube.search.list({
        q: q,
        maxResults: 1,
        part: 'snippet'
    });

    request.execute(function(response) {
        var str = JSON.stringify(response.result);
        updateIFrame(str);
    });
}

/*************************************************
   UPDATE iFRAME
   RETURNS THE VIDEO ID FROM THE SEARCH RESPONSE
 * @param response the JSON response from youtube
 *************************************************/
function updateIFrame(response) {
    var obj = JSON.parse(response);
    player.loadVideoById(obj.items[0].id.videoId);
}

// FINE CLASSE