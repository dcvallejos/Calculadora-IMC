package com.example.calculadora;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorWeb {


    static double imc;
    static String estado;
    static boolean permit;
    static int estadoTipo;

    @GetMapping("/calculadora")
    public String calculadora(Model model){
        return "calculadora";
    }

    @PostMapping("/calculadora")
    public String calculadora( 
        @RequestParam(name="peso", required=true, defaultValue="0") double peso,
        @RequestParam(name="altura", required=true, defaultValue="0") double h,
    Model model){


        //Variable "permit" controla la apariencia del form una vez hecho el submit
        model.addAttribute("permit", false);

        if(peso !=0 && h !=0){

            if(h>100){
                h=h/100;
            }

            imc = (double) Math.round(peso / (Math.pow(h, 2)) * 10) / 10;

            selectorIMC();

            
            model.addAttribute("estadoTipo", estadoTipo);
            model.addAttribute("permit", true);
            model.addAttribute("imc", imc);
            model.addAttribute("estado", "Te encuentras en un estado de: " + estado);
        }
        else if(peso == 0 || h ==0){
            model.addAttribute("permit", false);
        }
        return "calculadora";

    }

    private void selectorIMC() {
        if (imc < 16){
            estadoTipo = 0;
            estado= " delgadez extrema. Consulta con tu medico urgente";}
        else if (imc >= 16 && imc < 18.5){
            estadoTipo = 1;
            estado= "delgadez. No te vendria mal comer mejor";}
        else if (imc >= 25 && imc < 30){
            estadoTipo = 3;
            estado= "sobrepeso. Con ejercicio y un poco de dieta estarias genial";}
        else if (imc >= 30 && imc < 35){
            estadoTipo = 4;
            estado= "obesidad moderada. Podes estar llegando a notar pequenos dolores y cansancio, es recomendable ejercicio y que veas a un nutricionista.";}
        else if (imc >= 35 && imc < 40){
            estadoTipo = 5;
            estado= "obesidad severa. Es altamente recomendable asistir a un nutricionista y realizar actividad fisica";}
        else if (imc >= 40){
            estadoTipo = 6;
            estado= "obesidad morbida. Es necesario una urgente atención médica, dado que puede presentar graves complicaciones de salud";}
        else{
            estadoTipo = 2;
            estado= "peso normal. Segui asi!!";}
    }


    
}
