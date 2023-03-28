package com.formacion.core.util;

public class MessageConstants {

    public static final String IDENTIFICADOR_API = "hesbst-training";
    public static final String ERROR_MSG = "Ops! Something went wrong: Module: {} | Method: {} | Request: {} | Status: {} | Message: {}";
    public static final String SUCCES = "Consulta satisfactòria.";
    public static final String ILLEGAL_ARGUMENT = "Paràmetres de consulta incorrectes.";
    public static final String UNAUTHORIZED = "No autoritzat.";
    public static final String FORBIDDEN = "Accés no permès.";
    public static final String ENTITY_NOT_FOUND = "No s'han trobat l'entitat.";
    public static final String UPDATE_ENTITY_OTHER_USER = "No s'ha pogut actualitzar perquè altre usuari ha modificat el registre.";
    public static final String COULD_NOT_EXECUTE_STATEMENT = "Hi ha hagut un problema en inserir/modificar/esborrar les dades en la base de dades";

    public MessageConstants() {
    }
}
