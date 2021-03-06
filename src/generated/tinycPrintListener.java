package generated;

import com.sun.org.apache.xerces.internal.util.SymbolTable;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

/**
 * int var; var = foo+1;
 * int a = 1+2;
 */

public class tinycPrintListener extends tinycBaseListener {
    ParseTreeProperty<String> newTexts = new ParseTreeProperty<String>(); // 스트링 관리
    SymbolTable symbleTable = new SymbolTable();


    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterProgram(tinycParser.ProgramContext ctx) {
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitProgram(tinycParser.ProgramContext ctx) {
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterStatement(tinycParser.StatementContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitStatement(tinycParser.StatementContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterParen_expr(tinycParser.Paren_exprContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitParen_expr(tinycParser.Paren_exprContext ctx) {
        newTexts.put(ctx, "( " + newTexts.get(ctx.getChild(1)) + " )");
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterExpr(tinycParser.ExprContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitExpr(tinycParser.ExprContext ctx) {
        String value = "";
        for(int i = 0; i < ctx.getChildCount(); i++) {
            if(newTexts.get(ctx.getChild(i)) != null) value += newTexts.get(ctx.getChild(i));
            else {
                value += " " + ctx.getChild(i).getText() + " ";
                symbleTable.addSymbol(ctx.getChild(i).getText()); // if assignment
            }
        }

        newTexts.put(ctx, value);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterTest(tinycParser.TestContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitTest(tinycParser.TestContext ctx) {
        String value = "";
        for(int i = 0; i < ctx.getChildCount(); i++) {
            if(newTexts.get(ctx.getChild(i)) != null) value += newTexts.get(ctx.getChild(i));
            else value += " " + ctx.getChild(i).getText() + " ";
        }
        newTexts.put(ctx, value);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterSum(tinycParser.SumContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitSum(tinycParser.SumContext ctx) {
        String value = "";
        for(int i = 0; i < ctx.getChildCount(); i++) {
            if(newTexts.get(ctx.getChild(i)) != null) value += newTexts.get(ctx.getChild(i));
            else value += " " + ctx.getChild(i).getText() + " ";
        }
        newTexts.put(ctx, value);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterTerm(tinycParser.TermContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitTerm(tinycParser.TermContext ctx) {
        // 논 터미널의 경우 자식을 다시 찾아가면서 어떤 텍스트인지 찾음
        // getText: 자식이 id 나 integer이 나오면
        // 논 터미널일 경우 getChild 해서 트리로 달아놓음
        newTexts.put(ctx, newTexts.get(ctx.getChild(0)));
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterId(tinycParser.IdContext ctx) {
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitId(tinycParser.IdContext ctx) {
        newTexts.put(ctx, ctx.getText());
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterInteger(tinycParser.IntegerContext ctx) {
        /**
         * return integer
         */
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitInteger(tinycParser.IntegerContext ctx) {
        newTexts.put(ctx, ctx.getText());
    }

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void enterEveryRule(ParserRuleContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void exitEveryRule(ParserRuleContext ctx) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void visitTerminal(TerminalNode node) { }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override public void visitErrorNode(ErrorNode node) { }
}
