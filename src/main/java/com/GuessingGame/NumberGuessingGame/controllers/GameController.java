package com.GuessingGame.NumberGuessingGame.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Random;

@Controller
public class GameController {

    private int numeroSecreto;
    private int tentativas;

    public GameController() {
        // Inicialize o número secreto e o contador de tentativas
        numeroSecreto = new Random().nextInt(100) + 1;
        tentativas = 0;
    }

    @GetMapping("/jogo")
    public String jogo(Model model) {
        model.addAttribute("tentativas", tentativas);
        return "jogo";
    }

    @PostMapping("/adivinhar")
    public String adivinhar(int palpite, Model model) {
        tentativas++;
        if (palpite == numeroSecreto) {
            model.addAttribute("mensagem", "Parabéns! Você acertou em " + tentativas + " tentativas.");
        } else if (palpite < numeroSecreto) {
            model.addAttribute("mensagem", "Tente um número maior.");
        } else {
            model.addAttribute("mensagem", "Tente um número menor.");
        }
        return "jogo";
    }

    @GetMapping("/")
    public String index(Model model) {
        // Inicialize o número secreto e o contador de tentativas aqui
        numeroSecreto = new Random().nextInt(100) + 1;
        tentativas = 0;
        model.addAttribute("tentativas", tentativas);
        return "jogo";
    }
}

