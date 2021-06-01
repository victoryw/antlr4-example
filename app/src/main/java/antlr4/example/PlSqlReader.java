package antlr4.example;

import antlr4.sql.base.PlSqlParser;
import antlr4.sql.base.PlSqlParserBaseVisitor;

public class PlSqlReader extends PlSqlParserBaseVisitor<Integer> {
    @Override
    public Integer visitSelect_statement(PlSqlParser.Select_statementContext ctx) {

        return 1;
    }

}

