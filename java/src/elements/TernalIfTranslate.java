package elements;

import convertor.Validators;
import enums.EErrorCodes;
import enums.EInstructionSet;
import generatedParser.SLLanguageParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import tableClasses.ErrorHandle;
import tableClasses.TableOfCodes;
import tableClasses.TableOfSymbols;

/**
 * Created by BobrZlosyn on 22.12.2017.
 */
public class TernalIfTranslate extends DeclarationTranslate {

    public void doTernalIf (ParseTree ternalIf, Token token, String type, boolean isAssignment) {
        SLLanguageParser.ConditionalExpressionContext ctx =  (SLLanguageParser.ConditionalExpressionContext) (ternalIf.getChild(0));
        ParseTree condition = ctx.logicalOrExpression();
        ParserRuleContext trueSide = ctx.expression(0);
        ParserRuleContext falseSide = ctx.expression(1);

        handleAssigment(Validators.VARIABLE_TYPE_BOOLEAN, condition.getText(), ctx.logicalOrExpression(), condition.getText());
        EInstructionSet.doInstruction(EInstructionSet.JUMP_COMP, -1); //skok na falseSide
        if (!isAssignment) {
            prepareSideInfo(trueSide);
        }else {
            getValue(trueSide.getText(), type, trueSide, token, "");
        }


        EInstructionSet.doInstruction(EInstructionSet.JUMP, -1); //skok na další příkaz, preskoceni falseSide
        TableOfCodes.updateJumpCompare(TableOfSymbols.getObjectID(), String.valueOf(TableOfCodes.getTableOfMainCode().size()));

        if (isAssignment && falseSide == null) {
            ErrorHandle.addError(EErrorCodes.MISING_RETURN_TERNAL, token);
        }

        if (falseSide != null) {
            if (!isAssignment) {
                prepareSideInfo(falseSide);
            }else {
                getValue(falseSide.getText(), type, falseSide, token, "");
            }
        }
        TableOfCodes.updateJump(TableOfSymbols.getObjectID(), String.valueOf(TableOfCodes.getTableOfMainCode().size()));


    }

    private void prepareSideInfo(ParserRuleContext side) {
        if (!Validators.isAssignmentHere(side.getText())){
            ErrorHandle.addError(EErrorCodes.BAD_SYNTAX, side);
            return;
        }

        SimpleAssigmentTranslate assigmentTranslate = new SimpleAssigmentTranslate();
        assigmentTranslate.doAssigmentTranslate((ParserRuleContext) side.getChild(0), true);
    }

}
