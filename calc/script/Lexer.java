// 参考：2週間でできる！ スクリプト言語の作り方 (千葉滋　著)

package calc.script;

import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.math.BigDecimal;

public class Lexer {
	public static String regexPat
        = "\\s*((#.*)|([0-9]+(?![0-9]*\\.))|"
          + "([0-9]+\\.[0-9]*|\\.[0-9]+)|"
          + "\"(\\\\\"|\\\\\\\\|\\\\n|[^\"])*\"|"
          + "([A-Z_a-z][A-Z_a-z0-9]*)"
          + "|//|%%|==|<=|>=|&&|\\|\\||[\\p{Punct}&&[^\\.]]|\\.(?!([0-9])))?";
	private Pattern pattern = Pattern.compile(regexPat);
	private ArrayList<Token> queue = new ArrayList<>();
	private boolean hasMore;
	private LineNumberReader reader;
	
	public Lexer(Reader r) {
		hasMore = true;
		reader = new LineNumberReader(r);
	}
	public Token read() throws ParseException {
		if (fillQueue(0))
			return queue.remove(0);
		else
			return Token.EOF;
	}
	public Token peek(int i) throws ParseException {
		if (fillQueue(i))
			return queue.get(i);
		else
			return Token.EOF;
	}
	public boolean fillQueue(int i) throws ParseException {
		while (i >= queue.size())
			if (hasMore)
				readLine();
			else
				return false;
		return true;
	}
	protected void readLine() throws ParseException {
		String line;
		try {
			line = reader.readLine();
		} catch (IOException e) {
			throw new ParseException(e);
		}
		if (line == null) {
			hasMore = false;
			return;
		}
		int lineNo = reader.getLineNumber();
		Matcher matcher = pattern.matcher(line);
		matcher.useTransparentBounds(true).useAnchoringBounds(false);
		int pos = 0;
		int endPos = line.length();
		while (pos < endPos) {
			matcher.region(pos, endPos);
			if (matcher.lookingAt()) {
				addToken(lineNo, matcher);
				pos = matcher.end();
			} else
				throw new ParseException("bad token at line " + lineNo);
		}
		queue.add(new IdToken(lineNo, Token.EOL));
	}
	protected void addToken(int lineNo, Matcher matcher) {
		String m = matcher.group(1);
		if (m != null) // if not a space
			if (matcher.group(2) == null) { // if not a comment
				Token token;
				if (matcher.group(3) != null)
					token = new IntToken(lineNo, Integer.parseInt(m));
				else if (matcher.group(4) != null) {
					BigDecimal BDvalue = new BigDecimal(m);
					token = new RealToken(lineNo, BDvalue);
				} else if (matcher.group(5) != null)
					token = new StrToken(lineNo, toStringLiteral(m));
				else if (matcher.group(6) != null)
					token = new IdToken(lineNo, m);
				else
					token = new SymToken(lineNo, m);
				queue.add(token);
			}
	}
	protected String toStringLiteral(String s) {
		StringBuilder sb = new StringBuilder();
		int len = s.length() -1;
		for (int i = 1; i < len; i++) {
			char c = s.charAt(i);
			if (c == '\\' && i + 1 < len) {
				char c2 = s.charAt(i+1);
				if (c2 == '"' || c2 == '\\')
					c = s.charAt(++i);
				else if (c2 == 'n') {
					++i;
					c = '\n';
				}
			}
			sb.append(c);
		}
		return sb.toString();
	}
	
	protected static class IntToken extends Token {
		private int value;
		private Type type;
		
		protected IntToken(int line, int v) {
			super(line);
			value = v;
			type = Type.INTEGER;
		}
		public Type getType() { return type; }
		public String getText() { return Integer.toString(value); }
		public int getInt() { return value; }
	}
	
	protected static class RealToken extends Token {
		private BigDecimal value;
		private Type type;
		
		protected RealToken(int line, BigDecimal v) {
			super(line);
			value = v;
			type = Type.REAL;
		}
		public Type getType() { return type; }
		public String getText() { return value.toString(); }
		public BigDecimal getReal() { return value; }
	}
	
	protected static class IdToken extends Token {
		private String text;
		private Type type;
		
		protected IdToken(int line, String id) {
			super(line);
			text = id;
			type = Type.IDENTIER;
			if (text == EOL) type = Type.EOL;
		}
		public Type getType() { return type; }
		public String getText() { return text; }
	}
	
	protected static class SymToken extends Token {
		private String text;
		private Type type;
		
		protected SymToken(int line, String sym) {
			super(line);
			text = sym;
			type = Type.SYMBOL;
		}
		public Type getType() { return type; }
		public String getText() { return text; }
	}
	
	protected static class StrToken extends Token {
		private String literal;
		private Type type;
		
		protected StrToken(int line, String str) {
			super(line);
			literal = str;
			type = Type.STRING;
		}
		public Type getType() { return type; }
		public String getText() { return literal; }
	}
}