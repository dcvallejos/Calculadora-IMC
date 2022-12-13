"use strict";

var imc = parseFloat(document.getElementById("imc").innerHTML);
var h = document.getElementById("altura");
var estadoTipo = parseFloat(document.getElementById("estadoTipo").innerHTML);

function validateForm() {
  var Strpeso = document.getElementById("peso").value;
  var Straltura = document.getElementById("altura").value;
  var peso = Strpeso.replace(",", '.');
  var altura = Straltura.replace(",", '.');
  document.getElementById("peso").value = peso;
  document.getElementById("altura").value = altura;
  return true;
}

function changeBackgroundColor(color) {
  var elements = document.getElementsByClassName("resultados");

  for (var i = 0; i < elements.length; i++) {
    elements[i].style.background = color;
  }
}

switch (estadoTipo) {
  case 0:
    {
      changeBackgroundColor("red");
      break;
    }

  case 1:
    {
      changeBackgroundColor("orange");
      break;
    }

  case 2:
    {
      changeBackgroundColor("green");
      break;
    }

  case 3:
    {
      changeBackgroundColor("olive");
      break;
    }

  case 4:
    {
      changeBackgroundColor("orange");
      break;
    }

  case 5:
    {
      changeBackgroundColor("maroon");
      break;
    }

  case 6:
    {
      changeBackgroundColor("red");
      break;
    }
}