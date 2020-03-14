/********
   CANVAS
*********/

/******************
   GLOBAL VARIABLES
*******************/
var canvas;
var context;
var images = {};
var totalResources = 9;
var numResourcesLoaded = 0;
var fps = 40;
var charX = 240;
var charY = 150;
var breathInc = 0.2;
var breathDir = 1;
var breathAmt = 0;
var breathMax = 2;
var breathInterval = setInterval(updateBreath, 1000 / fps);
var maxEyeHeight = 14;
var curEyeHeight = maxEyeHeight;
var eyeOpenTime = 0;
var timeBtwBlinks = 1000000;
var blinkUpdateTime = 300;
var blinkTimer = setInterval(updateBlink, blinkUpdateTime);
var fpsInterval = setInterval(updateFPS, 1000);
var numFramesDrawn = 0;
var curFPS = 0;
var jumping = false;
var bt = true; // blink time: true = sta parlando, false = non parla
// FINE GLOBAL VARIABLES

/************
   UPDATE FPS
*************/
function updateFPS() {
    curFPS = numFramesDrawn;
    numFramesDrawn = 0;
}

/**************************
   SET BLINK TIME
   DEFINISCE QUANDO PARLARE
***************************/
function setBlinkTime() {
    if(bt) {
        timeBtwBlinks = 0;
    } else {
        timeBtwBlinks = 1000000;
    }
    bt = !bt;
}

/**********************************************
   PREPARE CANVAS
 * @param canvasDiv - elemento in cui inserire
 * @param width, heigth - dimensioni canvas
***********************************************/
function prepareCanvas(canvasDiv, canvasWidth, canvasHeight) {
    canvas = document.createElement('canvas');
    canvas.setAttribute('width', canvasWidth);
    canvas.setAttribute('height', canvasHeight);
    canvas.setAttribute('id', 'canvas');
    canvasDiv.appendChild(canvas);

    if (typeof G_vmlCanvasManager != 'undefined') {
        canvas = G_vmlCanvasManager.initElement(canvas);
    }
    context = canvas.getContext("2d"); // Grab the 2d canvas context

    canvas.width = canvas.width; // clears the canvas

    loadImage("leftArm");
    loadImage("legs");
    loadImage("torso");
    loadImage("rightArm");
    loadImage("head");
    loadImage("hair");
    loadImage("leftArm-jump");
    loadImage("legs-jump");
    loadImage("rightArm-jump");
}

/********************************
   LOAD IMAGE
 * @param nome file da inserire
********************************/
function loadImage(name) {
    images[name] = new Image();
    images[name].onload = function () {
        resourceLoaded();
    }
    images[name].src = "./images/canvas/" + name + ".png";
}

/*****************
   RESOURCE LOADED
******************/
function resourceLoaded() {
    numResourcesLoaded += 1;
    if (numResourcesLoaded === totalResources) {
        setInterval(redraw, 1000 / fps);
    }
}

/******************************************
   REDRAW
   RI-DISEGNO CANVAS CON FREQUENZA 1000/FPS
*******************************************/
function redraw() {
    var x = charX;
    var y = charY;
    var jumpHeight = 45;

    canvas.width = canvas.width; // clears the canvas

    // Draw shadow
    if (jumping) {
        drawEllipse(x + 35, y + 29, 100 - breathAmt, 4);
    } else {
        drawEllipse(x + 30, y + 29, 160 - breathAmt, 6);
    }

    if (jumping) {
        y -= jumpHeight;
    }

    if (jumping) {
        context.drawImage(images["leftArm-jump"], x - 35, y - 42 - breathAmt);
    } else {
        context.drawImage(images["leftArm"], x - 30, y - 42 - breathAmt);
	}

    if (jumping) {
        context.drawImage(images["legs-jump"], x - 25, y - 6);
    } else {
        context.drawImage(images["legs"], x - 18, y);
    }

    context.drawImage(images["torso"], x + 7, y - 50);
    context.drawImage(images["head"], x - 10, y - 125 - breathAmt);
    context.drawImage(images["hair"], x - 13, y - 138 - breathAmt);

    if (jumping) {
        context.drawImage(images["rightArm-jump"], x + 42, y - 42 - breathAmt);
    } else {
        context.drawImage(images["rightArm"], x + 47, y - 42 - breathAmt);
    }

    drawEllipse(x + 15, y - 68, 8, 13); // Left Eye
    drawEllipse(x + 25, y - 68, 8, 13); // Right Eye
	if(!bt){
		drawEllipse(x + 20, y - 45 - breathAmt, 18, curEyeHeight); // opened mouth
	} else {
		drawEllipse(x + 20, y - 45 - breathAmt, 18, 6); // closed mouth
	}
}

/************************************
   DRAW ELLIPSE
 * @param coordinate e misure figura
*************************************/
function drawEllipse(centerX, centerY, width, height) {
    context.beginPath();

    context.moveTo(centerX, centerY - height / 2);

    context.bezierCurveTo(
        centerX + width / 2, centerY - height / 2,
        centerX + width / 2, centerY + height / 2,
        centerX, centerY + height / 2);

    context.bezierCurveTo(
        centerX - width / 2, centerY + height / 2,
        centerX - width / 2, centerY - height / 2,
        centerX, centerY - height / 2);

    context.fillStyle = "black";
    context.fill();
    context.closePath();
}

/**************************************
   UPDATE BREATH
   ALTERNA INSPIRAZIONE CON ESPIRAZIONE
***************************************/
function updateBreath() {
    if (breathDir === 1) {  // breath in
        breathAmt -= breathInc;
        if (breathAmt < -breathMax) {
            breathDir = -1;
        }
    } else {  // breath out
        breathAmt += breathInc;
        if (breathAmt > breathMax) {
            breathDir = 1;
        }
    }
}

/**************
   UPDATE BLINK
***************/
function updateBlink() {
    eyeOpenTime += blinkUpdateTime;
    if (eyeOpenTime >= timeBtwBlinks) {
        blink();
    }
}

/*************************************
   BLINK
   DEFINISCE IL TEMPO DI BATTITO OCCHI
**************************************/
function blink() {
    curEyeHeight -= 1;
    if (curEyeHeight <= 0) {
        eyeOpenTime = 0;
        curEyeHeight = maxEyeHeight;
    } else {
        setTimeout(blink, 10);
    }
}

/*****************************
   JUMP
   DEFINISCE IL TEMPO DI SALTO
******************************/
function jump() {
    if (!jumping) {
        jumping = true;
        setTimeout(land, 500);
    }
}

/******
   LAND
*******/
function land() {
    jumping = false;
}

// FINE CLASSE