// Autogenerated by metajava.py.
// Do not edit this file directly.
// The template for this file is located at:
// ../../../../../../../../templates/ast/Iso8601.java

package com.rethinkdb.gen.ast;

import com.rethinkdb.gen.proto.TermType;
import com.rethinkdb.gen.exc.ReqlDriverError;
import com.rethinkdb.model.Arguments;
import com.rethinkdb.model.OptArgs;
import com.rethinkdb.ast.ReqlAst;
import com.querydsl.core.types.Expression;
import static com.egopulse.rethinkdb.RethinkDBSerializer.toReqlFunction1;



public class Iso8601 extends ReqlExpr {


    public Iso8601(Object arg) {
        this(new Arguments(arg), null);
    }
    public Iso8601(Arguments args){
        this(args, null);
    }
    public Iso8601(Arguments args, OptArgs optargs) {
        super(TermType.ISO8601, args, optargs);
    }
public Iso8601 optArg(String optname, Object value) {
    OptArgs newOptargs = OptArgs.fromMap(optargs).with(optname, value);
    return new Iso8601(args, newOptargs);
}


    public static Iso8601 fromString(String iso) {
        return new Iso8601(new Arguments(iso), null);
    }


}
