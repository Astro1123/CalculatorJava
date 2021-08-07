package script;

import java.math.BigDecimal;

public abstract class Token {
    public static final Token EOF = new Token(-1){}; // end of file
    public static final String EOL = "\\n";          // end of line 
    private int lineNumber;

    protected Token(int line) {
        lineNumber = line;
    }
    public int getLineNumber() { return lineNumber; }
    public Type getType() { return Type.NULL; }
    public int getInt() { throw new ScriptException("not number token"); }
    public BigDecimal getReal() { throw new ScriptException("not number token"); }
    public String getText() { return ""; }
}