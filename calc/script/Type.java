package calc.script;

public enum Type {

    NULL           ("null",      0   ),
    EOL             ("EOL",    1   ),
    EOF             ("EOF",    2   ),
    INTEGER		("整数",		100),
    REAL    		("実数",		101),
    STRING		("文字列",	150),
    SYMBOL		("記号",		200),
    //RESERVED	("予約語",	300),
    IDENTIER	("識別子",	400);
    
    private String label;
    private int id;

    private Type(String label, int id) {
        this.label = label;
        this.id = id;
    }

    public String getLabel() {
        return label;
    }
    public int getId() {
        return id;
    }
}