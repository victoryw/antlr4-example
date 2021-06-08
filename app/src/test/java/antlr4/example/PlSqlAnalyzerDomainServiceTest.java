package antlr4.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PlSqlAnalyzerDomainServiceTest {
    @Test
    void should_parser_sql_to_column(){
        //given
        String sql = "SELECT A,C FROM B";
        ColumnAnalyzer analyzer = new ColumnAnalyzer();
        PlSqlVisitor visitor = new PlSqlVisitor(analyzer);
        PlSqlAnalyzerDomainService domainService = new PlSqlAnalyzerDomainService(visitor);

        //when
        domainService.execute(sql);

        //then
        Assertions.assertEquals(2, analyzer.getColumns().size());

        Assertions.assertEquals("A", analyzer.getColumns().get(0).getColumn());
        Assertions.assertEquals("", analyzer.getColumns().get(0).getTable());
        Assertions.assertEquals("C", analyzer.getColumns().get(1).getColumn());
        Assertions.assertEquals("", analyzer.getColumns().get(1).getTable());
    }

    @Test
    void should_parser_sql_to_column2(){
        //given
        String sql = "SELECT B.* FROM B";
        ColumnAnalyzer analyzer = new ColumnAnalyzer();
        PlSqlVisitor visitor = new PlSqlVisitor(analyzer);
        PlSqlAnalyzerDomainService domainService = new PlSqlAnalyzerDomainService(visitor);

        //when
        domainService.execute(sql);

        //then
        Assertions.assertEquals(1, analyzer.getColumns().size());
        Assertions.assertEquals("*", analyzer.getColumns().get(0).getColumn());
        Assertions.assertEquals("B", analyzer.getColumns().get(0).getTable());
    }

    @Test
    void should_parser_sql_to_column3() {
        //given
        String sql = "SELECT B.A FROM B";
        ColumnAnalyzer analyzer = new ColumnAnalyzer();
        PlSqlVisitor visitor = new PlSqlVisitor(analyzer);
        PlSqlAnalyzerDomainService domainService = new PlSqlAnalyzerDomainService(visitor);

        //when
        domainService.execute(sql);

        //then
        Assertions.assertEquals(1, analyzer.getColumns().size());
        Assertions.assertEquals("A", analyzer.getColumns().get(0).getColumn());
        Assertions.assertEquals("B", analyzer.getColumns().get(0).getTable());
    }

}