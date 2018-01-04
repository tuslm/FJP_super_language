package tableClasses;

import Convertor.Validators;
import enums.EErrorCodes;
import enums.EInstructionSet;
import org.antlr.v4.runtime.Token;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by BobrZlosyn on 17.12.2017.
 */
public class TableOfSymbols {


    private static ArrayList <Symbol> tableOfSymbols = new ArrayList<>();
    private static ArrayList <Symbol> registerFunctions = new ArrayList<>();
    private static Stack <Integer> changesInParentID = new Stack<>();
    private static Stack <Integer> changesInObjectID = new Stack<>();
    private static int actualLevel = 0;
    private static int parentID = -1;
    private static int objectID = 0;
    private static int actObjectID = 0;
    public static String filepath = "";
    public static String destinationFilepath = "";
    private static int maxParams = 0;
    private static int returnSize = 0;

    public static class Symbol {
        private String name, variableType;
        private boolean isVariable, isConst;
        private int level, address, size, parentID, objectID;
        private int countParam;
        private ArrayList <String> params;
        private ArrayList <String> types;

        public Symbol(int parentID, int objectID, String name, boolean isVariable, int level, int address,
                                                    String variableType, int size, boolean isConst){

            this.name = name;
            this.isVariable = isVariable;
            this.level = level;
            this.address = address;
            this.variableType = variableType;
            this.size = size;
            this.isConst = isConst;
            this.parentID = parentID;
            this.objectID = objectID;
            params = new ArrayList();
            types = new ArrayList();
            countParam = 0;
        }

        public int getLevel() {
            return level;
        }

        public int getAddress() {
            return address;
        }

        public int getSize() {
            return size;
        }

        public String getName() {
            return name;
        }

        public String getVariableType() {
            return variableType;
        }

        public boolean isVariable() {
            return isVariable;
        }

        public boolean isConst() {
            return isConst;
        }

        public int getObjectID() {
            return objectID;
        }

        public int getParentID() {
            return parentID;
        }

        public int getCountParam() {
            return countParam;
        }

        public String getParamAtIndex(int index) {
            if (params.size() <= index) {
                return null;
            }
            return params.get(index);
        }

        public String getTypeAtIndex(int index) {
            if (types.size() <= index) {
                return null;
            }
            return types.get(index);
        }
    }


    public static boolean addSymbolConst(Token ctxToken, String name, String variableType, int size){

        return addSymbol(ctxToken, name, true, getNextSymbolVariableAddress(), variableType, size, true, false);
    }

    public static boolean addHiddenVariable(Token ctxToken, String name, String variableType, int size){

        return addSymbol(ctxToken, name, true, getNextSymbolVariableAddress(), variableType, size, false, true);
    }

    public static boolean addSymbolVariable(Token ctxToken, String name, String variableType, int size){

        return addSymbol(ctxToken, name, true, getNextSymbolVariableAddress(), variableType, size, false, false);
    }

    public static boolean addSymbolFunction(Token ctxToken, String name, String variableType, ArrayList <String> types, ArrayList <String> params){
       if( !addSymbol(ctxToken, name, false, TableOfCodes.getAddressInt(objectID) , variableType, 0, false, false)) {
            return false;
       }

        Symbol function = tableOfSymbols.get(tableOfSymbols.size() - 1);
        function.params = params;
        function.types = types;
        function.countParam = types.size();
        TableOfCodes.updateCall(types, name, String.valueOf(function.getAddress()));
        return true;
    }

    public static boolean addSymbol(Token ctxToken, String name, boolean isVariable, String variableType, int size, boolean isConst, boolean isEmpty){
        return addSymbol(ctxToken, name, isVariable, getNextSymbolVariableAddress(), variableType, size, isConst, isEmpty);
    }

    public static boolean addSymbol(Token ctxToken, String name, boolean isVariable, int address, String variableType, int size, boolean isConst, boolean isEmpty){

        if (findByNameActLevel(name, isVariable) != null) {
            ErrorHandle.addError(EErrorCodes.VARIABLE_EXISTS,
                    ctxToken.getLine(), ctxToken.getCharPositionInLine());
            return false;
        }

        if (!tableOfSymbols.add(new Symbol(parentID, objectID, name, isVariable, actualLevel, address, variableType, size, isConst))) {
            ErrorHandle.addError(EErrorCodes.UNKNOW_ERROR,
                    ctxToken.getLine(), ctxToken.getCharPositionInLine());
            return false;
        }



        if (size > 0) {
            TableOfCodes.updateInt(getObjectID(), size);
        }

        if (Validators.isArrayHere(variableType)) {//zapsani pole do prikazu
            for (int i = 0; i < size; i++) {
                EInstructionSet.doInstruction(EInstructionSet.LITERAL, 0);
                EInstructionSet.doInstruction(EInstructionSet.STORE, address + i);
            }

        }else {//normalni promenna

            if (isEmpty) {
                EInstructionSet.doInstruction(EInstructionSet.LITERAL, 0);
            }

            if (isVariable) {

                TableOfCodes.updateInt(getObjectID());
                EInstructionSet.doInstruction(EInstructionSet.STORE, address);
            }
        }

        return true;
    }

    public static boolean registerFunction(Token ctxToken, String name, String variableType, ArrayList <String> types, ArrayList <String> variables){
        if (functionExist(name, types)){
            ErrorHandle.addError(EErrorCodes.FUNCTION_EXISTS,
                    ctxToken.getLine(), ctxToken.getCharPositionInLine());
            return false;
        }

        boolean isVariable = false;
        boolean isConst = false;
        int address = -1;
        int size = -1;

        Symbol newFunction = new Symbol(parentID, objectID, name, isVariable, actualLevel, address, variableType, size, isConst);
        newFunction.params = variables;
        newFunction.types = types;
        newFunction.countParam = types.size();

        if (!registerFunctions.add(newFunction)) {
            ErrorHandle.addError(EErrorCodes.UNKNOW_ERROR,
                    ctxToken.getLine(), ctxToken.getCharPositionInLine());
            return false;
        }
        return true;

    }

    public static boolean functionExist(String name, ArrayList <String> types){
        boolean exists;
        int size = registerFunctions.size();

        for (int i = 0; i < size; i++) {
            Symbol symbol = registerFunctions.get(i);

            if (symbol.getName().equals(name)
                    && symbol.getCountParam() == types.size()) {
                exists = true;
                for (int j = 0; j < symbol.getCountParam(); j++) {

                    if (!symbol.getTypeAtIndex(j).equals(types.get(j))){
                        exists = false;
                        break;
                    }
                }

                if (exists) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean validFunctionType(String name, ArrayList <String> types, String expType){
        boolean exists;
        int size = registerFunctions.size();

        for (int i = 0; i < size; i++) {
            Symbol symbol = registerFunctions.get(i);
            if (symbol.getName().equals(name)
                    && symbol.getCountParam() == types.size()) {

                exists = true;
                for (int j = 0; j < symbol.getCountParam(); j++) {

                    if (!symbol.getTypeAtIndex(j).equals(types.get(j))){
                        exists = false;
                        break;
                    }
                }

                if (exists) {
                    return symbol.getVariableType().equals(expType);
                }
            }
        }

        return false;
    }

    public static String getFunctionType(String name, ArrayList <String> types){
        boolean exists;
        int size = registerFunctions.size();

        for (int i = 0; i < size; i++) {
            Symbol symbol = registerFunctions.get(i);
            if (symbol.getName().equals(name)
                    && symbol.getCountParam() == types.size()) {

                exists = true;
                for (int j = 0; j < symbol.getCountParam(); j++) {

                    if (!symbol.getTypeAtIndex(j).equals(types.get(j))){
                        exists = false;
                        break;
                    }
                }

                if (exists) {
                    return symbol.getVariableType();
                }
            }
        }

        return Validators.UNKNOWN_TYPE;
    }

    public static Symbol getValidateSymbol(String variable, String type, Token token) {
        TableOfSymbols.Symbol sym = TableOfSymbols.findByNameAllLevels(variable, true);
        if (sym == null) {
            ErrorHandle.addError(EErrorCodes.VARIABLE_DOESNT_EXIST, token);
            return null;
        }

        if (!sym.getVariableType().equals(type)){
            ErrorHandle.addError(EErrorCodes.TYPE_MISMATCH, token);
            return null;
        }
        return sym;
    }

    public static Symbol findByNameActLevel(String name, boolean isVariable){
        for (Symbol symbol : tableOfSymbols){
            if (symbol.getObjectID() == objectID && symbol.getName().equals(name) && (isVariable == symbol.isVariable())){
                return symbol;
            }
        }

        return null;
    }

    public static Symbol findFunction(String name, ArrayList <String> types){
        int size = tableOfSymbols.size();
        boolean exists;

        for (int i = 0; i < size; i++) {
            Symbol function = tableOfSymbols.get(i);
            if (function.getName().equals(name)
                    && types.size() == function.getCountParam()){

                exists = true;
                for (int j = 0; j < types.size(); j++){
                    if (!types.get(j).equals(function.getTypeAtIndex(j))){
                        exists = false;
                        break;
                    }
                }

                if(exists) {
                    return function;
                }
            }
        }
        return null;
    }

    public static Symbol findByNameAllLevels(String name, boolean isVariable){
        int object = objectID;
        int iteration = changesInObjectID.size();
        boolean dontStop = true;
        while (dontStop) {
            if (object == 0 ) {
                dontStop = false;
            }

            for (int i = 0; i < tableOfSymbols.size(); i++) {
                Symbol symbol = tableOfSymbols.get(i);
                System.out.println(symbol.getName() + "    " + name);
                 if(symbol.getObjectID() == object) {

                    if (symbol.getName().equals(name) && (isVariable == symbol.isVariable())){
                        return symbol;
                    }
                }
            }

            if (iteration == 0) {
                object = 0;
                iteration--;
            }else {
                object = object - changesInObjectID.get(changesInObjectID.size() - iteration);
                iteration--;
            }
        }

        return null;
    }

    public static void setLevel(boolean isDeeper){
        if(isDeeper) {
            actualLevel++;

        }else {
            actualLevel--;
        }
    }

    public static void setObject(boolean isDeeper) {
        if(isDeeper) {
            if(parentID == 0) {
                changesInParentID.push(parentID);
                parentID = objectID;

            }else {
                parentID++;
                changesInParentID.push(-1);
            }

            changesInObjectID.push(objectID);
            objectID = ++actObjectID;

        }else {
            parentID = changesInParentID.pop();
            objectID = changesInObjectID.pop();
        }
    }

    public static int getActualLevel() {
        return actualLevel;
    }

    public static int getParentID() {
        return parentID;
    }

    public static Symbol getLastSymbol(){
        return tableOfSymbols.get(tableOfSymbols.size() - 1);
    }



    public static int getNextSymbolVariableAddress(){
        Symbol symbol = null;
        for (Symbol sym : tableOfSymbols){
             if (actualLevel == 0 && sym.getLevel() == actualLevel && (sym.isVariable())) {
                 symbol = sym;
            } else {
                if (sym.getObjectID() == objectID && (sym.isVariable())){
                    symbol = sym;
                }
            }
        }

        if (symbol == null) {
            return 3;
        }else {
            if (symbol.getSize() <= 0) {
                return symbol.getAddress() + 1;
            }else {
                return symbol.getAddress() + symbol.getSize();
            }
        }
    }

    public static int getObjectID() {
        return objectID;
    }


    public static void setMaxParams(int number) {
        maxParams = Integer.max(maxParams, number);
    }

    public static int getMaxParams() {
       return maxParams;
    }

    public static void setReturnSize(int number) {
        returnSize = Integer.max(returnSize, number);
    }

    public static int getReturnSize() {
        return returnSize;
    }

    public static void clean() {
        registerFunctions.clear();
        changesInParentID.clear();
        changesInObjectID.clear();
        actualLevel = 0;
        parentID = -1;
        objectID = 0;
        actObjectID = 0;
        filepath = "";
        destinationFilepath = "";
        tableOfSymbols.clear();
    }

}
