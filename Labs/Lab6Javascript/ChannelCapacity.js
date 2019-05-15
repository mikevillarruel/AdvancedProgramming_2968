"use strict";

function calculateCapacity() {
	
	var bandwith = Number(document.getElementById('bandwith').value);
	var signalPower = Number(document.getElementById('signalPower').value);
	var noise = Number(document.getElementById('noise').value);
	
	document.getElementById('capacity').innerHTML = (bandwith*Math.log(1+signalPower/noise))/Math.log(2);
	
	return false;
	
}

document.getElementById('go').addEventListener('click',calculateCapacity);