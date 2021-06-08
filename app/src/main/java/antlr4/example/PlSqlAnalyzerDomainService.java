package antlr4.example;

import antlr4.sql.base.PlSqlLexer;
import antlr4.sql.base.PlSqlParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class PlSqlAnalyzerDomainService {
    private final PlSqlVisitor PlSqlVisitor;

    public PlSqlAnalyzerDomainService(PlSqlVisitor plSqlVisitor) {

        this.PlSqlVisitor = plSqlVisitor;
    }

    public void execute(String sql) {
        CharStream cs = CharStreams.fromString(sql);
        PlSqlLexer lexer = new PlSqlLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PlSqlParser parser = new PlSqlParser(tokens);
        parser.sql_statement().accept(this.PlSqlVisitor);
    }
}
