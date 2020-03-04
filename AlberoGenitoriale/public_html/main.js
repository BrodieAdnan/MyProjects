fusaro = {};

AlberoBin.EMPTY = new AlberoBin(null, null, null);

function AlberoBin (info, sx, dx) { 
	
	if (sx == undefined) {
		sx = AlberoBin.EMPTY;
	}
	if (dx == undefined) {
		dx = AlberoBin.EMPTY;
	}
	
	this.isEmpty = function () {
		return this == AlberoBin.EMPTY;
	}
	
	this.getInfo = function () {
		if (this.isEmpty()) {
			throw "getInfo non valida perchè albero vuoto";
		}
		return info;
	}
	
	this.setSx= function(s){
		if(s.constructor == AlberoBin){
			sx=s;
		} else {throw "exception";}		
	}
	
	this.setDx= function(d){
		if(d.constructor == AlberoBin){
			dx=d;
		} else {throw "exception";}		
	}
	
	this.setInfo= function(i){
		if(i.constructor == AlberoBin){
			info=i;
		} else {throw "exception";}		
	}
	
	this.getSx = function () {
		if (this.isEmpty()) {
			throw "exception";
		}
		return sx;
	}
	
	this.getDx = function () {
		if (this.isEmpty()) {
			throw "exception";
		}
		return dx;
	}
}
 


window.onload = AlberoBin;