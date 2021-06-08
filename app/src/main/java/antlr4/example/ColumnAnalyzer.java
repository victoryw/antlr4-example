package antlr4.example;

import antlr4.sql.base.PlSqlParser;

import java.util.ArrayList;
import java.util.List;

public class ColumnAnalyzer {
    private final List<Column> columns = new ArrayList<>();

    public void record(PlSqlParser.Select_statementContext ctx) {
    }

    public void record(PlSqlParser.Select_list_elementsContext ctx) {
        if(ctx.isEmpty()) {
            return;
        }

        String columnName = getColumnName(ctx);
        String tableName  = getTableName(ctx);

        Column column1 = new Column(columnName, tableName);

        this.columns.add(column1);
    }

    private String getTableName(PlSqlParser.Select_list_elementsContext ctx) {
        if(ctx.tableview_name() != null) {
            return ctx.tableview_name().getText();
        }

        return extractTableFromExpression(ctx.expression());
    }


    private String getColumnName(PlSqlParser.Select_list_elementsContext ctx) {
        if(ctx.ASTERISK() != null) {
            return ctx.ASTERISK().getText();
        }

        return extractColumnNameFromExpression(ctx.expression());
    }

    private String extractTableFromExpression(PlSqlParser.ExpressionContext expression) {
        final String columnName = expression.getText();
        final String[] columnCompose = columnName.split("\\.");
        if(columnCompose.length > 1) {
            return columnCompose[0];
        }
        return "";
    }

    private String extractColumnNameFromExpression(PlSqlParser.ExpressionContext expression) {
        final String columnName = expression.getText();

        final String[] split = columnName.split("\\.");
        if(split.length > 1) {
            return split[1];
        }

        return columnName;
    }

    public List<Column> getColumns() {
        return columns;
    }
}
