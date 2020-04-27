package com.parser;

import com.lexical.Token;
import com.parser.rules.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class Parser {

    // Variables
    private Queue<Token> lexicalOutput;
    private ArrayList<String> types, operators;

    // Constructor
    public Parser(Queue<Token> lexicalOutput) {
        this.lexicalOutput = lexicalOutput;
        this.types = new ArrayList<>(Arrays.asList("<VOID>", "<BOOl>", "<INT>", "<FLOAT>"));
        this.operators = new ArrayList<>(Arrays.asList(
                "<OR>", "<AND>", "<EQUAL>", "<NOT_EQUAL>",
                "<GREAT_EQ>","<LESS_EQ>","<LESSTHAN>", "<GREATERTHAN>",
                "<MINUS>", "<PLUS>", "<ASTERICK>", "<DIVIDE>","<MOD>"));
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
        Decl_List decl_list= decl_listRFun();
        if (decl_list == null){
            System.out.println("Syntax Error!!");
            return null;
        }
        return new Program(decl_list);
    }

    // Function of the decl_list rule in cGram
    private Decl_List decl_listRFun(){
        for(Token t : lexicalOutput){
            System.out.println(t.tokenName);
        }
        System.out.println("<------------------------>");
        Decl decl = declRFun();
        if(decl==null)
            return null;
        Decl_List decl_list = decl_listRFun();
        if(decl_list==null)
            return new Decl_List(decl);
        return new Decl_List(decl_list, decl);
    }

    // Function of the decl rule in cGram
    private Decl declRFun(){
        for(Token t : lexicalOutput)
            System.out.println(t.tokenName);
        System.out.println("<------------------------>");
        Var_decl var_decl = var_declRFun();
        if(var_decl!=null)
            return new Decl(var_decl);
        Fun_decl fun_decl = fun_declRFun();
        if(fun_decl!=null)
            return new Decl(fun_decl);
        return null;
    }

    // Function of the var_decl rule in cGram
    private Var_decl var_declRFun(){
        Type_spec type_spec = type_specRFun();
        if(type_spec!=null){
            Token eIDToken = lexicalOutput.peek();
            if(eIDToken.tokenName.equals("<ID>")){
                    lexicalOutput.poll();
                    Token nextToID = lexicalOutput.peek();
                    if(nextToID.tokenName.equals("<SEMICOLON>")){
                        lexicalOutput.poll();
                        return new Var_decl(type_spec, eIDToken, nextToID);
                    }
                    if(nextToID.tokenName.equals("<RIGHT_SQUARE_B>")){
                        lexicalOutput.poll();
                        Token eLeftSquare = lexicalOutput.peek();
                        if(eLeftSquare.tokenName.equals("<LEFT_SQUARE_B>")){
                            lexicalOutput.poll();
                            Token nextToLeftSQ = lexicalOutput.peek();
                            if(nextToLeftSQ.tokenName.equals("<SEMICOLON>")){
                                lexicalOutput.poll();
                                return new Var_decl(type_spec, eIDToken, nextToID, eLeftSquare, nextToLeftSQ);
                            }
                        }
                    }
                }
        }
        return null;
    }

    // Function of the type_spec rule in cGram
    private Type_spec type_specRFun(){
        Token token=lexicalOutput.poll();
        if (token != null && types.indexOf(token.tokenName) != -1)
            return new Type_spec(token);
        return null;
    }

    // Function of the fun_decl rule in cGram
    private Fun_decl fun_declRFun(){
        for(Token t : lexicalOutput){
            System.out.println(t.tokenName);
        }
        System.out.println("@<------------------------>");
        Type_spec type_spec = type_specRFun();
        System.out.println(type_spec == null);
        Token token1 = lexicalOutput.poll(),token2 = lexicalOutput.poll(),token3 = lexicalOutput.poll();
        Params params=paramsRFun();
        Compound_stmt compound_stmt=compound_stmtRFun();
        if (type_spec!=null && params != null && compound_stmt != null && token1.tokenName == "<ID>" &&
                token2.tokenName.equals("<RIGHT_ROUND_B>") && token3.tokenName.equals("<LEFT_ROUND_B>")){
            return new Fun_decl(type_spec, token1, token2, params, token3, compound_stmt);
        }
        return null;
    }

    // Function of the params rule in cGram
    private Params paramsRFun(){
        Param_list param_list = param_listRFun();
        if (param_list != null)
            return new Params(param_list);
        Token token=lexicalOutput.peek();
        if(token == null)
            return  null;
        if (token.tokenName.equals("<VOID>")){
            lexicalOutput.poll();
            return new Params(token);
        }
        return null;
    }

    // Function of the param_list rule in cGram
    private Param_list param_listRFun(){
        Param param=paramRFun();
        if (param != null){
            Token token=lexicalOutput.peek();
            Param_list param_list =param_listRFun();
            if (token.tokenName.equals("<COMMA>")&& param_list != null){
                lexicalOutput.poll();
                return new Param_list(param, param_list, token);
            }
            return new Param_list(param);
        }
        return null;
    }

    // Function of the param rule in cGram
    private Param paramRFun(){
        Type_spec type_spec = type_specRFun();
        Token token1 = lexicalOutput.poll();
        if (type_spec != null && token1.tokenName.equals("<ID>")){
            Token token2 = lexicalOutput.poll();
            Token token3 = lexicalOutput.poll();
            if (token2.tokenName.equals("RIGHT_SQUARE_B") && token3.tokenName.equals("LEFT_SQUARE_B"))
                return new Param(type_spec, token1, token3, token2);
            return new Param(type_spec, token1);
        }
        return null;
    }

    // Function of the stmt_list rule in cGram
    private Stmt_list stmt_listRFun(){
        Stmt stmt = stmtRFun();
        Stmt_list stmt_list = stmt_listRFun();
        if (stmt != null && stmt_list != null)
            return new Stmt_list(stmt,stmt_list);
        return null;
    }

    // Function of the stmt rule in cGram
    private Stmt stmtRFun(){
        Expr_stmt expr_stmt = expr_stmtRFun();
        if (expr_stmt != null )
            return new Stmt(expr_stmt);
        Compound_stmt compound_stmt = compound_stmtRFun();
        if (compound_stmt != null )
            return new Stmt(compound_stmt);
        If_stmt if_stmt = if_stmtRFun();
        if (if_stmt != null )
            return new Stmt(if_stmt);
        While_stmt while_stmt = while_stmtRFun();
        if (while_stmt != null )
            return new Stmt(while_stmt);
        Return_stmt return_stmt = return_stmtRFun();
        if (return_stmt != null)
            return new Stmt(return_stmt);
        Break_stmt break_stmt = break_stmtRFun();
        if (break_stmt != null)
            return new Stmt(break_stmt);
        return null;
    }

    // Function of the expr_stmt rule in cGram
    private Expr_stmt expr_stmtRFun(){
        Expr expr = exprRFun();
        Token token = lexicalOutput.poll();
        if (token.tokenName.equals("<SEMICOLON>")){
            if (expr != null)
                return new Expr_stmt(expr, token);
            return new Expr_stmt(token);
        }
        return null;
    }

    // Function of the while_stmt rule in cGram
    private While_stmt while_stmtRFun(){
        Token token1 = lexicalOutput.poll(),token2=lexicalOutput.poll(),token3=lexicalOutput.poll();
        Expr expr = exprRFun();
        Stmt stmt = stmtRFun();
        if (token1.tokenName.equals("<WHILE>") && token2.tokenName.equals("<RIGHT_ROUND_B>")
                && token3.tokenName.equals("<LEFT_ROUNDED_B>") && expr != null && stmt != null)
            return new While_stmt(token1, token3, token2, expr, stmt);
        return null;
    }

    // Function of the compound_stmt rule in cGram
    private Compound_stmt compound_stmtRFun(){
        Token token1 = lexicalOutput.poll(), token2 = lexicalOutput.poll() ;
        if(token1 == null)
            return  null;
        if (token1.tokenName.equals("<RIGHT_CURLY_B>") && token2.tokenName.equals("<LEFT_CURLY_B>"))
            return new Compound_stmt(token2, token1, local_declsRFun(), stmt_listRFun());
        return null;
    }

    // Function of the local_decls rule in cGram
    private Local_decls local_declsRFun(){
        Local_decl local_decl = local_declRFun();
        if (local_decl != null)
            return new Local_decls(local_decl, local_declsRFun());
        return null;
    }

    // Function of the local_decl rule in cGram
    private Local_decl local_declRFun(){
        Type_spec type_spec = type_specRFun();
        Token token1 =lexicalOutput.peek();
        if (type_spec != null && token1.tokenName.equals("<ID>")){
            lexicalOutput.poll();
            Token token2 = lexicalOutput.peek();
            if (token2.tokenName.equals("<SEMICOLON>"))
                return new Local_decl(type_spec, token1, token2);
            lexicalOutput.poll();
            Token token3 = lexicalOutput.poll() , token4 = lexicalOutput.poll();
            if (token2.tokenName.equals("<RIGHT_SQUARE_B>") && token3.tokenName.equals("<LEFT_SQUARE_B>")
                    && token4.tokenName.equals("<SEMICOLAN>"))
                return new Local_decl(type_spec, token1, token3, token2, token4);
        }
        return null;
    }

    // Function of the if_stmt rule in cGram
    private If_stmt if_stmtRFun(){
        Token token1 = lexicalOutput.poll(), token2 = lexicalOutput.poll(), token3 = lexicalOutput.poll();
        Expr expr = exprRFun();
        Stmt stmt1 = stmtRFun();
        if (token1.tokenName.equals("<IF>") && token2.tokenName.equals("<RIGHT_ROUNDED_B>") && expr != null
                && token3.tokenName.equals("<LEFT_ROUNDED_B>") && stmt1 != null){
            Token token4 = lexicalOutput.peek();
            if (token4.tokenName.equals("<ELSE>")){
                lexicalOutput.poll();
                Stmt stmt2 = stmtRFun();
                if (stmt2 != null)
                    return new If_stmt(token1, token3, token2, token4, expr, stmt1, stmt2);
            }
            else
                return new If_stmt(token1, token3, token2, expr, stmt1);
        }
        return null;
    }

    // Function of the return_stmt rule in cGram
    private Return_stmt return_stmtRFun(){
        Token token1 = lexicalOutput.poll(), token2 = lexicalOutput.poll();
        if (token1.tokenName.equals("<RETURN>") && token2.tokenName.equals("<SEMICOLAN>")){
            Expr expr = exprRFun();
            if (expr != null)
                return new Return_stmt(token1, token2, expr);
            return new Return_stmt(token1, token2);
        }
        return null;
    }

    // Function of the break_stm rule in cGram
    public Break_stmt break_stmtRFun() {
        Token token1 = lexicalOutput.poll() , token2 = lexicalOutput.poll();
        if (token1.tokenName.equals("<BREAK>") && token2.tokenName.equals("<SEMICOLAN>"))
            return new Break_stmt(token1, token2);
        return null;
    }

    // Function of the expr rule in cGram
    private Expr exprRFun(){
        Token token1=lexicalOutput.poll(),token2=lexicalOutput.peek();
        if(token1.tokenName.equals("<ID>") && token2.tokenName.equals("<ASSIGN_OPERATOR>")){
            lexicalOutput.poll();
            Expr expr = exprRFun();
            if (expr!=null)
                return new Expr(token1,token2,expr);
        }
        else if (token1.tokenName.equals("<IDE>") &&token2.tokenName.equals("<RIGHT_SQUARE>")) {
            lexicalOutput.poll();
            Expr expr = exprRFun();
            if (expr!=null) {
                Token token3=lexicalOutput.poll(),token4=lexicalOutput.poll();
                if (token3.tokenName.equals("<LEFT_SQUARE_B>") && token4.tokenName.equals("<ASSIGN_OPERATOR>")) {
                    Expr expr1=exprRFun();
                    if (expr1!=null)
                        return new Expr(token1,token2,expr1,token3,token4,expr1);
                }
            }
        }
        Expr expr = exprRFun();
        if (expr!=null)
        {
            OP op=opRFun();
            Expr expr1 = exprRFun();
            if (expr1!=null&&op!=null)
                return new Expr(expr,op,expr1);
            return null;
        }
        if (token1.tokenName.equals("<PLUS>") ||token1.tokenName.equals("<MINUS>") ||token1.tokenName.equals("<NOT>")) {
            expr = exprRFun();
            if (expr!=null)
                return new Expr(token1,expr);
        }
        else if (token1.tokenName.equals("<RIGHT_ROUNDED_B>")) {
            expr = exprRFun();
            if (expr!=null){
                token2=lexicalOutput.peek();
                assert token2 != null;
                if (token2.tokenName.equals("<LEFT_ROUNDED>"))
                    return new Expr(token1,expr,token2);
            }
        }
        if (token1.tokenName.equals("<ID>")) {
            if (token2.tokenName.equals("<RIGHT_SQUARE_B>")) {
                lexicalOutput.poll();
                expr=exprRFun();
                Token token3=lexicalOutput.peek();
                assert token3 != null;
                if (token3.tokenName.equals("<LEFT_SQUARE_B>")) {
                    lexicalOutput.poll();
                    return new Expr(token1,token2,expr,token3);
                }
            }
            else if (token2.tokenName.equals("<RIGHT_ROUNDED_B>")) {
                lexicalOutput.poll();
                Args args=argsRFun();
                if (args!=null) {
                    Token token3=lexicalOutput.peek();
                    assert token3 != null;
                    if (token3.tokenName.equals("<LEFT_ROUNDED_N>")){
                        lexicalOutput.poll();
                        return new Expr(token1,token2,args,token3);
                    }
                }
            }
            else if (token2.tokenName.equals("<DOT>")) {
                lexicalOutput.poll();
                Token token3=lexicalOutput.peek();
                assert token3 != null;
                if (token3.tokenName.equals("<SIZE_OF>")) {
                    lexicalOutput.poll();
                    return new Expr(token1,token2,token3);
                }
            }
            return new Expr(token1);
        }
        if (token1.equals("<BOOL_LITERAL>") || token1.tokenName.equals("<INTEGRAL_LITERAL>") || token1.tokenName.equals("<FLOAT_LITERAL>"))
            return new Expr(token1);
        if(token1.tokenName.equals("<NEW>")) {
            Type_spec type_spec=type_specRFun();
            if (type_spec!=null) {
                token2=lexicalOutput.peek();
                assert token2 != null;
                if(token2.tokenName.equals("<RIGHT_SQUARE_B>")) {
                    lexicalOutput.poll();
                    expr=exprRFun();
                    if (expr!=null) {
                        Token token3=lexicalOutput.peek();
                        assert token3 != null;
                        if(token3.tokenName.equals("<LEFT_ROUNDED_B>")) {
                            lexicalOutput.poll();
                            return new Expr(token1,type_spec,token2,expr,token3);
                        }
                    }
                }
            }
        }
        return null;
    }

    // Function of the arg_list rule in cGram
    private Arg_list arg_listRFun(){
        Expr expr = exprRFun();
        if (expr != null){
            Token token = lexicalOutput.peek();
            Arg_list arg_list = arg_listRFun();
            if (token.tokenName.equals("<COMMA>") && arg_list != null){
                lexicalOutput.poll();
                return new Arg_list(expr, token, arg_list);
            }
            return new Arg_list(expr);
        }
        return null;
    }

    // Function of the args rule in cGram
    private Args argsRFun(){
        return new Args(arg_listRFun());
    }

    // Function of the op rule in cGram
    private OP opRFun(){
        Token token = lexicalOutput.poll();
        if(operators.indexOf(token.tokenName) != -1)
            return new OP(token);
        return null;
    }

}
