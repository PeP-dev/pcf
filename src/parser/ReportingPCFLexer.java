package parser;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.LexerNoViableAltException;

public class ReportingPCFLexer extends PCFLexer {
    public ReportingPCFLexer(CharStream input) {
        super(input);
    }
    public void recover(LexerNoViableAltException e) {
        ErrorFlag.setFlag(); // report error
        super.recover(e);
    }
}
