package Niveau2_logic;

import Niveau3_persistens.Dialog;

public class Dansk extends Dialog
{
    @Override
    public String hi() {
        return "Hej og velkommen !";
    }

    @Override
    public String changeLanguage() {
        return "vil du skifte sprog skift sprog";
    }

    @Override
    public String selectLanguage() {
        return "angiv dk/eng/fi/deu";
    }
}
