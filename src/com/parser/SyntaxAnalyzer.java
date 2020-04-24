package com.parser;

import com.lexical.Token;
import com.parser.rules.*;
import java.util.ArrayList;

public class SyntaxAnalyzer {

    // Variables
    private ArrayList<Token> lexicalOutput;

    // Constructor
    public SyntaxAnalyzer(ArrayList<Token> lexicalOutput) {
        this.lexicalOutput = lexicalOutput;
    }

    /*
     * ================
     * 	  Functions
     * ================
     */

    // The main function to run the process of creating parse tree
    public Program parse(){
            return programRFun();
    }

    // Function of the program rule in cGram
    private Program programRFun(){

        return null;
    }

    // Function of the decl_list rule in cGram
    private Decl_List decl_listRFun(){

        return null;
    }

    // Function of the decl rule in cGram
    private Decl  declRFun(){
        return null;
    }

    // Function of the var_decl rule in cGram
    private Var_decl var_declRFun(){
        return null;
    }

    // Function of the type_spec rule in cGram
    private Type_spec type_specRFun(){
        return null;
    }

    // Function of the fun_decl rule in cGram
    private Fun_decl fun_declRFun(){
        return null;
    }

    // Function of the params rule in cGram
    private Params paramsRFun(){
        return null;
    }

    // Function of the param_list rule in cGram
    private Param_list param_listRFun(){
        return null;
    }

    // Function of the param rule in cGram
    private Param paramRFun(){
        return null;
    }

    // Function of the stmt_list rule in cGram
    private Stmt_list stmt_listRFun(){
        return null;
    }

    // Function of the stmt rule in cGram
    private Stmt stmtRFun(){
        return null;
    }

    // Function of the expr_stmt rule in cGram
    private Expr_stmt expr_stmtRFun(){
        return null;
    }

    // Function of the while_stmt rule in cGram
    private While_stmt while_stmtRFun(){
        return null;
    }

    // Function of the compound_stmt rule in cGram
    private Compound_stmt compound_stmtRFun(){
        return null;
    }

    // Function of the local_decls rule in cGram
    private Local_decls local_declsRFun(){
        return null;
    }

    // Function of the local_decl rule in cGram
    private Local_decl local_declRFun(){
        return null;
    }

    // Function of the if_stmt rule in cGram
    private If_stmt if_stmtRFun(){
        return null;
    }

    // Function of the return_stmt rule in cGram
    private Return_stmt return_stmtRFun(){
        return null;
    }

    // Function of the expr rule in cGram
    private Expr exprRFun(){
        return null;
    }

    // Function of the arg_list rule in cGram
    private Arg_list arg_listRFun(){
        return null;
    }

    // Function of the args rule in cGram
    private Args argsRFun(){
        return null;
    }

    // Function of the op rule in cGram
    private OP opRFun(){
        return null;
    }

}
