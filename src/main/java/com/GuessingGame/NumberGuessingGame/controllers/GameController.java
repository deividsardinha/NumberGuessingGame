package com.GuessingGame.NumberGuessingGame.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Random;

@Controller
public class GameController {

    private int secretNumber;
    private int attempts;

    public GameController() {
        // Initialize the secret number and the attempts counter
        secretNumber = new Random().nextInt(100) + 1;
        attempts = 0;
    }

    @GetMapping("/game")
    public String game(Model model) {
        model.addAttribute("attempts", attempts);
        return "game";
    }

    @PostMapping("/guess")
    public String guess(int guess, Model model) {
        attempts++;
        if (guess == secretNumber) {
            model.addAttribute("message", "Parabéns! Você acertou em " + attempts + " tentativas.");
        } else if (guess < secretNumber) {
            model.addAttribute("message", "Tente um número maior.");
        } else {
            model.addAttribute("message", "Tente um número menor.");
        }
        return "game";
    }
}
