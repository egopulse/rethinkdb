// Autogenerated by metajava.py.
// Do not edit this file directly.
// The template for this file is located at:
// ../../../../../../../../templates/ast/Funcall.java

package com.rethinkdb.gen.ast;

import com.rethinkdb.gen.proto.TermType;
import com.rethinkdb.gen.exc.ReqlDriverError;
import com.rethinkdb.model.Arguments;
import com.rethinkdb.model.OptArgs;
import com.rethinkdb.ast.ReqlAst;
import com.querydsl.core.types.Expression;
import static com.egopulse.RethinkDBSerializer.toReqlFunction1;



public class Funcall extends ReqlExpr {


    public Funcall(Object arg) {
        this(new Arguments(arg), null);
    }
    public Funcall(Arguments args){
        this(args, null);
    }
    public Funcall(Arguments args, OptArgs optargs) {
        super(TermType.FUNCALL, args, optargs);
    }


    @Override
    protected Object build()
    {
        /*
          This object should be constructed with arguments first, and the
          function itself as the last parameter.  This makes it easier for
          the places where this object is constructed.  The actual wire
          format is function first, arguments last, so we flip them around
          when building the AST.
        */
        ReqlAst func = args.remove(args.size()-1);
        args.add(0, func);
        return super.build();
    }


}
