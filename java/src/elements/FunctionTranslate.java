package elements;

import enums.EErrorCodes;
import enums.EInstructionSet;
import generatedParser.SLLanguageParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import tableClasses.*;

import java.util.ArrayList;

/**
 * Created by BobrZlosyn on 17.12.2017.
 */
public class FunctionTranslate {
    private boolean hasToReturn;
    private ArrayList <String> types;
    private ArrayList <String> variables;


    public FunctionTranslate () {
        hasToReturn = false;
        types = new ArrayList<>();
        variables = new ArrayList<>();
    }

    public boolean doFunctionDefinition(SLLanguageParser.FunctionDefinitionContext ctx) {
        String type;
        if (ctx.typeSpecifier() == null) {
            type= ctx.emptySpecifier().getText();
        }else {
            type= ctx.typeSpecifier().getText();
        }

        String name = ctx.Identifier().getText();
        SLLanguageParser.InitListContext list = ctx.initList();

        //TableOfSymbols.setLevel(true);


        if (!type.equals("void")) {
            hasToReturn = true;
        }

        if (list != null) {
            createVariables(list);
        }

        TableOfSymbols.addSymbolFunction(ctx.getStart(), name, type, types, variables);
        return hasToReturn;
    }


    private void createVariables(SLLanguageParser.InitListContext list) {

        String type;
        String name;
        ParseTree child = list;
        Symbol params = TableOfSymbols.findByNameAllLevels(RegisteredFunction.PARAMS_NAME, true);
        int address = params.getAddress();
        while (child != null) {
            if (child.getChildCount() > 2) {
                type = child.getChild(0).getText();
                name = child.getChild(1).getText();
                child = child.getChild(3);
            }else {
                type = child.getChild(0).getText();
                name = child.getChild(1).getText();
                child = null;
            }

            types.add(type);
            variables.add(name);


            EInstructionSet.doInstruction(EInstructionSet.LOAD, 1, address++);
            TableOfSymbols.addSymbolVariable(list.getStart(), name, type, 0);
        }

    }

    public void registerFunction(SLLanguageParser.FunctionDefinitionContext ctx) {
        String type;
        if (ctx.typeSpecifier() == null) {
            type= ctx.emptySpecifier().getText();
        }else {
            type= ctx.typeSpecifier().getText();
        }

        String name = ctx.Identifier().getText();
        SLLanguageParser.InitListContext variables = ctx.initList();

        TableOfSymbols.setLevel(true);

        if (variables != null) {
            getVariables(variables, name, type);
        }else {

            RegisteredFunction.registerFunction(ctx.getStart(), name, type, new ArrayList<>(), new ArrayList<>());
        }

        RegisteredFunction.setReturnSize(1);
    }


    private void getVariables(SLLanguageParser.InitListContext variables, String nameFunction, String typeFunction) {
        String type;
        String name;
        ParseTree child = variables;
        ArrayList <String> params = new ArrayList<>();
        ArrayList <String> types = new ArrayList<>();

        while (child != null) {
            if (child.getChildCount() > 2) {
                type = child.getChild(0).getText();
                name = child.getChild(1).getText();
                child = child.getChild(3);
            }else {
                type = child.getChild(0).getText();
                name = child.getChild(1).getText();
                child = null;
            }

            types.add(type);
            params.add(name);
        }

        RegisteredFunction.setMaxParams(types.size());
        RegisteredFunction.registerFunction(variables.getStart(), nameFunction, typeFunction, types, params);

    }


    public void validReturn (ParserRuleContext ctx) {
        ArrayList returnAddresses = new ArrayList();
        int size = TableOfCodes.getTableOfMainCode().size();
        boolean noReturn = true;
        boolean hasWrongJump = false;
        EInstructionSet code;
        int address, lastJumpAddress = Integer.MAX_VALUE;

        for (int i = size - 1; i >= 0; i-- ) {
            code = TableOfCodes.getTableOfMainCode().get(i).getCode();

            if (code.equals(EInstructionSet.INT)){
                break;
            }

            if (code.equals(EInstructionSet.RETURN)){
                returnAddresses.add(i);
                noReturn = false;
                continue;
            }

            if (code.equals(EInstructionSet.JUMP)) {
                address = Integer.parseInt(TableOfCodes.getTableOfMainCode().get(i).getValue());
                hasWrongJump = isBadReturn(returnAddresses, address, Integer.MAX_VALUE);
                lastJumpAddress = i;

            }

            if (code.equals(EInstructionSet.JUMP_COMP) ){
                address = Integer.parseInt(TableOfCodes.getTableOfMainCode().get(i).getValue());

                if (hasWrongJump) {
                    if (isBadReturn(returnAddresses, i, lastJumpAddress) && !isBadReturn(returnAddresses, address, Integer.MAX_VALUE)) {
                        noReturn = true;
                        break;
                    }else {
                        hasWrongJump = false;
                    }
                    continue;
                }

                if (isBadReturn(returnAddresses, address, Integer.MAX_VALUE)) {
                    noReturn = true;
                    break;
                }
            }

        }

        if (noReturn) {
            ErrorHandle.addError(EErrorCodes.MISSING_RETURN,
                    ctx.getStop().getLine(),
                    ctx.getStop().getCharPositionInLine());
        }
    }

    private boolean isBadReturn(ArrayList returns, int min, int max) {

        for (int i = 0; i < returns.size(); i++) {
            int value = (int)returns.get(i);
            if ( value > min && value <= max) {
                return false;
            }
        }

        return true;
    }
}
