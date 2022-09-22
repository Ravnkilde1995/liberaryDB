package Niveau2_logic;

import Niveau3_persistens.Dialog;

import java.util.Scanner;

public class Engelsk extends Dialog {
    @Override
    public String hi() {
        return "Hi and welcome !";
    }

    @Override
    public String changeLanguage() {
        return "do you want to change language ?";
    }

    @Override
    public String selectLanguage() {
        return "select dk/eng/fi/deu";
    }



}
