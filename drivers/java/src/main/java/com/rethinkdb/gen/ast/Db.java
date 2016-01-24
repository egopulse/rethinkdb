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



public class Db extends ReqlAst {


    public Db(Object arg) {
        this(new Arguments(arg), null);
    }
    public Db(Arguments args){
        this(args, null);
    }
    public Db(Arguments args, OptArgs optargs) {
        super(TermType.DB, args, optargs);
    }

    public Table table(Object expr) {
        Arguments arguments = new Arguments(this);
        arguments.coerceAndAdd(expr);
        return new Table(arguments);
    }
    public TableCreate tableCreate(Object expr) {
        Arguments arguments = new Arguments(this);
        arguments.coerceAndAdd(expr);
        return new TableCreate(arguments);
    }
    public TableDrop tableDrop(Object expr) {
        Arguments arguments = new Arguments(this);
        arguments.coerceAndAdd(expr);
        return new TableDrop(arguments);
    }
    public TableList tableList() {
        Arguments arguments = new Arguments(this);
        return new TableList(arguments);
    }
    public Config config() {
        Arguments arguments = new Arguments(this);
        return new Config(arguments);
    }
    public Wait wait_() {
        Arguments arguments = new Arguments(this);
        return new Wait(arguments);
    }
    public Reconfigure reconfigure() {
        Arguments arguments = new Arguments(this);
        return new Reconfigure(arguments);
    }
    public Rebalance rebalance() {
        Arguments arguments = new Arguments(this);
        return new Rebalance(arguments);
    }
    public Info info() {
        Arguments arguments = new Arguments(this);
        return new Info(arguments);
    }


}
