package com.parser.rules;

import com.lexical.Token;
import com.parser.Node;

public class Expr implements Node{
    
    Token ident,left_bracket,right_bracket,op,si;
    Expr expr1,expr2;
    OP operation;
    Args args;
    Type_spec type_spec;
    Expr_Dash exprDash1, exprDash2;
    
    public Expr(Token id, Token op, Expr expr) {
        this.expr1 = expr;
        this.ident = id;
        this.op = op;
    }
    
    public Expr(Token id,Token rb, Expr expr1, Token lb,Token op,Expr expr2){
        this.ident = id;
        this.right_bracket = rb;
        this.expr1 = expr1;
        this.left_bracket = lb;
        this.op=op;
        this.expr2 = expr2;
    }
    
    public Expr( Expr_Dash expr1, OP operation,Expr_Dash expr2){
        this.exprDash1=expr1;
        this.operation = operation;
        this.exprDash2 = expr2;
    }

    public Expr(Token op, Expr expr) {
        this.expr1 = expr;
        this.op = op;
    }

    public Expr(Token rb, Expr expr, Token lb) {
        this.right_bracket = rb;
        this.expr1 = expr;
        this.left_bracket = lb;
    }
    
    public Expr(Token id){this.ident = id;}

    public Expr(Token id, Token rb, Expr expr, Token lb) {
        this.ident = id;
        this.right_bracket = rb;
        this.expr1 = expr;
        this.left_bracket = lb;
    }
    
    public Expr(Token id, Token rb, Args args, Token lb) {
        this.ident = id;
        this.right_bracket = rb;
        this.args = args;
        this.left_bracket = lb;
    }
    
    public Expr(Token id, Token op, Token si) {
        this.ident = id;
        this.op = op;
        this.si = si;
    }
    
    public Expr(Token op,Type_spec ts,Token rb, Expr expr, Token lb){
        this.op = op;
        this.type_spec=ts;
        this.right_bracket = rb;
        this.expr1 = expr;
        this.left_bracket=lb;
    }
    
    @Override
    public void printNode() {
        if (ident!= null && op != null && expr1 !=null && expr2 == null){
            System.out.println("Expr: "+ident.value+" + "+op.value+" + Expr");
            expr1.printNode();
        }
        else if (ident!= null && op != null && expr1 !=null && expr2 != null && left_bracket != null && right_bracket != null){
            System.out.println("Expr: "+ident.value+" + "+right_bracket.value+" + Expr "+left_bracket.value+" + "+op.value+" + Expr");
            expr1.printNode();
            expr2.printNode();
        }
        else if (expr1 != null && expr2 != null && operation !=null){
            System.out.println("Expr: Expr + OP + Expr");
            expr1.printNode();
            expr2.printNode();
        }
        else if (expr1 != null && op != null){
            System.out.println("Expr: "+op.value+" + Expr");
            expr1.printNode();
        }
        else if (left_bracket != null && right_bracket != null && expr1 !=null && ident == null){
            System.out.println("Expr: "+right_bracket.value+" + Expr + "+left_bracket.value);
            expr1.printNode();
        }
        else if (ident != null && right_bracket != null && left_bracket != null && expr1 != null){
            System.out.println("Expr: "+ident.value+" + "+left_bracket.value+" + Expr + "+right_bracket.value);
            expr1.printNode();
        }
        else if (ident != null && right_bracket != null && left_bracket != null && args != null){
            System.out.println("Expr: "+ident.value+" + "+left_bracket.value+" + Args + "+right_bracket.value);
            args.printNode();
        }
        else if (ident != null && op != null && si != null){
            System.out.println("Expr: "+ident.value+" + "+op.value+" + "+si.value);
        }
        else if (ident != null && op != null && right_bracket != null && left_bracket != null && expr1 !=null && type_spec != null){
            System.out.println("Expr: "+ident.value+" + Type_spec + "+ left_bracket.value +" + Expr "+right_bracket.value );
            type_spec.printNode();
            expr1.printNode();
        }
        else if(ident != null){
            System.out.println("Expr: "+ident.value); 
        }
        else
            System.out.println("A7A");
    }
}
