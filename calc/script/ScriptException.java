// 参考：2週間でできる！ スクリプト言語の作り方 (千葉滋　著)

package calc.script;
//import script.ast.ASTree;

public class ScriptException extends RuntimeException {
    public ScriptException(String m) { super(m); }
    //public ScriptException(String m, ASTree t) {
    //    super(m + " " + t.location());
    //}
}