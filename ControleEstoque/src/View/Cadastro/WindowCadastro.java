package View.Cadastro;

import View.Scene;
import View.Window;
import javafx.scene.control.*;

// Classe pai das classes de cadastro, é abstrata para impedir a criação de uma instância
public abstract class WindowCadastro extends Window implements Scene {

    protected static Button button_ok; // botão será herdado por todas as classes filhas desta classe
}