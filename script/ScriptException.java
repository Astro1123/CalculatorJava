package script;
//import script.ast.ASTree;

public class ScriptException extends RuntimeException {
    public ScriptException(String m) { super(m); }
    //public ScriptException(String m, ASTree t) {
    //    super(m + " " + t.location());
    //}
}