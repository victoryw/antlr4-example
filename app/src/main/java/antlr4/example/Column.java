package antlr4.example;

import com.google.common.base.Strings;

import java.util.Objects;

public class Column {
    private final String column;
    private final String table;

    public Column(String column, String table) {
        this.column = column;
        this.table = table;
    }

    public String getColumn() {
        return column;
    }

    public String getTable() {
        return table;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Column column1 = (Column) o;
        return column.equals(column1.column) &&
                table.equals(column1.table);
    }

    @Override
    public int hashCode() {
        return Objects.hash(column, table);
    }
}
