// Autogenerated by metajava.py.
// Do not edit this file directly.
// The template for this file is located at:
// ../../../../../../../../templates/AstSubclass.java

package com.rethinkdb.gen.ast;

import com.rethinkdb.gen.proto.TermType;
import com.rethinkdb.gen.exc.ReqlDriverError;
import com.rethinkdb.model.Arguments;
import com.rethinkdb.model.OptArgs;
import com.rethinkdb.ast.ReqlAst;
import com.querydsl.core.types.Expression;
import static com.egopulse.RethinkDBSerializer.toReqlFunction1;



public class Bracket extends ReqlExpr {


    public Bracket(Object arg) {
        this(new Arguments(arg), null);
    }
    public Bracket(Arguments args){
        this(args, null);
    }
    public Bracket(Arguments args, OptArgs optargs) {
        super(TermType.BRACKET, args, optargs);
    }



}
