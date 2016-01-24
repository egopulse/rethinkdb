<%page args="term_name, classname, superclass, all_terms" />
package com.rethinkdb.gen.ast;

import com.rethinkdb.gen.proto.TermType;
import com.rethinkdb.gen.exc.ReqlDriverError;
import com.rethinkdb.model.Arguments;
import com.rethinkdb.model.OptArgs;
import com.rethinkdb.ast.ReqlAst;
import com.querydsl.core.types.Expression;
import static com.egopulse.RethinkDBSerializer.toReqlFunction1;

<%block name="add_imports" />

public class ${classname} extends ${superclass} {
<%block name="member_vars" />
<%block name="constructors">
    %if term_name is not None:
    public ${classname}(Object arg) {
        this(new Arguments(arg), null);
    }
    public ${classname}(Arguments args){
        this(args, null);
    }
    public ${classname}(Arguments args, OptArgs optargs) {
        super(TermType.${term_name}, args, optargs);
    }
    %else:
    protected ${classname}(TermType termType, Arguments args, OptArgs optargs){
        super(termType, args, optargs);
    }
    %endif
</%block>\
<%block name="static_factories"></%block>\
<%block name="optArgs">\
% if optargs:
public ${classname} optArg(String optname, Object value) {
    OptArgs newOptargs = OptArgs.fromMap(optargs).with(optname, value);
    return new ${classname}(args, newOptargs);
}
% endif
</%block>
<%block name="special_methods" />\
% for term, info in all_terms.items():
  % if classname in info.get('include_in'):
    % for methodname in info['methodnames']:
      % for signature in info['signatures']:
        % if signature['first_arg'] == classname:
    public ${info['classname']} ${methodname}(${
            ', '.join("%s %s" % (arg['type'], arg['var'])
                      for arg in signature['args'][1:])}) {
        Arguments arguments = new Arguments(this);
          %for arg in signature['args'][1:]:
            %if arg['type'].endswith('...'):
        arguments.coerceAndAddAll(${arg['var']});
            %else:
        arguments.coerceAndAdd(${arg['var']});
            %endif
          %endfor
        return new ${info['classname']}(arguments);
    }
        % endif
      % endfor
    % endfor
  % endif
% endfor

% for term, info in all_terms.items():
  % if classname in info.get('include_in'):
    % for methodname in info['methodnames']:
      % for signature in info['signatures']:
        % if signature['first_arg'] == classname:
          % if 'ReqlFunction1' in [arg['type'] for arg in signature['args'][1:]]:
    public ${info['classname']} ${methodname}(${
            ', '.join("%s %s" % ('Expression' if arg['type'] == 'ReqlFunction1' else arg['type'], arg['var']) for arg in signature['args'][1:])}) {
        return ${methodname}(${', '.join((("toReqlFunction1(%s)" if (arg['type'] == 'ReqlFunction1') else "%s") % arg['var']) for arg in signature['args'][1:])});
    }
          % endif
        % endif
      % endfor
    % endfor
  % endif
% endfor

}
