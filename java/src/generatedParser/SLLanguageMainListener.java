// Generated from D:/projekty/FJP_super_language\SLLanguage.g4 by ANTLR 4.7
package generatedParser;

import convertor.Validators;
import createFilePL0.CreateFile;
import elements.*;
import enums.EErrorCodes;
import enums.EInstructionSet;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import tableClasses.ErrorHandle;
import tableClasses.RegisteredFunction;
import tableClasses.TableOfCodes;
import tableClasses.TableOfSymbols;

import java.util.ArrayList;

/**
 * This class provides an empty implementation of {@link SLLanguageListener},
 * which can be extended to create a listener which only needs to handle a subset
 * of the available methods.
 */
public class SLLanguageMainListener extends SLLanguageBaseListener {

	public static boolean isInCycleHeader = false;
	private static boolean isInAssignemt = false;
	private static boolean isInDeclaration = false;
    private static boolean isInTernalIf = false;
	private static boolean compileFunctions = false;
	private static boolean isInFunction = false;
    private static String functionType;
    private static ArrayList isInCycle = new ArrayList();
	public static Token variable;

    private static ArrayList firstAddress = new ArrayList<>();

    public static void blockSegment(ArrayList segmentToBlock) {
        segmentToBlock.add(true);
    }

    public static void unblockSegment(ArrayList segmentToUnblock) {
        segmentToUnblock.remove(segmentToUnblock.size() - 1);
    }

    public static boolean isSegmentBlocked(ArrayList segment){
        return !segment.isEmpty();
    }

	public static void setCompileFunctions(boolean compileFunctions) {
		SLLanguageMainListener.compileFunctions = compileFunctions;
	}


	public static void addAddress (int address) {
        firstAddress.add(address);
    }

    public static int getAddress () {
        return (int) firstAddress.remove(firstAddress.size() - 1);
    }

    public static int getAddressWithoutRemove() {
        return (int) firstAddress.get(firstAddress.size() - 1);
    }

    public static boolean hasAccess() {
        return (isInFunction && !compileFunctions)
                || (!isInFunction && compileFunctions);
    }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCompilationUnit(SLLanguageParser.CompilationUnitContext ctx) {
		if (compileFunctions) {
			return;
		}

		EInstructionSet.doInstruction(EInstructionSet.JUMP, 1);
		EInstructionSet.doInstruction(EInstructionSet.INT, 3);

		if (RegisteredFunction.getReturnSize() != 0) {
			TableOfSymbols.addHiddenVariable(ctx.getStart(), RegisteredFunction.RETURN_NAME, Validators.UNKNOWN_TYPE, RegisteredFunction.getReturnSize() - 1);
		}

		if (RegisteredFunction.getMaxParams() != 0) {
			TableOfSymbols.addHiddenVariable(ctx.getStart(), RegisteredFunction.PARAMS_NAME, Validators.UNKNOWN_TYPE, RegisteredFunction.getMaxParams());
		}



	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitCompilationUnit(SLLanguageParser.CompilationUnitContext ctx) {
		if (compileFunctions) {
			CreateFile createFile = new CreateFile(TableOfSymbols.destinationFilepath);
			createFile.writeToFile(TableOfCodes.createString());
			createFile.close();
		}else {
			EInstructionSet.doInstruction(EInstructionSet.RETURN, 0);
		}
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterTranslationUnit(SLLanguageParser.TranslationUnitContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTranslationUnit(SLLanguageParser.TranslationUnitContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterAllCode(SLLanguageParser.AllCodeContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitAllCode(SLLanguageParser.AllCodeContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterConstDeclaration(SLLanguageParser.ConstDeclarationContext ctx) {
		if (compileFunctions) {
			return;
		}

		isInDeclaration = true;
		ConstantDeclarationTranslate constantDeclarationTranslate = new ConstantDeclarationTranslate();
		constantDeclarationTranslate.doConstantDeclaration(ctx);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitConstDeclaration(SLLanguageParser.ConstDeclarationContext ctx) {
		if (compileFunctions) {
			return;
		}

		isInDeclaration = false;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterArrayDeclaration(SLLanguageParser.ArrayDeclarationContext ctx) {
		if (hasAccess()) {
			return;
		}

		isInDeclaration = true;
		ArrayDeclarationTranslate declarationTranslate = new ArrayDeclarationTranslate();
		declarationTranslate.doArrayDeclaration(ctx);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitArrayDeclaration(SLLanguageParser.ArrayDeclarationContext ctx) {
		if (hasAccess()) {
			return;
		}

		isInDeclaration = false;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterFunctionDefinition(SLLanguageParser.FunctionDefinitionContext ctx) {
		isInFunction = true;
		if (!compileFunctions) {
			return;
		}

		if (ctx.typeSpecifier() == null) {
			functionType= ctx.emptySpecifier().getText();
		}else {
			functionType= ctx.typeSpecifier().getText();
		}

		TableOfSymbols.setLevel(true);
		TableOfSymbols.setObject(true);
		EInstructionSet.doInstruction(EInstructionSet.INT, 3);
		FunctionTranslate functionTranslate = new FunctionTranslate();
		functionTranslate.doFunctionDefinition(ctx);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitFunctionDefinition(SLLanguageParser.FunctionDefinitionContext ctx) {
		isInFunction = false;
		if (!compileFunctions) {
			return;
		}

		TableOfSymbols.setObject(false);
		if (functionType.equals(Validators.EMPTY_TYPE)) {
			EInstructionSet.doInstruction(EInstructionSet.RETURN, 0, 0);
		}else {
			FunctionTranslate functionTranslate = new FunctionTranslate();
			functionTranslate.validReturn(ctx);
		}

        TableOfSymbols.setLevel(false);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterInitList(SLLanguageParser.InitListContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitInitList(SLLanguageParser.InitListContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterTypeSpecifier(SLLanguageParser.TypeSpecifierContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTypeSpecifier(SLLanguageParser.TypeSpecifierContext ctx) { }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterEmptySpecifier(SLLanguageParser.EmptySpecifierContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitEmptySpecifier(SLLanguageParser.EmptySpecifierContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCycle(SLLanguageParser.CycleContext ctx) {

		if (hasAccess()) {
			return;
		}

        blockSegment(isInCycle);
        TableOfSymbols.setObject(true);
		String type = ctx.getChild(0).getText();
		switch (type) {
			case "for":{
				ForTranslate forTranslate = new ForTranslate();
				forTranslate.runFor(ctx);
			} break;
			case "if":{
                unblockSegment(isInCycle);
				IfTranslate ifTranslate = new IfTranslate();
				ifTranslate.runIf(ctx);
			} break;
			case "while":{
				WhileTranslate whileTranslate = new WhileTranslate();
				whileTranslate.runWhile(ctx);
			} break;
			case "do":{
				DoTranslate doTranslate = new DoTranslate();
				doTranslate.runDo(ctx);
			} break;
			case "until":{
				UntilTranslate untilTranslate = new UntilTranslate();
				untilTranslate.runUntil(ctx);
			} break;
			case "repeat":{
				RepeatTranslate repeatTranslate = new RepeatTranslate();
				repeatTranslate.runRepeat(ctx);
			} break;

			case "switch":{
                unblockSegment(isInCycle);
				SwitchTranslate switchTranslate = new SwitchTranslate();
				switchTranslate.runSwitch(ctx);
			} break;
		}

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitCycle(SLLanguageParser.CycleContext ctx) {
		if (hasAccess()) {
			return;
		}

        String type = ctx.getChild(0).getText();
		switch (type) {
			case "for":{
                unblockSegment(isInCycle);
				ForTranslate forTranslate = new ForTranslate();
				forTranslate.exitFor(ctx);
			} break;
			case "if":{
				IfTranslate ifTranslate = new IfTranslate();
				ifTranslate.exitIf(ctx);
			} break;
			case "while":{
                unblockSegment(isInCycle);
				WhileTranslate whileTranslate = new WhileTranslate();
				whileTranslate.exitWhile(ctx);
			} break;
			case "do":{
                unblockSegment(isInCycle);
				DoTranslate doTranslate = new DoTranslate();
				doTranslate.exitDo(ctx);
			} break;
			case "until":{
                unblockSegment(isInCycle);
				UntilTranslate untilTranslate = new UntilTranslate();
				untilTranslate.exitUntil(ctx);
			} break;
			case "repeat":{
				unblockSegment(isInCycle);
				RepeatTranslate repeatTranslate = new RepeatTranslate();
				repeatTranslate.exitRepeat(ctx);
			} break;
			case "switch":{
				SwitchTranslate switchTranslate = new SwitchTranslate();
				switchTranslate.exitSwitch(ctx);
			} break;
		}
        TableOfSymbols.setObject(false);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterStatement(SLLanguageParser.StatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitStatement(SLLanguageParser.StatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterLabeledStatement(SLLanguageParser.LabeledStatementContext ctx) {
		if (hasAccess()) {
			return;
		}

		if(ctx.getChild(0).getText().equals("case")){
			CaseTranslate casetranslate = new CaseTranslate();
			casetranslate.doCase(ctx, variable);
		}
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitLabeledStatement(SLLanguageParser.LabeledStatementContext ctx) {
		if (hasAccess()) {
			return;
		}

		CaseTranslate label = new CaseTranslate();
		label.exitLabel(ctx);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterElseStatement(SLLanguageParser.ElseStatementContext ctx) {
        if (hasAccess()) {
            return;
        }

        TableOfSymbols.setObject(true);
        IfTranslate iftranslate = new IfTranslate();
        iftranslate.doElse(ctx);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitElseStatement(SLLanguageParser.ElseStatementContext ctx) {
        if (hasAccess()) {
            return;
        }
        IfTranslate iftranslate = new IfTranslate();
        iftranslate.exitElse(ctx);
        TableOfSymbols.setObject(false);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCompoundStatement(SLLanguageParser.CompoundStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitCompoundStatement(SLLanguageParser.CompoundStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterExpressionStatement(SLLanguageParser.ExpressionStatementContext ctx) {

    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitExpressionStatement(SLLanguageParser.ExpressionStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterBlockItemList(SLLanguageParser.BlockItemListContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitBlockItemList(SLLanguageParser.BlockItemListContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterBlockItem(SLLanguageParser.BlockItemContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitBlockItem(SLLanguageParser.BlockItemContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterDeclaration(SLLanguageParser.DeclarationContext ctx) {
		if (hasAccess()) {
			return;
		}

		isInDeclaration = true;
		DeclarationTranslate declarationTranslate = new DeclarationTranslate();
		declarationTranslate.doStandardDeclaration(ctx);

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitDeclaration(SLLanguageParser.DeclarationContext ctx) {
		if (hasAccess()) {
			return;
		}

		isInDeclaration = false;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterInitDeclaratorList(SLLanguageParser.InitDeclaratorListContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitInitDeclaratorList(SLLanguageParser.InitDeclaratorListContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterInitDeclarator(SLLanguageParser.InitDeclaratorContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitInitDeclarator(SLLanguageParser.InitDeclaratorContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterJumpStatement(SLLanguageParser.JumpStatementContext ctx) {

        BreakersTranslate breakersTranslate = new BreakersTranslate();
        switch (ctx.getChild(0).getText()) {
            case "return": {
                if (!hasAccess()) {
                    breakersTranslate.doReturn(ctx, functionType);
                }
            }break;
            case "continue": {
                if (hasAccess()) {
                    return;
                }

                if (isSegmentBlocked(isInCycle)) {
                    breakersTranslate.doContinue(ctx);
                }else {
                    ErrorHandle.addError(EErrorCodes.BAD_SYNTAX,
                            ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
                }
            }break;

            case "break": {
                if (hasAccess()) {
                    return;
                }

                if (isSegmentBlocked(isInCycle)) {
                    breakersTranslate.doBreak(ctx);
                }else {
                    ErrorHandle.addError(EErrorCodes.BAD_SYNTAX,
                            ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
                }
            }break;
        }
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitJumpStatement(SLLanguageParser.JumpStatementContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterExpression(SLLanguageParser.ExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitExpression(SLLanguageParser.ExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterConditionalExpression(SLLanguageParser.ConditionalExpressionContext ctx) {
        if (hasAccess()) {
            return;
        }
		if (!isInCycleHeader && !isInDeclaration && !isInAssignemt) {

            if (Validators.isTernalIfHere(ctx.getText())) {
                isInTernalIf = true;
                TernalIfTranslate ternalIfTranslate = new TernalIfTranslate();
                ternalIfTranslate.doTernalIf(ctx.getParent(), ctx.getStart(), Validators.UNKNOWN_TYPE, false);
            }
        }
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitConditionalExpression(SLLanguageParser.ConditionalExpressionContext ctx) {
        if (hasAccess()) {
            return;
        }

        if (!isInCycleHeader && !isInDeclaration && !isInAssignemt) {
            if (Validators.isTernalIfHere(ctx.getText())) {
                isInTernalIf = false;
            }
        }
    }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterAssignmentOperator(SLLanguageParser.AssignmentOperatorContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitAssignmentOperator(SLLanguageParser.AssignmentOperatorContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterFunctionCall(SLLanguageParser.FunctionCallContext ctx) {
		if (hasAccess()) {
			return;
		}

        if (!isInDeclaration || !isInAssignemt) {
			CallFunctionTranslate callFunctionTranslate = new CallFunctionTranslate();
			callFunctionTranslate.doFunctionCalling(ctx);
		}
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitFunctionCall(SLLanguageParser.FunctionCallContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterFunctionValues(SLLanguageParser.FunctionValuesContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitFunctionValues(SLLanguageParser.FunctionValuesContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterLogicalOrExpression(SLLanguageParser.LogicalOrExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitLogicalOrExpression(SLLanguageParser.LogicalOrExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterLogicalAndExpression(SLLanguageParser.LogicalAndExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitLogicalAndExpression(SLLanguageParser.LogicalAndExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterAssignmentExpression(SLLanguageParser.AssignmentExpressionContext ctx) {
		if (hasAccess()) {
			return;
		}

		if (!isInCycleHeader && !isInDeclaration && !isInAssignemt && !isInTernalIf) {
            if (Validators.isAssignmentHere(ctx.getText())){
                isInAssignemt = true;
                SimpleAssigmentTranslate assigmentTranslate = new SimpleAssigmentTranslate();
                assigmentTranslate.doAssigmentTranslate(ctx, true);
            }
		}
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitAssignmentExpression(SLLanguageParser.AssignmentExpressionContext ctx) {
		if (hasAccess()) {
			return;
		}

		if (!isInCycleHeader && !isInDeclaration && isInAssignemt && !isInTernalIf) {
            if (Validators.isAssignmentHere(ctx.getText())){
				isInAssignemt = false;
            }
		}
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterEqualityExpression(SLLanguageParser.EqualityExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitEqualityExpression(SLLanguageParser.EqualityExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterRelationalExpression(SLLanguageParser.RelationalExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitRelationalExpression(SLLanguageParser.RelationalExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterAdditiveExpression(SLLanguageParser.AdditiveExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitAdditiveExpression(SLLanguageParser.AdditiveExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterMultiplicativeExpression(SLLanguageParser.MultiplicativeExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitMultiplicativeExpression(SLLanguageParser.MultiplicativeExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCastExpression(SLLanguageParser.CastExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitCastExpression(SLLanguageParser.CastExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterUnaryExpression(SLLanguageParser.UnaryExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitUnaryExpression(SLLanguageParser.UnaryExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterUnaryOperator(SLLanguageParser.UnaryOperatorContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitUnaryOperator(SLLanguageParser.UnaryOperatorContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterPostfixExpression(SLLanguageParser.PostfixExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitPostfixExpression(SLLanguageParser.PostfixExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterPrimaryExpression(SLLanguageParser.PrimaryExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitPrimaryExpression(SLLanguageParser.PrimaryExpressionContext ctx) { }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterForCondition(SLLanguageParser.ForConditionContext ctx) {
		if (hasAccess()) {
			return;
		}

		isInCycleHeader = true;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitForCondition(SLLanguageParser.ForConditionContext ctx) {
		if (hasAccess()) {
			return;
		}

		isInCycleHeader = false;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterForDeclaration(SLLanguageParser.ForDeclarationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitForDeclaration(SLLanguageParser.ForDeclarationContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterForExpression(SLLanguageParser.ForExpressionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitForExpression(SLLanguageParser.ForExpressionContext ctx) { }

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