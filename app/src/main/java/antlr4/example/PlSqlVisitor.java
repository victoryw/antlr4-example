package antlr4.example;

import antlr4.sql.base.PlSqlParser;
import antlr4.sql.base.PlSqlParserBaseVisitor;

import java.util.Objects;

public class PlSqlVisitor extends PlSqlParserBaseVisitor<Integer> {

    private final ColumnAnalyzer columnAnalyzer;

    public PlSqlVisitor(ColumnAnalyzer columnAnalyzer) {
        this.columnAnalyzer = columnAnalyzer;
    }

    @Override
    public Integer visitSelect_statement(PlSqlParser.Select_statementContext ctx) {
        super.visitSelect_statement(ctx);
        this.columnAnalyzer.record(ctx);
        return 1;
    }

    @Override
    public Integer visitSelect_list_elements(PlSqlParser.Select_list_elementsContext ctx) {
        super.visitSelect_list_elements(ctx);
        this.columnAnalyzer.record(ctx);
        return 1;
    }
}


